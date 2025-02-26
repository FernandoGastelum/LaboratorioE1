/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.CategoriaDTO;
import DTOS.CategoriaTablaDTO;
import Entidades.CategoriaPrueba;
import Persistencia.ICategoriaDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;

/**
 * Llama a los metodos de ParametroDAO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class CategoriaNegocio implements ICategoriaNegocio {
    
    private ICategoriaDAO categoriaDAO;

    public CategoriaNegocio(ICategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }
    
    private List<CategoriaTablaDTO> convertirCategoriaTablaDTO(List<CategoriaPrueba> categorias) {
        if (categorias == null) {
            return null;
        }
        List<CategoriaTablaDTO> categoriasDTO = new ArrayList<>();
        for (CategoriaPrueba categoria : categorias) {
            CategoriaTablaDTO dato = new CategoriaTablaDTO(categoria.getNombreCategoria());
            categoriasDTO.add(dato);
        }
        return categoriasDTO;
    }
    
    private CategoriaDTO convertirCategoriaDTO(CategoriaPrueba categoria) {
        if (categoria == null) {
            return null;
        }

        return new CategoriaDTO(categoria.getIdPruebaLab(), categoria.getNombreCategoria());
    }
    
    // Buscar (PENDIENTE)
    @Override
    public List<CategoriaTablaDTO> tablaCategorias() throws NegocioException {
        try {
            List<CategoriaPrueba> categorias = this.categoriaDAO.tablaCategorias();
            return this.convertirCategoriaTablaDTO(categorias);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    // Guardar
    @Override
    public CategoriaDTO guardarCategoria(int idPruebaLab, CategoriaDTO categoria) throws NegocioException {
        try {
            CategoriaPrueba categoriaGuardado = this.categoriaDAO.guardarCategoria(idPruebaLab, categoria);
            return this.convertirCategoriaDTO(categoriaGuardado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Editar
    @Override
    public CategoriaDTO editarCategoria(int id, CategoriaDTO categoria) throws NegocioException {
        try {
            CategoriaPrueba categoriaEditado = this.categoriaDAO.editarCategoria(id, categoria);
            return this.convertirCategoriaDTO(categoriaEditado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    // Eliminar
    @Override
    public CategoriaDTO eliminarCategoria(int id) throws NegocioException {
        try {
            CategoriaPrueba categoriaEliminado = this.categoriaDAO.eliminarCategoria(id);
            return this.convertirCategoriaDTO(categoriaEliminado);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

}
