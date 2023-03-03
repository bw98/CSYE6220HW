<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Store</title>
</head>
<body>
<h1>Add Movie Result:</h1>
<%
    boolean isSuccess = (boolean)request.getAttribute("isSuccess");
    if (isSuccess) {
        out.print("<p>Movie added successfully.</p>");
    } else {
        out.print("<p>Failed to add movie.</p>");
    }
%>
<a href="http://localhost:8080/CSYE6220_HW_war/HW3Part6-MovieStore-menu.html">Click here to go back to the main page</a>
</body>
</html>
