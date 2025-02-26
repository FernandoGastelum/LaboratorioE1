/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import DTOS.EditarAnalisisDTO;
import DTOS.GuardarAnalisisDTO;
import Entidades.AnalisisLaboratorio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */
public class AnalisisDAO implements IAnalisisDAO{
    private IConexionBD conexionBD;
    public AnalisisDAO(IConexionBD conexion){
        this.conexionBD = conexion;
    }
    @Override
    public List<AnalisisLaboratorio> BuscarAnalisis() throws PersistenciaException {
        String consulta = "SELECT id, idCliente, fechaRegistro FROM AnalisisLaboratorio";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta);
             ResultSet rs = stmt.executeQuery()) {
            List<AnalisisLaboratorio> analisisLaboratorioLista = null;
            while (rs.next()) {
                if(analisisLaboratorioLista==null){
                    analisisLaboratorioLista = new ArrayList<>();
                }
                analisisLaboratorioLista.add(this.convertirAnalisisEntidad(rs));
            }
            rs.close();
            stmt.close();
            conexion.close();
            return analisisLaboratorioLista;
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisLaboratorio Guardar(GuardarAnalisisDTO analisis) throws PersistenciaException {
        String consulta = "INSERT INTO AnalisisLaboratorio (idCliente) VALUES (?)";
        
        try (Connection conexion = conexionBD.crearConexion();
             PreparedStatement stmt = conexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            
            stmt.setInt(1, analisis.getIdCliente());
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del analisis falló, no se pudo insertar el registro.");
            }
            int idAnalisis = 0;
            ResultSet resultado = stmt.getGeneratedKeys();
            if(resultado.next()){
                idAnalisis = resultado.getInt(1);
            }
            resultado.close();
            stmt.close();
            conexion.close();
            return this.ObtenerPorID(idAnalisis);
           
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisLaboratorio Eliminar(int id) throws PersistenciaException {
        String consulta = "DELETE FROM AnalisisLaboratorio WHERE id = ?";
        
        try (Connection conexion = conexionBD.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            AnalisisLaboratorio analisis = this.ObtenerPorID(id);
            stmt.setInt(1,id);
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontro un analisis con el Id proporcionado.");
            }
            
            stmt.close();
            conexion.close();
            return analisis;
        } catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisLaboratorio Actualizar(EditarAnalisisDTO analisis) throws PersistenciaException {
        String consulta = "UPDATE AnalisisLaboratorio SET idCliente = ? WHERE id = ?";
        try (Connection conexion = conexionBD.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setInt(1, analisis.getIdCliente());
            stmt.setInt(2, analisis.getIdAnalisis());
            
            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se encontró un analisis con el ID proporcionado.");
            }
            stmt.close();
            conexion.close();
            return this.ObtenerPorID(analisis.getIdAnalisis());
            
        }catch (SQLException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public AnalisisLaboratorio ObtenerPorID(int id) throws PersistenciaException {
        String consulta = """
                          SELECT 
                                id,
                                idCliente,
                                fechaRegistro
                          FROM analisislaboratorio
                          WHERE id = ?;
                          """;
        try (Connection conexion = conexionBD.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(consulta)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if(resultado.next()){
                return convertirAnalisisEntidad(resultado);
            }else{
                throw new PersistenciaException("No se encontraron resultados con el id proporcionado");
            }
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }
    
    private AnalisisLaboratorio convertirAnalisisEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("id");
        int idCliente = resultado.getInt("idCliente");
        Date fechaRegistro = resultado.getDate("fechaRegistro");
        AnalisisLaboratorio analisisConstruido = new AnalisisLaboratorio(id, idCliente, fechaRegistro);
        return analisisConstruido;
    }


    
}
