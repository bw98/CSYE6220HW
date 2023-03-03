package com.example.csye6220hw.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MovieStoreMenuServlet", urlPatterns = {"/MovieStoreMenuServlet"})
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
public class MovieStoreMenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedPage = request.getParameter("page");
        if ("Browse Movies".equals(selectedPage)) {
            response.sendRedirect("HW3Part6-browse-movies.html");
        } else if ("Add Movie".equals(selectedPage)) {
            response.sendRedirect("HW3Part6-add-movie.html");
        }
    }
}
