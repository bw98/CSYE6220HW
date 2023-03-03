<%--
  Created by IntelliJ IDEA.
  User: weifeng.lai
  Date: 2/7/23
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List"%>
<%
    List<String> items = (List<String>) request.getAttribute("items");
%>
<html>
<head>
    <title>CSYE6220 Online Shop</title>
</head>
<body>

<h1>CSYE6220 Online Shop</h1>
<a href="http://localhost:8080/CSYE6220_HW_war/HW2Part7-add-item.html">1. Add New Items to Cart</a>
<br>
<a href="http://localhost:8080/CSYE6220_HW_war/ListItemServlet">2. List All Items in Cart</a>
<br>
<Hr>

<h1>All items in your cart is as follows: </h1>
<table>
    <tr>
        <th>Item</th>
        <th>Action</th>
    </tr>
    <%
        if (items != null) {
            for (String item : items) {
    %>
    <tr>
        <td><%= item %></td>
        <td>
            <a href="http://localhost:8080/CSYE6220_HW_war/ItemServlet?Action=DeleteItem&Item=<%= item %>"> [Remove]</a>
        </td>
    </tr>
    <%
            }
        }
    %>
</table>

</body>
</html>
