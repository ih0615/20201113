<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="student.jsp">
		<label for="name">이름</label>
		<input type="text" name="name"><br> 
		<label for="age">나이</label>
		<input type="number" name="age"><br> 
		성별
		<label for="gender">남성</label>
		<input type="radio" name="gender" value="남">
		<label for="gender">여성</label>
		<input type="radio" name="gender" value="여"><br>
		<label for="other">비고</label>
		<textarea rows="10" cols="20" name="other"></textarea>
		<input type="submit">
	</form>
</body>
</html>