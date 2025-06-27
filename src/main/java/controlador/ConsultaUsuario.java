/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Usuario;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaUsuario extends Conexion {
    
    public ArrayList<Usuario> consultaUsuario(int identificacion){
    
        ArrayList<Usuario> usuario = new ArrayList<>();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
               
        try {
            String consulta = "SELECT * FROM usuario WHERE identificacion="+identificacion;
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();
            
            while(rs.next()){
                usuario.add(new Usuario(
                        rs.getInt("identificacion"), 
                        rs.getString("usuario"), 
                        rs.getString("password"), 
                        rs.getInt("idEstado"), 
                        rs.getInt("idCargo")
                ));
            }
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        
        return usuario;
        
    }
    
    public int consultaCargo(String usuario, String password){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        int resultado = 0;        
        
        try {
            String consulta = "SELECT idCargo FROM `usuario` WHERE usuario='"+usuario+"' AND password= '"+password+"'";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();
                        
            while(rs.next()){                
                resultado = rs.getInt("idCargo");
            }
                        
        } catch (SQLException e) {
        }finally{
            try {
                
            } catch (Exception e2) {
                System.out.println("Error de cierre" + e2 );
            }
        }
        return resultado;
    
    }
    
    
    
    /**     
    public static void main(String[] args) {
        
        String us = "alvaro.rubiano";
        String pa = "alvaro.rubiano";
        
        ConsultaUsuario c = new ConsultaUsuario();
        
        int re = c.consultaCargo(us, pa);
        
        System.out.println(re);
        
    }
    */
    
}
