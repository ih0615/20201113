<%@page import="aa.bb.cc.bean.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>회원 목록</title>
<style type="text/css">
.textalign {
	text-align: center;
}
</style>
</head>
<body>
<body>
	<div class="container">
		<form action="list">
			<div class="row">
				<button type="submit" class="btn btn-dark col-md-6">조회</button>
				<button type="button" class="btn btn-dark col-md-6" id="back">돌아가기</button>
			</div>
		</form>
		<div class="row">
			<table class="table table-striped textalign">
				<tr>
					<th>이름</th>
					<th>성별</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>주소</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>취미</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<%
					ArrayList<Member> al = (ArrayList<Member>) request.getAttribute("member");
				for (int i = 0; i < al.size(); i++) {
					out.print("<tr>");
					out.print("<td>");
					out.print(al.get(i).getPname());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPgender());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPid());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPpwd());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPaddr());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPtel());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPemail());
					out.print("</td>");
					out.print("<td>");
					out.print(al.get(i).getPhobby());
					out.print("</td>");
				%>
				<td>
					<button type="button" class="btn btn-dark" onclick="doUpdate(<%=al.get(i).getPidx()%>)">수정</button>
				</td>
				<td>
					<button type="button" class="btn btn-dark" onclick="doDelete(<%=al.get(i).getPidx()%>)">삭제</button>
				</td>
				<%
					out.print("</tr>");
				}
				%>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		let back = document.getElementById("back");
		back.addEventListener('click', function() {
			location.href = "index.html";
		});
	</script>
	<script type="text/javascript">
	function doUpdate(idx){
		alert(idx);
		location.href="update?idx"+idx;
	};
	function doDelete(idx){
		alert(idx);
		location.href="delete?idx="+idx;
	};
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
		
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous">
		
	</script>
</body>


</html>