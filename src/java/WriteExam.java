


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WriteExam extends HttpServlet {   
   
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd1 =request.getRequestDispatcher("Home");
        try {            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Write Exam</title>");    
             out.println("<script type='text/javascript'>");            
    out.println("window.history.forward();function noBack() { window.history.forward(); }");
out.println("</script>");
out.println("</head>");
out.println("<BODY onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>");
            HttpSession session = request.getSession();
            try{
                out.println("<h2>USER ID: "+ session.getAttribute("UserId")+"</h2>");
            }
            catch(Exception e)
            {
                out.println("prblm is here");
            }
        
         
            int    QNo=(Integer)session.getAttribute("QNo");
            session.setAttribute("QNo",QNo);
         
         
            
                String url = "jdbc:mysql://localhost:3306/";
		String dbName = "onlineexam";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String passwd = "";
                String query="SELECT * FROM questions;";
               
		String b1="",b2="",b3="",b4="";
               String str=null;
               Integer qno=QNo;
                str=(String)session.getAttribute((qno).toString().trim());     
                         
                         
                 if(str!=null)
                  {
                          if(str.equals("1"))
                             {
                               b1="checked";
                              }
                              if(str.equals("2"))
                             {
                              b2="checked";
                               }
                              if(str.equals("3"))
                               {
                                  b3="checked";
                                }
                             if(str.equals("4"))
                             {
                               b4="checked";
                             }
                 }
		try 
		{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
			Statement stmt=null;
			ResultSet rs = null;			
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs= stmt.executeQuery(query);						
			
			
                        rs.absolute(QNo);
			
                        out.println("Q"+Integer.parseInt(rs.getString("QNo"))+")"+rs.getString(2)+"<br/><br/>"); 
                                           
                    
                    
                   out.println("<form action='Process' method='POST'>");
                   out.println( " <input type='radio' name='Choices' value='1'"+b1.trim()+"/>"+rs.getString(3)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='2' "+b2.trim()+"/>"+rs.getString(4)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='3' "+b3.trim()+"/>"+rs.getString(5)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='4' "+b4.trim()+"/>"+rs.getString(6)+"<br/>");
                   out.println(" <input type='submit' name='button' value='PREVIOUS'  /><input type='submit'  name='button' value='NEXT'  /><input type='submit' name='button' value='REVIEW' /> <input type='submit'  name='button' value='END EXAM' /></form>");	
            
                
           
            
                
            
			stmt.close();
			conn.close();
			
		}
		
            
            
                catch (Exception e)
                {
			
				
		}
            out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");

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
