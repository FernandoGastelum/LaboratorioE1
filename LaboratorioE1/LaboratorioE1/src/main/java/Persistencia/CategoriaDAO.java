/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.CategoriaDTO;
import DTOS.CategoriaTablaDTO;
import Entidades.CategoriaPrueba;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Todos los metodos para realizar las operaciones referentes a las categorías
 * de las pruebas
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class CategoriaDAO implements ICategoriaDAO {

    private IConexionBD conexionBD;

    public CategoriaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    private CategoriaPrueba convertirCategoria(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        int idPruebaLab = resultado.getInt("idPruebaLab");
        String nombreParametro = resultado.getString("nombreCategoria");

        CategoriaPrueba categoriaConvertida = new CategoriaPrueba(id, idPruebaLab, nombreParametro);
        return categoriaConvertida;
    }
    
    private CategoriaPrueba obtenerCategoria(int id) throws PersistenciaException {
        try {

            String consultaSQL = """
                                 SELECT 
                                    id,
                                    idPruebaLab,
                                    nombreCategoria
                                 FROM CategoriaPrueba WHERE id = ?;
                                 """;

            //
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            ResultSet resultado = preparedStatement.executeQuery();

            //
            if (resultado.next()) {
                return this.convertirCategoria(resultado);
            }
            return null;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    // Buscar (PENDIENTE)
    @Override
    public List<CategoriaPrueba> tablaCategorias() throws PersistenciaException {
        try {
            Connection conexion = this.conexionBD.crearConexion(); // Crea conexion
            String consultaSQL = """
                                 SELECT 
                                    id,
                                    idPruebaLab,
                                    nombreCategoria
                                 FROM CategoriaPrueba
                                 """;
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL); // Prepara la consulta para la conexion
            ResultSet resultado = preparedStatement.executeQuery(); // Guarda la conexion ya preparada

            List<CategoriaPrueba> categoriaPruebaLista = null;
            while (resultado.next()) {
                if (categoriaPruebaLista == null) { // Si la lista no existe crea una
                    categoriaPruebaLista = new ArrayList<>();
                }

                categoriaPruebaLista.add(this.convertirCategoria(resultado));
            }
            resultado.close();
            preparedStatement.close();
            conexion.close();

            return categoriaPruebaLista;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    
    // Guardar
    @Override
    public CategoriaPrueba guardarCategoria(int idPruebaLab, CategoriaDTO categoria) throws PersistenciaException {
        try {
            Connection conexion = this.conexionBD.crearConexion();
            String insertParametro = """
                                    INSERT INTO CategoriaPrueba 
                                    (idPruebaLab, nombreCategoria)
                                    VALUES (?, ?);
                                    """;
            PreparedStatement preparedStatement = conexion.prepareStatement(insertParametro, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, idPruebaLab);
            preparedStatement.setString(2, categoria.getNombreCategoria());

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del usuario falló, no se pudo insertar la categoría.");
            }

            ResultSet resultado = preparedStatement.getGeneratedKeys();
            CategoriaPrueba categoriaConvertida = null;
            if (resultado.next()) {
                int idGenerado = resultado.getInt(1);
                categoriaConvertida = new CategoriaPrueba(idGenerado, idPruebaLab, categoria.getNombreCategoria());
                
            }
            
            resultado.close();
            preparedStatement.close();
            conexion.close();

            return categoriaConvertida;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }

    }

    // Editar
    @Override
    public CategoriaPrueba editarCategoria(int id, CategoriaDTO categoria) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            String updateSQL = """
                           UPDATE CategoriaPrueba SET
                               idPruebaLab = ?,
                               Categoria = ?
                           WHERE id = ?;
                           """;
            try (PreparedStatement updateStatement = conexion.prepareStatement(updateSQL)) {
                updateStatement.setInt(1, categoria.getIdPruebaLab());
                updateStatement.setString(2, categoria.getNombreCategoria());
                updateStatement.setInt(3, id);

                int filasAfectadas = updateStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se pudo actualizar la categoría.");
                }

                // Retornar la prueba actualizada
                return new CategoriaPrueba(id, categoria.getIdPruebaLab(), categoria.getNombreCategoria());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

    // Eliminar
    @Override
    public CategoriaPrueba eliminarCategoria(int id) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            
            CategoriaPrueba categoriaEncontrado = obtenerCategoria(id);
            if (categoriaEncontrado == null) {
                throw new PersistenciaException("La eliminación falló, no se pudo encontrar la categoría.");
            }
            
            // Eliminación
            String deleteSQL = """
                           DELETE FROM CategoriaPrueba
                           WHERE id = ?;
                           """;
            try (PreparedStatement deleteStatement = conexion.prepareStatement(deleteSQL)) {
                deleteStatement.setInt(1, id);

                int filasAfectadas = deleteStatement.executeUpdate();
                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se pudo eliminar la categoría.");
                }

                // Retornar la prueba eliminada
                return categoriaEncontrado;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
    }

}
