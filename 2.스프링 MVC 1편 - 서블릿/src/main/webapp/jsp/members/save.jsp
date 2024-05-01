<%@ page import="com.hello.servlet.domain.member.MemberRepository" %>
<%@ page import="com.hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2024-04-25
  Time: 오후 8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>

    <a href="/index.html">메인</a>
</ul>
</body>
</html>
