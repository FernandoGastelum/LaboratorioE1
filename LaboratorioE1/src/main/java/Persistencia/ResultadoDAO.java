/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.EditarResultadoDTO;
import DTOS.GuardarResultadoDTO;
import Entidades.Resultado;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class ResultadoDAO implements IResultadoDAO{
    private IConexionBD conexionBD;
    public ResultadoDAO(IConexionBD conexion){
        this.conexionBD = conexion;
    }

    @Override
    public List<Resultado> obtenerResultadosPorAnalisis(int idAnalisis) throws PersistenciaException {
        List<Resultado> resultados = new ArrayList<>();
        String query = "SELECT r.* FROM Resultados r "
                     + "JOIN AnalisisDetalle ad ON r.idAnalisisDetalle = ad.id "
                     + "WHERE ad.idAnalisis = ?";

        try (Connection conexion = conexionBD.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idAnalisis);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                resultados.add(new Resultado(
                        rs.getInt("id"),
                        rs.getInt("idAnalisisDetalle"),
                        rs.getInt("idParametro"),
                        rs.getString("valor"),
                        rs.getDate("fechaRegistro")
                ));
            }
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
        return resultados;
    }

    @Override
    public Resultado guardar(GuardarResultadoDTO resultado) throws PersistenciaException {
        String query = "INSERT INTO Resultados (idAnalisisDetalle, idParametro, valor) "
                     + "VALUES (?, ?, ?)";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, resultado.getIdAnalisisDetalle());
            stmt.setInt(2, resultado.getIdParametro());
            stmt.setString(3, resultado.getValor());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return new Resultado(rs.getInt(1), resultado.getIdAnalisisDetalle(), resultado.getIdParametro(),
                        resultado.getValor(), new Date());
            } else {
                throw new PersistenciaException("No se pudo obtener el ID generado");
            }
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Resultado actualizar(EditarResultadoDTO resultado) throws PersistenciaException {
        String query = "UPDATE Resultados SET idAnalisisDetalle = ?, idParametro = ?, valor = ? WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, resultado.getIdAnalisisDetalle());
            stmt.setInt(2, resultado.getIdParametro());
            stmt.setString(3, resultado.getValor());
            stmt.setInt(4, resultado.getId());

            int rows = stmt.executeUpdate();
            if (rows == 0) {
                throw new PersistenciaException("No se encontró el resultado a actualizar");
            }
            return new Resultado(resultado.getId(), resultado.getIdAnalisisDetalle(), resultado.getIdParametro(),
                    resultado.getValor(), new Date());
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Resultado eliminar(int id) throws PersistenciaException {
        String query = "DELETE FROM Resultados WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(query)) {
            Resultado resultadoEliminado = this.obtenerPorID(id);
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontro un resultado con el Id proporcionado.");
            }
            
            stmt.close();
            conexion.close();
            return resultadoEliminado;
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public Resultado obtenerPorID(int id) throws PersistenciaException {
        String query = "SELECT id,idAnalisisDetalle,idParametro,valor,fechaRegistro FROM Resultados WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Resultado(
                        rs.getInt("id"),
                        rs.getInt("idAnalisisDetalle"),
                        rs.getInt("idParametro"),
                        rs.getString("valor"),
                        rs.getDate("fechaRegistro")
                );
            } else {
                throw new PersistenciaException("No se encontró el resultado con ID: " + id);
            }
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    @Override
    public List<Resultado> listarResultado() throws PersistenciaException{
        String query = "SELECT id,idAnalisisDetalle,idParametro,valor,fechaRegistro FROM Resultados";

        try (Connection conexion = conexionBD.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            List<Resultado> resultadoLista = new ArrayList<>();
            while (rs.next()) {
                resultadoLista.add(this.convertirResultadoEntidad(rs));
            }
            rs.close();
            stmt.close();
            conexion.close();
            return resultadoLista;
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    @Override
    public boolean existenResultadosParaAnalisis(int idAnalisis) throws PersistenciaException {
        String query = "SELECT COUNT(*) FROM Resultados r "
                     + "INNER JOIN AnalisisDetalle ad ON r.idAnalisisDetalle = ad.id "
                     + "WHERE ad.idAnalisis = ?";
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, idAnalisis);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
        return false;
    }
    private Resultado convertirResultadoEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        int idAnalisisDetalle = resultado.getInt("idAnalisisDetalle");
        int idParametro = resultado.getInt("idParametro");
        String valor = resultado.getString("valor");
        Date fechaRegistro = resultado.getDate("fechaRegistro");
        return new Resultado(id, idAnalisisDetalle, idParametro, valor, fechaRegistro);
    }
}
