/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.EditarResultadoDTO;
import DTOS.GuardarResultadoDTO;
import DTOS.ParametroDTO;
import DTOS.ParametroTablaDTO;
import DTOS.ResultadoDTO;
import DTOS.ResultadoParametroAnalisisTablaDTO;
import DTOS.ResultadoTablaDTO;
import Entidades.AnalisisDetalle;
import Entidades.ParametrosPrueba;
import Entidades.Resultado;
import Entidades.ResultadoParametroAnalisis;
import Persistencia.IAnalisisDetalleDAO;
import Persistencia.IClienteDAO;
import Persistencia.IParametroDAO;
import Persistencia.IResultadoDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class ResultadoNegocio implements IResultadoNegocio{
    private final IResultadoDAO resultadoDAO;
    private final IAnalisisDetalleDAO analisisDetalleDAO;
    private final IParametroDAO parametroPruebaDAO;
    public ResultadoNegocio(IResultadoDAO resultadoDAO,IAnalisisDetalleDAO analisisDetalleDAO,IParametroDAO parametroPruebaDAO){
        this.analisisDetalleDAO = analisisDetalleDAO;
        this.resultadoDAO = resultadoDAO;
        this.parametroPruebaDAO = parametroPruebaDAO;
        
    }
    @Override
    public List<ResultadoTablaDTO> obtenerResultadosPorAnalisis(int idResultado) throws NegocioException {
        try {
            this.validarInformacionBuscarResultado(idResultado);
            List<Resultado> resultadoBuscado = this.resultadoDAO.obtenerResultadosPorAnalisis(idResultado);
            if(resultadoBuscado == null){
                throw new NegocioException("resultado no encontrado con id: "+idResultado);
            }
            return this.convertirResultadoTablaDTO(resultadoBuscado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public ResultadoDTO guardar(GuardarResultadoDTO resultado) throws NegocioException {
        try {
            this.validarInformacionGuardarResultado(resultado);
            Resultado resultadoGuardado = this.resultadoDAO.guardar(resultado);
            return this.convertirResultadoDTO(resultadoGuardado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public ResultadoDTO actualizar(EditarResultadoDTO resultado) throws NegocioException {
        try {
            this.validarInformacionActualizarResultado(resultado);
            Resultado resultadoActualizado = this.resultadoDAO.actualizar(resultado);
            return this.convertirResultadoDTO(resultadoActualizado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    @Override
    public ResultadoDTO eliminar(int id) throws NegocioException {
        try {
            this.validarInformacionEliminarResultado(id);
            Resultado analisisEliminado = this.resultadoDAO.eliminar(id);
            return this.convertirResultadoDTO(analisisEliminado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    @Override
    public List<ParametroTablaDTO> obtenerParametrosPorAnalisis(int idAnalisis) throws NegocioException {
        try {
            // Obtener los detalles del análisis
            List<AnalisisDetalle> detalles = analisisDetalleDAO.obtenerDetallesPorAnalisis(idAnalisis);
            List<ParametroTablaDTO> parametrosDTO = new ArrayList<>();

            for (AnalisisDetalle detalle : detalles) {
                // Obtener parámetros por prueba
                List<ParametrosPrueba> parametros = parametroPruebaDAO.obtenerParametrosPorPrueba(detalle.getIdPrueba());
                for (ParametrosPrueba parametro : parametros) {
                    parametrosDTO.add(new ParametroTablaDTO(parametro.getNombreParametro()));
                }
            }
            return parametrosDTO;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener los parámetros del análisis.");
        }
    }
    
    @Override
    public List<Integer> obtenerAnalisisDetallePorIdAnalisis(int idAnalisis) throws NegocioException {
        try {
            List<Integer> resultadoLista = this.resultadoDAO.obtenerAnalisisDetallePorIdAnalisis(idAnalisis);
            return resultadoLista;
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
    }

    @Override
    public List<ResultadoTablaDTO> listarResultado() throws NegocioException {
        try {
            List<Resultado> resultadoLista = this.resultadoDAO.listarResultado();
            
            return this.convertirResultadoTablaDTO(resultadoLista);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    @Override
    public int obtenerIdParametroPorAnalisisDetalle(int idAnalisisDetalle) throws NegocioException {
        try {
            return resultadoDAO.obtenerIdParametroPorAnalisisDetalle(idAnalisisDetalle);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener idParametro: ");
        }
    }
    
    private void validarInformacionGuardarResultado(GuardarResultadoDTO resultado) throws NegocioException{
        
        if (resultado.getIdParametro()<= 0) {
                throw new NegocioException("El ID del parametro no es válido.");
        }
    }
    private void validarInformacionActualizarResultado(EditarResultadoDTO resultado) throws NegocioException{
        if (resultado.getId() <= 0) {
            throw new NegocioException("El ID del resultado no es válido.");
        }
    }
    private void validarInformacionEliminarResultado(int idResultado) throws NegocioException{
        if (idResultado <= 0) {
            throw new NegocioException("El ID del resultado no es válido.");
        }
    }
    private void validarInformacionBuscarResultado(int idResultado) throws NegocioException{
        if (idResultado <= 0) {
            throw new NegocioException("El ID del resultado no es válido.");
        }
    }
    
    private List<ResultadoTablaDTO> convertirResultadoTablaDTO(List<Resultado> resultados) {
        if (resultados == null) {
            return null;
        }
        List<ResultadoTablaDTO> resultadoDTO = new ArrayList<>();
        for (Resultado item : resultados) {
            ResultadoTablaDTO dato = new ResultadoTablaDTO(item.getId(), "NombrePruebaPH", "NombreParametroPH", item.getValor(), item.getFechaRegistro());
            resultadoDTO.add(dato);
        }
        return resultadoDTO;
    }
    
    private ResultadoDTO convertirResultadoDTO(Resultado resultado) {
        if (resultado == null) {
            return null;
        }
        return new ResultadoDTO(resultado.getId(), resultado.getIdParametro(),resultado.getValor(), resultado.getFechaRegistro());
    }
    
    private List<ResultadoParametroAnalisisTablaDTO> convertirParametroYResultadoPorAnalisisDTO(List<ResultadoParametroAnalisis> resultado) {
        if (resultado == null) {
            return null;
        }
        List<ResultadoParametroAnalisisTablaDTO> resultadoDTO = new ArrayList<>();
        for (ResultadoParametroAnalisis item : resultado) {
            ResultadoParametroAnalisisTablaDTO dato = new ResultadoParametroAnalisisTablaDTO(item.getIdAnalisis(), item.getNombreCliente(), item.getNombrePrueba(),item.getIdParametro(),item.getResultado(),item.getIdAnalisisDetalle());
            resultadoDTO.add(dato);
        }
        return resultadoDTO;
    }
    

    @Override
    public List<ResultadoParametroAnalisisTablaDTO> obtenerParametrosYResultadosPorAnalisis(int idAnalisis) throws NegocioException {
        try {
            List<ResultadoParametroAnalisis> resultadoLista = this.resultadoDAO.obtenerParametrosYResultadosPorAnalisis(idAnalisis);
            return this.convertirParametroYResultadoPorAnalisisDTO(resultadoLista);
        } catch (PersistenciaException e) {
            throw new NegocioException(e.getMessage());
        }
        
    }
}
