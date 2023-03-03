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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> items = (List<Item>) session.getAttribute("items");
        String action = request.getParameter("Action");
        System.out.println("26 line action = " + action);

        if ("AddItem".equals(action)) {
            if (items == null) {
                items = new ArrayList<>();
            }
            String item_name = request.getParameter("Item");
            float item_price = Float.parseFloat(request.getParameter(item_name + " Price"));
            if (item_name.length() > 0 && item_price != 0) {
                Item item = new Item();
                item.setName(item_name);
                item.setPrice(item_price);
                items.add(item);
                session.setAttribute("items", items);
            }
        } else if ("DeleteItem".equals(action)) {
            String itemNameToDelete = request.getParameter("Item");
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                if (itemNameToDelete.equals(item.getName())) {
                    iter.remove();
                }
            }
            session.setAttribute("items", items);
        }

        return new ModelAndView("redirect:/listitem");
    }
}
