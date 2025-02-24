/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import DTOS.ClientesTablaDTO;
import Entidades.Cliente;
import java.util.Date;


/**
 *
 * @author Ilian Fernando Gastelum Romo 228761,pau
 */
public class ClienteDAO implements IClienteDAO {
    private final IConexionBD conexionBD;

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

    @Override
    public List<Cliente> obtenerTodosLosClientes() {
        String sql = "SELECT id, CONCAT(nombre, ' ', apellidoPaterno, ' ', apellidoMaterno)AS Nombre, fechaNacimiento, fechaRegistro FROM Clientes";
        List<Cliente> clientesLista = new ArrayList<>();
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                clientesLista.add(this.convertirClienteEntidad(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientesLista;
    }
    private  Cliente convertirClienteEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        String nombre = resultado.getString("Nombre");
        String apellidoPaterno = resultado.getString("apellidoPaterno");
        String apellidoMaterno = resultado.getString("apellidoMaterno");
        Date fechaRegistro = resultado.getDate("fechaRegistro");
        Date fechaNacimiento = resultado.getDate("fechaNacimiento");
        Cliente analisisConstruido = new Cliente(id, nombre, apellidoPaterno, apellidoMaterno, fechaRegistro, fechaNacimiento);
        return analisisConstruido;
    }

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
}
