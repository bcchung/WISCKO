package com.wiscko.cmm;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.sourceforge.ajaxtags.xml.AjaxXmlBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;

@Controller
public class AjaxController {
    
    @Resource(name = "EgovCmmUseService")
    private EgovCmmUseService cmmUseService;
    
    /**
     * 과학기술표준분류적용분야코드 대분류->중분류 를 조회
     * @param searchName
     * @return
     * @throws Exception
     */
    @RequestMapping("/selectCityCodeSecond.do")
    protected ModelAndView selectSciTechStndAplcFldCodeSecond(
            @RequestParam("cityCodeFirst") String cityCodeFirst)
            throws Exception {
        
        /** 검색키워드 */
        ComDefaultCodeVO searchVO = new ComDefaultCodeVO();
        searchVO.setCodeId("CITYTC");
        searchVO.setUpperCode(cityCodeFirst);

        List<CmmnDetailCode> resultList = null;
        ModelAndView model = new ModelAndView(new AjaxXmlView());
        if (cityCodeFirst != null && !cityCodeFirst.equals("")) {
            resultList = cmmUseService.selectLevelCodeDetail(searchVO);
        }

        AjaxXmlBuilder ajaxXmlBuilder = new AjaxXmlBuilder();
        if (resultList != null) {
            if (resultList.size() > 0) {
                ajaxXmlBuilder.addItem(" :: 선택 :: ", "");
            }
            for (Iterator iter = resultList.iterator(); iter.hasNext();) {
                CmmnDetailCode code = (CmmnDetailCode) iter.next();
                ajaxXmlBuilder.addItem(code.getCodeNm(), code.getCode());
            }
        }
        model.addObject("ajaxXml", ajaxXmlBuilder.toString());

        return model;
    }
    
}