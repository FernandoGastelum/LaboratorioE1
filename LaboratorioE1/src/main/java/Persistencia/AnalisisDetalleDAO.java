/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import DTOS.GuardarAnalisisDetalleDTO;
import DTOS.EditarAnalisisDetalleDTO;
import Entidades.AnalisisDetalle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class AnalisisDetalleDAO implements IAnalisisDetalleDAO{
    private IConexionBD conexionBD;

    public AnalisisDetalleDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    @Override
    public List<AnalisisDetalle> obtenerDetallesPorAnalisis(int idAnalisis) throws PersistenciaException {
        String query = "SELECT id, idAnalisis, idPrueba FROM AnalisisDetalle WHERE idAnalisis = ?";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idAnalisis);
            ResultSet rs = stmt.executeQuery();
            
            List<AnalisisDetalle> analisisDetalleLista = null;
            while (rs.next()) {
                if(analisisDetalleLista==null){
                    analisisDetalleLista = new ArrayList<>();
                }
                analisisDetalleLista.add(this.convertirAnalisisDetalleEntidad(rs));
            }
            rs.close();
            stmt.close();
            conexion.close();
            return analisisDetalleLista;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalle guardar(GuardarAnalisisDetalleDTO detalle) throws PersistenciaException {
        String consulta = "INSERT INTO AnalisisDetalle (idAnalisis, idPrueba) VALUES (?, ?)";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, detalle.getIdAnalisis());
            stmt.setInt(2, detalle.getIdPrueba());
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del detalle falló.");
            }
            
            ResultSet resultado = stmt.getGeneratedKeys();
            if (resultado.next()) {
                
                return this.obtenerPorID(resultado.getInt(1));
            }
            stmt.close();
            conexion.close();
            resultado.close();
            
            throw new PersistenciaException("No se pudo obtener el ID del detalle insertado.");
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisDetalle actualizar(EditarAnalisisDetalleDTO detalle) throws PersistenciaException {
        String consulta = "UPDATE AnalisisDetalle SET idAnalisis = ?, idPrueba = ? WHERE id = ?";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setInt(1, detalle.getIdAnalisis());
            stmt.setInt(2, detalle.getIdPrueba());
            stmt.setInt(3, detalle.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontró un detalle con el ID proporcionado.");
            }
            stmt.close();
            conexion.close();
            return this.obtenerPorID(detalle.getId());
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisDetalle eliminar(int id) throws PersistenciaException {
        String consulta = "DELETE FROM AnalisisDetalle WHERE id = ?";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            AnalisisDetalle detalle = this.obtenerPorID(id);
            stmt.setInt(1, id);
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontró un detalle con el ID proporcionado.");
            }
            stmt.close();
            conexion.close();
            return detalle;
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisDetalle obtenerPorID(int id) throws PersistenciaException {
        String consulta = "SELECT id, idAnalisis, idPrueba FROM AnalisisDetalle WHERE id = ?";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
                return convertirAnalisisDetalleEntidad(resultado);
            }
            resultado.close();
            stmt.close();
            conexion.close();
            throw new PersistenciaException("No se encontró un detalle con el ID proporcionado.");
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    @Override
    public List<AnalisisDetalle> BuscarAnalisisDetalles() throws PersistenciaException {
        String consulta = "SELECT id, idAnalisis, idPrueba FROM AnalisisDetalle";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {
            List<AnalisisDetalle> detallesLista = new ArrayList<>();
            while (rs.next()) {
                detallesLista.add(this.convertirAnalisisDetalleEntidad(rs));
            }
            rs.close();
            stmt.close();
            conexion.close();
            return detallesLista;
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    private AnalisisDetalle convertirAnalisisDetalleEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        int idAnalisis = resultado.getInt("idAnalisis");
        int idPrueba = resultado.getInt("idPrueba");
        return new AnalisisDetalle(id, idAnalisis, idPrueba);
    }
}
