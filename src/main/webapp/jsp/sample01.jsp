<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>初めてのJSP</title>
</head>
<body>
	<%!public int tasu(int x, int y) {
		return x + y;
	}%>
	<%--スクリプトレット（Javaのプログラムを書く領域） --%>
	<%
	// 名前を表示
	//for (int i = 0; i < 5; i++) {
	//	out.println("木村" + "<br>");
	//}

	String name = "木村";
	%>
	私の名前は<%=name%>です。
	<br> 加算結果：<%=tasu(10, 20)%><br>
</body>
</html>