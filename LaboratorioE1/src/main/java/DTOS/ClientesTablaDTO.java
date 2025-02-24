/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientesTablaDTO {
    private int id;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private Date fechaRegistro; // se almacena el string para facilitar el uso de las tablas
 
    public ClientesTablaDTO(int id, String nombreCompleto, Date fechaNacimiento, Date fechaRegistro) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento; 
        this.fechaRegistro = fechaRegistro;   
    }  
    
   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "ClientesTablaDTO " +
                "id -> " + id +
                ", nombreCompleto: '" + nombreCompleto + '\'' +
                ", fechaNacimiento: " + fechaNacimiento +
                ", fechaRegistro: " + fechaRegistro;
    }
}

