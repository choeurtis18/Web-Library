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

    <style>
        #container{
            width:400px;
            margin:0 auto;
            margin-top:10%;
        }
        /* Bordered form */
        form {
            width:100%;
            padding: 30px;
            border: 1px solid #f1f1f1;
            background: #fff;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        #container h1{
            width: 38%;
            margin: 0 auto;
            padding-bottom: 10px;
        }

        /* Full-width inputs */
        input[type=email], input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        input[type=submit] {
            background-color: #53af57;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }
        input[type=submit]:hover {
            background-color: white;
            color: #53af57;
            border: 1px solid #53af57;
        }

    </style>
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
