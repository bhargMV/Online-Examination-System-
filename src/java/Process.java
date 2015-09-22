/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author BHARGAVA MOURYA
 */
public class Process extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String choice="";
           String button = request.getParameter("button");        
          
            choice= request.getParameter("Choices");
             
           HttpSession session = request.getSession(); 
           Integer QNo= (Integer) session.getAttribute("QNo");
           if(choice!=null)
           {
                if(choice.equals("1"))              
                {
                     
                    session.setAttribute(QNo.toString().trim(),"1");
                }
                if(choice.equals("2"))
                 {
                     
                    session.setAttribute(QNo.toString().trim(),"2");
                
                 }
                 if(choice.equals("3"))
                 {
                     
                    session.setAttribute(QNo.toString().trim(),"3");
                 }
                 if(choice.equals("4"))
                 {
                     
                    session.setAttribute(QNo.toString().trim(),"4");
                 }
           }
           
           if (button.equals("PREVIOUS"))
           {
               RequestDispatcher rd=request.getRequestDispatcher("Previous");
               rd.forward(request, response);
            } 
           else if (button.equals("NEXT"))
           {
                RequestDispatcher rd=request.getRequestDispatcher("Next");
               rd.forward(request, response);
           }
           
           else if(button.equals("END EXAM"))
           {
                RequestDispatcher rd=request.getRequestDispatcher("End_Exam");
               rd.forward(request, response);
            }
           else
           {
               RequestDispatcher rd=request.getRequestDispatcher("Review");
               rd.forward(request, response);
           }
        } 
       catch(Exception e)
                {
                     out.println("<html>");
                     out.println("<body>");
                    out.println(e.toString());
                    out.println("</body>");
                     out.println("</html>");
                  }
        finally {            
            out.close();
        }
    }

  
}
