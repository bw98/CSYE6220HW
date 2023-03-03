package com.example.csye6220hw.Service;

import com.example.csye6220hw.DAO.MovieDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddMovieServlet", urlPatterns = {"/AddMovieServlet"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "secured"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "POST", rolesAllowed = {
                        "secured"
                })
        })
public class AddMovieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String actor = request.getParameter("actor");
        String actress = request.getParameter("actress");
        String genre = request.getParameter("genre");
        int year = Integer.parseInt(request.getParameter("year"));

        MovieDAO movieDAO = new MovieDAO();
        boolean isSuccess = false;
        try {
            isSuccess = movieDAO.addMovie(title, actor, actress, genre, year);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // set success status in request attribute
        request.setAttribute("isSuccess", isSuccess);

        // forward request and response to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/HW3Part6-add-movie-status.jsp");
        dispatcher.forward(request, response);
    }
}
