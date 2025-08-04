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
public class ServletProveedor extends HttpServlet {

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

        String boton = request.getParameter("btnProveedor");

                int nit = 0;
                String nombre = "";
                String direccion = "";
                String telefono = "";
                String contacto = "";
                String correo = "";
                int idCiudad = 0;    

                Boolean resultado = false;
                
                ConsultaProveedor consulta = new ConsultaProveedor();

        switch (boton) {
            case "crearProveedor":

                nit = Integer.parseInt(request.getParameter("nit"));
                nombre = request.getParameter("nombre");
                direccion = request.getParameter("direccion");
                telefono = request.getParameter("telefono");
                contacto = request.getParameter("contacto");
                correo = request.getParameter("correo");
                idCiudad = Integer.parseInt(request.getParameter("ciudad"));

                resultado = consulta.crearProveedor(nit, nombre, direccion, telefono, contacto, correo, idCiudad);

                if (resultado.equals(true)) {
                    JOptionPane.showMessageDialog(null, "Proveedor creado con éxito");
                    response.sendRedirect("vista/vistas/crearProveedor.jsp");
                } else {
                    response.sendRedirect("vista/error.jsp");
                }

                break;
                
            case "modificarProveedor":    
                
                nit = Integer.parseInt(request.getParameter("identificacion")); 
                direccion = request.getParameter("direccion"); 
                telefono = request.getParameter("telefono"); 
                contacto = request.getParameter("contacto"); 
                correo = request.getParameter("correo"); 
                idCiudad = Integer.parseInt(request.getParameter("ciudad"));
                
                resultado = consulta.modificarProveedor(nit,direccion,telefono,contacto,correo,idCiudad);
                
                if (resultado.equals(true)) {
                    JOptionPane.showMessageDialog(null, "Proveedor actualizado con éxito");
                    response.sendRedirect("vista/vistas/crearProveedor.jsp");
                } else {
                    response.sendRedirect("vista/error.jsp");
                }
                
                break;        
                
            default:
                response.sendRedirect("vista/error.jsp");
                
                
        }//Fin del Switch
        
        

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
