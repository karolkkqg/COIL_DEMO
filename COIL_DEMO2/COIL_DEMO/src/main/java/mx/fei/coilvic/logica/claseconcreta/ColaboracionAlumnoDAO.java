package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.ColaboracionAlumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionAlumnoDAO;

/**
 *
 * @author nmh14
 */
public class ColaboracionAlumnoDAO implements IColaboracionAlumnoDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarColaboracionAlumno(ColaboracionAlumno alumnoColaboracion) throws SQLException {

        Connection conexion = null;
        int filasAfectadas = -1;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracionAlumno = conexion.prepareStatement("INSERT INTO ColaboracionAlumno VALUES (?,?)");

            objetoColaboracionAlumno.setString(1, alumnoColaboracion.getIdAlumno());
            objetoColaboracionAlumno.setString(2, alumnoColaboracion.getIdColaboracion());

            filasAfectadas = objetoColaboracionAlumno.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }

    @Override
    public int archivarColaboracionAlumno(String idColaboracion) throws SQLException {
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoFormaParte = conexion.prepareStatement("DELETE FROM ColaboracionAlumno WHERE idColaboracion=?");
            objetoFormaParte.setString(1, idColaboracion);

            filasObtenidas = objetoFormaParte.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<ColaboracionAlumno> consultarPorIdAlumnoColaboracionAlumno(String idAlumno) throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAlumno> listaColaboracionAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM ColaboracionAlumno WHERE idAlumno=?";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            enunciadoConsulta.setString(1, idAlumno);

            while (respuestaConsulta.next()) {
                String idColaboracion = respuestaConsulta.getString(1);
                String id = respuestaConsulta.getString(2);

                ColaboracionAlumno objetoColaboracionAporta = new ColaboracionAlumno();
                objetoColaboracionAporta.setIdColaboracion(idColaboracion);
                objetoColaboracionAporta.setIdAlumno(id);

                listaColaboracionAlumno.add(objetoColaboracionAporta);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAlumno;
    }

    @Override
    public ArrayList<ColaboracionAlumno> consultarPorIdColaboracionAlumno(String idColaboracion) throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAlumno> listaColaboracionAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM ColaboracionAlumno WHERE idColaboracion=?";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            enunciadoConsulta.setString(1, idColaboracion);

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idAlumno = respuestaConsulta.getString(2);

                ColaboracionAlumno objetoColaboracionAporta = new ColaboracionAlumno();
                objetoColaboracionAporta.setIdColaboracion(id);
                objetoColaboracionAporta.setIdAlumno(idAlumno);

                listaColaboracionAlumno.add(objetoColaboracionAporta);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAlumno;
    }

    @Override
    public ArrayList<ColaboracionAlumno> consultarPorIdYEstadoColaboracionAlumno(String idColaboracion, String estado) throws SQLException {
        Connection conexion = null;
        ArrayList<ColaboracionAlumno> listaColaboracionAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM ColaboracionAlumno NATURAL JOIN Colaboracion WHERE idColaboracion= ? AND estado=?";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            enunciadoConsulta.setString(1, idColaboracion);
            enunciadoConsulta.setString(2, estado);

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idAlumno = respuestaConsulta.getString(2);

                ColaboracionAlumno objetoColaboracionAporta = new ColaboracionAlumno();
                objetoColaboracionAporta.setIdColaboracion(id);
                objetoColaboracionAporta.setIdAlumno(idAlumno);

                listaColaboracionAlumno.add(objetoColaboracionAporta);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(ColaboracionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaColaboracionAlumno;
    }
}
