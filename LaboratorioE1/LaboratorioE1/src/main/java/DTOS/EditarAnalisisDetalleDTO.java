/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class EditarAnalisisDetalleDTO {
    private int id;
    private int idAnalisis;
    private int idPrueba;

    public EditarAnalisisDetalleDTO() {}

    public EditarAnalisisDetalleDTO(int id, int idAnalisis, int idPrueba) {
        this.id = id;
        this.idAnalisis = idAnalisis;
        this.idPrueba = idPrueba;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAnalisis() {
        return idAnalisis;
    }

    public void setIdAnalisis(int idAnalisis) {
        this.idAnalisis = idAnalisis;
    }

    public int getIdPrueba() {
        return idPrueba;
    }

    public void setIdPrueba(int idPrueba) {
        this.idPrueba = idPrueba;
    }
}
