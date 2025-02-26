package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DTOS.ClientesTablaDTO;
import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;  
import Entidades.Cliente;
import java.sql.Statement;
import java.util.Date;

public class ClienteDAO implements IClienteDAO {

    private final IConexionBD conexionBD;    
    // Constructor
    public ClienteDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    
    @Override
    public String obtenerNombrePorId(int idCliente) {
        String nombre = "";
        String sql = "SELECT CONCAT(nombre, ' ', apellidoPaterno, ' ', apellidoMaterno) FROM Clientes WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombre = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombre;
    }

    // método para obtener todos los clientes
    public List<ClientesTablaDTO> obtenerTodosLosClientes() {
        List<ClientesTablaDTO> listaClientes = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaRegistro FROM Clientes";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellidoPaterno = rs.getString("apellidoPaterno");
                String apellidoMaterno = rs.getString("apellidoMaterno");
                java.sql.Date fechaNacimiento = rs.getDate("fechaNacimiento");
                java.sql.Timestamp fechaRegistro = rs.getTimestamp("fechaRegistro");

                listaClientes.add(new ClientesTablaDTO(id, nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento, fechaRegistro));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaClientes;
    }


    // método para insertar un cliente
    public boolean insertarCliente(String nombre, String apellidoPaterno, String apellidoMaterno, java.sql.Date fechaNacimiento) {
        String sql = "INSERT INTO Clientes (nombre, apellidoPaterno, apellidoMaterno, fechaNacimiento) VALUES (?, ?, ?, ?)";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, apellidoPaterno);
            stmt.setString(3, apellidoMaterno);
            stmt.setDate(4, fechaNacimiento);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Cliente guardar(GuardarClienteDTO cliente) throws PersistenciaException {
        String consulta = """
                          INSERT INTO `laboratoriobdae1`.`clientes`
                          (`nombre`,
                          `apellidoPaterno`,
                          `apellidoMaterno`,
                          `fechaNacimiento`)
                          VALUES
                           (?,?,?,?);
                          """;

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidoPaterno());
            stmt.setString(3, cliente.getApellidoMaterno());

            // Convertir java.util.Date a java.sql.Date
            if (cliente.getFechaNacimiento() != null) {
                stmt.setDate(4, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            } else {
                stmt.setNull(4, java.sql.Types.DATE);
            }

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del cliente falló, no se pudo insertar el registro.");
            }

            int idCliente = 0;
            ResultSet resultado = stmt.getGeneratedKeys();
            if (resultado.next()) {
                idCliente = resultado.getInt(1);
            }
            resultado.close();

            return this.ObtenerPorID(idCliente);

        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }
    @Override
    public Cliente ObtenerPorID(int id) throws PersistenciaException {
        String consulta = """
                          SELECT 
                                id,
                                nombre,
                                apellidoPaterno,
                                apellidoMaterno,
                                fechaRegistro,
                                fechaNacimiento
                          FROM Clientes
                          WHERE id = ?;
                          """;
        try (Connection conexion = conexionBD.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                return convertirClienteEntidad(resultado);
            }else{
                throw new PersistenciaException("No se encontraron resultados con el id proporcionado");
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    private Cliente convertirClienteEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String nombre = resultado.getString("nombre");
        String apellidoPaterno = resultado.getString("apellidoPaterno");
        String apellidoMaterno = resultado.getString("apellidoMaterno");
        Date fechaNacimiento = resultado.getDate("fechaNacimiento");
        Cliente analisisConstruido = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, new Date(), fechaNacimiento);
        return analisisConstruido;
    }

    // Método para actualizar un cliente
    public boolean actualizarCliente(int id, String nombre, String apellidoPaterno, String apellidoMaterno, java.sql.Date fechaNacimiento) {
        String sql = "UPDATE Clientes SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, fechaNacimiento = ? WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            stmt.setString(2, apellidoPaterno);
            stmt.setString(3, apellidoMaterno);
            stmt.setDate(4, fechaNacimiento);
            stmt.setInt(5, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para eliminar un cliente
    public boolean eliminarCliente(int id) {
        String sql = "DELETE FROM Clientes WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

//    // Método para guardar un cliente
//    public boolean guardar(GuardarClienteDTO cliente) {
//        // Llamamos al método insertarCliente para agregar un cliente a la base de datos
//        return insertarCliente(cliente.getNombre(), cliente.getApellidoPaterno(), 
//                               cliente.getApellidoMaterno(), cliente.getFechaNacimiento());
//    }

    @Override
    public List<Cliente> buscarClientes() throws PersistenciaException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nombre, apellidoPaterno, apellidoMaterno, fechaRegistro, fechaNacimiento FROM Clientes";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidoPaterno"),
                    rs.getString("apellidoMaterno"),
                    rs.getDate("fechaRegistro"),
                    rs.getDate("fechaNacimiento")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al obtener la lista de clientes: " + e.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente editar(EditarClienteDTO cliente) throws PersistenciaException {
        String sql = "UPDATE Clientes SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, fechaNacimiento = ? WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidoPaterno());
            stmt.setString(3, cliente.getApellidoMaterno());
            stmt.setDate(4, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            stmt.setInt(5, cliente.getId());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                return buscarClientes(cliente.getId());
            } else {
                throw new PersistenciaException("No se encontró el cliente con ID " + cliente.getId());
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al editar cliente: " + e.getMessage());
        }
    }

    @Override
    public Cliente eliminar(int id) throws PersistenciaException {
        Cliente clienteEliminado = buscarClientes(id);
        if (clienteEliminado == null) {
            throw new PersistenciaException("No se encontró el cliente con ID " + id);
        }

        String sql = "DELETE FROM Clientes WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se pudo eliminar el cliente.");
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar cliente: " + e.getMessage());
        }

        return clienteEliminado;
    }

    @Override
    public Cliente buscarClientes(int id) throws PersistenciaException {
        String sql = "SELECT id, nombre, apellidoPaterno, apellidoMaterno, fechaRegistro, fechaNacimiento FROM Clientes WHERE id = ?";

        try (Connection conexion = conexionBD.crearConexion();
                PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidoPaterno"),
                    rs.getString("apellidoMaterno"),
                    rs.getDate("fechaRegistro"),
                    rs.getDate("fechaNacimiento")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new PersistenciaException("Error al buscar cliente por ID: " + e.getMessage());
        }
    }
}
