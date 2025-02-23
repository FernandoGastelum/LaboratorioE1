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
public class GuardarAnalisisDTO {
    private int idCliente;
    private Date fechaRegistro;

    public GuardarAnalisisDTO() {}

    public GuardarAnalisisDTO(int idCliente, Date fechaRegistro) {
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
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
        return "GuardarAnalisisDTO{" +
                "idCliente=" + idCliente +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
