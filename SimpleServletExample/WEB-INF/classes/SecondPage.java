import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class SecondPage extends HttpServlet 
{

public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
 {
  response.setContentType("text/html");
RequestDispatcher rd=request.getRequestDispatcher("/pageTwo.html");  
try{
	 rd.include(request, response); 
	}catch(ServletException e){
		PrintWriter out=response.getWriter();
		out.println("Errror"+e);
	}
        
 }



public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException
{

}

	
}