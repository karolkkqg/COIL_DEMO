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
import mx.fei.coilvic.logica.claseImplementa.IColaboracionAcademicoDAO;
import mx.fei.coilvic.logica.clasedominio.ColaboracionAcademico;

/**
 *
 * @author kahun
 */
public class ColaboracionAcademicoDAO implements IColaboracionAcademicoDAO{
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarColaboracionAcademico(ColaboracionAcademico academicoColaboracion) throws SQLException {
        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracionAcademico = conexion.prepareStatement("INSERT INTO colaboracionacademico VALUES (?,?)");
            objetoColaboracionAcademico.setString(1, academicoColaboracion.getIdColaboracion());
            objetoColaboracionAcademico.setString(2, academicoColaboracion.getIdAcademico());
            

            int filasAfectadas = objetoColaboracionAcademico.executeUpdate();
            return filasAfectadas;

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    /*@Override
    public int archivarColaboracionAcademico(String idColaboracion) throws SQLException {
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracionAcademico = conexion.prepareStatement("DELETE FROM colaboracionacademico WHERE idColaboracion=?");
            objetoColaboracionAcademico.setString(1, idColaboracion);

            filasObtenidas = objetoColaboracionAcademico.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<ColaboracionAcademico> consultarTotalColaboracionAcademico() throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAcademico> listaColaboracionAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM colaboracionacademico";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String idAcademico = respuestaConsulta.getString(2);
                
                ColaboracionAcademico objetoColaboracionAcademico = new ColaboracionAcademico();
                objetoColaboracionAcademico.setIdColaboracion(idColaboracion);
                objetoColaboracionAcademico.setIdAcademico(idAcademico);
                
                listaColaboracionAlumno.add(objetoColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAlumno;
    } */
    
    @Override
    public int archivarColaboracionAcademicoPorId(String idColaboracion) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracionAcademico = conexion.prepareStatement("DELETE FROM colaboracionacademico WHERE idColaboracion=?");
            objetoColaboracionAcademico.setString(1, idColaboracion);
            filasObtenidas = objetoColaboracionAcademico.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    
    @Override
    public int archivarColaboracionAcademicoPorIdAcademico(String idAcademico) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracionAcademico = conexion.prepareStatement("DELETE FROM colaboracionacademico WHERE idAcademico=?");
            objetoColaboracionAcademico.setString(1, idAcademico);
            filasObtenidas = objetoColaboracionAcademico.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<ColaboracionAcademico> consultarColaboracionAcademicoPorId(String idColaboracion) throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAcademico> listaColaboracionAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM colaboracionacademico WHERE idColaboracion = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idColaboracion);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idAcademico = respuestaConsulta.getString(2);

                ColaboracionAcademico objetoColaboracionAcademico = new ColaboracionAcademico();
                objetoColaboracionAcademico.setIdColaboracion(id);
                objetoColaboracionAcademico.setIdAcademico(idAcademico);
                
                listaColaboracionAcademico.add(objetoColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAcademico;
    }
    
    @Override
    public ArrayList<ColaboracionAcademico> consultarColaboracionAcademicoPorIdAcademico(String idAcademico) throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAcademico> listaColaboracionAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM colaboracionacademico WHERE idAcademico = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idAcademico);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String id = respuestaConsulta.getString(2);

                ColaboracionAcademico objetoColaboracionAcademico = new ColaboracionAcademico();
                objetoColaboracionAcademico.setIdColaboracion(idColaboracion);
                objetoColaboracionAcademico.setIdAcademico(id);
                
                listaColaboracionAcademico.add(objetoColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAcademico;
    }
    
    @Override
    public ArrayList<ColaboracionAcademico> consultaTotalColaboracionAcademico() throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAcademico> listaColaboracionAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM colaboracionacademico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String idAcademico = respuestaConsulta.getString(2);

                ColaboracionAcademico objetoColaboracionAcademico = new ColaboracionAcademico();
                objetoColaboracionAcademico.setIdColaboracion(idColaboracion);
                objetoColaboracionAcademico.setIdAcademico(idAcademico);
                
                listaColaboracionAcademico.add(objetoColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAcademico;
    }

}
