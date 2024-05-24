<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>
<h1>商品一覧</h1>
	<table border="1">
	<tr><td>コード</td><td>カテゴリーコード</td><td>商品名</td><td>値段</td><td>更新</td><td>削除</td></tr>
	
	<c:forEach items="${items}" var="item">
		<tr><td>${item.code}</td><td>${item.categoryCode}</td><td>${item.name}</td><td>${item.price}</td>
		<td>
		<form action="/jmaster/ItemServlet" method="post">
		<input type="submit" value="更新">
		<input type="hidden" name="action" value="update1">
		<input type="hidden" name="CODE" value="${item.code }">
		</form>
		</td>
		<td>
		<form action="/jmaster/ItemServlet" method="post">
		<input type="submit" value="削除">
		<input type="hidden" name="action" value="delete1">
		<input type="hidden" name="CODE" value="${item.code }">
		</form>
		</td></tr>
	</c:forEach>
	
	</table>
	<a href="/jmaster/la/addItem.jsp" method="get">新規登録</a>
</body>
</html>