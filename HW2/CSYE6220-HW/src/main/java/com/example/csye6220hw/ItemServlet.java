package com.example.csye6220hw;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
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
        List<String> items = (List<String>) session.getAttribute("items");
        String action = request.getParameter("Action");
        // System.out.println("38 line action = " + action);

        if ("AddItem".equals(action)) {
            if (items == null) {
                items = new ArrayList<>();
            }
            String new_item = request.getParameter("Item");
            if (new_item.length() > 0) {
                items.add(new_item);
            }
            session.setAttribute("items", items);
            response.sendRedirect("http://localhost:8080/CSYE6220_HW_war/ListItemServlet");
        }

        if ("DeleteItem".equals(action)) {
            String itemToDelete = request.getParameter("Item");
            items.remove(itemToDelete);
            session.setAttribute("items", items);
            response.sendRedirect("http://localhost:8080/CSYE6220_HW_war/ListItemServlet");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
