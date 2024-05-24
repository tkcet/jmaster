<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>おみくじ</title>
</head>
<body>
	<h1>STEP1</h1>
	<%@page import="java.util.Random"%>


	スクリプトレットで繰り返し処理を利用しておみくじ
	<br>
	<%
	for (int i = 1; i <= 12; i++) {
		out.println(i + "月はの運勢は、、、「 ");
		Random random = new Random();
		int randomValue = random.nextInt(6);
	%>

	<%
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
	out.println("」です。");
	out.println("<br>");
	}
	%>


</body>
</html>