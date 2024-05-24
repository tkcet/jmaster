<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ</title>
</head>
<body>
	<h1>STEP3</h1>
	<%@page import="java.util.Random"%>

	リクエストパラメータを取得しておみくじ結果を表示
	<br>
	<%=(String)request.getParameter("NAME")%>さんの今日の運勢は、、、「
	<%
	request.setCharacterEncoding("Shift_JIS");
	
	Random random = new Random();
	int randomValue = random.nextInt(6);

	switch (randomValue) {
	case 0:
		out.println("大吉");
		break;
	case 1:
		out.println("吉");
		break;
	case 2:
		out.println("吉");
		break;
	case 3:
		out.println("吉");
		break;
	case 4:
		out.println("小吉");
		break;
	case 5:
		out.println("凶");
		break;
	default:
		break;
	}
	%>
	」です。
</body>
</html>