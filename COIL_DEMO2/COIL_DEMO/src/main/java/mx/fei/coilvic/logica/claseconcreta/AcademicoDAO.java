package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;

/**
 *
 * @author kahun
 */
public class AcademicoDAO implements IAcademicoDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarAcademico(Academico academico) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademico = conexion.prepareStatement("INSERT INTO academico VALUES (?,?,?,?)");

            objetoAcademico.setString(1, academico.getIdAcademico());
            objetoAcademico.setString(2, academico.getNombreCompleto());
            objetoAcademico.setString(3, academico.getCorreo());
            objetoAcademico.setInt(4, academico.getNoEstudiantes());
            filasAfectadas = objetoAcademico.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }

    @Override
    public int archivarAcademico(String idAcademico) throws SQLException {
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademico = conexion.prepareStatement("DELETE FROM academico WHERE idAcademico=?");
            objetoAcademico.setString(1, idAcademico);

            filasObtenidas = objetoAcademico.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<Academico> consultarTotalAcademicos() throws SQLException {

        Connection conexion = null;
        ArrayList<Academico> listaAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String nombreCompleto = respuestaConsulta.getString(2);
                String correo = respuestaConsulta.getString(3);
                int noEstudiantes = respuestaConsulta.getInt(4);

                Academico objetoAcademico = new Academico();
                objetoAcademico.setIdAcademico(id);
                objetoAcademico.setNombreCompleto(nombreCompleto);
                objetoAcademico.setCorreo(correo);
                objetoAcademico.setNoEstudiantes(noEstudiantes);

                listaAcademico.add(objetoAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademico;
    }

    @Override
    public int actualizarAcademico(Academico academico) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademico = conexion.prepareStatement
        ("UPDATE academico SET nombreCompleto = ?, correo=?, noAlumnos= ? WHERE (idAcademico = ?)");

            
            objetoAcademico.setString(1, academico.getNombreCompleto());
            objetoAcademico.setString(2, academico.getCorreo());
            objetoAcademico.setInt(3, academico.getNoEstudiantes());
            objetoAcademico.setString(4, academico.getIdAcademico());
            
            filasAfectadas = objetoAcademico.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }
}
