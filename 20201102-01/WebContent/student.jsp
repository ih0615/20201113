<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
		String name = request.getParameter("name");
	String ageinput = request.getParameter("age");
	int age = Integer.parseInt(ageinput);
	String gender = request.getParameter("gender");
	String other = request.getParameter("other");

	Connection connect = null;

	PreparedStatement PS = null;

	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
		out.println("연결 성공");
		PS = connect.prepareStatement("insert into student " + "(name,age,gender,other) " + "values " + "('" + name + "','"
		+ age + "','" + gender + "','" + other + "')");
		PS.executeUpdate();
		connect.commit();
	} catch (Exception e) {
		out.println("연결 실패");
		connect.rollback();
	} finally {
		if (PS != null) {
			PS.close();
		}
		if (connect != null) {
			connect.close();
		}
	}
	%>
</body>
</html>