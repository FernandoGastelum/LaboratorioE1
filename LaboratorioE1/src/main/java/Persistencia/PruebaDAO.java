/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.PruebaDTO;
import DTOS.PruebaTablaDTO;
import Entidades.ParametrosPrueba;
import Entidades.PruebaLaboratorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Todos los metodos para realizar las operaciones referentes a las pruebas de
 * laboratorio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class PruebaDAO implements IPruebaDAO {

    private IConexionBD conexionBD;

    public PruebaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    private PruebaLaboratorio convertirPrueba(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String nombrePrueba = resultado.getString("nombrePrueba");

        PruebaLaboratorio pruebaConvertida = new PruebaLaboratorio(id, nombrePrueba);
        return pruebaConvertida;
    }

    @Override
    public List<PruebaTablaDTO> obtenerPruebasCompletita() throws PersistenciaException {
        List<PruebaTablaDTO> listaPruebas = new ArrayList<>();

        String consulta = """
                        SELECT 
                            pl.nombrePrueba, 
                            c.nombreCategoria, 
                            pp.nombreParametro
                        FROM 
                            PruebasLaboratorio pl
                        LEFT JOIN 
                            ParametrosPrueba pp ON pl.id = pp.idPrueba
                        LEFT JOIN 
                            categoriaPrueba c ON pl.id = c.idPruebaLab;
                        """;

        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement preparedStatement = conexion.prepareStatement(consulta); ResultSet resultado = preparedStatement.executeQuery()) {

            while (resultado.next()) {
                String nombrePrueba = resultado.getString("nombrePrueba");
                String nombreCategoria = resultado.getString("nombreCategoria");
                String nombreParametro = resultado.getString("nombreParametro");

                listaPruebas.add(new PruebaTablaDTO(nombrePrueba, nombreCategoria, nombreParametro));
            }

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al obtener las pruebas con categoría y parámetros: " + ex.getMessage());
        }

        return listaPruebas;
    }

    // Sin usar
    private int obtenerIDPrueba(PruebaDTO prueba, Connection conexion) throws SQLException {
        String buscarSQL = """
                       SELECT id FROM PruebasLaboratorio
                       WHERE nombrePrueba = ?;
                       """;
        try (PreparedStatement buscarStatement = conexion.prepareStatement(buscarSQL)) {
            buscarStatement.setString(1, prueba.getNombrePrueba());
            try (ResultSet resultado = buscarStatement.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt("id");
                }
            }
        }
        return -1; // Indica que no se encontró la prueba
    }

    // Buscar (PENDIENTE)(Sin Usar)
    @Override
    public List<PruebaLaboratorio> tablaPrueba() throws PersistenciaException {
        try {
            String consultaSQL = """
                                 SELECT 
                                    id,
                                    nombrePrueba,
                                    categoria
                                 FROM PruebasLaboratorio
                                 """;

            Connection conexion = this.conexionBD.crearConexion(); // Crea conexion
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL); // Prepara la consulta para la conexion
            ResultSet resultado = preparedStatement.executeQuery(); // Guarda la conexion ya preparada

            List<PruebaLaboratorio> pruebaLaboratorioLista = null;
            while (resultado.next()) {
                if (pruebaLaboratorioLista == null) { // Si la lista no existe crea una
                    pruebaLaboratorioLista = new ArrayList<>();
                }

                pruebaLaboratorioLista.add(this.convertirPrueba(resultado));
            }
            resultado.close();
            preparedStatement.close();
            conexion.close();

            return pruebaLaboratorioLista;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    // Guardar
    @Override
    public PruebaLaboratorio guardarPrueba(PruebaDTO prueba) throws PersistenciaException {
        try {
            Connection conexion = this.conexionBD.crearConexion();
            String insertPrueba = """
                                    INSERT INTO PruebasLaboratorio 
                                    (nombrePrueba)
                                    VALUES (?);
                                    """;
            PreparedStatement preparedStatement = conexion.prepareStatement(insertPrueba, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, prueba.getNombrePrueba());

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del usuario falló, no se pudo insertar la prueba.");
            }

            ResultSet resultado = preparedStatement.getGeneratedKeys();
            PruebaLaboratorio pruebaConvertida = null;
            if (resultado.next()) {
                int idGenerado = resultado.getInt(1);
                pruebaConvertida = new PruebaLaboratorio(idGenerado, prueba.getNombrePrueba());
            }

            resultado.close();
            preparedStatement.close();
            conexion.close();

            return pruebaConvertida;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }

    }

    // Editar
    @Override
    public PruebaLaboratorio editarPrueba(int id, PruebaDTO prueba) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            // Obtener el ID de la prueba
            //int id = obtenerIDPrueba(prueba, conexion);
            //if (id == -1) {
            //    throw new PersistenciaException("No se encontró la prueba a actualizar.");
            //}

            // Actualizar la prueba
            String updateSQL = """
                           UPDATE PruebasLaboratorio SET
                              nombrePrueba = ?
                           WHERE id = ?;
                           """;
            try (PreparedStatement updateStatement = conexion.prepareStatement(updateSQL)) {
                updateStatement.setString(1, prueba.getNombrePrueba());
                updateStatement.setInt(3, id);

                int filasAfectadas = updateStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se pudo actualizar la prueba.");
                }

                // Retornar la prueba actualizada
                return new PruebaLaboratorio(id, prueba.getNombrePrueba());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    // Eliminar
    @Override
    public PruebaLaboratorio eliminarPrueba(int id) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            // Obtener el ID de la prueba
            PruebaLaboratorio pruebaEncontrado = obtenerPrueba(id);
            if (pruebaEncontrado == null) {
                throw new PersistenciaException("La eliminación falló, no se pudo encontrar la prueba.");
            }

            // Eliminación
            String deleteSQL = """
                           DELETE FROM PruebasLaboratorio
                           WHERE id = ?;
                           """;
            try (PreparedStatement deleteStatement = conexion.prepareStatement(deleteSQL)) {
                deleteStatement.setInt(1, id);

                int filasAfectadas = deleteStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se pudo eliminar la prueba.");
                }

                // Retornar la prueba eliminada
                return pruebaEncontrado;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    private PruebaLaboratorio obtenerPrueba(int id) throws PersistenciaException {
        try {

            String consultaSQL = """
                                 SELECT 
                                    id,
                                    nombrePrueba
                                 FROM PruebasLaboratorio WHERE id = ?;
                                 """;

            //
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultado = preparedStatement.executeQuery();

            //
            if (resultado.next()) {
                return this.convertirPrueba(resultado);
            }
            return null;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

}
