package com.example.csye6220hw;

import org.apache.poi.ss.usermodel.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;


@WebServlet(name = "ExcelServlet", urlPatterns = {"/store.xls"})
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
public class ExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = this.getServletContext().getRealPath("/WEB-INF/store.xls");
        // System.out.println(path);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>HW2 Part5</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            InputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(0); // get table head

            out.println("<div class='container'>");
            out.println("<table class='text-center'>");

            out.println("<tr>");

            // Render table head
            for (Cell cell : row) {
                out.println("<th>");
                out.println(cell.getStringCellValue());
                out.println("</th>");
            }
            out.println("</tr>");

            // Render table body
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                out.println("<tr>");
                row = sheet.getRow(i);
                for (Cell cell : row) {
                    out.println("<td>");
                    cell.setCellType(CellType.STRING);
                    out.println(cell.getStringCellValue());
                    out.println("</td>");
                }
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("</div>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
