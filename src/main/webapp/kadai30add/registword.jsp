<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>英単語帳</title>
</head>
<body>
	<a href="/jmaster/kadai30add/registword.jsp">単語登録</a>
	<a href="/jmaster/kadai30add/searchword.jsp">単語検索</a>
	<hr>
	<form action="/jmaster/wordservlet?action=insert" method="post">
		英語： <input type="text" name="English"><br>
		日本語： <input type="text" name="Japanese"><br>
		<input type="submit" value="登録">
	</form>
</body>
</html>