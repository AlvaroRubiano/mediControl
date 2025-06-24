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
import modelo.Indicativo;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaIndicativo {
    
    public ArrayList<Indicativo> obtenerIndicativo(){
    
        //Preparando la consutal
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        ArrayList<Indicativo> indicativo = new ArrayList<>(){};
        
        try {
            String consulta = "SELECT * FROM indicativo";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                indicativo.add(new Indicativo(
                        rs.getString(1), 
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

        return indicativo;
    }
    
    
    //Envia lista de los indicativos con su respectivo identificador a un select en JSP
    public String obtenerSelectIndicativo(){
        String htmlcode = "";
        ConsultaIndicativo consulta = new ConsultaIndicativo();
        htmlcode = consulta.obtenerIndicativo().stream().map(f -> "<option value='"+f.getIndicativo()+"'>"+f.getPais()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    /**
    public static void main(String[] args) {
        
        ConsultaIndicativo c = new ConsultaIndicativo();
        
        String resultado = c.obtenerSelectIndicativo();
        
        System.out.println(resultado);
        
    }
    */
}
