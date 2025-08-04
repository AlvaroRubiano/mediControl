/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.Conexion.conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Proveedor;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaProveedor {
    
    //Metodo para crear proveedores
    public boolean crearProveedor(int nit, String nombre, String direccion, String telefono, String contacto, String correo, int ciudad){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "INSERT INTO proveedor (identificacion,nombre,direccion,telefono,contacto,correo,idCiudad) VALUES (?,?,?,?,?,?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setInt(1,nit);
            pst.setString(2,nombre);
            pst.setString(3,direccion);
            pst.setString(4,telefono);
            pst.setString(5,contacto);
            pst.setString(6,correo);
            pst.setInt(7,ciudad);
            
            if(pst.executeUpdate() ==1){            
              return true;                      
            }else{
                JOptionPane.showMessageDialog(null, "Error en la sentencia SQL");
            }
            
        } catch (SQLException e) {
        }finally{
            try {
                pst.close();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error en el cierre de la conexión: "+ e2);                
            }
        }
    
        return false;
    }
    
    //Metodo para modificar proveedores
    public boolean modificarProveedor(int nit, String direccion, String telefono, String contacto, String correo, int ciudad){
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
         try {
            String consulta = "UPDATE proveedor SET direccion='"+direccion+"', telefono='"+telefono+"', contacto='"+contacto+"', correo='"+correo+"', idCiudad='"+ciudad+"' WHERE identificacion ="+nit;
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            if(pst.executeUpdate() ==1){            
              return true;                      
            }else{
                JOptionPane.showMessageDialog(null, "Error en la sentencia SQL");
            }
            
        } catch (SQLException e) {
        }finally{
            try {
                pst.close();
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Error en el cierre de la conexión: "+ e2);                
            }
        }
        
        return false;
    }
    
    
    //Metodo para consulta básica de los proveedores
    public ArrayList<Proveedor> obtenerProveedor(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Proveedor> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM proveedor";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Proveedor(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 1: " + e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error 2: " + ex);
            }

        }// Final de Finally 

        return objeto;
        
    }
    
    //Envia lista de proveedores con su respectivo identificador a un select en JSP
    public String obtenerSelectProveedor(){
        String htmlcode = "";
        ConsultaProveedor estadoConsulta = new ConsultaProveedor();
        htmlcode = estadoConsulta.obtenerProveedor().stream().map(f -> "<option value='"+f.getNit()+"'>"+f.getNombre()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    
    
    
}
