/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.ParametroDTO;
import DTOS.ParametroTablaDTO;
import Entidades.ParametrosPrueba;
import Entidades.PruebaLaboratorio;
import Persistencia.IParametroDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Llama a los metodos de ParametroDAO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ParametroNegocio implements IParametroNegocio {
    
    private IParametroDAO parametroDAO;

    public ParametroNegocio(IParametroDAO parametroDAO) {
        this.parametroDAO = parametroDAO;
    }
    
    private List<ParametroTablaDTO> convertirParametroTablaDTO(List<ParametrosPrueba> parametros) {
        if (parametros == null) {
            return null;
        }
        List<ParametroTablaDTO> parametrosDTO = new ArrayList<>();
        for (ParametrosPrueba parametro : parametros) {
            ParametroTablaDTO dato = new ParametroTablaDTO(parametro.getNombreParametro());
            parametrosDTO.add(dato);
        }
        return parametrosDTO;
    }
    
    private ParametroDTO convertirParametroDTO(ParametrosPrueba parametro) {
        if (parametro == null) {
            return null;
        }

        return new ParametroDTO(parametro.getIdPrueba(), parametro.getNombreParametro());
    }
    
    // Buscar (PENDIENTE)
    @Override
    public List<ParametroTablaDTO> tablaParametros() throws NegocioException {
        try {
            List<ParametrosPrueba> pruebas = this.parametroDAO.tablaParametros();
            return this.convertirParametroTablaDTO(pruebas);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    // Guardar
    @Override
    public ParametroDTO guardarParametro(int idPrueba, ParametroDTO parametro) throws NegocioException {
        try {
            ParametrosPrueba parametroGuardado = this.parametroDAO.guardarParametro(idPrueba, parametro);
            return this.convertirParametroDTO(parametroGuardado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Editar
    @Override
    public ParametroDTO editarParametro(int id, ParametroDTO parametro) throws NegocioException {
        try {
            ParametrosPrueba parametroEditado = this.parametroDAO.editarParametro(id, parametro);
            return this.convertirParametroDTO(parametroEditado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Eliminar
    @Override
    public ParametroDTO eliminarParametro(int id) throws NegocioException {
        try {
            ParametrosPrueba parametroEliminado = this.parametroDAO.eliminarParametro(id);
            return this.convertirParametroDTO(parametroEliminado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<ParametroDTO> obtenerParametrosPorPrueba(int idPrueba) throws NegocioException {
        try {
            List<ParametrosPrueba> pruebas = this.parametroDAO.obtenerParametrosPorPrueba(idPrueba);
            return this.convertirParametrosTablaDTO(pruebas);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    private List<ParametroDTO> convertirParametrosTablaDTO(List<ParametrosPrueba> parametros) {
        if (parametros == null) {
            return null;
        }
        List<ParametroDTO> parametrosDTO = new ArrayList<>();
        for (ParametrosPrueba parametro : parametros) {
            ParametroDTO dato = new ParametroDTO(parametro.getId(),parametro.getId(),parametro.getNombreParametro());
            parametrosDTO.add(dato);
        }
        return parametrosDTO;
    }

}
