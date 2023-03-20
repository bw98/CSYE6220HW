<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8" />

    <title>JSTL Tag Example</title>
</head>

<body>

<h1>JSTL Formatting Tag Example</h1>

<h2>Format Message Example: Count 1, 2 and 3 in Chinese </h2>
<fmt:setLocale value="zh_CN"/>
<fmt:setBundle basename="demo" var="lang"/>
<fmt:message key="count.one" bundle="${lang}"/><br/>
<fmt:message key="count.two" bundle="${lang}"/><br/>
<fmt:message key="count.three" bundle="${lang}"/><br/>

<h2>Format Number Example: Keep point with 2 digits left</h2>
<p> Formatting PI is: <fmt:formatNumber value="3.1415926" minFractionDigits="2" maxFractionDigits="2"/></p>

<h2>Format Date Example: Show today</h2>
<c:set var="now" value="<%= new java.util.Date() %>"/>
<p>Current time is : <fmt:formatDate value="${now}" pattern="EEE, MMM d, yyyy"/></p>


<h1>JSTL SQL Tag Example</h1>

<h2>Database Results:</h2>
<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost/booksdb" user="root" password="12345678"/>
<sql:update dataSource="${db}" var="result">
    INSERT INTO books (isbn, title, authors, price) VALUES ("777-777-777", "777Lottery", "Boss77", 77.77);
</sql:update>
<sql:query var="result" dataSource="${db}">
    SELECT * FROM books;
</sql:query>
<table>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Authors</th>
        <th>Price</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.isbn}"/></td>
            <td><c:out value="${row.title}"/></td>
            <td><c:out value="${row.authors}"/></td>
            <td><c:out value="${row.price}"/></td>
        </tr>
    </c:forEach>
</table>


<h1>JSTL XML Tags Example</h1>
<h2>Books Info:</h2>
<c:set var="xmltext">
    <books>
        <book>
            <name>Padam History</name>
            <author>ZARA</author>
            <price>100</price>
        </book>
        <book>
            <name>Great Mistry</name>
            <author>NUHA</author>
            <price>2000</price>
        </book>
    </books>
</c:set>

<%--Fetch and parse XML file--%>
<c:import url="http://localhost:8080/CSYE6220_HW_war/HW3Part3-style.xsl" var="xslt"/>
<x:transform xml="${xmltext}" xslt="${xslt}"/>

</body>
</html>
