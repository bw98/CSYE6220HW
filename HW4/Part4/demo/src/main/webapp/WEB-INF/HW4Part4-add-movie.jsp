<%--
  Created by IntelliJ IDEA.
  User: weifeng.lai
  Date: 3/1/23
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Store</title>
</head>
<body>
<h1>Add a New Movie</h1>
<form method="post" action="add">
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br>

    <label for="actor">Lead Actor:</label>
    <input type="text" id="actor" name="actor" required><br>

    <label for="actress">Lead Actress:</label>
    <input type="text" id="actress" name="actress" required><br>

    <label for="genre">Genre:</label>
    <input type="text" id="genre" name="genre" required><br>

    <label for="year">Year:</label>
    <input type="number" id="year" name="year" required><br>

    <input type="submit" value="Add Movie">
</form>
</body>
</html>
