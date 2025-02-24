/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author gaspa,pau
 */
public class Cliente {
    //atributos que conforman al cliente 

    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaRegistro;
    private Date fechaNacimiento;
    
    //constructor para persistencia
    public Cliente(){
    }
    //constructor de la clase 
    public Cliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaRegistro, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //toString 
       @Override
    public String toString() {
        return "Cliente " +
                "idCliente: " + id +
                ", nombre: " + nombre + '\'' +
                ", apellidoPaterno: '" + apellidoPaterno + '\'' +
                ", apellidoMaterno: " + apellidoMaterno + '\'' +
                ", fechaRegistro: " + fechaRegistro +
                ", fechaNacimiento: " + fechaNacimiento;
    }
    

}
    
    
