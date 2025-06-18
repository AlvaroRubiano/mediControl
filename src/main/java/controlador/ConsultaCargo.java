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
import modelo.Cargo;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaCargo extends Conexion{
    
    //Metodo para consulta básica de los cargos
    public ArrayList<Cargo> obtenerCargos(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Cargo> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM cargo";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Cargo(
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
    
    //Envia lista de cargos con su respectivo identificador a un select en JSP
    public String obtenerSelectCargo(){
        String htmlcode = "";
        ConsultaCargo estadoConsulta = new ConsultaCargo();        
        htmlcode = estadoConsulta.obtenerCargos().stream().map(f -> "<option value='"+f.getIdCargo()+"'>"+f.getCargo()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
}
