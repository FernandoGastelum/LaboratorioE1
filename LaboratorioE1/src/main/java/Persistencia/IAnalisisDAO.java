/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.EditarAnalisisDTO;
import DTOS.GuardarAnalisisDTO;
import Entidades.AnalisisLaboratorio;
import java.util.List;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public interface IAnalisisDAO {

    List<AnalisisLaboratorio> BuscarAnalisis() throws PersistenciaException;

    AnalisisLaboratorio Guardar(GuardarAnalisisDTO analisis) throws PersistenciaException;
    
    AnalisisLaboratorio Eliminar(int id) throws PersistenciaException;
    
    AnalisisLaboratorio Actualizar(EditarAnalisisDTO analisis) throws PersistenciaException;
    
    AnalisisLaboratorio ObtenerPorID(int id) throws PersistenciaException;
    
    
    
    
}
