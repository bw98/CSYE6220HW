import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpHeaders;
import java.util.Enumeration;

@WebServlet(name = "HeaderServlet", value = "/HeaderServlet")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Enumeration<String> headers = request.getHeaderNames();

        out.println("<html>");
        out.println("<body>");

        // print request headers
        out.println("<h1>");
        out.println("Request Header Info");
        out.println("</h1>");
        out.println("<br>");
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            out.println(header + ": " + request.getHeader(header) + "<br>");
        }
        out.println("<br>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
