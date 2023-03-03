package com.example.csye6220hw.Controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuController extends AbstractController {

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String selectedPage = request.getParameter("page");
        if ("Browse Movies".equals(selectedPage)) {
            return new ModelAndView("HW4Part4-browse-movies");
        } else if ("Add Movie".equals(selectedPage)) {
            return new ModelAndView("HW4Part4-add-movie");
        }
        return null;
    }
}
