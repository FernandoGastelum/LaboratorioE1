/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.ClientesDTO;
import DTOS.ClientesTablaDTO;
import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import Entidades.Cliente;
import Persistencia.IClienteDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gaspa,pau
 */

public class ClienteNegocio implements IClienteNegocio {

    /**
     * Convertir un objeto Cliente a un ClientesDTO
     *
     * @param cliente Objeto Cliente obtenido de la base de datos
     * @return ClientesDTO info transformada
     */
    
     private final IClienteDAO clienteDAO;

    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    public ClientesDTO convertirAClientesDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        String nombreCompleto = cliente.getNombre() + " "
                + cliente.getApellidoPaterno() + " "
                + cliente.getApellidoMaterno();
        return new ClientesDTO(cliente.getId(), nombreCompleto, cliente.getFechaRegistro(), cliente.getFechaNacimiento());
    }

    
    //tabla para msql
    @Override
    public List<ClientesTablaDTO> buscarClientes() throws NegocioException {
         try {
             // Se obtiene la lista de clientes desde la capa de persistencia.
             List<Cliente> clientes = clienteDAO.buscarClientes();
             List<ClientesTablaDTO> dtos = new ArrayList<>();
             // Se convierten las entidades en DTOs para la presentación.
             clientes.forEach((c) -> {
                 dtos.add(new ClientesTablaDTO(
                         c.getId(),
                         c.getNombre(),
                         c.getApellidoPaterno(),
                         c.getApellidoMaterno(),
                         c.getFechaNacimiento(),
                         c.getFechaRegistro()
                 ));
             });
             return dtos;
         } catch (PersistenciaException ex) {
             Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    
    public ClientesDTO guardar(GuardarClienteDTO cliente) throws NegocioException {
         try {
             // Validación y aplicación de reglas de negocio.
             validarInformacionGuardarCliente(cliente);
             reglasDeNegocioGuardarCliente(cliente);
             // Se guarda el cliente mediante el DAO.
             Cliente clienteGuardado;
             clienteGuardado = clienteDAO.guardar(cliente);
             // Se convierte la entidad guardada a DTO.
             return convertirAClientesDTO(clienteGuardado);
         } catch (PersistenciaException ex) {
             Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
//    @Override
//    public List<ClientesTablaDTO> buscarClientes() throws NegocioException {
//        List<ClientesTablaDTO> clientes = new ArrayList<>();
//        clientes.add(new ClientesTablaDTO(1, "Juan", "Pérez", "López", new Date(90, 5, 15), new Date()));
//        clientes.add(new ClientesTablaDTO(2, "Ana", "Gómez", "Martínez", new Date(85, 2, 20), new Date()));
//        clientes.add(new ClientesTablaDTO(3, "Carlos", "Ramírez", "Hernández", new Date(95, 8, 10), new Date()));
//        clientes.add(new ClientesTablaDTO(4, "María", "Fernández", "Ruiz", new Date(88, 11, 5), new Date()));
//        System.out.println(clientes);
//        return clientes;
//    }

//    @Override
//    public ClientesDTO guardar(GuardarClienteDTO cliente) throws NegocioException {
//        try {
//            this.validarInformacionGuardarCliente(cliente);
//            this.reglasDeNegocioGuardarCliente(cliente);
//            AlumnoEntidad alumnoGuardado = this.ClienteDAO.guardarConTransaccion(cliente);
//            return this.convertirAlumnoDTO(alumnoGuardado);
//        } catch (PersistenciaException ex) {
//            throw new NegocioException(ex.getMessage());
//        }
//    }
    
      private void validarInformacionGuardarCliente(GuardarClienteDTO cliente) {
          System.out.println("validación");
    }

    private void reglasDeNegocioGuardarCliente(GuardarClienteDTO cliente) {
        System.out.println("regla de negocio");
    }
    
    
    
      public ClientesDTO editar(EditarClienteDTO cliente) throws NegocioException {
         try {
             // Validar la información a actualizar.
             validarInformacionEditarCliente(cliente);
             // Se actualiza el cliente mediante el DAO.
             Cliente clienteEditado = clienteDAO.editar(cliente);
             return convertirAClientesDTO(clienteEditado);
         } catch (PersistenciaException ex) {
             Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

   @Override
    public ClientesDTO eliminar(int id) throws NegocioException {
         try {
             // Validar que el ID del cliente sea correcto.
             validarInformacionEliminarCliente(id);
             // Se elimina el cliente mediante el DAO.
             Cliente clienteEliminado = clienteDAO.eliminar(id);
             return convertirAClientesDTO(clienteEliminado);
         } catch (PersistenciaException ex) {
             Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
    
   @Override
    public ClientesDTO buscarPorId(int id) throws NegocioException {
         try {
             // Validar el ID del cliente.
             validarInformacionBuscarCliente(id);
             Cliente clienteEncontrado = clienteDAO.buscarClientes(id);
             if (clienteEncontrado == null) {
                 throw new NegocioException("Cliente no encontrado con id: " + id);
             }
             return convertirAClientesDTO(clienteEncontrado);
         } catch (PersistenciaException ex) {
             Logger.getLogger(ClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

    private void validaInformacionGuardarCliente(GuardarClienteDTO cliente) throws NegocioException {
        if (cliente.getNombre() == null || cliente.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del cliente es obligatorio.");
        }
        

    }
    private void validarInformacionEditarCliente(EditarClienteDTO cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarInformacionEliminarCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarInformacionBuscarCliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

  

}

