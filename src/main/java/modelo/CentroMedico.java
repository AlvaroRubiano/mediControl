/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alvaro Rubiano
 */
public class CentroMedico {
    
    private Long identificador;
    private String nombre;
    private String direccion;
    private int idCiudad;

    public CentroMedico() {
    }

    public CentroMedico(Long identificador, String nombre, String direccion, int idCiudad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
    }

    public CentroMedico(String nombre, String direccion, int idCiudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.idCiudad = idCiudad;
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
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
