/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class Resultado {
    private int id;
    private int idAnalisisDetalle;
    private int idParametro;
    private String valor;
    private Date fechaRegistro;

    public Resultado() {}

    public Resultado(int id, int idAnalisisDetalle, int idParametro, String valor, Date fechaRegistro) {
        this.id = id;
        this.idAnalisisDetalle = idAnalisisDetalle;
        this.idParametro = idParametro;
        this.valor = valor;
        this.fechaRegistro=fechaRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Resultado{" + "id=" + id + ", idAnalisisDetalle=" + idAnalisisDetalle + ", idParametro=" + idParametro + ", valor=" + valor + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
}
