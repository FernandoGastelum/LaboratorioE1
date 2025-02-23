/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.AnalisisDetalleDTO;
import DTOS.AnalisisDetalleTablaDTO;
import DTOS.EditarAnalisisDetalleDTO;
import DTOS.GuardarAnalisisDetalleDTO;
import Entidades.AnalisisDetalle;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IAnalisisDetalleNegocio {
    List<AnalisisDetalleTablaDTO> listarAnalisisDetalles() throws NegocioException;
    AnalisisDetalleDTO guardar(GuardarAnalisisDetalleDTO detalle) throws NegocioException;
    AnalisisDetalleDTO eliminar(int id) throws NegocioException;
    AnalisisDetalleDTO actualizar(EditarAnalisisDetalleDTO detalle) throws NegocioException;
    AnalisisDetalleDTO obtenerPorID(int id) throws NegocioException;
}
