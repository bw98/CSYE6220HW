package com.example.csye6220hw.Service;

import com.example.csye6220hw.Bean.Item;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ItemServlet", urlPatterns = {"/ItemServlet"})
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
public class ItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Item> items = (List<Item>) session.getAttribute("items");
        String action = request.getParameter("Action");
        // System.out.println("38 line action = " + action);

        if ("AddItem".equals(action)) {
            if (items == null) {
                items = new ArrayList<>();
            }
            String item_name = request.getParameter("Item");
            float item_price = Float.parseFloat(request.getParameter(item_name + "Price"));
            if (item_name.length() > 0 && item_price != 0) {
                Item item = new Item();
                item.setName(item_name);
                item.setPrice(item_price);
                items.add(item);
                session.setAttribute("items", items);
            }
            response.sendRedirect("http://localhost:8080/CSYE6220_HW_war/ListItemServlet");
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
            response.sendRedirect("http://localhost:8080/CSYE6220_HW_war/ListItemServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
