/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import DTOS.AnalisisDTO;
import DTOS.AnalisisDetalleDTO;
import DTOS.AnalisisDetalleTablaDTO;
import DTOS.EditarAnalisisDTO;
import DTOS.EditarAnalisisDetalleDTO;
import DTOS.EditarResultadoDTO;
import DTOS.GuardarAnalisisDTO;
import DTOS.GuardarAnalisisDetalleDTO;
import DTOS.GuardarResultadoDTO;
import DTOS.ResultadoDTO;
import Entidades.AnalisisLaboratorio;
import Entidades.Resultado;
import Negocio.AnalisisDetalleNegocio;
import Negocio.AnalisisNegocio;
import Negocio.CategoriaNegocio;
import Negocio.IAnalisisDetalleNegocio;
import Negocio.IAnalisisNegocio;
import Negocio.ICategoriaNegocio;
import Negocio.IParametroNegocio;
import Negocio.IPruebaNegocio;
import Negocio.NegocioException;
import Negocio.ParametroNegocio;
import Negocio.PruebaNegocio;
import Persistencia.AnalisisDAO;
import Persistencia.AnalisisDetalleDAO;
import Persistencia.CategoriaDAO;
import Persistencia.ClienteDAO;
import Persistencia.ConexionBD;
import Persistencia.IAnalisisDAO;
import Persistencia.IAnalisisDetalleDAO;
import Persistencia.ICategoriaDAO;
import Persistencia.IClienteDAO;
import Persistencia.IConexionBD;
import Persistencia.IParametroDAO;
import Persistencia.IPruebaDAO;
import Persistencia.IResultadoDAO;
import Persistencia.ParametroDAO;
import Persistencia.PersistenciaException;
import Persistencia.PruebaDAO;
import Persistencia.ResultadoDAO;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Equipo1
 */
