/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Ciudad;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaCiudad extends Conexion {
    
    //Metodo para crear una ciudad
    public boolean crear(String nombre, int departamento){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "INSERT INTO ciudad (ciudad, idDepartamento) VALUES (?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setString(1,nombre);
            pst.setInt(2,departamento);
            
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
    
    
    //Metodo para consulta básica de las ciudad
    public ArrayList<Ciudad> obtenerCiudad(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Ciudad> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM ciudad";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Ciudad(
                        rs.getInt(1), 
                        rs.getString(2)
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
    
    //Metodo para consulta de una ciudad relacionada con un departamento
    public ArrayList<Ciudad> obtenerCiudadDepartemtno(int idDepartamento){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Ciudad> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM ciudad WHERE idDepartamento='"+idDepartamento+"'";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Ciudad(
                        rs.getInt(1), 
                        rs.getString(2)
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
    
    
    //Envia lista de ciudades con su respectivo identificador a un select en JSP
    public String obtenerSelectCiudad(){
        String htmlcode = "";
        ConsultaCiudad estadoConsulta = new ConsultaCiudad();
        htmlcode = estadoConsulta.obtenerCiudad().stream().map(f -> "<option value='"+f.getIdCiudad()+"'>"+f.getCiudad()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    //Envia lista de ciudades con su respectivo identificador a un select en JSP
    public String obtenerSelectCiudadConDepartamento(int idDepartamento){
        String htmlcode = "";
        ConsultaCiudad estadoConsulta = new ConsultaCiudad();
        htmlcode = estadoConsulta.obtenerCiudadDepartemtno(idDepartamento).stream().map(f -> f.getIdCiudad()+ f.getCiudad()).reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    
    /** 
    //Prueba metodo crear
    public static void main(String[] args) {
        
        String ciudad = "Bogotá D.C.";
        int departamento = 5;
        
        ConsultaCiudad c = new ConsultaCiudad();
        
        Boolean resultado = c.crear(ciudad, departamento);
        
        System.out.println(resultado);
        
    }
    */
    /** 
    public static void main(String[] args) {
        
        int departamento = 5;
        
        ConsultaCiudad c = new ConsultaCiudad();
        
        String objeto = c.obtenerSelectCiudadConDepartamento(departamento);
        
        System.out.println(objeto);
        
    }
    */

    
}
