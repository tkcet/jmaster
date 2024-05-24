<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empテーブル検索</title>
</head>
<body>
	<form action="/jmaster/EmpServlet" method="get">
		年齢の下限（必須） <input type="text" name="MINAGE" placeholder="下限" value="${MIN }"> 、
		年齢の上限（必須） <input type="text" name="MAXAGE" placeholder="上限" value=${MAX }> 
		<input type="submit" value="検索">
		<input type="hidden" name="action" value="search">
	</form>
	<form action="/jmaster/EmpServlet" method="get">
		上位 <input type="text" name="RANK" placeholder="人数" value="${NUM }"> 人
		<input type="submit" value="検索">
		<input type="hidden" name="action" value="desc">
	</form>
	<hr>
	<table border="1">
		<tr>
			<td>NO.</td>
			<td>名前</td>
			<td>年齢</td>
			<td>電話番号</td>
		</tr>


		<c:forEach var="emp" items="${emps}">
			<tr>
				<td>${emp.code}</td>
				<td>${emp.name}</td>
				<td>${emp.age}</td>
				<td>${emp.tel}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>