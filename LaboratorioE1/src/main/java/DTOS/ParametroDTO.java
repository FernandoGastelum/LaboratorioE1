/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * Elementos que el usuario guardara en los parametros de las pruebas.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ParametroDTO {

    private String nombreParametro;

    public ParametroDTO(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

}
