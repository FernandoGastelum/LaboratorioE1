/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.EditarResultadoDTO;
import DTOS.GuardarResultadoDTO;
import DTOS.ParametroTablaDTO;
import DTOS.ResultadoDTO;
import DTOS.ResultadoParametroAnalisisTablaDTO;
import DTOS.ResultadoTablaDTO;
import Entidades.ResultadoParametroAnalisis;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IResultadoNegocio {
    List<ResultadoTablaDTO> obtenerResultadosPorAnalisis(int idAnalisis) throws NegocioException;
    ResultadoDTO guardar(GuardarResultadoDTO resultado) throws NegocioException;
    ResultadoDTO actualizar(EditarResultadoDTO resultado) throws NegocioException;
    ResultadoDTO eliminar(int id) throws NegocioException;
    List<ResultadoTablaDTO> listarResultado() throws NegocioException;
    List<ParametroTablaDTO> obtenerParametrosPorAnalisis(int idAnalisis) throws NegocioException;
    int obtenerIdParametroPorAnalisisDetalle(int idAnalisisDetalle) throws NegocioException;
    List<Integer> obtenerAnalisisDetallePorIdAnalisis(int idAnalisis) throws NegocioException;
    List<ResultadoParametroAnalisisTablaDTO> obtenerParametrosYResultadosPorAnalisis(int idAnalisis) throws NegocioException;

}
