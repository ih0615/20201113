<%@page import="java.sql.DriverManager"%>
<%@page
	import="org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<h2>
		<b>작성하신 내용은 아래와 같습니다.</b>
	</h2>
	<%
		String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String ID = request.getParameter("ID");
	String PW = request.getParameter("PW");
	String PWR = request.getParameter("PWR");
	String address = request.getParameter("address");
	String tel = request.getParameter("tel");
	String email = request.getParameter("email");
	String[] hobby = request.getParameterValues("hobby");
	String allhobby = "";
	if (name != null && ID != null && PW != null && PW.equals(PWR) && address != null && tel != null && email != null) {
		out.println("이름 : " + name);
		out.println("<hr>");
		out.println("성별 : " + gender);
		out.println("<hr>");
		out.println("아이디 : " + ID);
		out.println("<hr>");
		out.println("주소 : " + address);
		out.println("<hr>");
		out.println("전화번호 : " + tel);
		out.println("<hr>");
		out.println("이메일 : " + email);
		out.println("<hr>");
		out.println("취미");
		if (hobby != null) {
			out.println("<table>");
			for (int i = 0; i < hobby.length; i++) {
		out.println("<tr>");
		out.println("<td>");
		out.println(hobby[i]);
		out.println("</td>");
		out.println("</tr>");
		allhobby += hobby[i] + " ";
			}
			Connection conn = null;
			PreparedStatement premt = null;
			try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.90:1521:xe", "scott", "1234");
		premt = conn.prepareStatement("insert into join123 values(?,?,?,?,?,?,?,?)");
		premt.setString(1, name);
		premt.setString(2, gender);
		premt.setString(3, ID);
		premt.setString(4, PW);
		premt.setString(5, address);
		premt.setString(6, tel);
		premt.setString(7, email);
		premt.setString(8, allhobby);
		premt.executeUpdate();
			} catch (Exception e) {

			} finally {
		conn.close();
		premt.close();
			}
		} else {
			out.println("선택한 취미가 없습니다.");
		}
	} else {
		out.println("입력을 덜하셨습니다.");
	}
	%>

</body>
</html>