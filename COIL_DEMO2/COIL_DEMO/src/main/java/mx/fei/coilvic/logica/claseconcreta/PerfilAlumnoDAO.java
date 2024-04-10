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
import mx.fei.coilvic.logica.claseImplementa.IPerfilAlumnoDAO;
import mx.fei.coilvic.logica.clasedominio.PerfilAlumno;

/**
 *
 * @author kahun
 */
public class PerfilAlumnoDAO implements IPerfilAlumnoDAO{
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
    
    @Override
    public int registrarPerfilAlumno(PerfilAlumno perfilAlumno) throws SQLException {
        Connection conexion=null;
        int filasAfectadas=0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoPerfilAlumno = conexion.prepareStatement("INSERT INTO perfilalumno VALUES (?,?,?,?)");
            
            objetoPerfilAlumno.setString(1, perfilAlumno.getIdAlumno());
            objetoPerfilAlumno.setString(2, perfilAlumno.getIdioma());
            objetoPerfilAlumno.setInt(3, perfilAlumno.getCantidadDeColaboraciones());
            objetoPerfilAlumno.setString(4, perfilAlumno.getExperienciasEducativasDeInteres());
            
            filasAfectadas = objetoPerfilAlumno.executeUpdate(); 
            
        } catch (SQLException excepcion) {
            Logger.getLogger(PerfilAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }
    
    public int archivarPerfilAlumnoPorIdAlumno(String idAlumno) throws SQLException{
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoPerfilAlumno = conexion.prepareStatement("DELETE FROM perfilalumno WHERE idAlumno=?");
            objetoPerfilAlumno.setString(1, idAlumno);
            filasObtenidas = objetoPerfilAlumno.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(PerfilAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    public ArrayList<PerfilAlumno> consultarPerfilAlumno() throws SQLException{
        Connection conexion = null;
        ArrayList<PerfilAlumno> listaPerfilAcademico = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM perfilalumno";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idiomas= respuestaConsulta.getString(2);
                int cantidadDeColaboraciones = respuestaConsulta.getInt(3);
                String experienciaEducativaDeInteres = respuestaConsulta.getString(4);
                
                PerfilAlumno objetoPerfilAcademico = new PerfilAlumno();
                objetoPerfilAcademico.setIdAlumno(id);
                objetoPerfilAcademico.setIdioma(idiomas);
                objetoPerfilAcademico.setCantidadDeColaboraciones(cantidadDeColaboraciones);
                objetoPerfilAcademico.setExperienciasEducativasDeInteres(experienciaEducativaDeInteres);

                listaPerfilAcademico.add(objetoPerfilAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(PerfilAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaPerfilAcademico;
    }
}
