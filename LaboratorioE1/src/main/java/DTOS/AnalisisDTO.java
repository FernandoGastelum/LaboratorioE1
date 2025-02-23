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
public class AnalisisDTO {
    private int idAnalisis;
    private int idCliente;
    private Date fechaRegistro;
    private String nombreCliente;

    public AnalisisDTO() {}

    public AnalisisDTO(int idAnalisis, int idCliente, Date fechaRegistro, String nombreCliente) {
        this.idAnalisis = idAnalisis;
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
        this.nombreCliente = nombreCliente;
    }
    public AnalisisDTO(int idAnalisis, int idCliente, Date fechaRegistro) {
        this.idAnalisis = idAnalisis;
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(int idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return "AnalisisDTO{" +
                "idAnalisis=" + idAnalisis +
                ", idCliente=" + idCliente +
                ", fechaRegistro=" + fechaRegistro +
                ", nombreCliente='" + nombreCliente + '\'' +
                '}';
    }
}
