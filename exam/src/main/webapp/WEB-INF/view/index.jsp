<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>
<body>

<c:choose>
    <c:when test="${admin==true}">
        <a href="/exit">Logout</a>
        <a href="/blogs/add">Add blog</a>
    </c:when>
    <c:otherwise>
        <a href="/login">Login</a>
    </c:otherwise>
</c:choose>

<h1>There is my Lorem blog!</h1>
<br/>
<c:forEach items="${blogs}" var="blog">
    <div>
        <p>${blog.title}</p>
        <div>
            <p>${blog.text}</p>
        </div>
    </div>
</c:forEach>
</body>
</html>
