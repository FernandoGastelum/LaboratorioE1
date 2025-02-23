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
public class ResultadoTablaDTO {
    private int idResultado;
    private String nombrePrueba;
    private String nombreParametro;
    private String valor;
    private Date fechaRegistro;

    public ResultadoTablaDTO(int idResultado, String nombrePrueba, String nombreParametro, String valor, Date fechaRegistro) {
        this.idResultado = idResultado;
        this.nombrePrueba = nombrePrueba;
        this.nombreParametro = nombreParametro;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters
    public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
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
        return "ResultadoTablaDTO{" +
                "idResultado=" + idResultado +
                ", nombrePrueba='" + nombrePrueba + '\'' +
                ", nombreParametro='" + nombreParametro + '\'' +
                ", valor='" + valor + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
