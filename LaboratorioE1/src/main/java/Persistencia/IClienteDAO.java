/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import Entidades.Cliente;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761,pau
 */
public interface IClienteDAO {
    public String obtenerNombrePorId(int idCliente);

    public List<Cliente> buscarClientes();

    public Cliente editar(EditarClienteDTO cliente);

    public Cliente eliminar(int id);

    public Cliente guardar(GuardarClienteDTO cliente);

    public Cliente buscarClientes(int id);


 
}
