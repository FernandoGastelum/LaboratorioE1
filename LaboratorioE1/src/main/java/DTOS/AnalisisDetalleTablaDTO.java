/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author gaspa
 */
public class AnalisisDetalleTablaDTO {
    private int id;
    private int idAnalisis;
    private String nombrePrueba;

    public AnalisisDetalleTablaDTO(int id, int idAnalisis, String nombrePrueba) {
        this.id = id;
        this.idAnalisis = idAnalisis;
        this.nombrePrueba = nombrePrueba;
    }

    public int getId() {
        return id;
    }

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    @Override
    public String toString() {
        return "AnalisisDetalleTablaDTO{" + "id=" + id + ", idAnalisis=" + idAnalisis + ", nombrePrueba=" + nombrePrueba + '}';
    }
}
