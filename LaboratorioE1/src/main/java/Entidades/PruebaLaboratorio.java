/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;

/**
 * Todos los elementos de las pruebas de laboratorio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class PruebaLaboratorio {

    private int id;
    private String nombrePrueba;
    private String categoria;
    private List<ParametrosPrueba> parametros;

    public PruebaLaboratorio(int id, String nombrePrueba) {
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

    public List<ParametrosPrueba> getParametros() {
        return parametros;
    }
    public void setParametros(List<ParametrosPrueba> parametros) {
        this.parametros = parametros;
    }
    
    @Override
    public String toString() {
        return "--- Prueba de Laboratorio ---\nID: " + id + "\nPrueba: " + nombrePrueba + "\nCategoria: " + categoria;
    }
    
    
}
