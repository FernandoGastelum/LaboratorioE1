/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * Elementos de la tabla de los parametros de las pruebas.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ParametroTablaDTO {

    private String nombreParametro;
    private int idParametro;

    public ParametroTablaDTO(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }
    public ParametroTablaDTO(String nombreParametro, int idParametro) {
        this.nombreParametro = nombreParametro;
        this.idParametro = idParametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    @Override
    public String toString() {
        return "ParametroTablaDTO{" + "Parametro: " + nombreParametro + '}';
    }
    
}
