<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : WisckoUnivRegister.jsp
  * @Description : WisckoUniv Register View
  * @Modification Information
  * 
  * @author bcchung
  * @since 2013-04-08
  * @version 1.0
  * @see
  *  
  * Copyright (C) All right reserved.
  */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:set var="registerFlag" value="${empty wisckoUnivVO.univId ? 'Register' : 'Update'}"/>			

<title> <c:out value="${registerFlag}"/> </title>

<!--For Commons Validator Client Side-->
<!-- script type="text/javascript" src="<c:url value='/cmmn/validator.do'/>"></script -->
<!-- validator:javascript formName="wisckoUnivVO" staticJavascript="false" xhtml="true" cdata="false"/ -->
<script type="text/javascript" src="<c:url value='/js/EgovMultiFile.js'/>" ></script>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* List View function */
function fn_egov_selectList() {
   	document.getElementById("detailForm").action = "<c:url value='/wiscko/wisckoUniv/WisckoUnivList.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* Delete function */
function fn_egov_delete() {
   	document.getElementById("detailForm").action = "<c:url value='/wiscko/wisckoUniv/deleteWisckoUniv.do'/>";
   	document.getElementById("detailForm").submit();		
}

/* Register function */
function fn_egov_save() {	
	frm = document.getElementById("detailForm");

	/* TODO Validation Function update */
	
  	frm.action = "<c:url value="${registerFlag == 'Register' ? '/wiscko/wisckoUniv/addWisckoUniv.do' : '/wiscko/wisckoUniv/updateWisckoUniv.do'}"/>";
    frm.submit();
}

function fn_egov_check_file(flag) {
	if (flag=="Y") {
		document.getElementById('file_upload_posbl').style.display = "block";
		document.getElementById('file_upload_imposbl').style.display = "none";			
	} else {
		document.getElementById('file_upload_posbl').style.display = "none";
		document.getElementById('file_upload_imposbl').style.display = "block";
	}
}	

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

<!-- 현재위치 네비게이션 시작 -->
<div id="cur_loc">
        <div id="cur_loc_align">
            <ul>
                <li>HOME</li>
                <li>&gt;</li>
                <li>시스템관리</li>
                <li>&gt;</li>
                <li><strong>대학교관리</strong></li>
            </ul>
        </div>
</div>
<!--contents start-->
<div id="content_field">

<form:form commandName="wisckoUnivVO" id="detailForm" method="post" enctype="multipart/form-data">
	<input type="hidden" name="searchCondition" value="<c:out value='${searchVO.searchCondition}'/>"/>
	<input type="hidden" name="searchKeyword" value="<c:out value='${searchVO.searchKeyword}'/>"/>
	<input type="hidden" name="pageIndex" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="univId" value="<c:out value='${wisckoUnivVO.univId}'/>"/>
	<input type="hidden" name="returnUrl" value="<c:url value='/wiscko/wisckoUniv/updateWisckoUnivView.do'/>"/>
	<input type="hidden" name="atchFileId" value="${wisckoUnivVO.univLogo}">
	<input type="hidden" name="fileSn">
	
	<!-- 중복방지 Token Parameter -->
	<input type="hidden" name="TOKEN_KEY" value="<%=request.getAttribute("TOKEN_KEY")%>" />
	<!-- 중복방지 Token Parameter -->

<!-- sub title start -->
<div><h2>대학상세정보</h2></div>
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
			<td class="td_width">대학교명</td>
			<td class="td_content">
				<form:input path="univNm" cssClass="txt"/>
				&nbsp;<form:errors path="univNm" />
			</td>
			<td class="td_width">로고</td>
			<td class="td_content">
				<c:choose>
					<c:when test="${empty wisckoUnivVO.univLogo}">
			            <form:input path="ctprvnCd" cssClass="txt"/>
						&nbsp;<form:errors path="ctprvnCd" />
					</c:when>
					<c:otherwise>
						<c:import url="/cmm/fms/selectImageFileInfs.do" charEncoding="UTF-8">
			                <c:param name="atchFileId" value="${wisckoUnivVO.univLogo}" />
			                <c:param name="imageWidth" value="100" />
			            </c:import>
		            </c:otherwise>
				</c:choose>
			</td>
		</tr>	
		<tr>
			<td class="td_width">도시코드</td>
			<td class="td_content">
				<form:input path="ctprvnCd" cssClass="txt"/>
				&nbsp;<form:errors path="ctprvnCd" />
			</td>
			<td class="td_width">시군구코드</td>
			<td class="td_content">
				<form:input path="signguCd" cssClass="txt"/>
				&nbsp;<form:errors path="signguCd" />
			</td>
		</tr>	
		<tr>
			<td class="td_width">정렬순서</td>
			<td class="td_content">
				<form:input path="sortOrdr" cssClass="txt"/>
				&nbsp;<form:errors path="sortOrdr" />
			</td>
			<td class="td_width">사용여부</td>
			<td class="td_content">
				<form:radiobutton path="useAt" value="Y"/>사용
				<form:radiobutton path="useAt" value="N"/>미사용
				&nbsp;<form:errors path="useAt" />
			</td>
		</tr>
	    <tr>
	      <td class="td_width"><label for="egovComFileUploader"><spring:message code="cop.atchFile" /></label></td>
	      <td class="td_content" colspan="3">
		      <div id="file_upload_posbl"  style="display:none;" >    
		            <input name="file_1" id="egovComFileUploader" type="file" />
		            <div id="egovComFileList"></div>
		      </div>
		      <div id="file_upload_imposbl"  style="display:none;" >
		          <spring:message code="common.imposbl.fileupload" />
		      </div>
	      <c:if test="${empty wisckoUnivVO.univLogo}">
	          <input type="hidden" id="fileListCnt" name="fileListCnt" value="0" />
	      </c:if> 
	      </td>
	    </tr>
	</table>
	
	
	<script type="text/javascript">
		var existFileNum = 0;        
		var maxFileNum = 1;
		
		if (existFileNum=="undefined" || existFileNum ==null) {
		    existFileNum = 0;
		}
		if (maxFileNum=="undefined" || maxFileNum ==null) {
		    maxFileNum = 0;
		}       
		var uploadableFileNum = maxFileNum - existFileNum;
		if (uploadableFileNum<0) {
		    uploadableFileNum = 0;
		}               
		if (uploadableFileNum != 0) {
		    fn_egov_check_file('Y');
		    var multi_selector = new MultiSelector( document.getElementById( 'egovComFileList' ), uploadableFileNum );
		    multi_selector.addElement( document.getElementById( 'egovComFileUploader' ) );
		} else {
		    fn_egov_check_file('N');
		}           
	</script>
	
	
  	</div>
	<div class="buttons" align="center" style="margin-bottom:100px">
		<a href="#LINK" onclick="javascript:fn_egov_selectList(); return fasle;"><spring:message code="button.list" /></a>
		<a href="#LINK" onclick="javascript:fn_egov_save(); return fasle;"><spring:message code="button.save" /></a>
		<a href="#LINK" onclick="javascript:fn_egov_delete(); return fasle;"><spring:message code="button.delete" /></a>		
	</div>


</div>
<!-- contents end -->

</form:form>
</body>
</html>

