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
    <title>Documents</title>
    <%@include file="../utils/include.jsp"%>

    <style>
        /*Header Style*/
        .header {
            padding: 60px;
            text-align: center;
            background: #53af57;
            color: white;
            font-size: 40px;
        }
        .header button{
            margin: 1%;
            background-color: #000000;
            border: #000000;
            color: #FFFFFF;
        }
        .header button:hover{
            background-color: #53af57;
            border: 2px solid #000000;
            color: #FFFFFF;
        }

        /*Card Style*/
        .card .card-header{
            background-color: #e9e9e9;
        }
        .card-footer .card-footer-item {
            background-color: #53af57;
            color: #FFFFFF;
            margin: 2px;
        }

        /*Foot Style*/
        .footer {
            padding: 20px;
            text-align: center;
            background: #53af57;
            color: white;
            font-size: 20px;
        }
        .footer a{
            text-decoration: none;
            color: white;
        }
    </style>
</head>
<body>
    <header class="header">
        <h1>BIENVENUE DANS NOTRE CATALOGUE</h1>
        <button id="new-doc-btn" class="button">Ajouter un document</button>
        <button id="return-doc-btn" class="button">Retourner un document</button>
    </header>

    <div class="card-columns">
        <j:choose>
            <j:when test="${empty requestScope.documents}">
                No documents available
            </j:when>
            <j:otherwise>
                <j:forEach items="${requestScope.documents}" var="document">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-header-title"><j:out value="${document.data()[1]}" /></h5>
                        </div>
                        <div class="card-content">
                            <div class="content">
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item" id="card-state">
                                        <j:choose>
                                            <j:when test="${ document.data()[3] == 'Free'}">Is free</j:when>
                                            <j:when test="${ document.data()[3] == 'Borrowed'}">Is borrowed</j:when>
                                        </j:choose>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="card-footer">
                            <a class="card-footer-item" href="#">Delete</a>
                            <a class="card-footer-item" href="#">Borrow</a>
                        </div>
                    </div>
                </j:forEach>
            </j:otherwise>
        </j:choose>
    </div>

    <footer class="footer">
        <a href="index.jsp">Return to home page</a>
    </footer>

    <!-- New document modal -->
    <div id="new-doc-modal" class="modal">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Add a document to the library</p>
                <button id="close-modal-btn" class="delete" ></button>
            </header>
            <section class="modal-card-body">
                <form id="new-document-form">
                    <div class="field">
                        <label class="label">Title</label>
                        <div class="control">
                            <input class="input" type="text" name="title" placeholder="Enter a title">
                        </div>
                    </div>

                    <div class="field">
                        <label class="label">Type of document</label>
                        <div class="control">
                            <div class="select">
                                <select name="type">
                                    <option value="1">Book</option>
                                    <option value="2">CD</option>
                                    <option value="3">DVD</option>
                                </select>
                            </div>
                        </div>
                    </div>

                    <div id="optional-field" class="field">
                        <label class="label">Author</label>
                        <div class="control">
                            <input class="input" type="text" name="author" placeholder="Enter an author">
                        </div>
                    </div>
                </form>
            </section>
            <footer class="modal-card-foot">
                <button id ="new-doc-save-btn" class="button is-success">Save</button>
                <button id ="new-doc-cancel-btn" class="button">Cancel</button>
            </footer>
        </div>
    </div>

    <!-- Return document modal -->
    <!--
    <div id="return-doc-modal" class="modal-return">
        <div class="modal-background"></div>
        <div class="modal-card">
            <header class="modal-card-head">
                <p class="modal-card-title">Remove a document from the library</p>
                <button id="close-modal-btn-2" class="delete" ></button>
            </header>
            <section class="modal-card-body">
                <form id="return-document-form">
                    <div class="field">
                        <label class="label">Title</label>
                        <div class="control">
                            <input class="input" type="text" name="title" placeholder="Enter a title">
                        </div>
                    </div>
                </form>
            </section>
            <footer class="modal-card-foot">
                <button id ="return-doc-save-btn" class="button is-success">Save</button>
                <button id ="return-doc-cancel-btn" class="button">Cancel</button>
            </footer>
        </div>
    </div>
    -->
    <script defer src="<j:url value="/resources/js/catalog.js"/>"></script>
</body>
</html>
