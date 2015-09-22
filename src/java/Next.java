/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;


public class Next extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        try {
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>WriteExam</title>");            
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
               
               
                Integer QNo=1;
                try
                {
                 QNo= (Integer)session.getAttribute("QNo");
                }
                 catch (Exception e)
                {
			out.println(e.toString());
                        out.println("HERE IT IS");
		}
                
               String b1="",b2="",b3="",b4="";
               String str=null;
               if(QNo!=20)
                     {
                         Integer qno=QNo+1;
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
                         
                     }
                     else
                     {
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
                     }
                
                
		try 
		{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(url+dbName,userName,passwd);
			Statement stmt=null;
			ResultSet rs = null;			
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs= stmt.executeQuery(query);						
			
                       
			if(QNo!=20)
                        {
                        rs.absolute(QNo+1);
                        session.setAttribute("QNo", QNo+1);
			
                        out.println("Q"+Integer.parseInt(rs.getString("QNo"))+")"+rs.getString(2)+"<br/><br/>"); 
                        
                        out.println("<form action='Process' method='POST'>");
                   
                   out.println("<form action='Process' method='POST'>");
                   out.println( " <input type='radio' name='Choices' value='1'"+b1.trim()+"/>"+rs.getString(3)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='2' "+b2.trim()+"/>"+rs.getString(4)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='3' "+b3.trim()+"/>"+rs.getString(5)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='4' "+b4.trim()+"/>"+rs.getString(6)+"<br/>");
                  out.println(" <input type='submit' name='button' value='PREVIOUS'  /><input type='submit'  name='button' value='NEXT'  /><input type='submit' name='button' value='REVIEW' /><input type='submit'  name='button' value='END EXAM' /></form>");	
                        }
                        else
                        {
                             rs.absolute(QNo);
			
                        out.println("Q"+Integer.parseInt(rs.getString("QNo"))+")"+rs.getString(2)+"<br/><br/>"); 
                        
                    
                   out.println("<form action='Process' method='POST'>");
                   out.println( " <input type='radio' name='Choices' value='1'"+b1.trim()+"/>"+rs.getString(3)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='2' "+b2.trim()+"/>"+rs.getString(4)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='3' "+b3.trim()+"/>"+rs.getString(5)+"<br/>");
                   out.println( " <input type='radio' name='Choices' value='4' "+b4.trim()+"/>"+rs.getString(6)+"<br/>");
                  out.println(" <input type='submit' name='button' value='PREVIOUS'  /><input type='submit'  name='button' value='NEXT'  /><input type='submit' name='button' value='REVIEW' /><input type='submit'  name='button' value='END EXAM' /></form>");	
                
                        }
			stmt.close();
			conn.close();
			
		}
		
            
            
                catch (Exception e)
                {
			out.println(e.toString());
				
		}
            out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");
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
        }
    }

   
}
