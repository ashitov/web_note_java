<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <title>Web notes</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
</head>

<body>
<div style="margin-right: 10%; margin-left: 10%">
<h1> List of all notes</h1>
</div>
    <c:forEach var="note" items="${noteslist}">
        <div class="jumbotron" style="text-align: center; margin-left: 10%; margin-right: 10%;">
            <c:if test="${note.title != ''}">
            <div style="font-size: medium">Title: ${note.title}</div>
            </c:if>
            <c:if test="${note.title == ''}">
            <div style="font-size: small">Text: ${note.text}</div>
            </c:if>
            <form action="/delete" method="POST">
                <input type="hidden" name="id" id="id" value=${note.id}>
                <input type="submit" value="Del Note">
            </form>
        </div>
    </c:forEach>
<div style="margin-left: 10%; margin-right: 10%">
<form action="/add" method="POST">
    <!-- <input type="hidden" name="id" value="1"> -->
    <label for="title">Title</label>
    <input type="text" name="title" id="title">
    <label for="text">Text</label>
    <c:if test="${error != 'no_text'}">
        <input type="text" name="text" id="text" value="Ntrcbn">
    </c:if>
    <c:if test="${error == 'no_text'}">
        <input type="text" name="text" id="text" value="Текст должен быть заполнен"">
    </c:if>
    <input type="submit" value="Add Note">
</form>

<form action="/search" method="POST">
    <input type="text" name="search_string">
    <input type="submit" value="Search">
</form>
</div>
</body>

</html>