/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.util.Date;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class AnalisisTablaDTO {
    private int idAnalisis;
    private String nombreCliente;
    private Date fechaRegistro;

    public AnalisisTablaDTO() {}

    public AnalisisTablaDTO(int idAnalisis, String nombreCliente, Date fechaRegistro) {
        this.idAnalisis = idAnalisis;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(int idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "AnalisisTablaDTO{" +
                "idAnalisis=" + idAnalisis +
                ", nombreCliente='" + nombreCliente + "'" +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
