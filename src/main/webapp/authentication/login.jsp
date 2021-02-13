<%--
  Created by IntelliJ IDEA.
  User: Danny
  Date: 09/02/2021
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<form action="/login" method="post">
    <p style="{color: red}"><j:out value="${requestScope.error}"></j:out></p>
    <input type="text" name="login" placeholder="ENTER YOUR LOGIN">
    <input type="password" name="password" placeholder="ENTER YOUR PASSWORD">
    <button type="submit">Login</button>
</form>
</body>
</html>
