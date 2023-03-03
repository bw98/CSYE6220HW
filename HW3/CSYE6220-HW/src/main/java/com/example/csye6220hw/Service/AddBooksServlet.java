package com.example.csye6220hw.Service;

import com.example.csye6220hw.Bean.Book;
import com.example.csye6220hw.DAO.BookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddBooksServlet", urlPatterns = {"/AddBooksServlet"})
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
public class AddBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bookNum = Integer.parseInt(request.getParameter("book_num"));
        List<Book> books = new ArrayList<Book>();
        for (int i = 1; i <= bookNum; i++) {
            String isbn = request.getParameter("isbn" + i);
            String title = request.getParameter("title" + i);
            String authors = request.getParameter("authors" + i);
            float price = Float.parseFloat(request.getParameter("price" + i));
            Book book = new Book(isbn, title, authors, price);
            books.add(book);
        }

        BookDAO bookDAO = new BookDAO();
        boolean isSuccess = bookDAO.insertBooks(books);

        request.setAttribute("isSuccess", isSuccess);
        request.setAttribute("bookNum", bookNum);

        // forward request and response to JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/HW3Part7-add-books-status.jsp");
        dispatcher.forward(request, response);
    }
}
