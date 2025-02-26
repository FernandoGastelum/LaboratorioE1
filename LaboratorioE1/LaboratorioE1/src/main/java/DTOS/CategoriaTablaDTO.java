/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * Elementos de la tabla de las categorias de las pruebas.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class CategoriaTablaDTO {

    private String nombreCategoria;

    public CategoriaTablaDTO(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    @Override
    public String toString() {
        return "CategoriaTablaDTO{" + "nombreCategoria=" + nombreCategoria + '}';
    }
    
}
