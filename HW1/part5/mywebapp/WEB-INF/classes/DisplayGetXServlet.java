import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DisplayGetXServlet", value = "/DisplayGetXServlet")
public class DisplayGetXServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>" + "Display all getX() methods form HttpServletRequest and ServletRequest" + "</h1>");

        // GetX Methods in HTTPServletRequest
        out.println("<h3>" + request.getAuthType() + "</h3>");
        out.println("<h3>" + request.getContextPath() + "</h3>");
        out.println("<h3>" + request.getCookies() + "</h3>");
        out.println("<h3>" + request.getHeaderNames() + "</h3>");
        out.println("<h3>" + request.getMethod() + "</h3>");
        out.println("<h3>" + request.getPathInfo() + "</h3>");
        out.println("<h3>" + request.getPathTranslated() + "</h3>");
        out.println("<h3>" + request.getQueryString() + "</h3>");
        out.println("<h3>" + request.getRemoteUser() + "</h3>");
        out.println("<h3>" + request.getRequestedSessionId() + "</h3>");
        out.println("<h3>" + request.getRequestURI() + "</h3>");
        out.println("<h3>" + request.getRequestURL() + "</h3>");
        out.println("<h3>" + request.getServletPath() + "</h3>");
        out.println("<h3>" + request.getSession() + "</h3>");
        out.println("<h3>" + request.getUserPrincipal() + "</h3>");

        // GetX Methods in ServletRequest
        out.println("<h3>" + request.getAsyncContext() + "</h3>");
        out.println("<h3>" + request.getAttributeNames() + "</h3>");
        out.println("<h3>" + request.getCharacterEncoding() + "</h3>");
        out.println("<h3>" + request.getContentLength() + "</h3>");
        out.println("<h3>" + request.getContentLengthLong() + "</h3>");
        out.println("<h3>" + request.getContentType() + "</h3>");
        out.println("<h3>" + request.getDispatcherType() + "</h3>");
        out.println("<h3>" + request.getInputStream() + "</h3>");
        out.println("<h3>" + request.getLocalAddr() + "</h3>");
        out.println("<h3>" + request.getLocale() + "</h3>");
        out.println("<h3>" + request.getLocales() + "</h3>");
        out.println("<h3>" + request.getLocalName() + "</h3>");
        out.println("<h3>" + request.getLocalPort() + "</h3>");
        out.println("<h3>" + request.getParameterMap() + "</h3>");
        out.println("<h3>" + request.getParameterNames() + "</h3>");
        out.println("<h3>" + request.getProtocol() + "</h3>");
        out.println("<h3>" + request.getReader() + "</h3>");
        out.println("<h3>" + request.getRemoteAddr() + "</h3>");
        out.println("<h3>" + request.getRemoteHost() + "</h3>");
        out.println("<h3>" + request.getRemotePort() + "</h3>");
        out.println("<h3>" + request.getScheme() + "</h3>");
        out.println("<h3>" + request.getServerName() + "</h3>");
        out.println("<h3>" + request.getServerPort() + "</h3>");
        out.println("<h3>" + request.getServletContext() + "</h3>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
