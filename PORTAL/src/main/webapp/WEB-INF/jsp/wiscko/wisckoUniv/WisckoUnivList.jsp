<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
 /**
  * @Class Name : WisckoUnivList.jsp
  * @Description : WisckoUniv List
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
<script type="text/javaScript" language="javascript" defer="defer">
<!--
function fn_egov_select(univId) {
    document.getElementById("listForm").univId.value = univId;
   	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoUniv/updateWisckoUnivView.do'/>";
   	document.getElementById("listForm").submit();
}

/* Register function */
function fn_egov_addView() {
   	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoUniv/addWisckoUnivView.do'/>";
   	document.getElementById("listForm").submit();		
}

/* pagination page Link function */
function fn_egov_link_page(pageNo){
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoUniv/WisckoUnivList.do'/>";
   	document.getElementById("listForm").submit();
}

 // -->
</script>
<style type="text/css">
	h1 {font-size:12px;}
	caption {visibility:hidden; font-size:0; height:0; margin:0; padding:0; line-height:0;}
	A:link    { color: #000000; text-decoration:none; }
	A:visited { color: #000000; text-decoration:none; }
	A:active  { color: #000000; text-decoration:none; }
	A:hover   { color: #fa2e2e; text-decoration:none; }	
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
<div id="content_field"><!--contents start-->

<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
    <input type="hidden" name="univId" />
    
<!-- sub title start -->
<div><h2>대학교관리</h2></div>
<!-- sub title end -->

<!-- search area start-->
<div class="search_service">
    <div class="search_area">
	    <div class="search_conditions" >
	    <label for="searchCondition" >검색유형선택</label>
	        <select name="searchCondition" class="select" title="검색유형선력">
	            <option value="0" <c:if test="${searchVO.searchCondition == '0'}">selected="selected"</c:if> >대학명</option>
	        </select>
	        <label for="searchKeyword" >검색어</label>
	        <input name="searchKeyword" type="text">
	    </div>
        <div class="search_buttons">
            <input type="submit" value="<spring:message code="button.inquire" />" onclick="fn_egov_select_brdMstr('1'); return false;" />
            <a href="<c:url value='/wiscko/wisckoUniv/addWisckoUnivView.do'/>" onclick="fn_egov_addView(); return false;"><spring:message code="button.create"/></a>
        </div>
    </div> 
</div>
<!-- search area end -->
    
<!-- search result start -->
<div class="search_result_div">

	<!-- List -->
	<div id="table">
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<colgroup>
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />
				<col />		
			</colgroup>		  
			<tr>
				<th align="center">대학교명</th>
				<th align="center">로고</th>
				<th align="center">도시코드</th>
				<th align="center">정렬순서</th>
				<th align="center">사용여부</th>
				<th align="center">수정자</th>
				<th align="center">수정일자</th>
			</tr>
			<c:if test="${fn:length(resultList) == 0}">
        	<tr>
                <td colspan="7"><spring:message code="common.nodata.msg" /></td>
            </tr>
            </c:if>
			<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center" class="listtd">
					<a href="javascript:fn_egov_select('<c:out value="${result.univId}"/>')"><c:out value="${result.univNm}"/></a>&nbsp;</td>
				<td align="center" class="listtd">
					<c:import url="/cmm/fms/selectImageFileInfs.do" charEncoding="UTF-8">
		                <c:param name="atchFileId" value="${result.univLogo}" />
		                <c:param name="imageWidth" value="100" />
		                <c:param name="delPosbleAt" value="N" />
		            </c:import>
				&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.ctprvnCd}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.sortOrdr}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.useAt}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.lastUpdusrId}"/>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.lastUpdtPnttm}"/>&nbsp;</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<!-- /List -->
	
</div>
<!-- search result end -->

<div id="paging_div">
	<ul class="paging_align">
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_select_brdMstr" />
	</ul>
</div>
<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>

</form:form>
</body>
</html>
