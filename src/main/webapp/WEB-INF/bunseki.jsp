<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Object o =request.getAttribute("negative");
	float negative = (float)o;

	Object p =request.getAttribute("neutral");
	float neutral = (float)p;
	
	Object q =request.getAttribute("positive");
	float positive = (float)q;

%>

<body>
<H1>Sentiment</H1>
<ul>
	<li>Positive:<%= negative %></li>
	<li>Neutral：<%= neutral %></li>
	<li>Negative:<%= positive%></li>
</ul>
</body>
</html>