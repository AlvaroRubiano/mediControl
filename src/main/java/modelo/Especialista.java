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
    
    private int registro;
    private String nombre;
    private int idCiudad;

    public Especialista() {
    }

    public Especialista(int registro, String nombre, int idCiudad) {
        this.registro = registro;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
    }
    
    public Especialista(int registro, String nombre) {
        this.registro = registro;
        this.nombre = nombre;        
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
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
