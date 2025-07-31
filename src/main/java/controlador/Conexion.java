/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alvaro Rubiano
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/medicontrol";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static Connection conexion;
    
    public static Connection conectar(){
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL,USUARIO,PASSWORD);
            //JOptionPane.showMessageDialog(null, "Conexión exitosa");
            //System.out.println("Conexión exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion: "+e);
            System.out.println("Error en la conexion: "+e);
            e.printStackTrace();
        }
    
        return conexion;
    }//Fin del metodo conectar 
    
    public static void desconectar(){
        try {
            
            if(conexion != null && !conexion.isClosed()){
                conexion.close();
                System.out.println("Conexion cerrada");
            }
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }//Fin del metodo desconectar
    
    /**Prueba de conexion 
      
    public static void main(String[] args) {        
        Connection conn = Conexion.conectar();
        Conexion.desconectar();        
    }
    */
}
