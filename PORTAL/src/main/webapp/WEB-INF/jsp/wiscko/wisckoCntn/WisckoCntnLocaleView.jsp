<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
<c:choose>
	<c:when test="${not empty resultVO}">
		<c:out value="${resultVO.nttCn}" escapeXml="false"/>
	</c:when>
	<c:otherwise>
		<div style="width:100%; text-align:center; padding-top:100px;"><img src="<c:url value='/'/>/images/ready_page.png" alt="준비중입니다." /></div>
		<div style="padding-top:30px; text-align:center;">페이지 준비중입니다.</div>
	</c:otherwise>
</c:choose>
</body>
</html>
