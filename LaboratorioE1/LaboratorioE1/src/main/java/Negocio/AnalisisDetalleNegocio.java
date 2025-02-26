/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.AnalisisDetalleDTO;
import DTOS.AnalisisDetalleTablaDTO;
import DTOS.AnalisisTablaDTO;
import DTOS.EditarAnalisisDetalleDTO;
import DTOS.GuardarAnalisisDetalleDTO;
import Entidades.AnalisisDetalle;
import Entidades.AnalisisLaboratorio;
import Entidades.PruebaLaboratorio;
import Persistencia.IAnalisisDetalleDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class AnalisisDetalleNegocio implements IAnalisisDetalleNegocio{
    private final IAnalisisDetalleDAO analisisDetalleDAO;

    public AnalisisDetalleNegocio(IAnalisisDetalleDAO analisisDetalleDAO) {
        this.analisisDetalleDAO = analisisDetalleDAO;
    }

    @Override
    public List<AnalisisDetalleTablaDTO> listarAnalisisDetalles() throws NegocioException {
        try {
            List<AnalisisDetalle> analisisLista = this.analisisDetalleDAO.BuscarAnalisisDetalles();
            return this.convertirAnalisisDetalleTablaDTO(analisisLista);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public AnalisisDetalleDTO guardar(GuardarAnalisisDetalleDTO detalle) throws NegocioException {
        try {
            this.validarInformacionGuardarAnalisis(detalle);
            AnalisisDetalle analisisGuardado = this.analisisDetalleDAO.guardar(detalle);
            return this.convertirAnalisisDetalleDTO(analisisGuardado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalleDTO eliminar(int id) throws NegocioException {
        try {
            this.validarInformacionEliminarAnalisis(id);
            AnalisisDetalle analisisEliminado = this.analisisDetalleDAO.eliminar(id);
            return this.convertirAnalisisDetalleDTO(analisisEliminado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalleDTO actualizar(EditarAnalisisDetalleDTO detalle) throws NegocioException {
        try {
            this.validarInformacionActualizarAnalisis(detalle);
            AnalisisDetalle analisisActualizado = this.analisisDetalleDAO.actualizar(detalle);
            return this.convertirAnalisisDetalleDTO(analisisActualizado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalleDTO obtenerPorID(int id) throws NegocioException {
        try {
            this.validarInformacionBuscarAnalisis(id);
            AnalisisDetalle analisisBuscado = this.analisisDetalleDAO.obtenerPorID(id);
            if(analisisBuscado == null){
                throw new NegocioException("Analisis no encontrado con id: "+id);
            }
            return this.convertirAnalisisDetalleDTO(analisisBuscado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    private List<AnalisisDetalleTablaDTO> convertirAnalisisDetalleTablaDTO(List<AnalisisDetalle> analisis) {
        if (analisis == null) {
            return null;
        }
        List<AnalisisDetalleTablaDTO> analisisDetalleDTO = new ArrayList<>();
        for (AnalisisDetalle item : analisis) {
            AnalisisDetalleTablaDTO dato = new AnalisisDetalleTablaDTO(item.getId(), item.getIdAnalisis(), "pruebaPendiente");
            analisisDetalleDTO.add(dato);
        }

        return analisisDetalleDTO;
    }
    private AnalisisDetalleDTO convertirAnalisisDetalleDTO(AnalisisDetalle analisis) {
        if (analisis == null) {
            return null;
        }

        return new AnalisisDetalleDTO(analisis.getId(), analisis.getIdAnalisis(),analisis.getIdPrueba());
    }
    private void validarInformacionGuardarAnalisis(GuardarAnalisisDetalleDTO analisis) throws NegocioException{
        if (analisis.getIdAnalisis()<= 0) {
                throw new NegocioException("El ID del analisis no es válido.");
        }
        if (analisis.getIdPrueba()<= 0) {
                throw new NegocioException("El ID de la prueba no es válido.");
        }
    }
    private void validarInformacionActualizarAnalisis(EditarAnalisisDetalleDTO analisis) throws NegocioException{
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
