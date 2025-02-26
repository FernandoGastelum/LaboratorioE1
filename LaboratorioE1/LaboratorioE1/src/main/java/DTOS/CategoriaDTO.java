/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * Elementos que el usuario guardara en las categorias de la prueba.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class CategoriaDTO {

    private int idPruebaLab;
    private String nombreCategoria;

    public CategoriaDTO(int idPruebaLab, String nombreCategoria) {
        this.idPruebaLab = idPruebaLab;
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdPruebaLab() {
        return idPruebaLab;
    }

    public void setIdPruebaLab(int idPruebaLab) {
        this.idPruebaLab = idPruebaLab;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
}
