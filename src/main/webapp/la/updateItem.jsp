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
	<h1>商品更新</h1>
	<form action="/jmaster/ItemServlet" method="post">
		<table border="1">
			<tr>
				<td>コード</td><td><input type="text" name="code" value="${ITEM.code }" readonly></td>
			</tr>
			<tr>
				<td>カテゴリーコード</td><td><input type="text" name="categoryCode" value="${ITEM.categoryCode }"></td>
			</tr>
			<tr>
				<td>名前</td><td><input type="text" name="name" value="${ITEM.name }"></td>
			</tr>
			<tr>
				<td>価格</td><td><input type="text" name="price" value="${ITEM.price }"></td>
			</tr>
		</table>
		<input type="submit" value="更新"><input type="hidden" name="action" value="update2">
	</form>
</body>
</html>