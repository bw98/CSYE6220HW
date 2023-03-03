<%--
  Created by IntelliJ IDEA.
  User: weifeng.lai
  Date: 3/1/23
  Time: 7:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Store</title>
</head>
<body>
<h1>Searching Movies</h1>
<form action="search" method="GET">
    <p>Keyword: </p>
    <input type="text" name="search_keyword"/>
    <br>
    <input type="radio" name="search_option" value="title" /> Search By Title
    <br>
    <input type="radio" name="search_option" value="actor" /> Search By Actor
    <br>
    <input type="radio" name="search_option" value="actress" /> Search By Actress
    <br>

    <input type="submit" value="Search Movies"/>
</form>
</body>
</html>
