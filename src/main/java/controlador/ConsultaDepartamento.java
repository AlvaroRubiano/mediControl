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
import modelo.Departamento;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaDepartamento extends Conexion {
    
    //Metodo para consulta básica de los departamentos
    public ArrayList<Departamento> obtenerDepartamento(){
        
        //Preparando la consulta a la base de datos
        PreparedStatement pst = null;
        ResultSet rs = null;
          
        ArrayList<Departamento> objeto = new ArrayList<>();

        try {
            String consulta = "SELECT * FROM departamento";
            pst = (PreparedStatement) conectar().prepareStatement(consulta);
            rs = pst.executeQuery();

            while (rs.next()) {
                objeto.add(new Departamento(
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
    
    //Envia lista de departamentos con su respectivo identificador a un select en JSP
    public String obtenerSelectDepartamento(){
        String htmlcode = "";
        ConsultaDepartamento estadoConsulta = new ConsultaDepartamento();
        htmlcode = estadoConsulta.obtenerDepartamento().stream().map(f -> "<option value='"+f.getIdDepartamento()+"'>"+f.getDepartamento()+"</option>").reduce(htmlcode, String::concat);
        return htmlcode;
    }
    
    /**
    public static void main(String[] args) {
        
        ConsultaDepartamento cd = new ConsultaDepartamento();
        
        for( Departamento de : cd.obtenerDepartamento() ){            
            int dato = de.getIdDepartamento();            
            System.out.println(de);
        }
        
        
    }*/
    
}
