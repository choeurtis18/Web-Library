<%--
  Created by IntelliJ IDEA.
  User: Danny
  Date: 09/02/2021
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Login page</title>
    <%@include file="../utils/include.jsp" %>
    <link rel="stylesheet" href="<j:url value="/resources/css/login.css" />"/>
    <script src="https://kit.fontawesome.com/9bdc77a9f2.js" crossorigin="anonymous"></script>
</head>
<body>
<div id="container">
    <!-- form connection -->
    <form class="box login-form px-5 py-6 action=" action="${pageContext.request.contextPath}/login" method="post">

        <h1 class="title has-text-centered">Login</h1>

        <j:if test="${not empty requestScope.error}">
            <article class="message is-danger">
                <div class="message-body">
                    <p><j:out value="${requestScope.error}"/></p>
                </div>
            </article>
        </j:if>

        <div class="field">
            <label class="label">Email</label>
            <div class="control has-icons-left">
                <input class="input" name="login" type="email" placeholder="Email" required>
                <span class="icon is-small is-left">
                            <i class="fa fa-envelope"></i>
                        </span>
            </div>
        </div>

        <div class="field">
            <label class="label">Password</label>
            <div class="control has-icons-left">
                <input class="input" type="password" name="password" minlength="8" placeholder="Password" required>
                <span class="icon is-small is-left">
                          <i class="fas fa-lock"></i>
                        </span>
            </div>
        </div>
        <div class="field">
            <div class="control">
                <button class="button is-black is-fullwidth">Login</button>
            </div>
        </div>

        <div class="field">
            <div class="control">
                <a href="/">Return to home page</a>
            </div>
        </div>
    </form>
</div>
</body>
</html>