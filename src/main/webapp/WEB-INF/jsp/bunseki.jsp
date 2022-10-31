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
	Object m =request.getAttribute("moto");
	String moto = (String)m;
	
	Object o =request.getAttribute("negative");
	double negative = (double)o;

	Object p =request.getAttribute("neutral");
	double neutral = (double)p;
	
	Object q =request.getAttribute("positive");
	double positive = (double)q;

%>

<body>
<H1>Sentiment結果</H1>
<table>
	<tr><td>negative</td>
		<td>:</td>
		<td><%= negative %></td>
	</tr>
	<tr><td>Neutral</td>
		<td>:</td>
		<td><%= neutral %></td>
	</tr>
	<tr><td>positive</td>
		<td>:</td>
		<td><%= positive %></td>
	</tr>
</table>
</body>
</html>