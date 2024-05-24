<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>掲示板</title>
</head>
<body>
	<%
	//文字化け対策
	request.setCharacterEncoding("UTF-8");

	//送信データを取得
	String name = request.getParameter("NAME");
	String message = request.getParameter("TEXT");

	@SuppressWarnings("unchecked")
	List<String> list = (List<String>) session.getAttribute("CONTENT");

	if (list == null) {
		list = new ArrayList<>();
		session.setAttribute("CONTENT", list);
	}

	if (name != null && message != null) {
		list.add(name + "：" + message);
	}
	%>
	<form action="bbs.jsp" method="POST">
		名前：
		<div>
			<input type="text" name="NAME">
		</div>
		メッセージ： <br>
		<div>
			<textarea name="TEXT" rows="5" cols="40"></textarea>
		</div>
		<div>
			<input type="submit" value="書き込み">
		</div>
	</form>
	<%
	for (String data : list) {
	%>
	<%=data%><br>
	<hr>
	<%
	}
	%>
</body>
</html>