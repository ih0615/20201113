<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String a = request.getParameter("number");
	out.println("a = "+a+"<br>");
	int gugudan = Integer.parseInt(a);
	for(int i = 1;i<10;i++){
		out.println(gugudan+" X "+i+" = "+gugudan*i+"<br>");
	}
%>
</body>
</html>