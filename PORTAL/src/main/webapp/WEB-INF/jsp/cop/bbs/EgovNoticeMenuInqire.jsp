<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value='${brdMstrVO.tmplatCours}'/>" rel="stylesheet" type="text/css">
<c:if test="${anonymous == 'true'}"><c:set var="prefix" value="/anonymous"/></c:if>
</head>
<body>

<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="ffffff" class="generalTable">
	<tr> 
		<td class="td_content">
			<c:out value="${result.nttCn}" escapeXml="false" />
		</td>
	</tr>
	<c:if test="${not empty result.atchFileId}">
	<tr> 
		<td class="td_content">
		    <c:import url="/cmm/fms/selectFileInfs.do" charEncoding="UTF-8">
		        <c:param name="param_atchFileId" value="${result.atchFileId}" />
		    </c:import>
		</td>
	</tr>
	</c:if>
</table>
</body>
</html>