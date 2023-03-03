package com.example.csye6220hw.Controller;

import com.example.csye6220hw.Bean.Movie;
import com.example.csye6220hw.DAO.MovieDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SearchController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        return new ModelAndView("HW4Part4-movie-search-results");
    }
}
