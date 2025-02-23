/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.PruebaDTO;
import DTOS.PruebaTablaDTO;
import Entidades.PruebaLaboratorio;
import Persistencia.PersistenciaException;
import java.util.List;

/**
 * Metodos de la clase PruebaNegocio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IPruebaNegocio {

    List<PruebaTablaDTO> tablaPrueba() throws NegocioException;
    
    //List<PruebaTablaDTO> tablaPrueba() throws NegocioException;

    PruebaDTO guardarPrueba(PruebaDTO prueba) throws NegocioException;

    PruebaDTO editarPrueba(int id, PruebaDTO prueba) throws NegocioException;

    PruebaDTO eliminarPrueba(int id) throws NegocioException;
}
