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
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro Rubiano
 */
public class ServletColaborador extends HttpServlet {

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
        
        String boton = request.getParameter("crearColaborador");
        
        if(boton.equals("crearColaborador")){        
        
        int identificacion = Integer.parseInt(request.getParameter("identificacion"));
        String nombre = request.getParameter("nombres");
        String correo = request.getParameter("correo");
        String indicativo = request.getParameter("indicativo");
        String celular = request.getParameter("celular");
        String dirección = request.getParameter("direccion");
        String rh = request.getParameter("rh");
        int ciudad = Integer.parseInt(request.getParameter("ciudad"));
        String natalidad = request.getParameter("cumpleanos");
        String ingreso = request.getParameter("ingreso");
        int cargo = Integer.parseInt(request.getParameter("cargo"));
        
        String telefono = indicativo+celular;
        
        ConsultaColaborador consulta = new ConsultaColaborador();
        
        Boolean resultado = consulta.crearColaborador(identificacion, nombre, correo, telefono, dirección, rh, ciudad, cargo, natalidad, ingreso);
            
            if(resultado.equals(true)){
                JOptionPane.showMessageDialog(null, "Colaborador creado con éxito");
                response.sendRedirect("index.jsp");
            }//Fin del if interno
            
            if(resultado.equals(false)){
                JOptionPane.showMessageDialog(null, "Error en la creación del colaborador");
                response.sendRedirect("index.jsp");
            }
        
        
        }//Fin del If
        
        
        
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
