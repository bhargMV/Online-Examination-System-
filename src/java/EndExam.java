

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;


public class EndExam extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

//response.setHeader("Cache-Control","no-cache"); 
//response.setHeader("Cache-Control","no-store"); 
//response.setDateHeader("Expires", 0); 

        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>EndExam</title>"); 
             out.println("<script type='text/javascript'>");
            
    out.println("window.history.forward();function noBack() { window.history.forward(); }");
out.println("</script>");
out.println("</head>");
out.println("<BODY onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>");
            
            HttpSession session = request.getSession();
            out.println("<h2>USER ID: "+ session.getAttribute("UserId")+"</h2>");
            

             
            String url = "jdbc:mysql://localhost:3306/";
	     String dbName = "onlineexam";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String passwd = "";
                String query="SELECT * FROM questions;";
                
                int Answers=0;
                int Attempts=0;
                
            
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>QUESTION</th>");
                out.println("<th>MARKED</th>");
                out.println("<th>ANSWER</th>");
                out.println("<th>RESULT</th>");
                out.println("</tr>");
                try 
		{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
			Statement stmt=null;
			ResultSet rs = null;			
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs= stmt.executeQuery(query);
                        
                           int i=1;
                        while(rs.next())
                        {
                         
                             out.println("<tr>");
                             out.println("<td>"+(i)+"</td>");
                                                 
                                 Integer in = i;
                                 if ((session.getAttribute(in.toString()))!=null) 
                                 {
                                     out.println("<td>"+session.getAttribute(in.toString())+"</td>");
                                     out.println("<td>"+rs.getString(7)+"</td>");
                                     Attempts++;
                                     if(rs.getString(7).equals((String)session.getAttribute(in.toString())))
                                     {
                                         Answers++;
                                         out.println("<td><img src='correct.jpg'/></td>");
                                     }
                                     else
                                     {
                                         out.println("<td><img src='wrong.jpg'/> </td>");
                                     }
                                     session.removeAttribute(in.toString());
                                 }
                                 else
                                 {
                                     out.println("<td> </td>");
                                     out.println("<td>"+rs.getString(7)+"</td>");
                                     out.println("<td> <img src='wrong.jpg'/></td>");                                     
                                 }
                                 i++;
                             out.println("</tr>");
                            
                        }
                        
                        String query2="UPDATE history SET Percentage=?  WHERE UserId=?";                        
			
                       PreparedStatement prest = (PreparedStatement) conn.prepareStatement(query2);
                        
                       prest.setInt(1,Answers*5);
                        prest.setInt(2,Integer.parseInt((String)session.getAttribute("UserId")));
			int  updt= prest.executeUpdate();
                        
                }
                
                 catch (Exception e)
                {
			out.println(e.toString());
				
		}
               
                out.println("<tr>");
                 out.println("<td> <input type='button' onClick='window.print(0)' value='Print This Page'></td>");
                 out.println("<td> <input type='button' onClick='window.open('http://google.com'); window.close();' value='EXIT'></td>");
                out.println("</tr>");
//                out.println("</table>");
//                 out.println("<input type='button' onClick='window.print(0)' value='Print This Page'>");
             
            
            out.println("<h3>TOTAL NO.OF QUESTIONS :  20</h3>");
            out.println("<h3>NO.OF QUESTIONS ATTEMPTED: "+Attempts+"</h3>");
            out.println("<h3>NO.OF QUESTIONS ATTEMPTED CORRECTLY : "+Answers+"</h3>");
            out.println("<h3>PERCENTAGE : "+(Answers*5)+"%</h3>");
            
           
            
//            out.println("<form action='printServlet' method='post'>");
//            out.println("<input type='submit' value='Execute' name='button'/>");
//            out.println("</form>");
            
            


           out.println("<table width='1350'> <tr bgcolor='IndianRed'><td>");
           out.println("<footer id='footer'><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Copyright &copy; 2012 <a href='#'>VENISHETTY BHARGAVA MOURYA</a><span class='sep'>|</span></p></footer>");

            out.println("</td></tr></table>");
    
    
            out.println("</body>");
            out.println("</html>");
        } 
         catch (Exception e)
                {
			out.println(e.toString());
				
		}
        finally {            
            out.close();
            HttpSession session = request.getSession();
            session.invalidate();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
