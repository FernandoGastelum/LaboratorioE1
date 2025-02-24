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
    private int id;
    private int IDPrueba;
    private String nombreParametro;

    public ParametroDTO(int IDPrueba, String nombreParametro) {
        this.IDPrueba = IDPrueba;
        this.nombreParametro = nombreParametro;
    }
    public ParametroDTO(int id, int IDPrueba, String nombreParametro) {
        this.id = id;
        this.IDPrueba = IDPrueba;
        this.nombreParametro = nombreParametro;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIDPrueba() {
        return IDPrueba;
    }
    public void setIDPrueba(int IDPrueba) {
        this.IDPrueba = IDPrueba;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }
    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

}
