package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DTOS.ClientesTablaDTO;
import DTOS.GuardarClienteDTO;  

public class ClienteDAO implements IClienteDAO {

    private final IConexionBD conexionBD;
    private ConexionBD conexionDB;
    
    public ClienteDAO() {
        this.conexionBD = new ConexionBD();
    }
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

    
    public boolean guardar(GuardarClienteDTO cliente) {
    // Llamamos al método insertarCliente para agregar un cliente a la base de datos
    return insertarCliente(cliente.getNombre(), 
                           cliente.getApellidoPaterno(), 
                           cliente.getApellidoMaterno(), 
                           cliente.getFechaNacimiento());
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
}
