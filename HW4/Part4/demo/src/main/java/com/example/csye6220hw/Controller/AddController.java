package com.example.csye6220hw.Controller;
import com.example.csye6220hw.DAO.MovieDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddController extends AbstractController {

    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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

        return new ModelAndView("HW4Part4-add-movie-status");
    }
}
