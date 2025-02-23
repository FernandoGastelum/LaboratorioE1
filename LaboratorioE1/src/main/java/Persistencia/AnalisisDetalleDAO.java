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
    private final Connection conexion;

    public AnalisisDetalleDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public List<AnalisisDetalle> obtenerDetallesPorAnalisis(int idAnalisis) throws PersistenciaException {
        List<AnalisisDetalle> detalles = new ArrayList<>();
        String query = "SELECT * FROM AnalisisDetalle WHERE idAnalisis = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idAnalisis);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                detalles.add(new AnalisisDetalle(
                        rs.getInt("id"),
                        rs.getInt("idAnalisis"),
                        rs.getInt("idPrueba")
                ));
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
        return detalles;
    }

    @Override
    public AnalisisDetalle guardar(GuardarAnalisisDetalleDTO detalle) throws PersistenciaException {
        String query = "INSERT INTO AnalisisDetalle (idAnalisis, idPrueba) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, detalle.getIdAnalisis());
            stmt.setInt(2, detalle.getIdPrueba());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return new AnalisisDetalle(rs.getInt(1), detalle.getIdAnalisis(), detalle.getIdPrueba());
            } else {
                throw new PersistenciaException("No se pudo obtener el ID generado");
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalle actualizar(EditarAnalisisDetalleDTO detalle) throws PersistenciaException {
        String query = "UPDATE AnalisisDetalle SET idAnalisis = ?, idPrueba = ? WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, detalle.getIdAnalisis());
            stmt.setInt(2, detalle.getIdPrueba());
            stmt.setInt(3, detalle.getId());
            
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new PersistenciaException("No se encontró el detalle a actualizar");
            }
            return new AnalisisDetalle(detalle.getId(), detalle.getIdAnalisis(), detalle.getIdPrueba());
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalle eliminar(int id) throws PersistenciaException {
        String query = "DELETE FROM AnalisisDetalle WHERE id = ?";
        AnalisisDetalle analisisDetalle = this.obtenerPorID(id);
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new PersistenciaException("No se encontró el detalle a eliminar");
            }
            stmt.close();
            conexion.close();
            return analisisDetalle;
            
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    @Override
    public AnalisisDetalle obtenerPorID(int id) throws PersistenciaException {
        String query = "SELECT * FROM AnalisisDetalle WHERE id = ?";
        
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new AnalisisDetalle(rs.getInt("id"), rs.getInt("idAnalisis"), rs.getInt("idPrueba"));
            } else {
                throw new PersistenciaException("No se encontró el detalle con ID: " + id);
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
}
