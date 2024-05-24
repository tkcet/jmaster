<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占い</title>
</head>
<body>
	<h1>占いたい月を入力してね</h1>
	<form action="/jmaster/FortuneServlet" method="get">
		<select name="MONTH">
			<c:forEach var="i" begin="1" end="12" step="1">
				<option value="${i }">${i }</option>
			</c:forEach>
		</select> 月 <input type="submit" value="占ってみる">
	</form>
	<hr>
	
	<c:if test="${bean.month != null }">
	${bean.month }月の運勢は、、、<br>
	・ラッキーカラー：${bean.color }<br>
	・ラッキーアイテム：${bean.item }<br>
	・順位は：${bean.rank }<br>
	</c:if>
</body>
</html>