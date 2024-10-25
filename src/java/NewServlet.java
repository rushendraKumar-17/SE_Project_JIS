/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author rushendra
 */
public class NewServlet extends HttpServlet {
    
    private static final String DB_URL = "jdbc:mysql://localhost:3306/JIS";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String role = request.getParameter("role").toLowerCase();
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement statement = null;
        ResultSet result = null;
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Step 3: Create the SQL query
//            String sql = "INSERT INTO users (username, email) VALUES (?, ?)";

//                String query = "SELECT * FROM use"
            // Step 4: Prepare the statement
            String query = "SELECT * FROM users WHERE email = ?";
            
//            statement = conn.createStatement();
//            statement.setString(1,email);
               pstmt = conn.prepareStatement(query);
               pstmt.setString(1, email);
//            pstmt.setString(1,email);
//            pstmt.setString(1, username);
//            pstmt.setString(2, email);

            // Step 5: Execute the query
            
            result = pstmt.executeQuery();
            
            out.println("<html><body>");
            if(result.next() && result.getString("password").equals(password) && result.getString("role").equals(role)){
//                out.println("<p>Email: " + result.getString("email") + "</p>");
//                out.println("<p>Role: " + result.getString("role") + "</p>");
                
                   request.getRequestDispatcher(role+".jsp").forward(request, response);
            }
            else{
                out.println("<h1>No user found</h1>");
            }
//            while(result.next()){
//                out.println("<p>"+result.getString("email")+"&nbsp;"+result.getString("password")+"</p>");
//            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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
