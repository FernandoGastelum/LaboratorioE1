/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.CategoriaDTO;
import Entidades.CategoriaPrueba;
import java.util.List;

/**
 * Metodos de la clase CategoriaDAO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface ICategoriaDAO {

    List<CategoriaPrueba> tablaCategorias() throws PersistenciaException;

    CategoriaPrueba guardarCategoria(int idPrueba, CategoriaDTO categoria) throws PersistenciaException;

    CategoriaPrueba editarCategoria(int id, CategoriaDTO categoria) throws PersistenciaException;

    CategoriaPrueba eliminarCategoria(int id) throws PersistenciaException;
}
