<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <link rel="stylesheet" href="<j:url value="/resources/css/app.css"/>">
</head>
<body>
  <section id="index_section">
    <header class="header">
      <h1 class="header-title">WELCOME TO OUR LIBRARY</h1>
      <a href="../authentication/login.jsp" ><button class="header-btn">Login</button></a>
    </header>
  </section>
</body>
</html>