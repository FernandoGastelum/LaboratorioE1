/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class GuardarAnalisisDetalleDTO {
    private int idAnalisis;
    private int idPrueba;

    public GuardarAnalisisDetalleDTO() {}

    public GuardarAnalisisDetalleDTO(int idAnalisis, int idPrueba) {
        this.idAnalisis = idAnalisis;
        this.idPrueba = idPrueba;
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
