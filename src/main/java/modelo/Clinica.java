/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Rubiano
 */
public class Clinica {
    
    private int nit;
    private String nombre;
    private String direccion;
    private int idCiudad;

    public Clinica() {
    }

    public Clinica(int nit, String nombre, String direccion, int idCiudad) {
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    
    
    
}
