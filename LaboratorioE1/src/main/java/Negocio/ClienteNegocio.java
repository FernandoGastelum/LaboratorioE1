/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;
import DTOS.AnalisisTablaDTO;
import DTOS.ClientesDTO;
import DTOS.ClientesTablaDTO;
import Entidades.AnalisisDetalle;
import Entidades.AnalisisLaboratorio;
import Entidades.Cliente;
import Persistencia.IClienteDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author gaspa,pau
 */
public class ClienteNegocio implements IClienteNegocio{
    /**
     * Convertir un objeto Cliente a un ClientesDTO
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
    
    private List<ClientesTablaDTO> convertirClientesTablaDTO(List<Cliente> cliente) throws PersistenciaException {
        if (cliente == null) {
            return null;
        }
        List<ClientesTablaDTO> clienteDTO = new ArrayList<>();
        for (Cliente item : cliente) {
            ClientesTablaDTO dato = new ClientesTablaDTO(item.getId(), item.getNombre()+" "+item.getApellidoPaterno()+" "+item.getApellidoMaterno(), item.getFechaNacimiento(), item.getFechaRegistro());
            clienteDTO.add(dato);
        }

        return clienteDTO;
    }
    

    @Override
    public List<ClientesTablaDTO> obtenerTodosLosClientes() throws NegocioException {
        try {
            List<Cliente> clientesLista = this.clienteDAO.obtenerTodosLosClientes();
            
            return this.convertirClientesTablaDTO(clientesLista);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
}
