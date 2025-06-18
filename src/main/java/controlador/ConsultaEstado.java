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
import modelo.Estado;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaEstado extends Conexion {
    
    //Metodo para consulta básica de los cargos
    public ArrayList<Estado> obtenerEstado(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Estado> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM estado";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Estado(
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
    
    //Envia lista de estados con su respectivo identificador a un select en JSP
    public String obtenerSelectEstado(){
        String htmlcode = "";
        ConsultaEstado estadoConsulta = new ConsultaEstado();        
        htmlcode = estadoConsulta.obtenerEstado().stream().map(f -> "<option value='"+f.getIdEstado()+"'>"+f.getEstado()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
}
