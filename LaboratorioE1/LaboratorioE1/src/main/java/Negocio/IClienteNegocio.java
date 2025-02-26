/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.ClientesDTO;
import DTOS.ClientesTablaDTO;
import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import Negocio.NegocioException;
import java.util.List;

/**
 *
 * @author gaspa,pau 
 */
public interface IClienteNegocio {
    
        List<ClientesTablaDTO> buscarClientes() throws NegocioException;

    ClientesDTO guardar(GuardarClienteDTO cliente) throws NegocioException;

    ClientesDTO editar(EditarClienteDTO cliente) throws NegocioException;

    ClientesDTO eliminar(int id) throws NegocioException;

    ClientesDTO buscarPorId(int id) throws NegocioException;
}
