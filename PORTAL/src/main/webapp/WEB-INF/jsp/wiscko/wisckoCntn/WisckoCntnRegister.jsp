<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : WisckoCntnRegister.jsp
  * @Description : WisckoCntn Register View
  * @Modification Information
  * 
  * @author bcchung
  * @since 2013-04-28
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<c:set var="registerFlag" value="${empty wisckoCntnVO.cntnId ? 'Register' : 'Update'}"/>			

<title> <c:out value="${registerFlag}"/> </title>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="wisckoCntnVO" staticJavascript="false" xhtml="true" cdata="false"/ -->

<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* List View function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/wiscko/wisckoCntn/WisckoCntnList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* Delete function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/wiscko/wisckoCntn/deleteWisckoCntn.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* Register function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation Function update */
	$j(":radio[name=localeRdo]").each(function (index, domEle) {
		if($j(domEle).is(":checked")) {
			//에디터값 textarea에 set
			$j(":button[name=editorGetBtn]").click();
			$j('textarea[name*="nttCn"]').eq(index).text($j("#editorData").text());
		}
	});
	
  	frm.action = "<c:url value="${registerFlag == 'Register' ? '/wiscko/wisckoCntn/addWisckoCntn.do' : '/wiscko/wisckoCntn/updateWisckoCntn.do'}"/>";
    frm.submit();
}

$j(document).ready(function() {

	$j("#editorData").text(($j('textarea[name*="nttCn"]').eq(0).text()));
	$j("#beforeIndex").val(0);
	
	$j(":radio[name=localeRdo]").on('click', function() {
		$j(":radio[name=localeRdo]").each(function (index, domEle) {
			if($j(domEle).is(":checked")) {
				//에디터값 textarea에 set
				$j(":button[name=editorGetBtn]").click();
				$j('textarea[name*="nttCn"]').eq($j("#beforeIndex").val()).text($j("#editorData").text());
				
				//선택한 locale textarea값 에디터에 set
				$j("#editorData").text($j('textarea[name*="nttCn"]').eq(index).text());
				$j("#beforeIndex").val(index);
				$j(":button[name=editorSetBtn]").click();
			}
		});
	});
	
});
// -->
</script>
<style type="text/css">
	.noStyle {background:ButtonFace; BORDER-TOP:0px; BORDER-bottom:0px; BORDER-left:0px; BORDER-right:0px;}
  	.noStyle th{background:ButtonFace; padding-left:0px;padding-right:0px}
  	.noStyle td{background:ButtonFace; padding-left:0px;padding-right:0px}
</style>
<style type="text/css">
    h1 {font-size:12px;}
    caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
</style>
</head>
<body>

<!-- Current Navigation -->
<div id="cur_loc">
        <div id="cur_loc_align">
            <ul>
                <li>HOME</li>
                <li>&gt;</li>
                <li>시스템관리</li>
                <li>&gt;</li>
                <li><strong>컨텐츠관리</strong></li>
            </ul>
        </div>
</div>
<!--contents start-->
<div id="content_field">

<form:form commandName="wisckoCntnVO" name="detailForm" id="detailForm">
	<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
	<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="cntnId" value="<c:out value='${searchVO.cntnId}'/>"/>
	<input type="hidden" id="beforeIndex"/>

	<!-- Double Submit Token Parameter -->
	<input type="hidden" name="TOKEN_KEY" value="<%=request.getAttribute("TOKEN_KEY")%>" />
	<!-- Double Submit Token Parameter -->

<!-- sub title start -->
<div><h2>컨텐츠관리</h2></div>
<!-- sub title end -->

<!--detail area start -->
<div class="search_service">
    <div class="search_top_table">

	<table width="100%" border="1" cellpadding="0" cellspacing="0" >
		<colgroup>
			<col width="150"/>
			<col width=""/>
		</colgroup>
			
		<c:if test="${registerFlag == 'Update'}">
		</c:if>
		<c:if test="${registerFlag == 'Register'}">
		</c:if>		
		<tr>
			<td class="td_width">컨텐츠명</td>
			<td class="td_content">
				<form:input path="nttSj" cssClass="txt" size="80"/>
				&nbsp;<form:errors path="nttSj" />
			</td>
		</tr>
		<tr>
			<td class="td_width">국가</td>
			<td class="td_content" colspan="3">
			
			<c:if test="${registerFlag == 'Register'}">
				<c:forEach var="result" items="${localeTcList}" varStatus="status">
					<input type="radio" name="localeRdo" value="${result.code}" <c:if test="${status.first}">checked="checked"</c:if>/>${result.codeNm}
					<input type="hidden" name="localeArray[${status.index}].locale" value="${result.code}"/>
					<textarea name="localeArray[${status.index}].nttCn" id="localeArray[${status.index}].nttCn" style="display:none;"></textarea>
				</c:forEach>
			</c:if>
			<c:if test="${registerFlag == 'Update'}">
				<c:if test="${cntnYn == 'Y'}">
					<c:forEach var="result" items="${localeArray}" varStatus="status">
						<input type="radio" name="localeRdo" value="${result.locale}" <c:if test="${status.first}">checked="checked"</c:if>/>${result.localeNm}
						<input type="hidden" name="localeArray[${status.index}].locale" value="${result.locale}"/>
						<textarea name="localeArray[${status.index}].nttCn" id="localeArray[${status.index}].nttCn" style="display:none;">${result.nttCn}</textarea>
					</c:forEach>
				</c:if>
				<c:if test="${cntnYn == 'N'}">
					<c:forEach var="result" items="${localeTcList}" varStatus="status">
						<input type="radio" name="localeRdo" value="${result.code}" <c:if test="${status.first}">checked="checked"</c:if>/>${result.codeNm}
						<input type="hidden" name="localeArray[${status.index}].locale" value="${result.code}"/>
						<textarea name="localeArray[${status.index}].nttCn" id="localeArray[${status.index}].nttCn" style="display:none;"></textarea>
					</c:forEach>
				</c:if>
			</c:if>
			</td>
		</tr>
		<tr>
			<td class="td_width">대학소개</td>
			<td class="td_content" colspan="3">
	            
	            <!-- ##Smart Editor Start## -->
	            <c:import url="/editor/SmartEditor.jsp" charEncoding="UTF-8">
	                <c:param name="v_width">600</c:param>
	                <c:param name="v_height">400</c:param>
	            </c:import>
	            <!-- ##Smart Editor End## -->
	          
            </td>
		</tr>	
	</table>
  	</div>
	<div class="buttons" align="center" style="margin-bottom:100px">
		<a href="#LINK" onclick="javascript:fn_egov_selectList();"><spring:message code="button.list" /></a>
		<a href="#LINK" onclick="javascript:fn_egov_save()"><spring:message code="button.save" /></a>
		<a href="#LINK" onclick="javascript:fn_egov_delete();"><spring:message code="button.delete" /></a>		
	</div>

</div>
<!-- contents end -->

</form:form>
</body>
</html>

