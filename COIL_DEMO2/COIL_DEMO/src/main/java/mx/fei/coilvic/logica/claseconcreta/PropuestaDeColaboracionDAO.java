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
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;

/**
 *
 * @author nmh14
 */
public class PropuestaDeColaboracionDAO implements IPropuestaDeColaboracionDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarPropuestaDeColaboracion(PropuestaDeColaboracion propuestaDeColaboracion) throws SQLException {

        Connection conexion = null;
        int filasAfectadas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();

            PreparedStatement objetoPropuestaDeColaboracion = conexion.prepareStatement("INSERT INTO propuestadecolaboracion VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            objetoPropuestaDeColaboracion.setString(1, propuestaDeColaboracion.getIdPropuesta());
            objetoPropuestaDeColaboracion.setString(2, propuestaDeColaboracion.getIdAcademico());
            objetoPropuestaDeColaboracion.setString(3, propuestaDeColaboracion.getNombreCurso());
            objetoPropuestaDeColaboracion.setString(4, propuestaDeColaboracion.getDisciplina());
            objetoPropuestaDeColaboracion.setString(5, propuestaDeColaboracion.getTipoDeColaboracion());
            objetoPropuestaDeColaboracion.setString(6, propuestaDeColaboracion.getObjetivoGeneral());
            objetoPropuestaDeColaboracion.setString(7, propuestaDeColaboracion.getTemasDeInteres());
            objetoPropuestaDeColaboracion.setString(8, propuestaDeColaboracion.getPeriodo());
            objetoPropuestaDeColaboracion.setString(9, propuestaDeColaboracion.getPerfilEstudiantes());
            objetoPropuestaDeColaboracion.setString(10, propuestaDeColaboracion.getIdioma());
            objetoPropuestaDeColaboracion.setString(11, propuestaDeColaboracion.getInformacionAdicional());
            objetoPropuestaDeColaboracion.setString(12, propuestaDeColaboracion.getEstado());
            objetoPropuestaDeColaboracion.setInt(13, propuestaDeColaboracion.getNoAlumnos());

            filasAfectadas=objetoPropuestaDeColaboracion.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(PropuestaDeColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }

        return filasAfectadas;
    }

    @Override
    public int archivarPropuestaDeColaboracion(String id) throws SQLException {
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoColaboracion = conexion.prepareStatement("DELETE FROM propuestadecolaboracion WHERE idPropuesta=?");
            objetoColaboracion.setString(1, id);

            filasObtenidas = objetoColaboracion.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(PropuestaDeColaboracionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
}
