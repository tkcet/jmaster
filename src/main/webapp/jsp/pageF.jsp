<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List, java.util.ArrayList"%>
<%@page import="java.util.Map, java.util.HashMap"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フォワード処理</title>
</head>
<body>
	<%
	request.setAttribute("data", 10);
	request.setAttribute("data2", "null");
	%>
	●EL式
	<br> ${data > 0 }
	<br> ${data gt 0 }
	<br> ${empty data2 }
</body>
</body>
</html>