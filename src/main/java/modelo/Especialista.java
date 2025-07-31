/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Rubiano
 */
public class Especialista {
    
    private String identificacion;
    private String nombre;
    private int idCiudad;

    public Especialista() {
    }

    public Especialista(String identificacion, String nombre, int idCiudad) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }
    
    public Especialista(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;        
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    
    
}
