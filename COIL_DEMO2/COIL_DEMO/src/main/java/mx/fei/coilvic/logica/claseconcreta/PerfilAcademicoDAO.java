/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.claseconcreta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IPerfilAcademicoDAO;
import mx.fei.coilvic.logica.clasedominio.PerfilAcademico;

public class PerfilAcademicoDAO implements IPerfilAcademicoDAO{
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
    
    @Override
    public int registrarPerfilAcademico(PerfilAcademico perfilAcademico) throws SQLException {
        Connection conexion=null;
        int filasAfectadas=0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoPerfilAcademico = conexion.prepareStatement("INSERT INTO perfilacademico VALUES (?,?,?,?,?)");
            
            objetoPerfilAcademico.setString(1, perfilAcademico.getIdAcademico());
            objetoPerfilAcademico.setString(2, perfilAcademico.getIdiomas());
            objetoPerfilAcademico.setInt(3, perfilAcademico.getCantidadDeColaboraciones());
            objetoPerfilAcademico.setInt(4, perfilAcademico.getParticipacionEnCursos());
            objetoPerfilAcademico.setString(5, perfilAcademico.getExperienciasEducativasDeInteres());
            
            filasAfectadas = objetoPerfilAcademico.executeUpdate(); 
            
        } catch (SQLException excepcion) {
            Logger.getLogger(PerfilAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }
    
    @Override
    public int archivarPerfilAcademicoPorIdAcademico(String idAcademico) throws SQLException{
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoPerfilAcademico = conexion.prepareStatement("DELETE FROM perfilacademico WHERE idAcademico=?");
            objetoPerfilAcademico.setString(1, idAcademico);
            filasObtenidas = objetoPerfilAcademico.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(PerfilAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    public ArrayList<PerfilAcademico> consultarPerfilAcademico() throws SQLException{
        Connection conexion = null;
        ArrayList<PerfilAcademico> listaPerfilAcademico = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM perfilacademico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idiomas= respuestaConsulta.getString(2);
                int cantidadDeColaboraciones = respuestaConsulta.getInt(3);
                int participacionEnCursos = respuestaConsulta.getInt(4);
                String experienciaEducativaDeInteres = respuestaConsulta.getString(5);
                
                PerfilAcademico objetoPerfilAcademico = new PerfilAcademico();
                objetoPerfilAcademico.setIdAcademico(id);
                objetoPerfilAcademico.setIdiomas(idiomas);
                objetoPerfilAcademico.setCantidadDeColaboraciones(cantidadDeColaboraciones);
                objetoPerfilAcademico.setParticipacionEnCursos(participacionEnCursos);
                objetoPerfilAcademico.setExperienciasEducativasDeInteres(experienciaEducativaDeInteres);

                listaPerfilAcademico.add(objetoPerfilAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(PerfilAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaPerfilAcademico;
    }
}
