/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Todos los elementos de las categorías de las pruebas.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class CategoriaPrueba {

    private int id;
    private int idPruebaLab;
    private String nombreCategoria;

    public CategoriaPrueba(int id, int idPruebaLab, String nombreCategoria) {
        this.id = id;
        this.idPruebaLab = idPruebaLab;
        this.nombreCategoria = nombreCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "--- Categoría ---\nID: " + id + "\nIDPruebaLab: " + idPruebaLab + "\nCategoria: " + nombreCategoria;
    }

}
