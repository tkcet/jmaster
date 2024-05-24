<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>英単語帳</title>
</head>
<body>
<body>
	<a href="/jmaster/kadai30add/registword.jsp">単語登録</a>
	<a href="/jmaster/kadai30add/searchword.jsp">単語検索</a>
	<hr>
	<table border="1">
		<tr>
			<th>英語</th>
			<th>日本語</th>
		</tr>
		<c:forEach var="word" items="${WORD }">
			<tr>
				<td>${word.getEnglish() }</td>
				<td>${word.getJapanese() }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>