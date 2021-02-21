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
</head>
<body>
    <header>
        <button id="new-doc-btn" class="button is-black">New document</button>
    </header>

    <div class="card-columns">
        <j:choose>
            <j:when test="${empty requestScope.documents}">
                No documents available
            </j:when>
            <j:otherwise>
                <j:forEach items="${requestScope.documents}" var="document">
                    <div class="card">
                            <%--            <img class="card-img-top" src="../../../../../import/images/dvd.jpg" alt="Card image">--%>
                        <div class="card-body">
                            <h5 class="card-title"><j:out value="${document.data()[1]}" /></h5>
                        </div>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item" id="card-state">
                                <j:choose>
                                    <j:when test="${ document.data()[3] == 'Free'}">Is free</j:when>
                                    <j:when test="${ document.data()[3] == 'Borrowed'}">Is borrowed</j:when>
                                </j:choose>
                            </li>
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
            </j:otherwise>
        </j:choose>
    </div>

    <a href="index.jsp">Return to home page</a>

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
                            <input class="input" type="text" name="" placeholder="Enter an author">
                        </div>
                    </div>
                </form>
            </section>
            <footer class="modal-card-foot">
                <button id ="new-doc-save-btn" class="button is-success">Save </button>
                <button class="button">Cancel</button>
            </footer>
        </div>
    </div>
<%--    <script defer src="<j:url value="/resources/js/catalog.js"/>"></script>--%>
    <script>
        const newDocButton = document.querySelector("#new-doc-btn");
        const closeModal = document.querySelector("#close-modal-btn");
        const modal = document.querySelector(".modal");
        const typeSelect = document.querySelector(".select>select");

        newDocButton.addEventListener('click', () => {
            const modalContainer = document.querySelector("#new-doc-modal");
            modalContainer.classList.add("is-active");
        });

        closeModal.addEventListener('click', () => {
            modal.classList.remove("is-active");
        });

        typeSelect.addEventListener('change', e => {
            const type = e.target.value;
            const label = document.querySelector("#optional-field>label");
            const optionalInput = document.querySelector("#optional-field .control>input");

            switch (type) {
                case "1":
                    label.textContent = "Author";
                    optionalInput.getAttributeNode("placeholder").textContent = "Enter an author";
                    optionalInput.getAttributeNode("name").textContent = "author";
                    break;
                case "2":
                    label.textContent = "Artist";
                    optionalInput.getAttributeNode("placeholder").textContent = "Enter an artist";
                    optionalInput.getAttributeNode("name").textContent = "artist";
                    break;
                case "3":
                    label.textContent = "Producer";
                    optionalInput.getAttributeNode("placeholder").textContent = "Enter a producer";
                    optionalInput.getAttributeNode("name").textContent = "producer";
                    break;
            }
        });

        $("#new-doc-save-btn").click(() => {
            $.ajax({
                type: "POST",
                url: "localhost:8080/document/new",
                data: $("#new-document-form").serialize(),
                success: () => {},
                dataType: "json"
            });
        });
    </script>
</body>
</html>
