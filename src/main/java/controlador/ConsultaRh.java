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
import modelo.Rh;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaRh extends Conexion{
    
    public ArrayList<Rh> obtenerRh(){
    
        //Preparando la consutal
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        ArrayList<Rh> rh = new ArrayList<>(){};
        
        try {
            String consulta = "SELECT * FROM rh";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                rh.add(new Rh(
                        rs.getInt(1), 
                        rs.getString(2)) );
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

        return rh;
    }
    
    
    //Envia lista de los indicativos con su respectivo identificador a un select en JSP
    public String obtenerSelectRh(){
        String htmlcode = "";
        ConsultaRh consulta = new ConsultaRh();
        htmlcode = consulta.obtenerRh().stream().map(f -> "<option value='"+f.getIdentificador()+"'>"+f.getRh()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    /**
    public static void main(String[] args) {
        
        ConsultaRh rh = new ConsultaRh();
        
        String consulta = rh.obtenerSelectRh();
        
        System.out.println(consulta);
        
    }
    */
}
