<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page language="java"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.net.URLEncoder"%>

<%@ page import="javax.servlet.ServletException"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>

<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>

<%
	//request.setCharacterEncoding("UTF-8");

	String url = "";

	String contextRealPath = "";
	String savePath = "";

	String requestUrl  = request.getRequestURL().toString();
	String fileUrl   = requestUrl.substring(0, requestUrl.indexOf("/"))+"/PORTAL/FILE/";
	//String fileUrl   = requestUrl.substring(0, requestUrl.indexOf("/"))+"/FILE/";
	String PATH = "editor";
	
	contextRealPath = request.getSession().getServletContext().getRealPath("\\")+ "FILE\\";
	savePath = contextRealPath + PATH + "\\";
	
	System.out.println("savePath = " + savePath);

	File dir = new File(savePath);

	if (!dir.exists()) {
		if (!dir.mkdirs())
			throw new Exception("디렉토리 생성 오류");
	}

	int sizeLimit = 10 * 1024 * 1024; // 최대 업로드 파일 크기로 제한

	try {
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		Enumeration files = multi.getFileNames(); // 파일명 모두 얻기
		
		String callback = multi.getParameter("callback");
		String callback_func = multi.getParameter("callback_func");
		
		url = callback+"?callback_func="+callback_func;
		//System.out.println(url);
		
		String bfFileName = "";
		String fileType = "";
		Long fileSize = 0L;
		
		while (files.hasMoreElements()) {

			String name = (String) files.nextElement();
			bfFileName += multi.getFilesystemName(name);

			fileType = multi.getContentType(name);
			File f = multi.getFile(name);
			fileSize = f.length();

			String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date()); //현재시간
			int i = -1;
			i = bfFileName.lastIndexOf("."); // 파일 확장자 위치
			String afFileName = "";
			
			//확장자 없는 파일의 경우
			if ( i < 0)
			{
				afFileName = now;
			}
			else
			{
				afFileName = now + bfFileName.substring(i, bfFileName.length()); //현재시간과 확장자 합치기
			}

			File oldFile = new File(savePath + bfFileName);
			File newFile = new File(savePath + afFileName);

			oldFile.renameTo(newFile); // 파일명 변경
			
			url += "&bNewLine=true";
			url += "&sFileName="+URLEncoder.encode(bfFileName, "UTF-8");
			url += "&size="+fileSize;
			url += "&sFileURL="+fileUrl+PATH+"/"+URLEncoder.encode(afFileName, "UTF-8");
		}
	} catch (Exception e) {
		//System.out.println(e.toString());
		url += "&errstr=error";
	}
	System.out.println(url);
	response.sendRedirect(url);
%>
