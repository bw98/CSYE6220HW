package com.example.csye6220hw.Controller;

import com.example.csye6220hw.Bean.Book;
import com.example.csye6220hw.DAO.BookDAO;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class AddController extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
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

        return new ModelAndView("add-books-status");
    }
}