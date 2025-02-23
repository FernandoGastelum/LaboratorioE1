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
public class AnalisisLaboratorio {
    private int id;
    private int idCliente;
    private Date fechaRegistro;

    public AnalisisLaboratorio() {}

    public AnalisisLaboratorio(int id, int idCliente, Date fechaRegistro) {
        this.id = id;
        this.idCliente = idCliente;
        this.fechaRegistro = fechaRegistro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "AnalisisLaboratorio{" + "id=" + id + ", idCliente=" + idCliente + ", fechaRegistro=" + fechaRegistro + '}';
    }
    
    
}
