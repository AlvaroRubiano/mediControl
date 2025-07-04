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
import modelo.Especialista;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaEspecialista extends Conexion {
    
    //Metodo para crear especialistas
    public boolean crearEspecialista(int registro, String nombre, int ciudad){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "INSERT INTO especialista (registro,nombre,idCiudad) VALUES (?,?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setInt(1,registro);
            pst.setString(2,nombre);
            pst.setInt(3,ciudad);
            
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
    
    //Metodo para consulta básica de los especialistas
    public ArrayList<Especialista> obtenerEspecialista(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Especialista> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM especialista";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Especialista(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getInt(3)
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
    
    //Envia lista de especialistas con su respectivo identificador a un select en JSP
    public String obtenerSelectEspecialista(){
        String htmlcode = "";
        ConsultaEspecialista estadoConsulta = new ConsultaEspecialista();
        htmlcode = estadoConsulta.obtenerEspecialista().stream().map(f -> "<option value='"+f.getRegistro()+"'>"+f.getNombre()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
}
