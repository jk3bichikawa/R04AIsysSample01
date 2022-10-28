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
	double negative = (double)o;

	Object p =request.getAttribute("neutral");
	double neutral = (double)p;
	
	Object q =request.getAttribute("positive");
	double positive = (double)q;

%>

<body>
<H1>Sentiment</H1>
<ul>
	<li>negative:<%= negative %></li>
	<li>Neutral：<%= neutral %></li>
	<li>positive:<%= positive%></li>
</ul>
</body>
</html>