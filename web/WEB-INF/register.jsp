
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User register</title>
</head>
<body>
<form action="/user/register" method="post">
    <input type="text" name="name" placeholder="Please input name"><br>
    <input type="text" name="surname" placeholder="Please input surname"><br>
    <input type="email" name="email" placeholder="Please input email"><br>
    <input type="password" name="password" placeholder="Please input password"><br>
    <button>Submit</button>
</form>
</body>
</html>
