package egovframework.com.cmm;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class CommandArrayArgumentResolver implements WebArgumentResolver {
	private Logger	logger	= Logger.getLogger(this.getClass());	// Logger 처리

	/**
	 * Setter를 통해 객체에 대한 property name list를 얻음.
	 * 
	 * @param clazz
	 * @return
	 */
	protected String[] getPropertyName(Class<?> clazz) {
		List<String> list = new ArrayList<String>();

		Method[] methods = clazz.getMethods();

		for (Method method : methods) {
			if (method.getName().startsWith("set") && method.getParameterTypes().length == 1) {
				list.add(method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4));
			}
		}

		return list.toArray(new String[0]);
	}

	/**
	 * Property의 setter를 호출함.
	 * 
	 * @param vo
	 * @param propertyName
	 * @param value
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected void callSetter(Object vo, String propertyName, String value) throws IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		PropertyDescriptor pd = BeanUtils.getPropertyDescriptor(vo.getClass(), propertyName);

		pd.getWriteMethod().invoke(vo, new Object[] { value });

	}

	/**
	 * Array유형에 대한 argument 처리.
	 */
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {

		Class<?> clazz = methodParameter.getParameterType();

		// logger.debug("Parameter Class : " + clazz.getCanonicalName());

		if (clazz.isArray()) { // ①
			Class<?> targetClazz = clazz.getComponentType(); // 대상 VO

			logger.debug("Target object in array : " + targetClazz.getCanonicalName());

			HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();

			// ② VO의 property Name 얻기..
			String[] properties = getPropertyName(targetClazz);

			// ③ parameter 배열 최대 구하기..
			int max = 0;
			for (String getter : properties) {
				logger.debug("Property : " + getter);

				if (request.getParameterValues(getter) == null) {
					continue;
				}

				logger.debug("ParameterValues's length : " + request.getParameterValues(getter).length);

				if (max < request.getParameterValues(getter).length) {
					max = request.getParameterValues(getter).length;
				}
			}

			logger.debug("Parameter array's MAX length : " + max);

			// ④ 리턴할 객체 배열 생성하기..
			Object ret = Array.newInstance(targetClazz, max);
			Object target = null;
			for (int index = 0; index < max; index++) { // index
				target = targetClazz.newInstance();

				for (String property : properties) {
					String[] values = request.getParameterValues(property);

					if (values != null && index < values.length) {
						callSetter(target, property, values[index]); // ⑤
					}
				}
				// ⑥ 배열에 각 파라미터 객체를 지정..
				Array.set(ret, index, target);
			}

			return ret;
		}

		return UNRESOLVED;
	}

}
