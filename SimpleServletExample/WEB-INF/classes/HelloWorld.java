import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class HelloWorld extends HttpServlet 
{

public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
 {
  response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.println("<html>");
out.println("<body>");
out.println("<p><h3>I am First Page</H3><h4>Created from Servlet</H4><p></p>");
out.println("<ul><li><a href="+"index.html"+">Home</a></li><li><a href="+"pageOne"+">Page 1</a></li><li><a href="+"pageTwo"+">Page 2</a></li></ul>");
out.println("</body></html>");
 }



public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
{

}

	
}