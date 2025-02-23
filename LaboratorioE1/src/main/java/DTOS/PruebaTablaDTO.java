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
    private String nombreParametro;

    public PruebaTablaDTO(String nombrePrueba, String categoria, String nombreParametro) {
        this.nombrePrueba = nombrePrueba;
        this.categoria = categoria;
        this.nombreParametro = nombreParametro;
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

    public String getNombreParametro() {
        return nombreParametro;
    }
    public void setNombreParametro(String nombreParametro) {
        this.nombreParametro = nombreParametro;
    }
    
}
