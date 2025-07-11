/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Actividad;

/**
 *
 * @author Alvaro Rubiano
 */
public class ConsultaActividad extends Conexion {
    
    public int actualizarTutorias(Actividad actividad){
        PreparedStatement pst = null;
        ResultSet rs = null;
        int resultado = 0;
        
            try {
                String consulta = "INSERT INTO actividades (idPaciente, idEspecialista, idProveedor, idClinica, fechaProgramada, descripcion, idEstado, ruta) VALUES(?,?,?,?,?,?,?,?)";
                pst = (PreparedStatement) conectar().prepareStatement(consulta);
                                
                pst.setInt(1, actividad.getIdPaciente());
                pst.setInt(2, actividad.getIdEspecialista());
                pst.setInt(3, actividad.getIdProveedor());
                pst.setInt(4, actividad.getIdClinica());
                pst.setDate(5, actividad.getFecha());
                pst.setString(6, actividad.getDescripcion());
                pst.setInt(7, actividad.getIdEstado());
                pst.setString(8, actividad.getRuta());
                
                pst.executeUpdate();                

            } catch (SQLException e) {
                System.out.print("Error: " + e);                
            } finally {
                try {
                    if (pst != null) {
                        pst.close();
                        
                    }
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    
                }
            }        
        return resultado;
    }
    
    
}
