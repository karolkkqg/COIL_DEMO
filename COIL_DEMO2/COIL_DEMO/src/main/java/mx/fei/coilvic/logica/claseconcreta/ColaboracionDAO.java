package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionDAO;

/**
 *
 * @author nmh14
 */
public class ColaboracionDAO implements IColaboracionDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarColaboracion(Colaboracion colaboracion) throws SQLException {

        Connection conexion = null;
        int filasAfectadas = -1;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracion = conexion.prepareStatement("INSERT INTO colaboracion VALUES (?,?,?)");

            objetoColaboracion.setString(1, colaboracion.getIdColaboracion());
            objetoColaboracion.setString(2, colaboracion.getIdPropuesta());
            objetoColaboracion.setString(3, colaboracion.getEstado());

            filasAfectadas = objetoColaboracion.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }

    @Override
    public int archivarColaboracion(String idColaboracion) throws SQLException {

        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracion = conexion.prepareStatement("DELETE FROM colaboracion WHERE idColaboracion=?");
            objetoColaboracion.setString(1, idColaboracion);

            filasObtenidas = objetoColaboracion.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<Colaboracion> consultarTotalColaboracion() throws SQLException {

        Connection conexion = null;
        ArrayList<Colaboracion> listaColaboracion = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM colaboracion";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String idPropuesta = respuestaConsulta.getString(2);
                String estado = respuestaConsulta.getString(3);

                Colaboracion objetoColaboracion = new Colaboracion();
                objetoColaboracion.setIdColaboracion(idColaboracion);
                objetoColaboracion.setIdPropuesta(idPropuesta);
                objetoColaboracion.setEstado(estado);

                listaColaboracion.add(objetoColaboracion);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracion;
    }

    @Override
    public ArrayList<Colaboracion> consultarPorIdColaboracion(String idColaboracion) throws SQLException {

        Connection conexion = null;
        ArrayList<Colaboracion> listaColaboracion = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM colaboracion WHERE idColaboracion=?";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);

            enunciadoConsulta.setString(1, idColaboracion);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idPropuesta = respuestaConsulta.getString(2);
                String estado = respuestaConsulta.getString(3);

                Colaboracion objetoColaboracion = new Colaboracion();
                objetoColaboracion.setIdColaboracion(id);
                objetoColaboracion.setIdPropuesta(idPropuesta);
                objetoColaboracion.setEstado(estado);

                listaColaboracion.add(objetoColaboracion);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracion;
    }

    @Override
    public ArrayList<Colaboracion> consultarPorEstadoColaboracion(String estado) throws SQLException {
        Connection conexion = null;
        ArrayList<Colaboracion> listaColaboracion = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM colaboracion WHERE estado=?";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);

            enunciadoConsulta.setString(1, estado);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idPropuesta = respuestaConsulta.getString(2);
                String estadoColaboracion = respuestaConsulta.getString(3);

                Colaboracion objetoColaboracion = new Colaboracion();
                objetoColaboracion.setIdColaboracion(id);
                objetoColaboracion.setIdPropuesta(idPropuesta);
                objetoColaboracion.setEstado(estadoColaboracion);

                listaColaboracion.add(objetoColaboracion);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracion;
    }

    @Override
    public int actaulizarEstadoColaboracion(String idColaboracion, String estado) throws SQLException {
        
        Connection conexion = null;
        int filasAfectadas = -1; 
        String consultaMySQL = "UPDATE colaboracion SET estado=? WHERE idColaboracion=?";
        
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracion = conexion.prepareStatement(consultaMySQL);
            
            objetoColaboracion.setString(1, estado);
            objetoColaboracion.setString(2, idColaboracion);

            filasAfectadas = objetoColaboracion.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }

}
