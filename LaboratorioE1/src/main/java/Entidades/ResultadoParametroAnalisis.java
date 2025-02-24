/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author gaspa
 */
public class ResultadoParametroAnalisis {
    private int idAnalisisDetalle;
    private int idParametro;
    private int idAnalisis;
    private int idPrueba;
    private String nombreParametro;
    private String nombrePrueba;
    private String resultado;
    private String nombreCliente;

    public ResultadoParametroAnalisis(int idAnalisisDetalle, int idParametro, int idAnalisis, int idPrueba, String nombreParametro, String nombrePrueba, String resultado, String nombreCliente) {
        this.idAnalisisDetalle = idAnalisisDetalle;
        this.idParametro = idParametro;
        this.idAnalisis = idAnalisis;
        this.idPrueba = idPrueba;
        this.nombreParametro = nombreParametro;
        this.nombrePrueba = nombrePrueba;
        this.resultado = resultado;
        this.nombreCliente = nombreCliente;
    }

    public int getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
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

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
}
