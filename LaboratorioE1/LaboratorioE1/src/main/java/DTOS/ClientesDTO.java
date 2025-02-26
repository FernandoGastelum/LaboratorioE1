/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.util.Date;

/**
 *
 * @author gaspa,pau
 */
public class ClientesDTO {
    
    private int id;
    private String nombreCompleto;
    private Date fechaRegistro;
    private Date fechaNacimiento;
    
    
    public ClientesDTO( ){
}
    //constructor con parametros
    public ClientesDTO(int id, String nombreCompleto, Date fechaRegistro, Date fechaNacimiento) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.fechaRegistro = fechaRegistro;
        this.fechaNacimiento = fechaNacimiento;
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
    
    @Override
    public String toString() {
        return  "ClientesDTO " +
                "idClienteDTO: " + id +
                ", nombreCompleto: '" + nombreCompleto + '\'' +
                ", fechaRegistro: " + fechaRegistro +
                ", fechaNacimiento: " + fechaNacimiento +
                '}';
    }
    
    
}
