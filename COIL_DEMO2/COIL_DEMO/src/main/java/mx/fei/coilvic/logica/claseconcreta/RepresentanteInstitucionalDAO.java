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
import mx.fei.coilvic.logica.claseImplementa.IRepresentanteInstitucionalDAO;
import mx.fei.coilvic.logica.clasedominio.RepresentanteInstitucional;


/**
 *
 * @author kahun
 */
public class RepresentanteInstitucionalDAO implements IRepresentanteInstitucionalDAO{
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    public int registrarRepresentanteInstitucional(RepresentanteInstitucional representanteInstitucional) throws SQLException {
        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoRepresentanteInstitucional = conexion.prepareStatement("INSERT INTO representanteinstitucional VALUES (?,?,?,?,?,?)");

            objetoRepresentanteInstitucional.setString(1, representanteInstitucional.getIdRepresentante());
            objetoRepresentanteInstitucional.setString(2, representanteInstitucional.getNombre());
            objetoRepresentanteInstitucional.setString(3, representanteInstitucional.getDireccion());
            objetoRepresentanteInstitucional.setString(4, representanteInstitucional.getCorreo());
            objetoRepresentanteInstitucional.setString(5, representanteInstitucional.getTelefono());
            objetoRepresentanteInstitucional.setString(6, representanteInstitucional.getNombreUniversidad());
            
            int filasAfectadas = objetoRepresentanteInstitucional.executeUpdate();
            return filasAfectadas;
        } catch (SQLException excepcion) {
            Logger.getLogger(RepresentanteInstitucionalDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    @Override
    public int archivarRepresentanteInstitucional(String idRepresentante) throws SQLException {
        Connection conexion = null;
       
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoRepresentanteInstitucional = conexion.prepareStatement("DELETE FROM representanteinstitucional WHERE idRepresentante=?");
            objetoRepresentanteInstitucional.setString(1, idRepresentante);
            filasObtenidas = objetoRepresentanteInstitucional.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(RepresentanteInstitucionalDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<RepresentanteInstitucional> consultarRepresentanteInstitucional() throws SQLException {
        Connection conexion = null;
        ArrayList<RepresentanteInstitucional> listaRepresentanteInstitucional = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM representanteinstitucional";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String nombre = respuestaConsulta.getString(2);
                String direccion = respuestaConsulta.getString(3);
                String correo = respuestaConsulta.getString(4);
                String telefono = respuestaConsulta.getString(5);
                String nombreUniversidad = respuestaConsulta.getString(6);
                

                RepresentanteInstitucional objetoRepresentanteInstitucional = new RepresentanteInstitucional();
                objetoRepresentanteInstitucional.setIdRepresentante(id);
                objetoRepresentanteInstitucional.setNombre(nombre);
                objetoRepresentanteInstitucional.setDireccion(direccion);
                objetoRepresentanteInstitucional.setCorreo(correo);
                objetoRepresentanteInstitucional.setTelefono(telefono);
                objetoRepresentanteInstitucional.setNombreUniversidad(nombreUniversidad);

                listaRepresentanteInstitucional.add(objetoRepresentanteInstitucional);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(RepresentanteInstitucionalDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaRepresentanteInstitucional;
    }
    
    public ArrayList<RepresentanteInstitucional> consultarRepresentanteInstitucionalPorNombre() throws SQLException {
        Connection conexion = null;
        ArrayList<RepresentanteInstitucional> listaRepresentanteInstitucional = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM representanteInstitucional ORDER BY nombre;";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String nombre = respuestaConsulta.getString(2);
                String direccion = respuestaConsulta.getString(3);
                String correo = respuestaConsulta.getString(4);
                String telefono = respuestaConsulta.getString(5);
                String nombreUniversidad = respuestaConsulta.getString(6);
                

                RepresentanteInstitucional objetoRepresentanteInstitucional = new RepresentanteInstitucional();
                
                objetoRepresentanteInstitucional.setIdRepresentante(id);
                objetoRepresentanteInstitucional.setNombre(nombre);
                objetoRepresentanteInstitucional.setDireccion(direccion);
                objetoRepresentanteInstitucional.setCorreo(correo);
                objetoRepresentanteInstitucional.setTelefono(telefono);
                objetoRepresentanteInstitucional.setNombreUniversidad(nombreUniversidad);

                listaRepresentanteInstitucional.add(objetoRepresentanteInstitucional);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(RepresentanteInstitucionalDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaRepresentanteInstitucional;
    }

}
