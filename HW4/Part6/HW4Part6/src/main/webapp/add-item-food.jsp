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

<h1>Shopping for Food</h1>
<h1>Which items you want to add into your cart?</h1>
<form action="item" method="GET">
  <input type="hidden" name="Action" value="AddItem" />

  <fieldset>
    <input type="radio" name="Item" value="Water"/> Water  $1.5
    <input type="hidden" name="Water Price" value="1.50"/>
    <br>
    <input type="radio" name="Item" value="Milk"/> Milk  $4.99
    <input type="hidden" name="Milk Price" value="4.99"/>
    <br>
    <input type="radio" name="Item" value="Apple"/> Apple  $3.00
    <input type="hidden" name="Apple Price" value="3.00"/>
    <br>
    <input type="radio" name="Item" value="Egg"/> Egg  $5.99
    <input type="hidden" name="Egg Price" value="5.99"/>
    <br>
    <input type="radio" name="Item" value="Bread"/> Bread  $2.59
    <input type="hidden" name="Bread Price" value="2.59"/>
    <br>
  </fieldset>

    <input type="submit" value="Add to Cart"/>
</form>

</body>
</html>
