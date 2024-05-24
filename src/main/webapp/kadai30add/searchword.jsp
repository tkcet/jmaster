<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/jmaster/kadai30add/registword.jsp">単語登録</a>
	<a href="/jmaster/kadai30add/searchword.jsp">単語検索</a>
	<hr>
	<form action="/jmaster/wordservlet?action=search" method="post">
		キーワード： <input type="text" name="searchWord"><br>
		<input type="submit" value="検索">
	</form>
</body>
</html>