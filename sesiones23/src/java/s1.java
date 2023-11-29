/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import misclases.ConnMysql;
import misclases.ConnSingleton;
import misclases.usuario;

/**
 *
 * @author alejandro
 */
@WebServlet(urlPatterns = {"/s1"})
public class s1 extends HttpServlet {

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
            out.println("<title>Servlet s1</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet s1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            HttpSession misesion;
            misesion = request.getSession();
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            /* 
            if(mu.getUsu().equals(usuario) && mu.getPass().equals(pass)){
              misesion.setAttribute("logueado", mu);
            }*/

            Connection con = new ConnMysql().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;

            rs = stmt.executeQuery("select * from cliente where usuario='" + usuario + "' and pass='" + pass + "'");
            usuario mu = null;
            while (rs.next()) {

                mu = new usuario(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getString(6));
            }
            misesion.setAttribute("logueado", mu);
            rs.close();
            stmt.close();
            con.close();

            if (mu.getRol().equals("admin")) {

                con = new ConnMysql().getConnection();
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from cliente");

                request.setAttribute("miresult", rs);

                request.getRequestDispatcher("/vadmin.jsp").forward(request, response);
                rs.close();
                stmt.close();
                con.close();

            } else {
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            }

        } catch (SQLException ex) {
            Logger.getLogger(s1.class.getName()).log(Level.SEVERE, null, ex);
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
