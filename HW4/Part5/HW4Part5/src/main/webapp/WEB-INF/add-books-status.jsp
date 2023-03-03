<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Added</title>
</head>
<body>
<h1>Add Books Result:</h1>
<%
    boolean isSuccess = (boolean)request.getAttribute("isSuccess");
    int bookNum = (int)request.getAttribute("bookNum");
%>
<%
    if(isSuccess) {
%>
<p><%= bookNum %> book(s) added successfully!</p>
<%
    } else {
%>
<p>Failed to add books!</p>
<%
    }
%>
<a href="./add-book.jsp">Click here to go back to the add-book page</a>
</body>
</html>
