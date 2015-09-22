/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import javax.swing.JOptionPane;

/**
 *
 * @author S08110650000
 */
public class LoginVerification extends HttpServlet {
   
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList ErrMsg = new ArrayList();
        request.setAttribute("ErrMsg", ErrMsg);
        try
        {
            String str1= request.getParameter("User_Id").trim();
            String str2= request.getParameter("Pwd");
            int id=-1;
            try
            {
                id=Integer.parseInt(str1);
            }
            catch(Exception e)
            {
                ErrMsg.add("ENTER YOUR VALID USER-ID");
            }
            if(!ErrMsg.isEmpty())
            {
                RequestDispatcher rd = request.getRequestDispatcher("Home");
                rd.forward(request,response);
            }
            
            else{ 
                
                String Ur = "jdbc:mysql://localhost:3306/";
		String dbName = "onlineexam";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root"; 
		String passwd = "";
                
                int selected=0;
		
		try 
		{
			Class.forName(driver).newInstance();
			Connection conn = DriverManager.getConnection(Ur+dbName,userName,passwd);
			Statement stmt=null;
			ResultSet rs = null;			
			stmt=conn.createStatement();
                        String query="SELECT * FROM users;";
			rs= stmt.executeQuery(query);
						
                        Connection conn2 = DriverManager.getConnection(Ur+dbName,userName,passwd);
			Statement stmt2=null;
			ResultSet rs2 = null;			
			stmt2=conn2.createStatement();
                        String query2="SELECT * FROM history;";
			rs2= stmt2.executeQuery(query2);
						
			
			
			while(rs.next()&&selected==0)
			{
				int uid=rs.getInt("UserId");                               
                                String pass1=rs.getString("Password");
				 if(id==uid && str2.matches(pass1) )
				 {					
					selected=1;
				 }
			}
                        
                        while(rs2.next()&&selected==1)
                        {
                            int uid=rs2.getInt("UserId");  
                            if(id==uid)
                            {
                                selected=2;
                            }
                        }
                        
                        
			
			if(selected==0)
			{
                            ErrMsg.add("INVALID LOGIN : LOGIN WITH CORRECT USER-ID AND PASSWORD");
			}
			
			if(selected==2)
                        {
                               ErrMsg.add(" YOU HAVE ALREADY TAKEN THIS EXAM  ........");
                        }
			
			
			stmt.close();
			conn.close();
                        stmt2.close();
                        conn2.close();
			
		}
		catch (Exception e)
		{
			 ErrMsg.add(e.toString());
				
		}
                 if(!ErrMsg.isEmpty())
                {
                    RequestDispatcher rd =request.getRequestDispatcher("Home");
                    rd.forward(request,response);
                }
                else
                {   
                    HttpSession session = request.getSession();
                    session.setAttribute("UserId",str1);
                    session.setAttribute("QNo",1);
                    
                   
                
                
                    
			
						try{
                                                    Class.forName(driver).newInstance();
		    Connection conn1= DriverManager.getConnection(Ur+dbName,userName,passwd);
						Statement stmt1=null;
						ResultSet rs1 = null;
							String sql = "INSERT into history VALUES(?,?)";
							com.mysql.jdbc.PreparedStatement prest = (com.mysql.jdbc.PreparedStatement) conn1.prepareStatement(sql);

							prest.setInt(1,Integer.parseInt(str1));
							prest.setInt(2,0);
							
							
							int cnt = prest.executeUpdate();
							
							
							
							conn1.close();	
						}
						catch (Exception e)
						{
							//e.printStackTrace();
							
						}
				
						
                    
                        //Cookie userCookie = new Cookie("UserId", str1);
                      // userCookie.setMaxAge(60*60*24*365); //Store cookie for 1 year
                       // response.addCookie(userCookie);                  
                    
                     RequestDispatcher rd =request.getRequestDispatcher("Start_Exam");
                     rd.forward(request,response);
                 }
           
            
            }
            

        }
        finally
        {
            out.close();
        }
    } 

 

}
