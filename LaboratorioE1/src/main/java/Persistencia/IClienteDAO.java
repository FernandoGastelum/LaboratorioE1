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
    String obtenerNombrePorId(int idCliente);

    List<Cliente> buscarClientes()throws PersistenciaException;

    Cliente editar(EditarClienteDTO cliente)throws PersistenciaException;

    Cliente eliminar(int id)throws PersistenciaException;

    Cliente guardar(GuardarClienteDTO cliente) throws PersistenciaException;

    Cliente buscarClientes(int id)throws PersistenciaException;

    Cliente ObtenerPorID(int id) throws PersistenciaException;

 
}
