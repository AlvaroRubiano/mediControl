/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.Conexion.conectar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaColaborador extends Conexion{
    
    //Metodo para crear nuevos usuarios
    public boolean crearColaborador(int identificacion, String nombre, String correo, String telefono, String direccion, String rh, int ciudad, int cargo, String natalidad, String ingreso){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            
            String consulta = "INSERT INTO colaborador (identificacion, nombre, correo, telefono, direccion, rh, idCiudad, idCargo, nacimiento, ingreso) VALUES (?,?,?,?,?,?,?,?,?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setInt(1,identificacion);
            pst.setString(2,nombre);
            pst.setString(3,correo);
            pst.setString(4,telefono);
            pst.setString(5,direccion);
            pst.setString(6,rh);
            pst.setInt(7, ciudad);
            pst.setInt(8, cargo);
            pst.setString(9,natalidad);
            pst.setString(10,ingreso);
            
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
    
    /**
    //Metodo para comprobar el ingreso de colaboradores
    public static void main(String[] args) {
        
        int identificacion = 86066225;
        String nombre = "Alvaro Augusto Rubiano Guarnizo";
        String correo = "rubiano124@gmail.com";
        String telefono = "+573203712166";
        String direccion = "Calle 6 Sur No. 23-137";
        String rh = "A+";
        int idCiudad = 4;
        int idCargo = 3;
        String natalidad = "1980-11-08";
        String ingreso = "2025-02-15";
        
        ConsultaColaborador consulta = new ConsultaColaborador();
        
        Boolean resultado = consulta.crearColaborador(identificacion, nombre, correo, telefono, direccion, rh, idCiudad, idCargo, natalidad, ingreso);
        
        System.out.println(resultado);
        
    }
    */
    
}
