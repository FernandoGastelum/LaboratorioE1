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
import DTOS.GuardarAnalisisDTO;
import DTOS.GuardarAnalisisDetalleDTO;
import Entidades.AnalisisLaboratorio;
import Negocio.AnalisisDetalleNegocio;
import Negocio.AnalisisNegocio;
import Negocio.IAnalisisDetalleNegocio;
import Negocio.IAnalisisNegocio;
import Negocio.NegocioException;
import Persistencia.AnalisisDAO;
import Persistencia.AnalisisDetalleDAO;
import Persistencia.ClienteDAO;
import Persistencia.ConexionBD;
import Persistencia.IAnalisisDAO;
import Persistencia.IAnalisisDetalleDAO;
import Persistencia.IClienteDAO;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
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
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
            IClienteDAO clienteDAO = new ClienteDAO(conexion);
            IAnalisisNegocio analisisNegocio = new AnalisisNegocio(analisisDAO, clienteDAO);
            AnalisisDTO analisisBD = analisisNegocio.obtenerAnalisisPorId(1);
            System.out.println(analisisBD);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
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
    public static void main(String[] args) {
        Temporal temp = new Temporal();
        temp.eliminarAnalisisDetalles();
    }
}
