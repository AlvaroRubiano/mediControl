/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author kelly
 */
public class ServletLogin extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        int resultado = 0;

        ConsultaUsuario c = new ConsultaUsuario();

        resultado = c.consultaCargo(usuario, password);

        if (resultado > 0) {
            switch (resultado) {
                case 1:
                    try {
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Cargo", resultado);
                        response.sendRedirect("vista/gerente.jsp");
                    } catch (Exception e) {
                        out.print("Error en el login: " + e);
                    }
                    break;
                case 2:
                    try {
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Cargo", resultado);
                        response.sendRedirect("vista/gerenteTecnico.jsp");
                    } catch (Exception e) {
                        out.print("Error en el login: " + e);
                    }
                    break;
                case 3:
                    try {
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Cargo", resultado);
                        response.sendRedirect("vista/almacenista.jsp");
                    } catch (Exception e) {
                        out.print("Error en el login: " + e);
                    }
                    break;
                case 4:
                    try {
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Cargo", resultado);
                        response.sendRedirect("vista/auxiliarContable.jsp");
                    } catch (Exception e) {
                        out.print("Error en el login: " + e);
                    }
                    break;

                case 5:
                    try {
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Cargo", resultado);
                        response.sendRedirect("vista/auxiliarAlmacen.jsp");
                    } catch (Exception e) {
                        out.print("Error en el login: " + e);
                    }
                    break;
                case 6:
                    try {
                        HttpSession objetoSesion = request.getSession(true);
                        objetoSesion.setAttribute("Cargo", resultado);
                        response.sendRedirect("vista/soporte.jsp");
                    } catch (Exception e) {
                        out.print("Error en el login: " + e);
                    }
                    break;

                default:
                    response.sendRedirect("vista/error.jsp");
            }//Fin del swich
        } else {
            response.sendRedirect("vista/error.jsp");
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
