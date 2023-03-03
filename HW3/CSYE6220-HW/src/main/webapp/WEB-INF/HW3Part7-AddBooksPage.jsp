<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Books</title>
</head>
<body>
<h1>Add Books</h1>
<form method="POST" action="AddBooksServlet">
    <table>
        <thead>
        <tr>
            <th>ISBN</th>
            <th>Book Title</th>
            <th>Authors</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <%
            int bookNum = (int) request.getAttribute("book_num");
            for (int i = 1; i <= bookNum; i++) {
        %>
        <tr>
            <td><input type="text" name="isbn<%=i%>"></td>
            <td><input type="text" name="title<%=i%>"></td>
            <td><input type="text" name="authors<%=i%>"></td>
            <td><input type="text" name="price<%=i%>"></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <input type="hidden" name="book_num" value="<%=bookNum%>"/>
    <input type="submit" value="Add Books">
</form>
</body>
</html>
