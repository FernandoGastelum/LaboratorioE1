/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.PruebaDTO;
import DTOS.PruebaTablaDTO;
import Entidades.PruebaLaboratorio;
import Persistencia.IPruebaDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Llama a los metodos de PruebaDAO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class PruebaNegocio implements IPruebaNegocio {

    private IPruebaDAO pruebaDAO;

    public PruebaNegocio(IPruebaDAO pruebaDAO) {
        this.pruebaDAO = pruebaDAO;
    }

    private PruebaDTO convertirPruebaDTO(PruebaLaboratorio prueba) {
        if (prueba == null) {
            return null;
        }

        return new PruebaDTO(prueba.getNombrePrueba());
    }

    @Override
    public List<PruebaTablaDTO> tablaPrueba() throws NegocioException {
        try {
            return this.pruebaDAO.obtenerPruebasCompletita();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public PruebaDTO buscarID(int id) throws NegocioException {
        try {
            PruebaLaboratorio pruebaBuscada = this.pruebaDAO.obtenerPrueba(id);
            return this.convertirPruebaDTO(pruebaBuscada);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Guardar
    @Override
    public int guardarPrueba(PruebaDTO prueba) throws NegocioException {
        try {
            PruebaLaboratorio pruebaGuardada = this.pruebaDAO.guardarPrueba(prueba);
            return pruebaGuardada.getId();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Editar
    @Override
    public PruebaDTO editarPrueba(int id, PruebaDTO prueba) throws NegocioException {
        try {
            PruebaLaboratorio pruebaEditada = this.pruebaDAO.editarPrueba(id, prueba);
            return this.convertirPruebaDTO(pruebaEditada);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Eliminar
    @Override
    public PruebaDTO eliminarPrueba(int id) throws NegocioException {
        try {
            PruebaLaboratorio pruebaEliminada = this.pruebaDAO.eliminarPrueba(id);
            return this.convertirPruebaDTO(pruebaEliminada);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

}
