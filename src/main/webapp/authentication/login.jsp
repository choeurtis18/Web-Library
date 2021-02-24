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
    <%@include file="../utils/include.jsp"%>
    <link rel="stylesheet" href="<j:url value="/resources/css/login.css"/>">
</head>
<body>

    <div id="container">
        <!-- zone de connexion -->
        <form action="/login" method="post">
            <h1>Connexion</h1>
            <p style="{color: red}"><j:out value="${requestScope.error}"></j:out></p>

            <label><b>Mail de l'utilisateur</b></label>
            <input type="email" name="login" required placeholder="ENTER YOUR MAIL">

            <label><b>Mot de passe</b></label>
            <input type="password" name="password" required  minlength="8" placeholder="ENTER YOUR PASSWORD">

            <button type="submit">Login</button>
        </form>
    </div>

</body>
</html>
