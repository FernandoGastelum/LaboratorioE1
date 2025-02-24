/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author paula
 */
public class GuardarClienteDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private java.sql.Date fechaNacimiento;

    // Constructor
    public GuardarClienteDTO(String nombre, String apellidoPaterno, String apellidoMaterno, java.sql.Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Métodos getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public java.sql.Date getFechaNacimiento() {
        return fechaNacimiento;
    }
}

