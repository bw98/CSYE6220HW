<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.List"%>
<%@ page import="com.example.csye6220hw.Bean.Item" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>CSYE6220 Online Shop</title>
</head>
<body>

<h1>CSYE6220 Online Shop</h1>
<a href="http://localhost:8080/CSYE6220_HW_war/HW3Part8-add-item.html">1. Add New Items to Cart</a>
<br>
<a href="http://localhost:8080/CSYE6220_HW_war/ListItemServlet">2. List and Delete Items in Cart</a>
<br>
<Hr>

<h1>All items in your cart is as follows: </h1>
<%--<%--%>
<%--    List<Item> items = (List<Item>) request.getAttribute("items");--%>
<%--%>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Item</th>--%>
<%--        <th>Price</th>--%>
<%--        <th>Action</th>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        if (items != null) {--%>
<%--            for (Item item : items) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= item.getName() %></td>--%>
<%--        <td>$<%= item.getPrice() %></td>--%>
<%--        <td>--%>
<%--            <a href="http://localhost:8080/CSYE6220_HW_war/ItemServlet?Action=DeleteItem&Item=<%= item.getName() %>"> [Remove]</a>--%>
<%--        </td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--            }--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>
<c:set var="items" value="${requestScope.items}"/>
<table>
    <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Action</th>
    </tr>
    <c:if test="${not empty items}">
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>
                    <a href="http://localhost:8080/CSYE6220_HW_war/ItemServlet?Action=DeleteItem&amp;Item=${item.name}"> [Remove]</a>
                </td>
            </tr>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
