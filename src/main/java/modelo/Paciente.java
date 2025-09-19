/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Rubiano
 */
public class Paciente {
    
    private long cedula;
    private String nombre;
    private int idCiudad;
    
    public Paciente() {
    }

    public Paciente(long cedula, String nombre, int idCiudad ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
        
    }

    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
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
