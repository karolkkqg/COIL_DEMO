/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.claseconcreta;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IConstanciaColaboracionAlumnoDAO;
import mx.fei.coilvic.logica.clasedominio.ConstanciaColaboracionAlumno;


/**
 *
 * @author kahun
 */
public class ConstanciaColaboracionAlumnoDAO implements IConstanciaColaboracionAlumnoDAO{
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override 
    public int registrarConstanciaColaboracionAlumno(ConstanciaColaboracionAlumno constanciaColaboracionAlumno) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoConstanciaColaboracionAlumno = conexion.prepareStatement("INSERT INTO constanciaColaboracionalumno VALUES (?,?,?,?,?)");

            objetoConstanciaColaboracionAlumno.setString(1, constanciaColaboracionAlumno.getIdAlumno());
            objetoConstanciaColaboracionAlumno.setString(2, constanciaColaboracionAlumno.getIdColaboracion());
            objetoConstanciaColaboracionAlumno.setString(3, constanciaColaboracionAlumno.getRutaConstancia());
            objetoConstanciaColaboracionAlumno.setString(4, constanciaColaboracionAlumno.getNombreConstancia());
            objetoConstanciaColaboracionAlumno.setString(5, constanciaColaboracionAlumno.getFechaEmision());

            filasAfectadas = objetoConstanciaColaboracionAlumno.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }  
    
    @Override
    public int archivarConstanciaColaboracionAlumnoPorIdColaboracion(String idColaboracion) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoConstanciaColaboracionAlumno = conexion.prepareStatement("DELETE FROM constanciacolaboracionalumno WHERE idColaboracion=?");
            objetoConstanciaColaboracionAlumno.setString(1, idColaboracion);
            filasObtenidas = objetoConstanciaColaboracionAlumno.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    
    @Override
    public int archivarConstanciaColaboracionAlumnoPorIdAlumno(String idAlumno) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoConstanciaColaboracionAlumno = conexion.prepareStatement("DELETE FROM constanciacolaboracionalumno WHERE idAlumno=?");
            objetoConstanciaColaboracionAlumno.setString(1, idAlumno);
            filasObtenidas = objetoConstanciaColaboracionAlumno.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<ConstanciaColaboracionAlumno> consultarConstanciaColaboracionAlumnoPorIdColaboracion(String idColaboracion) throws SQLException {
        Connection conexion = null;
        ArrayList<ConstanciaColaboracionAlumno> listaConstanciaColaboracionAlumno = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM constanciacolaboracionalumno WHERE idColaboracion = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idColaboracion);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idAlumno = respuestaConsulta.getString(2);
                String rutaConstancia = respuestaConsulta.getString(3);
                String nombreConstancia = respuestaConsulta.getString(4);
                String fechaEmision = respuestaConsulta.getString(5);

                ConstanciaColaboracionAlumno objetoConstanciaColaboracionAlumno = new ConstanciaColaboracionAlumno();
                objetoConstanciaColaboracionAlumno.setIdColaboracion(id);
                objetoConstanciaColaboracionAlumno.setIdAlumno(idAlumno);
                objetoConstanciaColaboracionAlumno.setRutaConstancia(rutaConstancia);
                objetoConstanciaColaboracionAlumno.setNombreConstancia(nombreConstancia);
                objetoConstanciaColaboracionAlumno.setFechaEmision(fechaEmision);
                
                listaConstanciaColaboracionAlumno.add(objetoConstanciaColaboracionAlumno);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaConstanciaColaboracionAlumno;
    }
    
    @Override
    public ArrayList<ConstanciaColaboracionAlumno> consultarConstanciaColaboracionAlumnoPorIdAcademico(String idAlumno) throws SQLException {
        Connection conexion = null;
        ArrayList<ConstanciaColaboracionAlumno> listaConstanciaColaboracionAlumno = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM constanciacolaboracionalumno WHERE idAlumno = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idAlumno);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String id = respuestaConsulta.getString(2);
                String rutaConstancia = respuestaConsulta.getString(3);
                String nombreConstancia = respuestaConsulta.getString(4);
                String fechaEmision = respuestaConsulta.getString(5);

                ConstanciaColaboracionAlumno objetoConstanciaColaboracionAlumno = new ConstanciaColaboracionAlumno();
                objetoConstanciaColaboracionAlumno.setIdColaboracion(idColaboracion);
                objetoConstanciaColaboracionAlumno.setIdAlumno(id);
                objetoConstanciaColaboracionAlumno.setRutaConstancia(rutaConstancia);
                objetoConstanciaColaboracionAlumno.setNombreConstancia(nombreConstancia);
                objetoConstanciaColaboracionAlumno.setFechaEmision(fechaEmision);
                
                listaConstanciaColaboracionAlumno.add(objetoConstanciaColaboracionAlumno);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaConstanciaColaboracionAlumno;
    }
    
    @Override
    public ArrayList<ConstanciaColaboracionAlumno> consultaTotalConstanciaColaboracionAlumno() throws SQLException {
        Connection conexion = null;
        ArrayList<ConstanciaColaboracionAlumno> listaConstanciaColaboracionAlumno = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM constanciacolaboracionalumno";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String idAlumno = respuestaConsulta.getString(2);
                String rutaConstancia = respuestaConsulta.getString(3);
                String nombreConstancia = respuestaConsulta.getString(4);
                String fechaEmision = respuestaConsulta.getString(5);

                ConstanciaColaboracionAlumno objetoConstanciaColaboracionAcademico = new ConstanciaColaboracionAlumno();
                objetoConstanciaColaboracionAcademico.setIdColaboracion(idColaboracion);
                objetoConstanciaColaboracionAcademico.setIdAlumno(idAlumno);
                objetoConstanciaColaboracionAcademico.setRutaConstancia(rutaConstancia);
                objetoConstanciaColaboracionAcademico.setNombreConstancia(nombreConstancia);
                objetoConstanciaColaboracionAcademico.setFechaEmision(fechaEmision);
                
                listaConstanciaColaboracionAlumno.add(objetoConstanciaColaboracionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ConstanciaColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaConstanciaColaboracionAlumno;
    }

}
