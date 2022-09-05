<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add author</title>
</head>
<body>
<form action="/authors/add" method="post">
    <input type="text" name="name" placeholder="please input name"/><br>
    <input type="text" name="surname" placeholder="please input surname"/><br>
    <input type="email" name="email" placeholder="please input email"/><br>
    <input type="number" name="age" placeholder="please input age"/><br>

    <input type="submit" value="Register">
</form>
<br>

</body>
</html>
