/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.EditarResultadoDTO;
import DTOS.GuardarResultadoDTO;
import Entidades.Resultado;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IResultadoDAO {
    
    List<Resultado> obtenerResultadosPorAnalisis(int idAnalisis) throws PersistenciaException;
    
    Resultado guardar(GuardarResultadoDTO resultado) throws PersistenciaException;

    Resultado actualizar(EditarResultadoDTO resultado) throws PersistenciaException;

    Resultado eliminar(int id) throws PersistenciaException;

    Resultado obtenerPorID(int id) throws PersistenciaException;
    
    List<Resultado> listarResultado() throws PersistenciaException;
}
