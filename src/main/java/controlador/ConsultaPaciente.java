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
import modelo.Paciente;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaPaciente {
    
    //Metodo para crear pacientes
    public boolean crearPaciente(int cedula, String nombre, int ciudad, int clinica){
    
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try {
            String consulta = "INSERT INTO paciente (cedula,nombre,idCiudad,idClinica) VALUES (?,?,?,?)";
            pst =(PreparedStatement) conectar().prepareStatement(consulta);
            
            pst.setInt(1,cedula);
            pst.setString(2,nombre);
            pst.setInt(3,ciudad);
            pst.setInt(4,clinica);
            
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
    
    //Metodo para consulta básica de los pacientes
    public ArrayList<Paciente> obtenerPaciente(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Paciente> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM paciente";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Paciente(
                        rs.getInt(1), 
                        rs.getString(2),
                        rs.getInt(3),
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
    
    //Envia lista de pacientes con su respectivo identificador a un select en JSP
    public String obtenerSelectPaciente(){
        String htmlcode = "";
        ConsultaPaciente estadoConsulta = new ConsultaPaciente();
        htmlcode = estadoConsulta.obtenerPaciente().stream().map(f -> "<option value='"+f.getCedula()+"'>"+f.getNombre()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    
}
