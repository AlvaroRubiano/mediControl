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
public class Actividad {
    
    private int registro;
    private int idPaciente;
    private String nombrePaciente;
    private int idEspecialista;
    private String nombreEspecialista;
    private int idProveedor;
    private String nombreProveedor;
    private int idClinica;
    private String nombreClinica;
    private Date fecha;
    private String descripcion;
    private int idEstado;
    private String estado;
    private String ruta;

    public Actividad() {
    }

    public Actividad(int registro, String nombrePaciente, String nombreEspecialista, String nombreClinica, Date fecha, String descripcion, String estado, String ruta) {
        this.registro = registro;
        this.nombrePaciente = nombrePaciente;
        this.nombreEspecialista = nombreEspecialista;
        this.nombreClinica = nombreClinica;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.estado = estado;
        this.ruta = ruta;
        
    }

    public Actividad(int registro, int idPaciente, int idEspecialista, int idClinica, Date fecha, String descripcion, int idEstado, String ruta) {
        this.registro = registro;
        this.idPaciente = idPaciente;
        this.idEspecialista = idEspecialista;
        this.idClinica = idClinica;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idEstado = idEstado;
        this.ruta = ruta;
    }
    
    

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getIdEspecialista() {
        return idEspecialista;
    }

    public void setIdEspecialista(int idEspecialista) {
        this.idEspecialista = idEspecialista;
    }

    public String getNombreEspecialista() {
        return nombreEspecialista;
    }

    public void setNombreEspecialista(String nombreEspecialista) {
        this.nombreEspecialista = nombreEspecialista;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public int getIdClinica() {
        return idClinica;
    }

    public void setIdClinica(int idClinica) {
        this.idClinica = idClinica;
    }

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    
    
    
    
}
