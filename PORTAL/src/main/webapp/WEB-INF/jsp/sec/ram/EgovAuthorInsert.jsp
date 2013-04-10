<%--
  Class Name : EgovAuthorInsert.jsp
  Description : EgovAuthorInsert 화면
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.02.01    lee.m.j          최초 생성
     2011.08.31  JJY       경량환경 버전 생성
 
    author   : 공통서비스개발팀 lee.m.j
    since    : 2009.02.01
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<c:set var="registerFlag" value="${empty authorManageVO.authorCode ? 'INSERT' : 'UPDATE'}"/>
<c:set var="registerFlagName" value="${empty authorManageVO.authorCode ? '권한 등록' : '권한 수정'}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="<c:url value="/validator.do"/>"></script>
<validator:javascript formName="authorManage" staticJavascript="false" xhtml="true" cdata="false"/>
<script type="text/javaScript" language="javascript">
<!--
function fncSelectAuthorList() {
	var varFrom = document.getElementById("authorManage");
	varFrom.action = "<c:url value='/sec/ram/EgovAuthorList.do'/>";
	varFrom.submit();       
}

function fncAuthorInsert() {

    var varFrom = document.getElementById("authorManage");
    varFrom.action = "<c:url value='/sec/ram/EgovAuthorInsert.do'/>";

    if(confirm("저장 하시겠습니까?")){
        if(!validateAuthorManage(varFrom)){           
            return;
        }else{
            varFrom.submit();
        } 
    }
}

function fncAuthorUpdate() {
	var varFrom = document.getElementById("authorManage");
	varFrom.action = "<c:url value='/sec/ram/EgovAuthorUpdate.do'/>";

    if(confirm("저장 하시겠습니까?")){
        if(!validateAuthorManage(varFrom)){           
            return;
        }else{
            varFrom.submit();
        } 
    }
}

function fncAuthorDelete() {
	var varFrom = document.getElementById("authorManage");
	varFrom.action = "<c:url value='/sec/ram/EgovAuthorDelete.do'/>";
	if(confirm("삭제 하시겠습니까?")){
	    varFrom.submit();
	}
}
//-->
</script>
</head>

<body>

            <!-- 현재위치 네비게이션 시작 -->
            <div id="cur_loc">
                    <div id="cur_loc_align">
                        <ul>
                            <li>HOME</li>
                            <li>&gt;</li>
                            <li>포털시스템관리</li>
                            <li>&gt;</li>
                            <li>사용자권한관리</li>
                            <li>&gt;</li>
                            <li><strong>권한관리</strong></li>
                        </ul>
                    </div>
            </div>
            <div id="content_field"><!--contents start-->
            
            <form:form commandName="authorManage" method="post" >
            
            <!-- sub title start -->
            <div><h2>권한 등록</h2></div>
            <!-- sub title end -->

            <!--detail area start -->
            <div class="search_service">
                <div class="search_top_table">                  
					<table summary="권한을 등록하는 테이블입니다.권한 코드,권한 명,설명,등록일자의 정보를 담고 있습니다.">
					  <tr>
					    <td class="td_width">권한  코드<img src="<c:url value='/'/>images/required.gif" alt="필수항목" title="필수항목" width="15" height="15"/></td>
					    <td class="td_content"><input name="authorCode" id="authorCode" type="text" value="<c:out value='${authorManage.authorCode}'/>" size="40" title="권한코드" />&nbsp;<form:errors path="authorCode" /></td>
					     
					  </tr>
					  <tr>  
					    <td class="td_width">권한 명<img src="<c:url value='/'/>images/required.gif" alt="필수항목" title="필수항목" width="15" height="15"/></td>
					    <td class="td_content"><input name="authorNm" id="authorNm" type="text" value="<c:out value='${authorManage.authorNm}'/>" maxLength="50" size="40" title="권한명" />&nbsp;<form:errors path="authorNm" /></td>
					    
					  </tr>
					  <tr>  
					    <td class="td_width">설명</td>
					    <td class="td_content"><input name="authorDc" id="authorDc" type="text" value="<c:out value='${authorManage.authorDc}'/>" maxLength="50" size="50" title="설명" /></td>
					  </tr>
					  <tr>  
					    <td class="td_width">등록일자</td>
					    <td class="td_content"><input name="authorCreatDe" id="authorCreatDe" type="text" value="<c:out value='${authorManage.authorCreatDe}'/>" maxLength="50" size="20" readonly="readonly" title="등록일자"/></td>
					  </tr>
					</table>
                </div>
            </div>
            <!--detail area end -->
            
            <!-- 목록/저장버튼  시작-->
            <table border="0" cellspacing="0" cellpadding="0" align="center"><tr><td>
            <div class="buttons" align="center" style="margin-bottom:100px">
		      <a href="#LINK" onclick="javascript:fncSelectAuthorList()" style="selector-dummy:expression(this.hideFocus=false);">목록</a> 
		      <c:if test="${registerFlag == 'INSERT'}">
		      <a href="#LINK" onclick="javascript:fncAuthorInsert()" style="selector-dummy:expression(this.hideFocus=false);">저장</a> 
		      </c:if>
		      <c:if test="${registerFlag == 'UPDATE'}">
		      <a href="#LINK" onclick="javascript:fncAuthorUpdate()" style="selector-dummy:expression(this.hideFocus=false);">저장</a> 
		      <a href="#LINK" onclick="javascript:fncAuthorDelete()" style="selector-dummy:expression(this.hideFocus=false);">삭제</a> 
		      </c:if>
            </div>
            </td></tr></table>
            <!-- 목록/저장버튼  끝-->
            
			<!-- 검색조건 유지 -->
			<c:if test="${registerFlag == 'UPDATE'}">
			<input type="hidden" name="searchCondition" value="<c:out value='${authorManageVO.searchCondition}'/>"/>
			<input type="hidden" name="searchKeyword" value="<c:out value='${authorManageVO.searchKeyword}'/>"/>
			<input type="hidden" name="pageIndex" value="<c:out value='${authorManageVO.pageIndex}'/>"/>
			</c:if>

		    <div align="right">
		        <input type="text" name="message" value="<c:out value='${message}'/>" size="30" readonly="readonly" title="메시지" />
		    </div>
    
            </form:form>
            
            </div><!-- contents end -->

</body>
</html>

