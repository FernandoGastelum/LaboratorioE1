/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.AnalisisDTO;
import DTOS.AnalisisTablaDTO;
import DTOS.EditarAnalisisDTO;
import DTOS.GuardarAnalisisDTO;
import Entidades.AnalisisDetalle;
import Entidades.AnalisisLaboratorio;
import Persistencia.IAnalisisDAO;
import Persistencia.IAnalisisDetalleDAO;
import Persistencia.IClienteDAO;
import Persistencia.IPruebaDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class AnalisisNegocio implements IAnalisisNegocio{
    private final IAnalisisDAO analisisDAO;
    private final IClienteDAO clienteDAO;
    private final IAnalisisDetalleDAO analisisDetalleDAO;
    private IPruebaDAO pruebaDAO; 

    public AnalisisNegocio(IAnalisisDAO analisisDAO,IClienteDAO clienteDAO, IAnalisisDetalleDAO analisisDetalleDAO,IPruebaDAO pruebaDAO) {
        this.analisisDAO = analisisDAO;
        this.clienteDAO = clienteDAO;
        this.analisisDetalleDAO = analisisDetalleDAO;
        this.pruebaDAO = pruebaDAO;
    }

    @Override
    public AnalisisDTO Guardar(GuardarAnalisisDTO analisis) throws NegocioException {
        try {
            this.validarInformacionGuardarAnalisis(analisis);
            AnalisisLaboratorio analisisGuardado = this.analisisDAO.Guardar(analisis);
            return this.convertirAnalisisDTO(analisisGuardado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDTO Actualizar(EditarAnalisisDTO analisis) throws NegocioException {
        try {
            this.validarInformacionActualizarAnalisis(analisis);
            AnalisisLaboratorio analisisActualizado = this.analisisDAO.Actualizar(analisis);
            return this.convertirAnalisisDTO(analisisActualizado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDTO Eliminar(int idAnalisis) throws NegocioException {
        try {
            this.validarInformacionEliminarAnalisis(idAnalisis);
            AnalisisLaboratorio analisisEliminado = this.analisisDAO.Eliminar(idAnalisis);
            return this.convertirAnalisisDTO(analisisEliminado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDTO obtenerAnalisisPorId(int idAnalisis) throws NegocioException {
        try {
            this.validarInformacionBuscarAnalisis(idAnalisis);
            AnalisisLaboratorio analisisBuscado = this.analisisDAO.ObtenerPorID(idAnalisis);
            if(analisisBuscado == null){
                throw new NegocioException("Analisis no encontrado con id: "+idAnalisis);
            }
            return this.convertirAnalisisDTO(analisisBuscado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public List<AnalisisTablaDTO> listarAnalisis() throws NegocioException {
        try {
            List<AnalisisLaboratorio> analisisLista = this.analisisDAO.BuscarAnalisis();
            
            return this.convertirAnalisisTablaDTO(analisisLista);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    private AnalisisDTO convertirAnalisisDTO(AnalisisLaboratorio analisis) {
        if (analisis == null) {
            return null;
        }
        String nombreCliente = clienteDAO.obtenerNombrePorId(analisis.getIdCliente());
        return new AnalisisDTO(analisis.getId(), analisis.getIdCliente(),analisis.getFechaRegistro(),nombreCliente);
    }
    private List<AnalisisTablaDTO> convertirAnalisisTablaDTO(List<AnalisisLaboratorio> analisis) throws PersistenciaException {
        if (analisis == null) {
            return null;
        }
        List<AnalisisTablaDTO> analisisDTO = new ArrayList<>();
        for (AnalisisLaboratorio item : analisis) {
            String nombreCliente = clienteDAO.obtenerNombrePorId(item.getId());
            List<AnalisisDetalle> detalles = analisisDetalleDAO.obtenerDetallesPorAnalisis(item.getId());
            List<String> pruebas = new ArrayList<>();
            for (AnalisisDetalle detalle : detalles) {
                //String nombrePrueba = pruebaDAO.obtenerNombrePruebaPorId(detalle.getIdPrueba());
                pruebas.add("PROVISIONAL");
            }
            AnalisisTablaDTO dato = new AnalisisTablaDTO(item.getId(), nombreCliente, item.getFechaRegistro(),pruebas);
            analisisDTO.add(dato);
        }

        return analisisDTO;
    }
    private void validarInformacionGuardarAnalisis(GuardarAnalisisDTO analisis) throws NegocioException{
        if (analisis.getIdCliente() <= 0) {
                throw new NegocioException("El ID del cliente no es válido.");
        }
    }
    private void validarInformacionActualizarAnalisis(EditarAnalisisDTO analisis) throws NegocioException{
        if (analisis.getIdAnalisis() <= 0) {
            throw new NegocioException("El ID del análisis no es válido.");
        }
    }
    private void validarInformacionEliminarAnalisis(int idAnalisis) throws NegocioException{
        if (idAnalisis <= 0) {
            throw new NegocioException("El ID del análisis no es válido.");
        }
    }
    private void validarInformacionBuscarAnalisis(int idAnalisis) throws NegocioException{
        if (idAnalisis <= 0) {
            throw new NegocioException("El ID del análisis no es válido.");
        }
    }
}
