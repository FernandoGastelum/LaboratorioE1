/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * Elementos que el usuario guardara en las pruebas de laboratorio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class PruebaDTO {
    private int id;
    private String nombrePrueba;
    private String categoria;

    public PruebaDTO(String nombrePrueba, String categoria) {
        this.nombrePrueba = nombrePrueba;
        this.categoria = categoria;
    }

    public PruebaDTO(int id, String nombrePrueba) {
        this.id = id;
        this.nombrePrueba = nombrePrueba;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
