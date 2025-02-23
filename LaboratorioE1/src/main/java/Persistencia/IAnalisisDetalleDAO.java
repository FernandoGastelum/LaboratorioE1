/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;


import DTOS.EditarAnalisisDetalleDTO;
import DTOS.GuardarAnalisisDetalleDTO;
import Entidades.AnalisisDetalle;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IAnalisisDetalleDAO {
    List<AnalisisDetalle> obtenerDetallesPorAnalisis(int idAnalisis) throws PersistenciaException;
    
    List<AnalisisDetalle> BuscarAnalisisDetalles() throws PersistenciaException;
    
    AnalisisDetalle guardar(GuardarAnalisisDetalleDTO detalle) throws PersistenciaException;

    AnalisisDetalle actualizar(EditarAnalisisDetalleDTO detalle) throws PersistenciaException;

    AnalisisDetalle eliminar(int id) throws PersistenciaException;

    AnalisisDetalle obtenerPorID(int id) throws PersistenciaException;
}
