/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
//import javax.mail.internet.MailDateFormat;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import modelo.Actividad;

/**
 *
 * @author Alvaro Rubiano
 */
public class ServletActividad extends HttpServlet {

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
        
        String accion = request.getParameter("accion");
        Actividad actividad = new Actividad();
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");        
        ConsultaActividad consulta = new ConsultaActividad();
                
        switch (accion){
            case "actualizar":
                ArrayList<String> lista = new ArrayList<>();
                try {
                    FileItemFactory file = new DiskFileItemFactory();
                    ServletFileUpload fileUpload = new ServletFileUpload(file);
                    List items = fileUpload.parseRequest(request);
                    
                    for (int i = 0; i < items.size(); i++) {
                        FileItem fileitem = (FileItem)items.get(i);
                        if(!fileitem.isFormField()){
                            File f = new File("C:\\Users\\kelly\\OneDrive\\Escritorio\\PC\\ProyectWeb\\mediControl\\src\\main\\webapp\\ordenes\\"+fileitem.getName());
                            fileitem.write(f);
                            actividad.setRuta("http://localhost:8080/mediControl/ordenes/"+fileitem.getName());
                        }else{
                            lista.add(fileitem.getString());
                        }
                    }
                    actividad.setIdPaciente(Integer.parseInt(lista.get(0)));
                    actividad.setIdEspecialista(Integer.parseInt(lista.get(1)));
                    actividad.setIdProveedor(Integer.parseInt(lista.get(2)));
                    actividad.setIdClinica(Integer.parseInt(lista.get(3)));
                    actividad.setFecha(Date.valueOf(lista.get(4)));
                    actividad.setDescripcion(lista.get(5));
                    actividad.setIdEstado(Integer.parseInt(lista.get(6)));
                    
                    consulta.actualizarTutorias(actividad);
                    
                    
                } catch (Exception e) {
                    out.print("Error: "+ e);
                }   
                    response.sendRedirect("vista/vistas/actividades.jsp");
                    break;
            default:
                throw new AssertionError();
        
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
