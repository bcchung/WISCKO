<%--
  Class Name : EgovImgFileList.jsp
  Description : 이미지 파일 조회화면(include)
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2009.03.31  이삼섭          최초 생성
     2011.08.31  JJY       경량환경 버전 생성
 
    author   : 공통서비스 개발팀 이삼섭
    since    : 2009.03.31
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<script type="text/javascript">
	function fn_egov_downFile(atchFileId, fileSn){
		window.open("<c:url value='/cmm/fms/FileDown.do?atchFileId="+atchFileId+"&fileSn="+fileSn+"'/>");
	}	
	
	function fn_egov_deleteFile(atchFileId, fileSn) {
		forms = document.getElementsByTagName("form");

		for (var i = 0; i < forms.length; i++) {
			if (typeof(forms[i].atchFileId) != "undefined" &&
					typeof(forms[i].fileSn) != "undefined") {
				form = forms[i];
			}
		}
		form.atchFileId.value = atchFileId;
		form.fileSn.value = fileSn;
		form.action = '<c:url value="/cmm/fms/deleteFileInfs.do"/>';
		form.submit();
	}
</script>
<c:forEach var="fileVO" items="${fileList}" varStatus="status">
	<img
		src='<c:url value='/cmm/fms/getImage.do'/>?atchFileId=<c:out value="${fileVO.atchFileId}"/>&fileSn=<c:out value="${fileVO.fileSn}"/>'
		width="<c:out value="${imageWidth}"/>" alt="파일보기링크"/>
	<img alt="파일 삭제" src="<c:url value='/images/btn/bu5_close.gif'/>" 
			       		width="19" height="18" onClick="javascript:fn_egov_deleteFile('<c:out value="${fileVO.atchFileId}"/>','<c:out value="${fileVO.fileSn}"/>');" />
	<c:if test="${!status.last}"><br/></c:if>
</c:forEach>
