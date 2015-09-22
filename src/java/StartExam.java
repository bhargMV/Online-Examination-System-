/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class StartExam extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         
        try {
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>StartExam</title>");            
             out.println("<script type='text/javascript'>");            
    out.println("window.history.forward();function noBack() { window.history.forward(); }");
out.println("</script>");
out.println("</head>");
out.println("<BODY onload='noBack();' onpageshow='if (event.persisted) noBack();' onunload=''>");
            HttpSession session = request.getSession();
            out.println("<h1>WELCOME  "+session.getAttribute("UserId")+"</h1><br/><br/>");
            out.println("<a href='Write_Exam'><h2>START EXAM</h2></a><br/>");
            out.println("<a href='Home'><h2>CANCEL</h2></a><br/>");
              out.println("<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>");

            out.println("<table width='1350'> <tr bgcolor='IndianRed'><td>");
           out.println("<footer id='footer'><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Copyright &copy; 2012 <a href='#'>VENISHETTY BHARGAVA MOURYA</a><span class='sep'>|</span></p></footer>");
            
            out.println("</td></tr></table>"); 
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
