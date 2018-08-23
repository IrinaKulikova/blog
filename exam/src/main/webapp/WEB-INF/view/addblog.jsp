<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Home</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>
<body>
<h1>Your profile!</h1>
<a href="/exit">Logout</a>
<br/>
<h3>Add blog</h3>
<form action="/blogs/" method="post">
    <label>Title: <input name = "title" id="title"/></label><br/>
    <label>Text:  <textarea name="text" id="text"></textarea></label><br/>
    <button id="add" type="submit">Add</button>
</form>
</body>
</html>
