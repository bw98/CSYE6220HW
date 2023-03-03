package com.example.csye6220hw.Service;

import com.example.csye6220hw.Bean.Movie;
import com.example.csye6220hw.DAO.MovieDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchMoviesServlet", urlPatterns = {"/SearchMoviesServlet"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "secured"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "GET", rolesAllowed = {
                        "secured"
                })
        })
public class SearchMoviesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchOption = request.getParameter("search_option");
        String searchKeyword = request.getParameter("search_keyword");

        List<Movie> movies = null;
        MovieDAO movieDAO = new MovieDAO();
        try {
            if ("title".equals(searchOption)) {
                movies = movieDAO.searchByTitle(searchKeyword);
            } else if ("actor".equals(searchOption)) {
                movies = movieDAO.searchByActor(searchKeyword);
            } else if ("actress".equals(searchOption)) {
                movies = movieDAO.searchByActress(searchKeyword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("search_keyword", searchKeyword);
        request.setAttribute("movies", movies);
        request.getRequestDispatcher("/WEB-INF/HW3Part6-movie-search-results.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
