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
		String ID = request.getParameter("ID");
	String PW = request.getParameter("PW");
	if (ID.equals("admin") && PW.equals("1234")) {
		out.println("로그인에 성공하셨습니다.");

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
			pstmt = conn.prepareStatement("insert into member123 values(?,?)");
			pstmt.setString(1, ID);
			pstmt.setString(2, PW);
			pstmt.executeUpdate();
		} catch (Exception e) {

		} finally {
			conn.close();
			pstmt.close();
		}
	} else {
		out.println("아이디나 비밀번호가 일치하지 않습니다.");
	}
	%>
</body>
</html>