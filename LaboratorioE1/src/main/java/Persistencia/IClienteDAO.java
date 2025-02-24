/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.ClientesTablaDTO;
import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IClienteDAO {
    public String obtenerNombrePorId(int idCliente);
    public List<Cliente> obtenerTodosLosClientes();
}
