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
import mx.fei.coilvic.logica.claseImplementa.IConstanciaColaboracionAcademicoDAO;
import mx.fei.coilvic.logica.clasedominio.ConstanciaColaboracionAcademico;

/**
 *
 * @author kahun
 */
public class ConstanciaColaboracionAcademicoDAO implements IConstanciaColaboracionAcademicoDAO{
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override 
    public int registrarConstanciaColaboracionAcademico(ConstanciaColaboracionAcademico constanciaColaboracionAcademico) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoConstanciaColaboracionAcademico = conexion.prepareStatement("INSERT INTO constanciaColaboracionAcademico VALUES (?,?,?,?,?)");

            objetoConstanciaColaboracionAcademico.setString(1, constanciaColaboracionAcademico.getIdAcademico());
            objetoConstanciaColaboracionAcademico.setString(2, constanciaColaboracionAcademico.getIdColaboracion());
            objetoConstanciaColaboracionAcademico.setString(3, constanciaColaboracionAcademico.getRutaConstancia());
            objetoConstanciaColaboracionAcademico.setString(4, constanciaColaboracionAcademico.getNombreConstancia());
            objetoConstanciaColaboracionAcademico.setString(5, constanciaColaboracionAcademico.getFechaEmision());

            filasAfectadas = objetoConstanciaColaboracionAcademico.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }

    @Override
    public int archivarConstanciaColaboracionAcademicoPorIdColaboracion(String idColaboracion) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoConstanciaColaboracionAcademico = conexion.prepareStatement("DELETE FROM constanciacolaboracionacademico WHERE idColaboracion=?");
            objetoConstanciaColaboracionAcademico.setString(1, idColaboracion);
            filasObtenidas = objetoConstanciaColaboracionAcademico.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    
    @Override
    public int archivarConstanciaColaboracionAcademicoPorIdAcademico(String idAcademico) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoConstanciaColaboracionAcademico = conexion.prepareStatement("DELETE FROM constanciacolaboracionacademico WHERE idAcademico=?");
            objetoConstanciaColaboracionAcademico.setString(1, idAcademico);
            filasObtenidas = objetoConstanciaColaboracionAcademico.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<ConstanciaColaboracionAcademico> consultarConstanciaColaboracionAcademicoPorIdColaboracion(String idColaboracion) throws SQLException {
        Connection conexion = null;
        ArrayList<ConstanciaColaboracionAcademico> listaConstanciaColaboracionAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM constanciacolaboracionacademico WHERE idColaboracion = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idColaboracion);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idAcademico = respuestaConsulta.getString(2);
                String rutaConstancia = respuestaConsulta.getString(3);
                String nombreConstancia = respuestaConsulta.getString(4);
                String fechaEmision = respuestaConsulta.getString(5);

                ConstanciaColaboracionAcademico objetoConstanciaColaboracionAcademico = new ConstanciaColaboracionAcademico();
                objetoConstanciaColaboracionAcademico.setIdColaboracion(id);
                objetoConstanciaColaboracionAcademico.setIdAcademico(idAcademico);
                objetoConstanciaColaboracionAcademico.setRutaConstancia(rutaConstancia);
                objetoConstanciaColaboracionAcademico.setNombreConstancia(nombreConstancia);
                objetoConstanciaColaboracionAcademico.setFechaEmision(fechaEmision);
                
                listaConstanciaColaboracionAcademico.add(objetoConstanciaColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaConstanciaColaboracionAcademico;
    }
    
    @Override
    public ArrayList<ConstanciaColaboracionAcademico> consultarConstanciaColaboracionAcademicoPorIdAcademico(String idAcademico) throws SQLException {
        Connection conexion = null;
        ArrayList<ConstanciaColaboracionAcademico> listaConstanciaColaboracionAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM constanciacolaboracionacademico WHERE idAcademico = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idAcademico);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String id = respuestaConsulta.getString(2);
                String rutaConstancia = respuestaConsulta.getString(3);
                String nombreConstancia = respuestaConsulta.getString(4);
                String fechaEmision = respuestaConsulta.getString(5);

                ConstanciaColaboracionAcademico objetoConstanciaColaboracionAcademico = new ConstanciaColaboracionAcademico();
                objetoConstanciaColaboracionAcademico.setIdColaboracion(idColaboracion);
                objetoConstanciaColaboracionAcademico.setIdAcademico(id);
                objetoConstanciaColaboracionAcademico.setRutaConstancia(rutaConstancia);
                objetoConstanciaColaboracionAcademico.setNombreConstancia(nombreConstancia);
                objetoConstanciaColaboracionAcademico.setFechaEmision(fechaEmision);
                
                listaConstanciaColaboracionAcademico.add(objetoConstanciaColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaConstanciaColaboracionAcademico;
    }
    
    @Override
    public ArrayList<ConstanciaColaboracionAcademico> consultaTotalConstanciaColaboracionAcademico() throws SQLException {
        Connection conexion = null;
        ArrayList<ConstanciaColaboracionAcademico> listaConstanciaColaboracionAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM constanciacolaboracionacademico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String idAcademico = respuestaConsulta.getString(2);
                String rutaConstancia = respuestaConsulta.getString(3);
                String nombreConstancia = respuestaConsulta.getString(4);
                String fechaEmision = respuestaConsulta.getString(5);

                ConstanciaColaboracionAcademico objetoConstanciaColaboracionAcademico = new ConstanciaColaboracionAcademico();
                objetoConstanciaColaboracionAcademico.setIdColaboracion(idColaboracion);
                objetoConstanciaColaboracionAcademico.setIdAcademico(idAcademico);
                objetoConstanciaColaboracionAcademico.setRutaConstancia(rutaConstancia);
                objetoConstanciaColaboracionAcademico.setNombreConstancia(nombreConstancia);
                objetoConstanciaColaboracionAcademico.setFechaEmision(fechaEmision);
                
                listaConstanciaColaboracionAcademico.add(objetoConstanciaColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaConstanciaColaboracionAcademico;
    }

}
