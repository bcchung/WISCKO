<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Locale" %>
<%@ page import="org.springframework.context.i18n.LocaleContextHolder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Locale Display</title></head>
<body>
<h2>Here is your preferred locale info...</h2>

<c:set var="clientLocale" value="${pageContext.request.locale}" />
<c:set var="clientLocales" value="${pageContext.request.locales}" />

Preferred locale: ${clientLocale.displayName}
 <br />
Preferred locale country: ${clientLocale.displayCountry}
<br />
Preferred locale language: ${clientLocale.displayLanguage}
<h3>Lower priority locales...</h3>
<c:forEach var="loc" items="${clientLocales}" begin="1">
    Locale: ${loc.displayName} | Locale country: ${loc.displayCountry} | Locale language: ${loc.displayLanguage}<br/>
</c:forEach>
<br/>
<%
Locale locale = LocaleContextHolder.getLocale();
out.println("[System Locale] ======================== [" + locale + "]");
%>


<a href="?locale=ko">한국어</a> | <a href="?locale=en">영어</a> | <a href="?locale=de">독일어</a><br/>
</body>
</html>