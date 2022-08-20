<%@ page import="com.example.servlet.domain.member.Member" %>
<%@ page import="com.example.servlet.domain.member.MemberRepository" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>   <%--JSP문서라는 뜻--%>

<%
    // request, response는 그대로 사용가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    // Get parameter from request
    String username = request.getParameter("username");
    String age = request.getParameter("age");

    // 비지니스 로직
    Member member = new Member(username, Integer.parseInt(age));
    System.out.println("member = " + member);

    memberRepository.save(member);
%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>성공</h2>
        <ul>
            <li>id=<%=member.getId()%></li>
            <li>username=<%=member.getUsername()%></li>
            <li>age=<%=member.getAge()%></li>
        </ul>

        <a href="/index.html">메인</a><br>
        <a href="/jsp/members/new-form.jsp">회원등록</a><br>
        <a href="/jsp/members/members.jsp">회원목록</a>
    </body>
</html>
