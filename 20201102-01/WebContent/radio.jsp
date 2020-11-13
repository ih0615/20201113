<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="result.jsp">
		이름 <input type="text" name="name"> <br> 성별 남성<input
			type="radio" name="gender" value="1"> 여성<input type="radio"
			name="gender" value="2"><br> 비고 
			<textarea rows="10" cols="10" name="asdf"></textarea>
			<input type="submit" value="전달">
	</form>

</body>
</html>