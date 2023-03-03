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

<h1>Shopping for Digital Products</h1>
<h1> Which items you want to add into your cart?</h1>
<form action="item" method="GET">
  <input type="hidden" name="Action" value="AddItem" />

  <fieldset>
    <input type="radio" name="Item" value="MacBook Pro"/> Apple MacBook Pro 13.3  [$1299.99]
    <input type="hidden" name="MacBook Pro Price" value="1299.99"/>
    <br>
    <input type="radio" name="Item" value="Asus Laptop"/> Asus Laptop NEO 2 Black [$949.95]
    <input type="hidden" name="Asus Laptop Price" value="949.95"/>
    <br>
    <input type="radio" name="Item" value="HP Laptop"/> HP Laptop with 2 DV7 [$1199.95]
    <input type="hidden" name="HP Laptop Price" value="1199.95"/>
    <br>
    <input type="radio" name="Item" value="Apple Airpod"/> Apple Airpod pro XI [$399]
    <input type="hidden" name="Apple Airpod Price" value="399.00"/>
    <br>
  </fieldset>

    <input type="submit" value="Add to Cart"/>
</form>

</body>
</html>
