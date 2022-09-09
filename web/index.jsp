<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book manager</title>
</head>
<body>
<% User user = (User) session.getAttribute("user");%>
<br>
<a href="/books">Show all Books</a><br>
<a href="/authors"> Show all authors</a><br>
<% if (user != null) {%>
<a href="/books/add">Add Books</a><br>
<a href="/authors/add"> Add new authors</a><br>
<a href="/logout"> Logout</a><br>
<%
} else {%>
<a href="/login"> Login </a>
<%}%>
<a href="/user/register">Register</a>
</body>
</html>
