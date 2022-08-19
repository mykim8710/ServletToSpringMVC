<%@ page contentType="text/html;charset=UTF-8" language="java" %>   <%--JSP문서라는 뜻--%>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h2>성공</h2>
        <ul>
            <li>id=${member.id}</li>            <%--JSP는 ${} 문법을 제공하는데, 이 문법을 사용하면 request의 attribute에 담긴 데이터를 편리하게 조회--%>
            <li>username=${member.username}</li>
            <li>age=${member.age}</li>
        </ul>

        <a href="/index.html">메인</a><br>
        <a href="/servlet-mvc/members/new-form">회원등록</a><br>
        <a href="/servlet-mvc/members">회원목록</a>
    </body>
</html>
