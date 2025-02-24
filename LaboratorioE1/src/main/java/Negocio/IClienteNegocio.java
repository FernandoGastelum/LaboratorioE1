/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.ClientesTablaDTO;
import java.util.List;

/**
 *
 * @author gaspa
 */
public interface IClienteNegocio {
    public List<ClientesTablaDTO> obtenerTodosLosClientes()throws NegocioException;
}
