<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import ="egovframework.com.cmm.LoginVO" %>

<%@ page import="java.net.URL"%>
<%@ page import="java.net.URLConnection"%>
<%@ page import="java.io.BufferedReader"%>
<%@ page import="java.io.InputStreamReader"%>
<%@ page import="java.io.InputStream"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="org.springframework.util.FileCopyUtils"%>
<%@ page import="org.springframework.util.xml.DomUtils"%>
<%@ page import="org.springframework.web.util.HtmlUtils"%>
<%@ page import="org.jdom.Attribute"%>
<%@ page import="org.jdom.DocType"%>
<%@ page import="org.jdom.Document"%>
<%@ page import="org.jdom.Element"%>
<%@ page import="org.jdom.JDOMException"%>
<%@ page import="org.jdom.input.SAXBuilder"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%
//URL url = new URL("http://www.kma.go.kr/XML/weather/sfc_web_map.xml");
/* URL url = new URL("http://www.google.co.kr/ig/api?weather=seoul");
String xml = FileCopyUtils.copyToString(new InputStreamReader(url.openConnection().getInputStream(), "EUC-KR"));
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(new InputStreamReader(url.openConnection().getInputStream(), "EUC-KR"));
Element root= doc.getRootElement();
Element weather = root.getChild("weather");
Element current_conditions = weather.getChild("current_conditions");
List list = current_conditions.getChildren();
HashMap<String, String> result = new HashMap<String, String>();
for(Object obj : list){
       Element ele = (Element)obj;
       result.put(ele.getName(), ele.getAttributeValue("data"));
}
request.setAttribute("xml", HtmlUtils.htmlEscape(xml));
request.setAttribute("result", result); */

// 상태 : ${result.condition}
// 온도 : ${result.temp_f} (Fahrenheit)
// 온도: ${result.temp_c} (Celsius)
// 습도 : ${result.humidity}
// 바람 : ${result.wind_condition}
// xml : ${xml}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="content-language" content="ko">
<title>WISCKO - 위드미어학원</title>
<link href="<c:url value='/'/>css/default.css" rel="stylesheet" type="text/css" >
<decorator:head/>
</head>
<body>
<noscript><p>자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</p></noscript>
<!-- login status start -->
<div id="login_area"><c:import url="/EgovPageLink.do?link=main/inc/EgovIncTborder" /></div>
<!-- //login status end -->
<!-- wrap start -->
<div id="wrap">	
	<!-- header start -->
	<div id="header"><c:import url="/sym/mms/EgovMainMenuHead.do?flag=MAIN" /></div>
	<!-- //header end -->

<!-- ################################################################################################################################## -->
<!-- #### ==== SiteMesh Body Start =============================================================================================== #### -->
	        <decorator:body/>
<!-- #### ==== SiteMesh Body End   =============================================================================================== #### -->
<!-- ################################################################################################################################## -->
	
	<!-- footer 시작 -->
	<div id="footer"><c:import url="/EgovPageLink.do?link=main/inc/EgovIncFooter" /></div>
	<!-- //footer 끝 -->
</div>
<!-- //wrap end -->
</body>
</html>
<%

%>