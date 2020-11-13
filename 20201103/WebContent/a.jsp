<%@page import="aa.bb.cc.A"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<String> al = new ArrayList<String>();
al.add("aa");
al.add("bb");
al.add("cc");
//al의 값을 하나씩 가지고 와서 집어 넣음
for (String temp : al) {
	System.out.println("temp = " + temp);
}

//for (int i = 0; i < al.size(); i++) {
//	String temp = al.get(i);
//	System.out.println("temp = " + temp);
//}

A a = new A();
a.doPrint();
out.print(a.a);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		
	%>
</body>
</html>