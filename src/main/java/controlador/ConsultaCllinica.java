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
import modelo.Cliente;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaCllinica extends Conexion {
    
    //Metodo para crear clientes
    public boolean crearClinica(int identificacion, String nombre, String direccion, int ciudad){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "INSERT INTO cliente (identificacion,nombre,direccion,idCiudad) VALUES (?,?,?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setInt(1,identificacion);
            pst.setString(2,nombre);
            pst.setString(3,direccion);
            pst.setInt(4,ciudad);
            
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
    
    //Metodo para crear clinicas o centros médicos
    public boolean crearCentroMedico(Long identificacion, String nombre, String direccion, int ciudad){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "INSERT INTO centromedico (identificacion,nombre,direccion,idCiudad) VALUES (?,?,?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setLong(1,identificacion);
            pst.setString(2,nombre);
            pst.setString(3,direccion);
            pst.setInt(4,ciudad);
            
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
    
    
    //Metodo para consulta básica de las clinicas o centros médicos
    public ArrayList<Cliente> obtenerClinica(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Cliente> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM clinica";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Cliente(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
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
    
    //Envia lista de clinicas con su respectivo identificador a un select en JSP
    public String obtenerSelectClinica(){
        String htmlcode = "";
        ConsultaCllinica estadoConsulta = new ConsultaCllinica();
        htmlcode = estadoConsulta.obtenerClinica().stream().map(f -> "<option value='"+f.getNit()+"'>"+f.getNombre()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    
}
