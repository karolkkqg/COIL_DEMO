/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.claseconcreta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IDocumentoColaboracionDAO;
import mx.fei.coilvic.logica.clasedominio.DocumentoColaboracion;

/**
 *
 * @author kahun
 */
public class DocumentoColaboracionDAO implements IDocumentoColaboracionDAO {
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
    
    @Override
    public int registrarDocumentosColaboracion(DocumentoColaboracion documentosColaboracion) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoDocumentosColaboracion = conexion.prepareStatement("INSERT INTO documentoscolaboracion VALUES (?,?,?,?,?,?,?)");

            objetoDocumentosColaboracion.setString(1, documentosColaboracion.getIdColaboracion());
            objetoDocumentosColaboracion.setString(2, documentosColaboracion.getRutaSyllabus());
            objetoDocumentosColaboracion.setString(3,documentosColaboracion.getRutaActividades());
            objetoDocumentosColaboracion.setString(4, documentosColaboracion.getNombreSyllabus());
            objetoDocumentosColaboracion.setString(5, documentosColaboracion.getNombreActividades());
            objetoDocumentosColaboracion.setString(6, documentosColaboracion.getFechaEmisionSyllabus());
            objetoDocumentosColaboracion.setString(7, documentosColaboracion.getFechaEmisionActividades());

            filasAfectadas = objetoDocumentosColaboracion.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(DocumentoColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }
    
    @Override
    public int archivarDocumentosColaboracionPorIdColaboracion(String idColaboracion) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoDocumentosColaboracion = conexion.prepareStatement("DELETE FROM documentoscolaboracion WHERE idColaboracion=?");
            objetoDocumentosColaboracion.setString(1, idColaboracion);
            filasObtenidas = objetoDocumentosColaboracion.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(DocumentoColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    @Override
    public ArrayList<DocumentoColaboracion> consultarDocumentosColaboracionPorIdColaboracion(String idColaboracion) throws SQLException {
        Connection conexion = null;
        ArrayList<DocumentoColaboracion> listaDocumentosColaboracion = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM documentoscolaboracion WHERE idcolaboracion = ?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            enunciadoConsulta.setString(1, idColaboracion);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String rutaSyllabus = respuestaConsulta.getString(2);
                String rutaActividades = respuestaConsulta.getString(3);
                String nombreSyllabus = respuestaConsulta.getString(4);
                String nombreActividades = respuestaConsulta.getString(5);
                String fechaEmisionSyllabus = respuestaConsulta.getString(6);
                String fechaEmisionActividades = respuestaConsulta.getString(7);
                
                DocumentoColaboracion objetoDocumentosColaboracion = new DocumentoColaboracion();
                objetoDocumentosColaboracion.setIdColaboracion(id);
                objetoDocumentosColaboracion.setRutaSyllabus(rutaSyllabus);
                objetoDocumentosColaboracion.setRutaActividades(rutaActividades);
                objetoDocumentosColaboracion.setNombreSyllabus(nombreSyllabus);
                objetoDocumentosColaboracion.setNombreActividades(nombreActividades);
                objetoDocumentosColaboracion.setFechaEmisionSyllabus(fechaEmisionSyllabus);
                objetoDocumentosColaboracion.setFechaEmisionActividades(fechaEmisionActividades);

                listaDocumentosColaboracion.add(objetoDocumentosColaboracion);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(DocumentoColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaDocumentosColaboracion;
    }
    
    @Override
    public ArrayList<DocumentoColaboracion> consultaTotalDocumentosColaboracion() throws SQLException {
        Connection conexion = null;
        ArrayList<DocumentoColaboracion> listaDocumentosColaboracion = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM documentoscolaboracion";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String rutaSyllabus = respuestaConsulta.getString(2);
                String rutaActividades = respuestaConsulta.getString(3);
                String nombreSyllabus = respuestaConsulta.getString(4);
                String nombreActividades = respuestaConsulta.getString(5);
                String fechaEmisionSyllabus = respuestaConsulta.getString(6);
                String fechaEmisionActividades = respuestaConsulta.getString(7);
                
                DocumentoColaboracion objetoDocumentosColaboracion = new DocumentoColaboracion();
                objetoDocumentosColaboracion.setIdColaboracion(idColaboracion);
                objetoDocumentosColaboracion.setRutaSyllabus(rutaSyllabus);
                objetoDocumentosColaboracion.setRutaActividades(rutaActividades);
                objetoDocumentosColaboracion.setNombreSyllabus(nombreSyllabus);
                objetoDocumentosColaboracion.setNombreActividades(nombreActividades);
                objetoDocumentosColaboracion.setFechaEmisionSyllabus(fechaEmisionSyllabus);
                objetoDocumentosColaboracion.setFechaEmisionActividades(fechaEmisionActividades);

                listaDocumentosColaboracion.add(objetoDocumentosColaboracion);
            }
        } catch (SQLException excepcion) {
            Logger.getLogger(DocumentoColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaDocumentosColaboracion;
    }

}
