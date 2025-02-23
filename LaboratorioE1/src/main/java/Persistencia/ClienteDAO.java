/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class ClienteDAO implements IClienteDAO{
    private final Connection conexion;

    public ClienteDAO(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public String obtenerNombrePorId(int idCliente) {
        String nombre = "";
        String sql = "SELECT CONCAT(nombre, ' ', apellidoPaterno, ' ', apellidoMaterno) FROM Clientes WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nombre = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de errores según tu lógica
        }
        return nombre;
    }
}
