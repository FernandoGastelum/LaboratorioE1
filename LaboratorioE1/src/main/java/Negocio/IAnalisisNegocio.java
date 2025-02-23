/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.AnalisisDTO;
import DTOS.AnalisisTablaDTO;
import DTOS.EditarAnalisisDTO;
import DTOS.GuardarAnalisisDTO;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IAnalisisNegocio {
    AnalisisDTO Guardar(GuardarAnalisisDTO analisis) throws NegocioException;
    AnalisisDTO Actualizar(EditarAnalisisDTO analisis) throws NegocioException;
    AnalisisDTO Eliminar(int idAnalisis) throws NegocioException;
    AnalisisDTO obtenerAnalisisPorId(int idAnalisis) throws NegocioException;
    List<AnalisisTablaDTO> listarAnalisis() throws NegocioException;
}
