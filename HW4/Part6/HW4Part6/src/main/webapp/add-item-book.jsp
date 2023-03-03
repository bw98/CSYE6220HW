<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>

<body>

<h1>CSYE6220 Online Shop</h1>
<a href="./add-item.jsp">1. Add New Items to Cart</a>
<br>
<a href="listitem">2. List and Delete Items in Cart</a>
<br>
<Hr>

<h1>Shopping for Books</h1>
<h1>Which items you want to add into your cart?</h1>
<form action="item" method="GET">
  <input type="hidden" name="Action" value="AddItem" />

  <fieldset>
    <input type="radio" name="Item" value="Java Servlet Programming"/> Java Servlet Programming [$29.95]
    <input type="hidden" name="Java Servlet Programming Price" value="29.95"/>
    <br>
    <input type="radio" name="Item" value="Oracle Database Programming"/> Oracle Database Programming [$48.95]
    <input type="hidden" name="Oracle Database Programming Price" value="48.95"/>
    <br>
    <input type="radio" name="Item" value="System Design"/> System Design [$14.95]
    <input type="hidden" name="System Design Price" value="14.95"/>
    <br>
    <input type="radio" name="Item" value="Object Oriented Software Engineering"/> Object Oriented Software Engineering [$35.99]
    <input type="hidden" name="Object Oriented Software Engineering Price" value="35.99"/>
    <br>
    <input type="radio" name="Item" value="Java Web Services"/> Java Web Services [$27.99]
    <input type="hidden" name="Java Web Services Price" value="27.99"/>
    <br>
  </fieldset>

    <input type="submit" value="Add to Cart"/>
</form>

</body>
</html>
