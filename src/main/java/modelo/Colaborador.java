/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Alvaro Rubiano
 */
public class Colaborador {
    
    private int identificacion;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private int rh;
    private int ciudad;
    private int cargo;
    private Date natalidad;
    private Date ingreso;
    private Date salida;

    public Colaborador() {
    }

    public Colaborador(int identificacion, String nombre, String correo, String telefono, String direccion, int rh, int ciudad, int cargo, Date natalidad, Date ingreso) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.rh = rh;
        this.ciudad = ciudad;
        this.cargo = cargo;
        this.natalidad = natalidad;
        this.ingreso = ingreso;
    }
    
    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getRh() {
        return rh;
    }

    public void setRh(int rh) {
        this.rh = rh;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getNatalidad() {
        return natalidad;
    }

    public void setNatalidad(Date natalidad) {
        this.natalidad = natalidad;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }
    
    
    
}
