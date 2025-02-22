/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Todos los elementos de los parametros de las pruebas.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ParametrosPrueba {

    private int id;
    private int idPrueba;
    private String nombreParametro;

    public ParametrosPrueba(int id, int idPrueba, String nombreParametro) {
        this.id = id;
        this.idPrueba = idPrueba;
        this.nombreParametro = nombreParametro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }

    public String getNombreParametro() {
        return nombreParametro;
    }

    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }

    @Override
    public String toString() {
        return "--- Parametro de Prueba ---\nID: " + id + "\nID de Prueba" + idPrueba + "\nParametro: " + nombreParametro;
    }

}
