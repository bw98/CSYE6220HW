package com.example.csye6220hw.Controller;

import com.example.csye6220hw.Bean.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/listitem")
public class ListItemController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> items = (List<Item>) session.getAttribute("items");
        request.setAttribute("items", items);

        return new ModelAndView("list-item");
    }
}
