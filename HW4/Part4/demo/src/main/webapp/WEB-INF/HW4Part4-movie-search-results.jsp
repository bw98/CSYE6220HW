<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.csye6220hw.Bean.Movie" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Store</title>
</head>
<body>
<h1>You searched for </h1>
<%--<%--%>
<%--    String searchKeyword = (String)request.getAttribute("search_keyword");--%>
<%--        out.print("<p>'" + searchKeyword + "'</p>");--%>
<%--%>--%>
<c:set var="searchKeyword" value="${requestScope.search_keyword}"/>
<p>'${searchKeyword}'</p>
<br>
<h1>Here are the search results</h1>
<br>
<%--<%--%>
<%--    List<Movie> movies = (List<Movie>) request.getAttribute("movies");--%>
<%--%>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <th>Title</th>--%>
<%--        <th>Actor</th>--%>
<%--        <th>Actress</th>--%>
<%--        <th>Genre</th>--%>
<%--        <th>Year</th>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--        if (movies != null) {--%>
<%--            for (Movie movie : movies) {--%>
<%--    %>--%>
<%--    <tr>--%>
<%--        <td><%= movie.getTitle() %></td>--%>
<%--        <td><%= movie.getLeadActor() %></td>--%>
<%--        <td><%= movie.getLeadActress() %></td>--%>
<%--        <td><%= movie.getGenre() %></td>--%>
<%--        <td><%= movie.getYear() %></td>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--            }--%>
<%--        }--%>
<%--    %>--%>
<%--</table>--%>
<c:set var="movies" value="${requestScope.movies}"/>
<table>
    <tr>
        <th>Title</th>
        <th>Actor</th>
        <th>Actress</th>
        <th>Genre</th>
        <th>Year</th>
    </tr>
    <c:if test="${not empty movies}">
        <c:forEach items="${movies}" var="movie">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.leadActor}</td>
                <td>${movie.leadActress}</td>
                <td>${movie.genre}</td>
                <td>${movie.year}</td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<br>
<a href="./HW4Part4-MovieStore-menu.jsp">Click here to go back to the main page</a>
</body>
</html>
