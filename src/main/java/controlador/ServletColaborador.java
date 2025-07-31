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
import java.sql.Date;
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

        String boton = request.getParameter("btnColaborador");

        if (boton.equals("crearColaborador")) {

            int identificacion = Integer.parseInt(request.getParameter("identificacion"));
            String nombre = request.getParameter("nombres");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("celular");
            String direccion = request.getParameter("direccion");
            int rh = Integer.parseInt(request.getParameter("rh"));
            int ciudad = Integer.parseInt(request.getParameter("ciudad"));
            Date natalidad = Date.valueOf(request.getParameter("cumpleanos"));
            Date ingreso = Date.valueOf(request.getParameter("ingreso"));
            int cargo = Integer.parseInt(request.getParameter("cargo"));

            ConsultaColaborador consulta = new ConsultaColaborador();

            Boolean resultado = consulta.crearColaborador(identificacion, nombre, correo, telefono, direccion, rh, ciudad, cargo, natalidad, ingreso);

            if (resultado.equals(true)) {
                JOptionPane.showMessageDialog(null, "Colaborador creado con éxito");
                response.sendRedirect("vista/vistas/crearColaborador.jsp");
            }//Fin del if interno

            if (resultado.equals(false)) {
                JOptionPane.showMessageDialog(null, "Error en la creación del colaborador");
                response.sendRedirect("index.jsp");
            }

        }//Fin del If de crear

        if (boton.equals("modificarColaborador")) {

            int identificacion = Integer.parseInt(request.getParameter("identificacion"));
            
            String correo = request.getParameter("correo");
            
            String indicativo = request.getParameter("indicativo");
            String telefono = request.getParameter("celular");
            String direccion = request.getParameter("direccion");
            int ciudad = Integer.parseInt(request.getParameter("ciudad"));
            int cargo = Integer.parseInt(request.getParameter("cargo"));            

            ConsultaColaborador consulta = new ConsultaColaborador();
            
            Boolean resultado = consulta.modificarColaborador(identificacion, correo, telefono, direccion, ciudad, cargo);

            if (resultado.equals(true)) {
                JOptionPane.showMessageDialog(null, "Colaborador actualizado con éxito");
                response.sendRedirect("vista/vistas/crearColaborador.jsp");
            }//Fin del if interno

            if (resultado.equals(false)) {
                JOptionPane.showMessageDialog(null, "Error en la actualización del colaborador");
                response.sendRedirect("index.jsp");
            }
            

        }//Fin del If de modificar

        if (boton.equals("terminarColaborador")) {

            int identificacion = Integer.parseInt(request.getParameter("identificacion"));
            
            Date finalizacion = Date.valueOf(request.getParameter("salida"));
            
            ConsultaColaborador consulta = new ConsultaColaborador();
            
            Boolean resultado = consulta.terminarColaborador(identificacion, finalizacion);

            if (resultado.equals(true)) {
                JOptionPane.showMessageDialog(null, "Contrato terminado con éxito");
                response.sendRedirect("vista/vistas/crearColaborador.jsp");
            }//Fin del if interno

            if (resultado.equals(false)) {
                JOptionPane.showMessageDialog(null, "Error en la terminación del contrato");
                response.sendRedirect("index.jsp");
            }
            

        }//Fin del If de terminar contrato
        
        
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
