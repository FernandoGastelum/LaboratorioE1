/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import DTOS.ClientesTablaDTO;
import Entidades.Cliente;
import java.util.Date;

/**
 *
 * @author paula
 */
public class PruebaCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear un cliente con datos de prueba
        Cliente cliente = new Cliente(1, " Carlos", " García", " Martínez", new Date(90, 4, 15), new Date()); 
        
        // Convertir el cliente en DTO para mostrarlo en la tabla
        ClientesTablaDTO dto = new ClientesTablaDTO(
            cliente.getId(), 
            cliente.getNombre() + " " + cliente.getApellidoPaterno() + " " + cliente.getApellidoMaterno(),
            cliente.getFechaNacimiento(),
            cliente.getFechaRegistro()
        );

        // Imprimir los datos
        System.out.println(dto);
    }

}
