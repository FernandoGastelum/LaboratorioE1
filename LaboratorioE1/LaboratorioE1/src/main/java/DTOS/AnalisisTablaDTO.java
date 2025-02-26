/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class AnalisisTablaDTO {
    private int idAnalisis;
    private String nombreCliente;
    private Date fechaRegistro;
    private List<String> pruebasAsociadas;

    public AnalisisTablaDTO() {}

    public AnalisisTablaDTO(int idAnalisis, String nombreCliente, Date fechaRegistro,List<String> pruebasAsociadas) {
        this.idAnalisis = idAnalisis;
        this.nombreCliente = nombreCliente;
        this.fechaRegistro = fechaRegistro;
        this.pruebasAsociadas = pruebasAsociadas;
    }

    public List<String> getPruebasAsociadas() {
        return pruebasAsociadas;
    }

    public void setPruebasAsociadas(List<String> pruebasAsociadas) {
        this.pruebasAsociadas = pruebasAsociadas;
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
        return "AnalisisTablaDTO{" + "idAnalisis=" + idAnalisis + ", nombreCliente=" + nombreCliente + ", fechaRegistro=" + fechaRegistro + ", pruebasAsociadas=" + pruebasAsociadas + '}';
    }

    
}
