<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value='/'/>js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="<c:url value='/'/>js/jquery.popupWindow.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<meta http-equiv="content-language" content="ko">
<link href="<c:url value='/'/>css/default.css" rel="stylesheet" type="text/css" >
<title>전자정부프레임워크</title>
<script type="text/javascript">
<!--
var $j = jQuery.noConflict();
//-->
</script>
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

    <div id="bodywrap">
        <div id="leftmenu_div"><c:import url="/sym/mms/EgovMainMenuLeft.do" /></div>
        <div id="middle_content">
<!-- ################################################################################################################################## -->
<!-- #### ==== SiteMesh Body Start =============================================================================================== #### -->
	        <decorator:body />
<!-- #### ==== SiteMesh Body End   =============================================================================================== #### -->
<!-- ################################################################################################################################## -->
        </div> 
    </div>
    <!-- footer 시작 -->
    <div id="footer"><c:import url="/EgovPageLink.do?link=main/inc/EgovIncFooter" /></div>
    <!-- //footer 끝 -->
</div>

</body>
</html>


