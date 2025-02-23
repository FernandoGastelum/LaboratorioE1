/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

import DTOS.GuardarAnalisisDTO;
import Entidades.AnalisisLaboratorio;
import Persistencia.AnalisisDAO;
import Persistencia.ConexionBD;
import Persistencia.IAnalisisDAO;
import Persistencia.IConexionBD;
import Persistencia.PersistenciaException;
import java.util.Date;

/**
 *
 * @author Equipo1
 */
public class Temporal {
    public void guardar(){
        try {
            IConexionBD conexion = new ConexionBD();
            IAnalisisDAO analisisDAO = new AnalisisDAO(conexion);
            GuardarAnalisisDTO guardar = new GuardarAnalisisDTO(1, new Date());
            AnalisisLaboratorio analisisBD = analisisDAO.Guardar(guardar);
            System.out.println(analisisBD);
        } catch (PersistenciaException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        Temporal temp = new Temporal();
        temp.guardar();
    }
}
