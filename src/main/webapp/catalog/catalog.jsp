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
    <link rel="stylesheet" href="<j:url value="/resources/css/app.css"/>">
</head>
<body>
    <j:set var="isLibrarian" value="${sessionScope.user.data()[3]}"/>
    <div class="main-container">
        <div class="body-container">
            <header class="header">
                <div class="container is-fluid">
                    <div class="is-flex">
                        <h1 class="is-flex-grow-1">WELCOME TO OUR CATALOG OF DOCUMENTS</h1>
                        <j:if test="${sessionScope.user != null}">
                            <a class="button is-black" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </j:if>
                    </div>
                </div>

                <j:if test="${isLibrarian == true}">
                    <button id="new-doc-btn" class="button">Add a new document</button>
                </j:if>
            </header>
            <div class="catalog-dropDown">
                <div class="dropDown-title">
                    <label class="label">Trier par type</label>
                </div>
                <div class="control">
                    <div class="dropDown-select">
                        <select name="type">
                            <option id="dropDown-option-1" value="4">All documents</option>
                            <option id="dropDown-option-2" value="3">DVD</option>
                            <option id="dropDown-option-3" value="2">CD</option>
                            <option id="dropDown-option-4" value="1">Book</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="container is-fluid my-6">
                <div class="columns is-multiline">
                    <j:choose>
                        <j:when test="${empty requestScope.documents}">
                            No documents available
                        </j:when>
                        <j:otherwise>
                            <j:forEach items="${requestScope.documents}" var="document">
                                <div class="column is-4">
                                    <div class="card">
                                        <div class="card-header">
                                            <h5 class="card-header-title"><j:out value="${document.data()[1]}" /></h5>
                                        </div>
                                        <div class="card-content">
                                            <div class="content">
                                                <j:choose>
                                                    <j:when test="${ !empty document.data()[2]}">
                                                        <p><j:out value="${document.data()[2]}" /></p>
                                                    </j:when>
                                                    <j:otherwise>
                                                        <p>No description</p>
                                                    </j:otherwise>
                                                </j:choose>
                                                <p>
                                                    <j:choose>
                                                        <j:when test="${ document.data()[4] == 'Free'}"><span class="tag is-success">Free</span></j:when>
                                                        <j:when test="${ document.data()[4] == 'Borrowed'}"><span class="tag is-danger">Borrowed</span></j:when>
                                                    </j:choose>
                                                </p>
                                            </div>
                                        </div>
                                        <div class="card-footer">
                                            <j:if test="${isLibrarian == true}">
                                                <button
                                                        id="delete-doc-btn"
                                                        class="card-footer-item"
                                                        doc-id="<j:out value="${document.data()[0]}"/>"
                                                >
                                                    Delete
                                                </button>
                                            </j:if>
                                        </div>
                                    </div>
                                </div>
                            </j:forEach>
                        </j:otherwise>
                    </j:choose>
                </div>
            </div>
        </div>
        <footer class="footer-container">
            <a href="../index.jsp">Return to home page</a>
        </footer>
    </div>

    <%@include file="./modals/newDocument.jsp"%>
    <%@include file="./modals/deleteDocument.jsp"%>

    <script defer src="<j:url value="/resources/js/catalog.js"/>"></script>
</body>
</html>
