/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
public class ReviewProcess extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ReviewProcess</title>");            
             out.println("<script type='text/javascript'>");            
    out.println("window.history.forward();function noBack() { window.history.forward(); }");
out.println("</script>");
out.println("</head>");
out.println("<BODY onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>");
           HttpSession session = request.getSession();
            out.println("<h2>USER ID: "+ session.getAttribute("UserId")+"</h2>");
            String button = request.getParameter("button");
            for(int i=0;i<20;i++)
            {
                if (button.equals(""+(i+1)+""))
                 {
                      
                      session.setAttribute("QNo", i+1);
                      RequestDispatcher rd=request.getRequestDispatcher("Write_Exam");
                      rd.forward(request, response);
                 } 
            }
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    
}
