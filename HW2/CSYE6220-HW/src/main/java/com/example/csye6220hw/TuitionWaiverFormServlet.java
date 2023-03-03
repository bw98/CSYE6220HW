package com.example.csye6220hw;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TuitionFormServlet", urlPatterns = {"/TuitionWaiverFormServlet"})
@ServletSecurity(
        value = @HttpConstraint(
                rolesAllowed = {
                        "secured"
                }),
        httpMethodConstraints = {
                @HttpMethodConstraint(value = "Post", rolesAllowed = {
                        "secured"
                })
        })
public class TuitionWaiverFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1> Tuition Waiver Form Information</h1>");

        out.println("<h3> Academic Term: " + request.getParameter("Term") + "</h3>");
        out.println("<h3> Academic Year: " + request.getParameter("Year") + "</h3>");

        String employeeStatus = request.getParameter("EmployeeStatus");
        if (employeeStatus.length() != 0) {
            out.println("<h3> Employee Status: " + employeeStatus + "</h3>");
        } else {
            out.println("<h3> Employee Status: " + request.getParameter("OtherEmployeeStatus") + "</h3>");
        }
        out.println("<h3> Student's Name: " + request.getParameter("StudentName") + "</h3>");
        out.println("<h3> Relation to Employee: " + request.getParameter("RelationshipToEmployee") + "</h3>");
        out.println("<h3> Student's NUID: " + request.getParameter("StudentNUID") + "</h3>");

        out.println("<h3> Employee Name: " + request.getParameter("EmployeeName") + "</h3>");
        out.println("<h3> Employee's NUID: " + request.getParameter("EmployeeNUID") + "</h3>");
        out.println("<h3> Department: " + request.getParameter("Department") + "</h3>");
        out.println("<h3> Campus Location: " + request.getParameter("CampusLocation") + "</h3>");
        out.println("<h3> Phone Number: " + request.getParameter("PhoneNumber") + "</h3>");
        out.println("<h3> Supervisor's Name: " + request.getParameter("SupervisorName") + "</h3>");
        out.println("<h3> Program: " + request.getParameter("Program") + "</h3>");

        out.println("<h2><u>Course 1</u></h2>");
        out.println("<h3> Course 1 No.: " + request.getParameter("Course1No") + "</h3>");
        out.println("<h3> Course1 Name: " + request.getParameter("Course1Name") + "</h3>");
        out.println("<h3> Supervisor Signature: " + request.getParameter("Course1Sig") + "</h3>");
        out.println("<h3> Credit Hrs.: " + request.getParameter("Course1Hrs") + "</h3>");
        out.println("<h3> Day(s): " + request.getParameter("Course1Days") + "</h3>");
        out.println("<h3> Time: " + request.getParameter("Course1Time") + "</h3>");


        out.println("<h3> Course 2 No.: " + request.getParameter("Course2No") + "</h3>");
        out.println("<h3> Course2 Name: " + request.getParameter("Course2Name") + "</h3>");
        out.println("<h3> Supervisor Signature: " + request.getParameter("Course2Sig") + "</h3>");
        out.println("<h3> Credit Hrs.: " + request.getParameter("Course2Hrs") + "</h3>");
        out.println("<h3> Day(s): " + request.getParameter("Course2Days") + "</h3>");
        out.println("<h3> Time: " + request.getParameter("Course2Time") + "</h3>");

        out.println("<h2><u>Course 3</u></h2>");
        out.println("<h3> Course 3 No.: " + request.getParameter("Course3No") + "</h3>");
        out.println("<h3> Course2 Name: " + request.getParameter("Course3Name") + "</h3>");
        out.println("<h3> Supervisor Signature: " + request.getParameter("Course3Sig") + "</h3>");
        out.println("<h3> Credit Hrs.: " + request.getParameter("Course3Hrs") + "</h3>");
        out.println("<h3> Day(s): " + request.getParameter("Course3Days") + "</h3>");
        out.println("<h3> Time: " + request.getParameter("Course3Time") + "</h3>");

        out.println("<h3>" + "Employee Signature: " + request.getParameter("EmployeeSig") + "</h3>");
        out.println("<h3>" + "Date: " + request.getParameter("EmployeeSigDate") + "</h3>");

        out.println("<h3>" + "HRM Approval: " + request.getParameter("HRM") + "</h3>");
        out.println("<h3>" + "Date: " + request.getParameter("HRMDate") + "</h3>");

        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
