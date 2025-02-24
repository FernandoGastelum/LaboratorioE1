/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import DTOS.ClientesDTO;
import Entidades.Cliente;


/**
 *
 * @author gaspa,pau
 */
public class ClienteNegocio {
    /**
     * Convertir un objeto Cliente a un ClientesDTO
     * @param cliente Objeto Cliente obtenido de la base de datos
     * @return ClientesDTO info transformada
     */
    public ClientesDTO convertirAClientesDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        String nombreCompleto = cliente.getNombre() + " " 
                                  + cliente.getApellidoPaterno() + " " 
                                  + cliente.getApellidoMaterno();
        return new ClientesDTO(cliente.getId(), nombreCompleto, cliente.getFechaRegistro(), cliente.getFechaNacimiento());
    }
}
