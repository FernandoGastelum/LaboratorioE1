/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.ParametroDTO;
import DTOS.ParametroTablaDTO;
import Entidades.ParametrosPrueba;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 * Metodos de la clase ParametroNegocio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IParametroNegocio {

    List<ParametroTablaDTO> tablaParametros() throws NegocioException;

    ParametroDTO guardarParametro(int idPrueba, ParametroDTO parametro) throws NegocioException;

    ParametroDTO editarParametro(int id, ParametroDTO parametro) throws NegocioException;

    ParametroDTO eliminarParametro(int id) throws NegocioException;
    
    List<ParametroDTO> obtenerParametrosPorPrueba(int idPrueba) throws NegocioException;
}
