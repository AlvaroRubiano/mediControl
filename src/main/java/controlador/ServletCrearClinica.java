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
public class ServletCrearClinica extends HttpServlet {

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
        
        String boton = request.getParameter("crear");
        
        if(boton.equals("crearCliente")){
            int nit = Integer.parseInt(request.getParameter("nit"));
            String nombre = request.getParameter("nombres");
            String direccion = request.getParameter("direccion");
            int idCiudad = Integer.parseInt(request.getParameter("ciudad"));
            
            ConsultaCllinica consulta = new ConsultaCllinica();
            
            Boolean resultado =  consulta.crearClinica(nit, nombre, direccion, idCiudad);
            
            if(resultado.equals(true)){
                JOptionPane.showMessageDialog(null, "Cliente creado con éxito");
                response.sendRedirect("vista/vistas/crearClinica.jsp");
            }else{
                response.sendRedirect("vista/error.jsp");
            }            
        }
        
        if(boton.equals("crearCentroMedico")){
            Long nit = Long.parseLong(request.getParameter("nit"));
            String nombre = request.getParameter("nombres");
            String direccion = request.getParameter("direccion");
            int idCiudad = Integer.parseInt(request.getParameter("ciudad"));
            
            ConsultaCllinica consulta = new ConsultaCllinica();
            
            Boolean resultado =  consulta.crearCentroMedico(nit, nombre, direccion, idCiudad);
            
            if(resultado.equals(true)){
                JOptionPane.showMessageDialog(null, "Centro medico creado con éxito");
                response.sendRedirect("vista/vistas/centroMedico.jsp");
            }else{
                response.sendRedirect("vista/error.jsp");
            }            
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
