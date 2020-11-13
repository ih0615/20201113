<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
input[type=text]{
width: 200px;
height: 20px;
}
</style>
</head>
<body>
<form action="practice">
<label>이름
<input type="text" name="name">
</label><br>
<label>학번
<input type="text" name="code">
</label><br>
성별
<label>남성
<input type="radio" name="gender" value="남성">
</label>
<label>여성
<input type="radio" name="gender" value="여성">
</label><br>
<label>비고
<textarea rows="10" cols="20" name="remark"></textarea>
</label><br>
<input type="submit" value="저장">
</form>
</body>
</html>