<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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

</body>
</html>
