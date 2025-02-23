/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;
import java.time.LocalDate;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class GuardarResultadoDTO {
    private int idAnalisisDetalle;
    private int idParametro;
    private String valor;
    private LocalDate fechaRegistro;

    public GuardarResultadoDTO() {}

    public GuardarResultadoDTO(int idAnalisisDetalle, int idParametro, String valor, LocalDate fechaRegistro) {
        this.idAnalisisDetalle = idAnalisisDetalle;
        this.idParametro = idParametro;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
