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
public class EditarAnalisisDTO {
    private int idAnalisis;
    private int idCliente;
    private Date fechaRegistro;

    public EditarAnalisisDTO() {}

    public EditarAnalisisDTO(int idAnalisis, int idCliente, Date fechaRegistro) {
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

    @Override
    public String toString() {
        return "EditarAnalisisDTO{" +
                "idAnalisis=" + idAnalisis +
                ", idCliente=" + idCliente +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
