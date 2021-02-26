<%--
  Created by IntelliJ IDEA.
  User: Danny
  Date: 26/02/2021
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- New document modal -->
<div id="new-doc-modal" class="modal">
    <div class="modal-background"></div>
    <div class="modal-card">
        <header class="modal-card-head">
            <p class="modal-card-title">Add a document to the library</p>
            <button class="delete close-new-modal"></button>
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

                <div class="field">
                    <label class="label">Description</label>
                    <div class="control">
                        <textarea class="textarea" name="description" placeholder="Enter a description"></textarea>
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
            <button class="button close-new-modal">Cancel</button>
        </footer>
    </div>
</div>
