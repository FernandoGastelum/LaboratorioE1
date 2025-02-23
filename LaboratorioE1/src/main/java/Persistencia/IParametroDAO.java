/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.ParametroDTO;
import Entidades.ParametrosPrueba;
import java.util.List;

/**
 * Metodos de la clase ParametroDAO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IParametroDAO {

    List<ParametrosPrueba> tablaParametros() throws PersistenciaException;

    ParametrosPrueba guardarParametro(int idPrueba, ParametroDTO parametro) throws PersistenciaException;

    ParametrosPrueba editarParametro(int id, ParametroDTO parametro) throws PersistenciaException;

    ParametrosPrueba eliminarParametro(int id) throws PersistenciaException;
}
