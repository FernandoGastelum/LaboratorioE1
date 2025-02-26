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
public class ResultadoDTO {
    
    private int idResultado;
    private int idAnalisisDetalle;
    private int idParametro;
    private String valor;
    private Date fechaRegistro;

    public ResultadoDTO() {}

    public ResultadoDTO(int idResultado,  int idParametro, String valor, Date fechaRegistro) {
        this.idResultado = idResultado;
        this.idParametro = idParametro;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
    }

    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public int getIdAnalisisDetalle() {
        return idAnalisisDetalle;
    }

    public void setIdAnalisisDetalle(int idAnalisisDetalle) {
        this.idAnalisisDetalle = idAnalisisDetalle;
    }

    public int getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(int idParametro) {
        this.idParametro = idParametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "ResultadoDTO{" +
                "idResultado=" + idResultado +
                ", idAnalisisDetalle=" + idAnalisisDetalle +
                ", idParametro=" + idParametro +
                ", valor='" + valor + "'" +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