public class Temporal {
    public void guardarAnalisisLaboratorio(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
            GuardarAnalisisDTO guardar = new GuardarAnalisisDTO(2, new Date());
            AnalisisLaboratorio analisisBD = analisisDAO.Guardar(guardar);
            System.out.println(analisisBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ActualizarAnalisisLaboratorio(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
            EditarAnalisisDTO editar = new EditarAnalisisDTO(3,2);
            AnalisisLaboratorio analisisBD = analisisDAO.Actualizar(editar);
            System.out.println(analisisBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ConsultarAnalisisLaboratorio(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
            List<AnalisisLaboratorio> analisisBD = analisisDAO.BuscarAnalisis();
            System.out.println(analisisBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ConsultarAnalisisLaboratorioID(){
//        try {
//            IConexionBD conexion = new ConexionBD();
//            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
//            IClienteDAO clienteDAO = new ClienteDAO(conexion);
//            IAnalisisNegocio analisisNegocio = new AnalisisNegocio(analisisDAO, clienteDAO);
//            AnalisisDTO analisisBD = analisisNegocio.obtenerAnalisisPorId(1);
//            System.out.println(analisisBD);
//        } catch (NegocioException e) {
//            System.out.println(e.getMessage());
//        }
    }
    public void EliminarAnalisisLaboratorio(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
            AnalisisLaboratorio analisisBD = analisisDAO.Eliminar(4);
            System.out.println(analisisBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ConsultarAnalisisDetalleID(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDetalleDAO analisisDetalleDAO = new AnalisisDetalleDAO(conexion);
            IAnalisisDetalleNegocio analisisDetalleNegocio = new AnalisisDetalleNegocio(analisisDetalleDAO);
            AnalisisDetalleDTO analisisBD = analisisDetalleNegocio.obtenerPorID(3);
            System.out.println(analisisBD);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
    public void ConsultarAnalisisDetalle(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDetalleDAO analisisDetalleDAO = new AnalisisDetalleDAO(conexion);
            IAnalisisDetalleNegocio analisisDetalleNegocio = new AnalisisDetalleNegocio(analisisDetalleDAO);
            List<AnalisisDetalleTablaDTO> analisisBD = analisisDetalleNegocio.listarAnalisisDetalles();
            System.out.println(analisisBD);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
    public void guardarAnalisisDetalles(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDetalleDAO analisisDetalleDAO = new AnalisisDetalleDAO(conexion);
            IAnalisisDetalleNegocio analisisDetalleNegocio = new AnalisisDetalleNegocio(analisisDetalleDAO);
            GuardarAnalisisDetalleDTO detalle = new GuardarAnalisisDetalleDTO(2, 3);
            AnalisisDetalleDTO analisisBD = analisisDetalleNegocio.guardar(detalle);
            System.out.println(analisisBD);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
    public void actualizarAnalisisDetalles(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDetalleDAO analisisDetalleDAO = new AnalisisDetalleDAO(conexion);
            IAnalisisDetalleNegocio analisisDetalleNegocio = new AnalisisDetalleNegocio(analisisDetalleDAO);
            EditarAnalisisDetalleDTO detalle = new EditarAnalisisDetalleDTO(9, 2, 1);
            AnalisisDetalleDTO analisisBD = analisisDetalleNegocio.actualizar(detalle);
            System.out.println(analisisBD);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarAnalisisDetalles(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDetalleDAO analisisDetalleDAO = new AnalisisDetalleDAO(conexion);
            IAnalisisDetalleNegocio analisisDetalleNegocio = new AnalisisDetalleNegocio(analisisDetalleDAO);
            AnalisisDetalleDTO analisisBD = analisisDetalleNegocio.eliminar(9);
            System.out.println(analisisBD);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
    }
    public void guardarResultado() {
        try {
            IConexionBD conexion = new ConexionBD();
            IResultadoDAO resultadoDAO = new ResultadoDAO(conexion);
            GuardarResultadoDTO guardar = new GuardarResultadoDTO(3, 9, "NewGuard", new Date());
            Resultado resultadoBD = resultadoDAO.guardar(guardar);
            System.out.println(resultadoBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actualizarResultado() {
        try {
            IConexionBD conexion = new ConexionBD();
            IResultadoDAO resultadoDAO = new ResultadoDAO(conexion);
            EditarResultadoDTO editar = new EditarResultadoDTO(9, 3, 5, "editado");
            Resultado resultadoBD = resultadoDAO.actualizar(editar);
            System.out.println(resultadoBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public void eliminarResultado() {
        try {
            IConexionBD conexion = new ConexionBD();
            IResultadoDAO resultadoDAO = new ResultadoDAO(conexion);
            Resultado resultadoBD = resultadoDAO.eliminar(17);
            System.out.println(resultadoBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void consultarResultados() {
        try {
            IConexionBD conexion = new ConexionBD();
            IResultadoDAO resultadoDAO = new ResultadoDAO(conexion);
            List<Resultado> resultadosBD = resultadoDAO.obtenerResultadosPorAnalisis(0);
            System.out.println(resultadosBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Temporal temp = new Temporal();
        IConexionBD conexion = new ConexionBD();
        IClienteDAO clienteDAO = new ClienteDAO(conexion);
        IAnalisisDetalleDAO analisisDetalleDAO = new AnalisisDetalleDAO(conexion);
        IPruebaDAO pruebaDAO = new PruebaDAO(conexion);
        IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
        IAnalisisNegocio analisisNegocio = new AnalisisNegocio(analisisDAO, clienteDAO, analisisDetalleDAO, pruebaDAO);
        
        ICategoriaDAO categoriaDAO = new CategoriaDAO(conexion);
        IParametroDAO parametroDAO = new ParametroDAO(conexion);
        
        IPruebaNegocio pruebaNegocio = new PruebaNegocio(pruebaDAO);
        ICategoriaNegocio categoriaNegocio = new CategoriaNegocio(categoriaDAO);
        IParametroNegocio parametroNegocio = new ParametroNegocio(parametroDAO);
        
        FrmMenuPrincipal frmPrincipal = new FrmMenuPrincipal(analisisNegocio, pruebaNegocio, categoriaNegocio, parametroNegocio);
        frmPrincipal.setVisible(true);
        
        //PruebaPanel pruebaPanel = new PruebaPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);
        //pruebaPanel.setVisible(true);
        
    }
}
