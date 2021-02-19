<%--
  Created by IntelliJ IDEA.
  User: Choeurtis
  Date: 18/02/2021
  Time: 23:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>

<html>
<head>
    <title>Catalogue</title>
    <!--Import for boostrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <!--Import for dropDown menu -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>

</head>
<body>
    <header>
        <button type="submit" class="btn btn-primary">Add new document</button>
    </header>

    <div class="card-columns">
    <j:forEach items="${requestScope.documents}" var="document">
        <div class="card">
            <img class="card-img-top" src="../../../../../import/images/dvd.jpg" alt="Card image">
            <div class="card-body">
                <h5 class="card-title">${document.data[1]}</h5>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item" id="card-state">${document.data[2]}</li>
            </ul>
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Action
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="#">Delete</a>
                    <a class="dropdown-item" href="#">Borrow</a>
                    <a class="dropdown-item" href="#">Return</a>
                </div>
            </div>
        </div>
    </j:forEach>
    </div>

    <a href="index.jsp">Return to home page</a>
</body>
</html>
