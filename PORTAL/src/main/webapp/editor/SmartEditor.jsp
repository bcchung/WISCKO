<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	
	String v_width = request.getParameter("v_width");
	String v_height = request.getParameter("v_height");
	
	int temp = Integer.parseInt(v_height) - 49;
	v_height = String.valueOf(temp);
%>

<!-- ################################################################################################################################## -->
<!-- #### ==== SmartEditor Layout Start ========================================================================================== #### -->
	<style type="text/css">
          body {
               margin-left: 0px;
               margin-top: 0px;
               margin-right: 0px;
               margin-bottom: 0px;
               width: 100%;
               height:100%;
          }
    </style>
	<script type="text/javascript" src="<c:url value='/'/>editor/js/HuskyEZCreator.js" charset="UTF-8"></script>
	<script type="text/javascript" src="<c:url value='/'/>js/jquery-1.9.1.js" charset="UTF-8"></script>
	<form id="frmSMEditor">
		<textarea name="editorData" id="editorData" style="width:100%; height:<%=v_height%>px; min-width:<%=v_width%>px; display:none;"></textarea>
		<input id="editorGetBtn" name="editorGetBtn" value="test" type="button" onclick="fn_getEditor()" style="display:none" />
		<input id="editorSetBtn" name="editorSetBtn" value="" type="button" onclick="fn_setEditor()"  style="display:none" />
	</form>
	<script>
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef: oEditors,
			elPlaceHolder: "editorData",
			sSkinURI: "<c:url value='/'/>editor/SmartEditor2Skin.html",
			fCreator: "createSEditor2",
			htParams: { fOnBeforeUnload : function() {} }
		});
	
		// 화면의 데이터셋 CONTENTS값을 웹에디터에 세팅(정상작동 확인)
		function fn_setEditor(){
			//sHTML = document.getElementById("editorData").value; //chrome에서 동작안되서 jquery문으로 변경
			sHTML = $j("#editorData").text();
			oEditors[0].exec("SET_IR", [sHTML]);
		}
		
		//웹 에디터에 편집한 내용을 화면으로 전달하기 위한 준비작업(editorData에 편집한 내용 세팅, 화면에서는 여기에 접근)
		function fn_getEditor() {
			oEditors[0].exec("UPDATE_CONTENTS_FIELD", []);
		}
	</script>
<!-- #### ==== SmartEditor Layout End   ========================================================================================== #### -->
<!-- ################################################################################################################################## -->