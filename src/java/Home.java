/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author S08110650000
 */
public class Home extends HttpServlet {
   
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            ArrayList ErrMsg= (ArrayList)request.getAttribute("ErrMsg");
            out.println("<html> <head><title>WELCOME TO EXAM</title>");
            out.println("<script type='text/javascript'>");
            
    out.println("window.history.forward();function noBack() { window.history.forward(); }");
out.println("</script>");
out.println("</head>");
out.println("<BODY onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>");
            
            out.println("<h1>WELCOME TO ONLINE EXAMINATION</h1>");
            out.println(" <br/>");
            if(ErrMsg!=null&&!ErrMsg.isEmpty())
            {
                Iterator it = ErrMsg.iterator();
                while(it.hasNext())
                {
                    out.println(it.next());
                }
            }
            out.println("<h2>PLEASE LOGIN WITH YOUR USER-ID & PASSWORD</h2>");
            out.println(" <form action='Login_Verification' method='POST'>");
            out.println("USER ID  :<input type='text' name='User_Id' value='' /><br/>");
            out.println("PASSWORD :<input type='password' name='Pwd' value='' /><br/>");
            out.println("<input type='submit' value='SUBMIT' /> </form>");
              out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");

           out.println("<table width='1350'> <tr bgcolor='IndianRed'><td>");
           out.println("<footer id='footer'><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Copyright &copy; 2012 <a href='#'>VENISHETTY BHARGAVA MOURYA</a><span class='sep'>|</span></p></footer>");
            out.println("</td></tr></table>");
            out.println(" </body></html>");
        } finally { 
            out.close();
        }
    } 

   

}
