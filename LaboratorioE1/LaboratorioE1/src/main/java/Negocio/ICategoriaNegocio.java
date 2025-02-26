/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.CategoriaDTO;
import DTOS.CategoriaTablaDTO;
import java.util.List;

/**
 * Metodos de la clase CategoriaNegocio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface ICategoriaNegocio {

    List<CategoriaTablaDTO> tablaCategorias() throws NegocioException;

    CategoriaDTO guardarCategoria(int idPruebaLab, CategoriaDTO categoria) throws NegocioException;

    CategoriaDTO editarCategoria(int id, CategoriaDTO categoria) throws NegocioException;

    CategoriaDTO eliminarCategoria(int id) throws NegocioException;
}
