<%--
  Created by IntelliJ IDEA.
  User: Danny
  Date: 26/02/2021
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="delete-doc-modal" class="modal">
    <div class="modal-background"></div>
    <div class="modal-card">
        <header class="modal-card-head">
            <p class="modal-card-title">Delete a document</p>
            <button class="delete close-delete-modal"></button>
        </header>
        <section class="modal-card-body">
            Do you want to delete this document ?
        </section>
        <footer class="modal-card-foot">
            <button id="delete-doc-confirm-btn" class="button is-success">Yes</button>
            <button class="button close-delete-modal">No</button>
        </footer>
    </div>
</div>
