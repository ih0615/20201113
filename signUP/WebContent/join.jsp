<%@page import="aa.bb.cc.bean.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>가입 결과</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
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

        .inline {
            display: inline-block;
        }

        #return {
            float: right;
            line-height: 36px;
        }
    </style>
</head>
<body>
<div class="container container-sm">
    <div>
        <h1 style="font-size: 36px" class="inline">
            <b>가입하신 정보</b>
        </h1>
        <a href="index.html" id="return">돌아가기</a>
    </div>
    <br>
    <table class="table table-striped">
        <tr>
            <td>이름</td>
            <td><%=request.getParameter("name")%>
            </td>
        </tr>
        <tr>
            <td>성별</td>
            <td><%=request.getParameter("gender")%>
            </td>
        </tr>
        <tr>
            <td>아이디</td>
            <td><%=request.getParameter("id")%>
            </td>
        </tr>
        <tr>
            <td>주소</td>
            <td><%=request.getParameter("addr")%>
            </td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td><%=request.getParameter("tel")%>
            </td>
        </tr>
        <tr>
            <td>이메일</td>
            <td><%=request.getParameter("email")%>
            </td>
        </tr>
        <tr>
            <td>취미</td>
            <td><%=request.getAttribute("phobby")%>
            </td>
        </tr>
    </table>
</div>
<script type="text/javascript">
    let hobby = [];
    hobby = <%=request.getParameterValues("hobby")%>
        alert(hobby[0]);
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous">

</script>
</body>
</html>