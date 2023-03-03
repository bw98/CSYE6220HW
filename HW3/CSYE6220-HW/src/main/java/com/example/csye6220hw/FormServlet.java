package com.example.csye6220hw;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

@WebServlet(name = "FormServlet", value = "/FormServlet")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<h1>");
        out.println("FormServlet Test");
        out.println("</h1>");
        out.println("<body>");

        //  Using getParameterMap()
        out.println("<h3>");
        out.println("Servlet getParameterMap Test");
        out.println("</h3>");
        out.println("<br>");
        Map<String, String[]> requestMap = request.getParameterMap();  // value 的类型是 String[], 而不是 String
        Iterator<Map.Entry<String, String[]>> it = requestMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> entry = it.next();
            String name = (String) entry.getKey();
            String[] values = (String[]) entry.getValue();
            out.println(name + ": ");
            for (int i = 0; i < values.length; i++) {
                out.println(values[i]);
            }
            out.println("<br>");
        }

        // Using getParameterNames()
        // 通过 Enumeration 的 hasMoreElements() 方法遍历, 再由 nextElement() 方法获得枚举的值,
        // 此时的值是 form 表单中所有控件的 name 属性的值
        out.println("<h3>");
        out.println("Servlet getParameterNames Test");
        out.println("</h3>");
        out.println("<br>");
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            out.print(name + ": " + value);
            out.println("<br>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
