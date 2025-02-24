/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.PruebaDTO;
import DTOS.PruebaTablaDTO;
import Entidades.PruebaLaboratorio;
import java.util.List;

/**
 * Metodos de la clase PruebaDAO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IPruebaDAO {
    
    List<PruebaTablaDTO> obtenerPruebasCompletita() throws PersistenciaException;
    
    List<PruebaLaboratorio> tablaPrueba() throws PersistenciaException;
    
    PruebaLaboratorio guardarPrueba(PruebaDTO prueba) throws PersistenciaException;
    
    PruebaLaboratorio editarPrueba(int id, PruebaDTO prueba) throws PersistenciaException;
    
    PruebaLaboratorio eliminarPrueba(int id) throws PersistenciaException;
    
    PruebaLaboratorio obtenerPrueba(int id) throws PersistenciaException;
}
