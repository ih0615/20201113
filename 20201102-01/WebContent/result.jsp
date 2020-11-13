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
	String gender = request.getParameter("gender");
	String asdf = request.getParameter("asdf");
	int gender1 = Integer.parseInt(gender);
	if (gender1 == 1) {
		gender = "남성";
	} else if (gender1 == 2) {
		gender = "여성";
	}
	out.println(name + "<br>" + gender + "<br>" + asdf + "<br>");
	// DB 연결 유지 객체 
	Connection conn = null;
	// DB sql 작성 객체
	PreparedStatement pstmt = null;

	try {
		//ojdbc6.jar파일 추가 확인
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
		out.println("연결 성공");
		//띄워쓰기 해줘야 함
		pstmt = conn.prepareStatement("insert into aa1 " + "(name,age,remark) " + "values " + "('"+name+"','"+gender1+"','"+asdf+"')");
		pstmt.executeUpdate();
	} catch (Exception e) {
		out.println("연결 실패");
	} finally {
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}
	%>
</body>
</html>