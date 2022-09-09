<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authors page</title>
</head>
<body>
<%
    List<Author> authors = (List<Author>) request.getAttribute("authors");
%>
<table border="1">
    <tr>
        <th>image</th>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>age</th>
    </tr>
    <%for (Author author : authors) {%>
    <tr>
        <td><%if (author.getProfilePic() == null || author.getProfilePic().length() == 0) {%>
            <img src="/imageAuthor/defualtProfilePic.png" width="100"/>
            <%} else {%>
            <img src="/getAuthorImage?profilePic =<%=author.getProfilePic()%>" width="100"/>
            <%}%>
        </td>
        <td><%=author.getId()%>
        </td>
        <td><%=author.getName()%>
        </td>
        <td><%=author.getSurName()%>
        </td>
        <td><%=author.getEmail()%>
        </td>
        <td><%=author.getAge()%>
        </td>
    </tr>
    <% } %>
</table>
<br>
<a href="../index.jsp">Back</a>
</body>
</html>
