/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.ParametroDTO;
import Entidades.ParametrosPrueba;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Todos los metodos para realizar las operaciones referentes a los parámetros
 * de las pruebas
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ParametroDAO implements IParametroDAO {

    private IConexionBD conexionBD;

    public ParametroDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    private ParametrosPrueba convertirParametro(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        int idPrueba = resultado.getInt("idPrueba");
        String nombreParametro = resultado.getString("nombreParametro");

        ParametrosPrueba parametroConvertida = new ParametrosPrueba(id, idPrueba, nombreParametro);
        return parametroConvertida;
    }
    
    // (Sin usar)
    private int obtenerIDParametro(ParametroDTO parametro, Connection conexion) throws SQLException {
        String buscarSQL = """
                       SELECT id FROM ParametrosPrueba
                       WHERE nombreParametro = ?;
                       """;
        try (PreparedStatement buscarStatement = conexion.prepareStatement(buscarSQL)) {
            buscarStatement.setString(1, parametro.getNombreParametro());
            try (ResultSet resultado = buscarStatement.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt("id");
                }
            }
        }
        return -1; // Indica que no se encontró la prueba
    }
    
    private ParametrosPrueba obtenerParametro(int id) throws PersistenciaException {
        try {

            String consultaSQL = """
                                 SELECT 
                                    id,
                                    idPrueba,
                                    nombreParametro
                                 FROM ParametrosPrueba WHERE id = ?;
                                 """;

            //
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultado = preparedStatement.executeQuery();

            //
            if (resultado.next()) {
                return this.convertirParametro(resultado);
            }
            return null;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    // Buscar (PENDIENTE)
    @Override
    public List<ParametrosPrueba> tablaParametros() throws PersistenciaException {
        try {
            Connection conexion = this.conexionBD.crearConexion(); // Crea conexion
            String consultaSQL = """
                                 SELECT 
                                    id,
                                    idPrueba,
                                    nombreParametro
                                 FROM ParametrosPrueba
                                 """;
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL); // Prepara la consulta para la conexion
            ResultSet resultado = preparedStatement.executeQuery(); // Guarda la conexion ya preparada

            List<ParametrosPrueba> parametrosPruebaLista = null;
            while (resultado.next()) {
                if (parametrosPruebaLista == null) { // Si la lista no existe crea una
                    parametrosPruebaLista = new ArrayList<>();
                }

                parametrosPruebaLista.add(this.convertirParametro(resultado));
            }
            resultado.close();
            preparedStatement.close();
            conexion.close();

            return parametrosPruebaLista;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    // Guardar
    @Override
    public ParametrosPrueba guardarParametro(int idPrueba, ParametroDTO parametro) throws PersistenciaException {
        try {
            Connection conexion = this.conexionBD.crearConexion();
            String insertParametro = """
                                    INSERT INTO ParametrosPrueba 
                                    (idPrueba, nombreParametro)
                                    VALUES (?, ?);
                                    """;
            PreparedStatement preparedStatement = conexion.prepareStatement(insertParametro, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idPrueba);
            preparedStatement.setString(2, parametro.getNombreParametro());

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del usuario falló, no se pudo insertar el parámetro.");
            }

            ResultSet resultado = preparedStatement.getGeneratedKeys();
            ParametrosPrueba parametroConvertida = null;
            if (resultado.next()) {
                int idGenerado = resultado.getInt(1);
                parametroConvertida = new ParametrosPrueba(idGenerado, idPrueba, parametro.getNombreParametro());
                
            }
            
            resultado.close();
            preparedStatement.close();
            conexion.close();

            return parametroConvertida;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }

    }

    // Editar
    @Override
    public ParametrosPrueba editarParametro(int id, ParametroDTO parametro) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            // Obtener el ID de la prueba
            //int id = obtenerIDParametro(parametro, conexion);
            //if (id == -1) {
            //    throw new PersistenciaException("No se encontró la prueba a actualizar.");
            //}

            // Actualizar la prueba
            String updateSQL = """
                           UPDATE ParametrosPrueba SET
                               idPrueba = ?,
                               nombreParametro = ?
                           WHERE id = ?;
                           """;
            try (PreparedStatement updateStatement = conexion.prepareStatement(updateSQL)) {
                updateStatement.setInt(1, parametro.getIDPrueba());
                updateStatement.setString(2, parametro.getNombreParametro());
                updateStatement.setInt(3, id);

                int filasAfectadas = updateStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se pudo actualizar el parametro.");
                }

                // Retornar la prueba actualizada
                return new ParametrosPrueba(id, parametro.getIDPrueba(), parametro.getNombreParametro());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    // Eliminar
    @Override
    public ParametrosPrueba eliminarParametro(int id) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            // Obtener el ID del parametro
            ParametrosPrueba parametroEncontrado = obtenerParametro(id);
            if (parametroEncontrado == null) {
                throw new PersistenciaException("La eliminación falló, no se pudo encontrar el parametro.");
            }
            
            // Eliminación
            String deleteSQL = """
                           DELETE FROM ParametrosPrueba
                           WHERE id = ?;
                           """;
            try (PreparedStatement deleteStatement = conexion.prepareStatement(deleteSQL)) {
                deleteStatement.setInt(1, id);

                int filasAfectadas = deleteStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se pudo eliminar el parámetro.");
                }

                // Retornar la prueba eliminada
                return parametroEncontrado;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }
    @Override
    public List<ParametrosPrueba> obtenerParametrosPorPrueba(int idPrueba) throws PersistenciaException {
        List<ParametrosPrueba> parametros = new ArrayList<>();
        String sql = "SELECT id,nombreParametro FROM ParametrosPrueba WHERE idPrueba = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idPrueba);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                parametros.add(new ParametrosPrueba(rs.getInt("id"),rs.getString("nombreParametro")));
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener los parámetros de la prueba.");
        }

        return parametros;
    }

}
