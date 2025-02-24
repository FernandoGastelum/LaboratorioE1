/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author gaspa
 */
public class ResultadoParametroAnalisisTablaDTO {
    private int idAnalisis;
    private int idAnalisisDetalle;
    private int IdParametro;
    private String nombreCliente;
    private String nombrePrueba;
    private String nombreParametro;
    private String resultado;

    public ResultadoParametroAnalisisTablaDTO(int idAnalisis, String nombreCliente, String nombrePrueba,int IdParametro, String resultado,int idAnalisisDetalle) {
        this.idAnalisis = idAnalisis;
        this.nombreCliente = nombreCliente;
        this.nombrePrueba = nombrePrueba;
        this.IdParametro=IdParametro;
        this.resultado = resultado;
    }

    public ResultadoParametroAnalisisTablaDTO(String nombreParametro, String resultado) {
        this.nombreParametro = nombreParametro;
        this.resultado = resultado;
    }

    public int getIdAnalisisDetalle() {
        return idAnalisisDetalle;
    }

    public void setIdAnalisisDetalle(int idAnalisisDetalle) {
        this.idAnalisisDetalle = idAnalisisDetalle;
    }

    public int getIdParametro() {
        return IdParametro;
    }

    public void setIdParametro(int IdParametro) {
        this.IdParametro = IdParametro;
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

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }
    
}
