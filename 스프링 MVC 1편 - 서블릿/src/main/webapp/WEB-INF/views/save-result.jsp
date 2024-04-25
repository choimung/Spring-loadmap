<%@ page import="com.hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-04-25
  Time: 오후 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=((Member)request.getAttribute("member")).getId()%></li>
    <li>username=<%=((Member)request.getAttribute("member")).getUsername()%></li>
    <li>age=<%=((Member)request.getAttribute("member")).getAge()%></li>

    <a href="/index.html">메인</a>
</ul>
</body>
</html>
