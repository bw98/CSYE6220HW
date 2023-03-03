package com.example.csye6220hw.Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputController extends AbstractController {

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String bookNumStr = request.getParameter("book_num");
        int bookNum = Integer.parseInt(bookNumStr);
        request.setAttribute("book_num", bookNum);
        return new ModelAndView("add-books-page");
    }
}
