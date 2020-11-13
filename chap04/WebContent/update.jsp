<%@page import="aa.bb.cc.bean.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Member member = (Member) request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
}
/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure, footer, header, hgroup,
	menu, nav, section {
	display: block;
}

body {
	line-height: 1;
}

ol, ul {
	list-style: none;
}

blockquote, q {
	quotes: none;
}

blockquote:before, blockquote:after, q:before, q:after {
	content: '';
	content: none;
}

table {
	border-collapse: collapse;
	border-spacing: 0;
}

div {
	width: 600px;
	margin: 0 auto;
	background-color: blue;
}
</style>
</head>
<body>
	<div>
		<form action="Update" name="loginName" method="post">
			<input type="text" name="idx" value="<%=member.getIdx()%>">
			<table>
				<tr>
					<td>이름</td>
					<td>
						<input type="text" name="name" value="<%=member.getPname()%>">
					</td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<select name="gender">
							<option value="남자">남자</option>
							<option value="여자">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>아이디</td>
					<td>
						<input type="text" name="id" value="<%=member.getPid()%>">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" name="pwd" value="<%=member.getPpwd()%>">
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
						<input type="password" name="cpwd" value="<%=member.getPcpwd()%>">
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="addr" value="<%=member.getPaddr()%>">
					</td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td>
						<input type="tel" name="phone" value="<%=member.getPphone()%>">
					</td>
				</tr>
				<tr>
					<td>이메일 주소</td>
					<td>
						<input type="email" name="email" value="<%=member.getPemail()%>">
					</td>
				</tr>
				<tr>
					<td>취미</td>
					<td style="width: 170px">
						<input type="checkbox" name="hobby" value="축구">
						축구
						<input type="checkbox" name="hobby" value="농구">
						농구
						<input type="checkbox" name="hobby" value="야구">
						야구
						<input type="checkbox" name="hobby" value="수영">
						수영
						<input type="checkbox" name="hobby" value="연극">
						연극
						<input type="checkbox" name="hobby" value="수영">
						수영
						<input type="checkbox" name="hobby" value="게임">
						게임
						<input type="checkbox" name="hobby" value="독서">
						독서
					</td>
				</tr>
			</table>
			<hr>
			<input type="submit" value="수정" name="submit">
		</form>
	</div>
</body>
</html>