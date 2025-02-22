/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * Elementos de la tabla de las pruebas de laboratorio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class PruebaTablaDTO {

    private String nombrePrueba;
    private String categoria;

    public PruebaTablaDTO(String nombrePrueba, String categoria) {
        this.nombrePrueba = nombrePrueba;
        this.categoria = categoria;
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

    @Override
    public String toString() {
        return "PruebaTablaDTO{" + "Preuba: " + nombrePrueba + ", Categoria: " + categoria + '}';
    }
}
