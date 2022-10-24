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
	Optional<String> message = 
		Optional.ofNullable((String) request.getAttribute("message"));
Optional<String> string = 
	Optional.ofNullable((String) request.getAttribute("string"));

%>

<body>
<H1>Sentiment</H1>
<ul>
	<li>Positive:<%= string.orElse("ERROR") %></li>
	<li>Neutral：<%= message.orElse("ERROR") %></li>
	<li>Negative:<%= %></li>
</ul>
</body>
</html>