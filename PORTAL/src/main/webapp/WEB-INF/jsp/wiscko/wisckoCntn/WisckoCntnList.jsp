<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script type="text/javaScript" language="javascript" defer="defer">
<!--
/* Update function */
$j(document).ready(function() {
	$j(".preViewPopup").popupWindow({
		centerScreen : 1
	});
});

function fn_egov_select(cntnId) {
	document.getElementById("listForm").cntnId.value = cntnId;
	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoCntn/updateWisckoCntnView.do'/>";
	document.getElementById("listForm").submit();
}

/* Register function */
function fn_egov_addView() {
	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoCntn/addWisckoCntnView.do'/>";
	document.getElementById("listForm").submit();
}

function fn_egov_selectSearch() {
	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoCntn/WisckoCntnList.do'/>";
	document.getElementById("listForm").submit();
}

/* pagination page Link function */
function fn_egov_link_page(pageNo) {
	document.getElementById("listForm").pageIndex.value = pageNo;
	document.getElementById("listForm").action = "<c:url value='/wiscko/wisckoCntn/WisckoCntnList.do'/>";
	document.getElementById("listForm").submit();
}
// -->
</script>
<style type="text/css">
h1 {
	font-size: 12px;
}

caption {
	visibility: hidden;
	font-size: 0;
	height: 0;
	margin: 0;
	padding: 0;
	line-height: 0;
}

A:link {
	color: #000000;
	text-decoration: none;
}

A:visited {
	color: #000000;
	text-decoration: none;
}

A:active {
	color: #000000;
	text-decoration: none;
}

A:hover {
	color: #fa2e2e;
	text-decoration: none;
}
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
<div id="content_field">
<!--contents start-->

<form:form commandName="searchVO" name="listForm" id="listForm" method="post">
	<input type="hidden" name="cntnId" />
	<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>" />

<!-- sub title start -->
<div>
	<h2>컨텐츠관리</h2>
</div>
<!-- sub title end -->

<!-- search area start-->
<div class="search_service">
	<div class="search_area">
		<div class="search_conditions">
			<label for="searchCnd">SEARCH</label>
			<select name="searchCnd" class="select" title="SEARCH">
			</select>
		</div>
		<div class="search_buttons">
			<input type="submit" value="<spring:message code="button.inquire" />" onclick="fn_egov_selectSearch(); return false;"/>
			<a href="#LINK" onclick="fn_egov_addView(); return false;"><spring:message code="button.create"/></a>
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
		</colgroup>
		<tr>
			<th align="center">컨텐츠명</th>
			<th align="center">등록일</th>
			<th align="center">등록자</th>
			<th align="center">미리보기</th>
		</tr>
		<c:if test="${fn:length(resultList) == 0}">
			<tr>
				<td colspan="4"><spring:message code="common.nodata.msg" /></td>
			</tr>
		</c:if>
		<c:forEach var="result" items="${resultList}" varStatus="status">
			<tr>
				<td align="center" class="listtd"><a href="javascript:fn_egov_select('<c:out value="${result.cntnId}"/>')"><c:out value="${result.nttSj}"/></a>&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.frstRegistPnttm}" />&nbsp;</td>
				<td align="center" class="listtd"><c:out value="${result.frstRegisterId}" />&nbsp;</td>
				<td align="center" class="listtd">
				<a href="<c:url value="/wiscko/wisckoCntn/selectWisckoCntnLocaleView.do"/>?cntnId=<c:out value="${result.cntnId}"/>"
					class="preViewPopup">미리보기</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<!-- /List -->

</div>
<!-- search result end -->

<div id="paging_div">
	<ul class="paging_align">
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_egov_link_page" />
	</ul>
</div>

</form:form>
</body>
</html>
