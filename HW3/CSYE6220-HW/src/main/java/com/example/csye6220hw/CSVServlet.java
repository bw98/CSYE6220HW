package com.example.csye6220hw;

import Util.CSVReader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CSVServlet", value = "/CSVServlet")
public class CSVServlet extends HttpServlet {
    CSVReader csvReader = new CSVReader();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("CSVFileName");
        String Path = this.getServletContext().getRealPath("/WEB-INF/");  // Get real file path in Tomcat

        try {
            List<String[]> result = csvReader.parse(Path, filename);
            String[] tableHead = result.get(0);  // First string[] in list is column name
            PrintWriter out = response.getWriter();
            out.println("<!doctype HTML>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CSV Reader HW_Part4</title>");
            out.println("</head>");
            out.println("<body>");

            // Render table
            out.println("<div class='container'>");
            out.println("<table class='w-full text-center table-auto'>");
            out.println("<tr>");
            for (String s : tableHead) {
                out.println("<th>");  // Head line of table
                out.println(s);
                out.println("</th>");
            }
            out.println("</tr>");
            for (int i = 1; i < result.size(); i++) {
                out.println("</tr>");
                for (int j = 0; j < result.get(i).length; j++) {
                    out.println("<td>");  // Cell line of table
                    out.println(result.get(i)[j]);
                    out.println("</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
