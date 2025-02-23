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

    /**
     * // Buscar (PENDIENTE)
     *
     * @Override public List<PruebaTablaDTO> tablaPrueba() throws
     * NegocioException { try { List<PruebaLaboratorio> pruebas =
     * this.pruebaDAO.tablaPrueba(); return
     * this.convertirPruebaTablaDTO(pruebas); } catch (PersistenciaException ex)
     * { throw new NegocioException(ex.getMessage()); } }
     *
     * private List<PruebaTablaDTO>
     * convertirPruebaTablaDTO(List<PruebaLaboratorio> pruebas) { if (pruebas ==
     * null) { return null; } List<PruebaTablaDTO> pruebasDTO = new
     * ArrayList<>(); for (PruebaLaboratorio prueba : pruebas) { PruebaTablaDTO
     * dato = new PruebaTablaDTO(prueba.getNombrePrueba(),
     * prueba.getCategoria()); pruebasDTO.add(dato); } return pruebasDTO; }
    *
     */
    
    // Guardar
    @Override
    public PruebaDTO guardarPrueba(PruebaDTO prueba) throws NegocioException {
        try {
            PruebaLaboratorio pruebaGuardada = this.pruebaDAO.guardarPrueba(prueba);
            return this.convertirPruebaDTO(pruebaGuardada);
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
