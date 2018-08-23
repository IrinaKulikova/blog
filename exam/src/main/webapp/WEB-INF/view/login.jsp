<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="/resources/css/style.css"/>
</head>
<body>
<h1>Please, login!</h1>
<form method="post">
    Login: <input name="login" required/> <br/>
    Password: <input name="password"/> <br/>
    <button type="submit">Login</button>
</form>
</body>
</html>


