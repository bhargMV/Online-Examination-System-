

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author BHARGAVA MOURYA
 */
public class Review extends HttpServlet {

   
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Review</title>");            
             out.println("<script type='text/javascript'>");            
    out.println("window.history.forward();function noBack() { window.history.forward(); }");
out.println("</script>");
out.println("</head>");
out.println("<BODY onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>");
           HttpSession session = request.getSession();
            out.println("<h2>USER ID: "+ session.getAttribute("UserId")+"</h2>");
            
            out.println("<form action='Review_Process' method='POST'>");
             out.println("<table cellpadding='20'>");
            
             out.println("<tr>");
             for(int i=0;i<10;i++)
             {
                 if((session.getAttribute((new Integer(i+1)).toString()))!=null)
                 {
                     out.println("<td bgcolor='GreenYellow'>");
                     out.println("<input type='submit' name='button' value='"+(i+1)+"' width='100%' />");
                     out.println("</td>");
                 }
                 else
                 {
                     out.println("<td bgcolor='IndianRed'>");
                     out.println("<input type='submit' name='button' value='"+(i+1)+"' width='100%' />");
                     out.println("</td>");
                 }
                 
             }
              out.println("</tr>"); 
              
              out.println("<tr>");
             for(int i=10;i<20;i++)
             {
                  if((session.getAttribute((new Integer(i+1)).toString()))!=null)
                 {
                     out.println("<td bgcolor='GreenYellow'>");
                     out.println("<input type='submit' name='button' value='"+(i+1)+"' width:'100%' />");
                     out.println("</td>");
                 }
                 else
                 {
                     out.println("<td bgcolor='IndianRed'>");
                     out.println("<input type='submit' name='button' value='"+(i+1)+"' width:'100%' />");
                     out.println("</td>");
                 }
             }
              out.println("</tr>");  
              out.println("</table>");
              out.println("</form>");
              
              out.println("<br/><br/>");
              out.println("<table cellpadding='20'>");
              
              out.println("<tr>");
              out.println("<td bgcolor='GreenYellow'>");
              out.println("</td>");
              out.println("<td>");
              out.println("ATTEMPTED QUESTIONS");
              out.println("</td >");
              out.println("</tr>");
              
              out.println("<tr>");
              out.println("<td bgcolor='IndianRed'>");
              out.println("</td>");
              out.println("<td>");
               out.println("UNATTEMPTED QUESTIONS");
              out.println("</td>");
              out.println("</tr>");
              
              out.println("</table>");
            out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
            out.println("<table width='1350'> <tr bgcolor='IndianRed'><td>");
           out.println("<footer id='footer'><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Copyright &copy; 2012 <a href='#'>VENISHETTY BHARGAVA MOURYA</a><span class='sep'>|</span></p></footer>");
            
            out.println("</td></tr></table>");    
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

   
}
