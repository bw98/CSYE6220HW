package com.example.csye6220hw.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ToAddBooksPageServlet", urlPatterns = {"/ToAddBooksPageServlet"})
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
public class ToAddBooksPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookNumStr = request.getParameter("book_num");
        int bookNum = Integer.parseInt(bookNumStr);
        request.setAttribute("book_num", bookNum);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/HW3Part7-AddBooksPage.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
