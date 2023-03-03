<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>HW3 JSTL Example</title>
</head>
<body>
	<h1>HW# JSTL Example</h1>

    <h1>Current Time</h1>
    <p>The current time is: 
        <fmt:formatDate value="${now}" pattern="HH:mm:ss"/>
    </p>
    <p>
        Hello, Weifeng Lai!
    </p>

	<p>The current time is: <c:out value="${now}"/></p>
	
	<h2>List of fruits:</h2>
	<ul>
	<c:forEach var="fruit" items="${fruits}">
		<li><c:out value="${fruit}"/></li>
	</c:forEach>
	</ul>
	
	<h2>List of numbers:</h2>
	<table>
	<tr>
		<th>Number</th>
		<th>Square</th>
		<th>Cube</th>
	</tr>
	<c:forEach var="num" begin="1" end="5">
	<tr>
		<td><c:out value="${num}"/></td>
		<td><c:out value="${num*num}"/></td>
		<td><c:out value="${num*num*num}"/></td>
	</tr>
	</c:forEach>
	</table>
	
	<h2>Database Results:</h2>
	<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/mydb" user="root" password="password"/>
	<sql:query var="result" dataSource="${db}">
	SELECT * FROM users;
	</sql:query>
	<table>
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
	</tr>
	<c:forEach var="row" items="${result.rows}">
	<tr>
		<td><c:out value="${row.title}"/></td>
	</tr>
	</c:forEach>
	</table>

	<fmt:formatDate value="${now}" pattern="HH:mm:ss" timeZone="UTC"/><c:out value=" Weifeng Lai"/>
</body>
</html>

