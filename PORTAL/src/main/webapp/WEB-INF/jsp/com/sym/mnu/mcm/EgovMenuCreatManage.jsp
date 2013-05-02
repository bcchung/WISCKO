<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : EgovMenuCreatManage.jsp
 * @Description : 메뉴생성관리 조회 화면
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.10    이용          최초 생성
 *
 *  @author 공통서비스 개발팀 이용
 *  @since 2009.03.10
 *  @version 1.0
 *  @see
 *
 */

/* Image Path 설정 */
String imagePath_icon = "/images/egovframework/com/sym/mnu/mcm/icon/";
String imagePath_button = "/images/egovframework/com/sym/mnu/mcm/button/";
%>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/com.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/css/egovframework/com/cmm/button.css' />" type="text/css">
<title>메뉴생성관리</title>
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
</style>
<script language="javascript1.2" type="text/javaScript">/* ********************************************************
 * 최초조회 함수
 ******************************************************** */
function fMenuCreatManageSelect(){
    document.menuCreatManageForm.action = "<c:url value='/sym/mnu/mcm/EgovMenuCreatManageSelect.do'/>";
    document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function linkPage(pageNo){
	document.menuCreatManageForm.pageIndex.value = pageNo;
	document.menuCreatManageForm.action = "<c:url value='/sym/mnu/mcm/EgovMenuCreatManageSelect.do'/>";
   	document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 조회 처리 함수
 ******************************************************** */
function selectMenuCreatManageList() {
	document.menuCreatManageForm.pageIndex.value = 1;
    document.menuCreatManageForm.action = "<c:url value='/sym/mnu/mcm/EgovMenuCreatManageSelect.do'/>";
    document.menuCreatManageForm.submit();
}

/* ********************************************************
 * 메뉴생성 화면 호출
 ******************************************************** */
function selectMenuCreat(locale, vAuthorCode) {
	document.menuCreatManageForm.locale.value = locale;
	document.menuCreatManageForm.authorCode.value = vAuthorCode;
   	document.menuCreatManageForm.action = "<c:url value='/sym/mnu/mcm/EgovMenuCreatSelect.do'/>";
   	document.menuCreatManageForm.submit();
}
<c:if test="${!empty resultMsg}">alert("${resultMsg}");</c:if>
-->
</script>
</head>
<body>


<form name="menuCreatManageForm" action="<c:url value='/sym/mnu/mcm/EgovMenuCreatManageSelect.do'/>" method="post">
	<input name="checkedMenuNoForDel" type="hidden" />
	<input name="authorCode" type="hidden" />
	<input name="pageIndex" type="hidden" value="<c:out value='${searchVO.pageIndex}'/>"/>
	<input type="hidden" name="req_menuNo">
	<input type="hidden" name="locale">
	
<table width="100%" cellpadding="8" class="table-search" border="0">
	<tr>
		<td width="40%" class="title_left">
			<h1>
				<img src="<c:url value='/images/egovframework/com/cmm/icon/tit_icon.gif' />" width="16" height="16" hspace="3" alt=""/>&nbsp;메뉴생성관리
			</h1>
		</td>
		<th></th>
		<td width="10%"></td>
		<td width="35%"></td>
		<th width="10%">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td></td>
				</tr>
			</table>
		</th>
	</tr>
</table>
<%-- <table width="100%" border="0" cellpadding="0" cellspacing="1">
	<tr>
		<td width="100%">
			<table width="100%" border="0" cellpadding="0" cellspacing="1" class="table-register" summary="메뉴생성관리 검색조건">
				<caption>메뉴생성관리 검색조건</caption>
				<tr>
					<th width="20%" height="40" class="" scope="row"><label for="searchKeyword">보안설정대상ID*&nbsp;</label></th>
					<td width="80%">
						<table border="0" cellspacing="0" cellpadding="0" align="left">
							<tr>
								<td>&nbsp;<input name="searchKeyword" type="text" size="80" value="" maxlength="60" title="검색조건" /></td>
								<td width="5%"></td>
								<td><span class="button"><input type="submit" value="<spring:message code="button.inquire" />"
										onclick="selectMenuCreatManageList(); return false;"/></span></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table> --%>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="10">&nbsp;</td>
	</tr>
</table>
<table width="100%" cellpadding="8" class="table-line">
	<caption>메뉴생성관리 목록</caption>
	<thead>
		<tr>
			<th class="title" width="20%" scope="col">권한코드</th>
			<th class="title" width="10%" scope="col">권한명</th>
			<th class="title" width="10%" scope="col">권한 설명</th>
			<th class="title" width="60%" scope="col">메뉴생성(국가별설정)</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="result" items="${list_menumanage}" varStatus="status">
		<tr>
			<td class="lt_text3" style="cursor: hand;"><c:out value="${result.authorCode}" /></td>
			<td class="lt_text3" style="cursor: hand;"><c:out value="${result.authorNm}" /></td>
			<td class="lt_text3" style="cursor: hand;"><c:out value="${result.authorDc}" /></td>
			<td class="lt_text3">
				<c:forEach var="locale" items="${localeTcList}" varStatus="localeStatus">
				<span class="button">
					<a href="<c:url value='/sym/mnu/mcm/EgovMenuCreatSelect.do'/>?locale='<c:out value="${locale.code}"/>'&authorCode='<c:out value="${result.authorCode}"/>'"
						onclick="selectMenuCreat('<c:out value="${locale.code}"/>', '<c:out value="${result.authorCode}"/>'); return false;"><c:out value="${locale.codeNm}"/></a>
				</span>
				</c:forEach>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<!-- 페이징 시작 -->
<div id="paging_div">
	<ul class="paging_align">
		<ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="linkPage" />
	</ul>
</div>
<!-- 페이징 끝 -->
</form>
</body>
</html>

