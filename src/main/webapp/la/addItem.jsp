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
	<h1>商品登録</h1>
	<form action="/jmaster/ItemServlet" method="post">
		<table border="1">
			<tr>
				<td>カテゴリーコード</td><td><input type="text" name="categoryCode"></td>
			</tr>
			<tr>
				<td>名前</td><td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>価格</td><td><input type="text" name="price"></td>
			</tr>
		</table>
		<input type="submit" value="登録"><input type="hidden" name="action" value="regist">
	</form>
</body>
</html>