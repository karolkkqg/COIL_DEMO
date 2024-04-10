package mx.fei.coilvic.logica.claseconcreta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.clasedominio.AcademicoExtranjero;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoExtranjeroDAO;

/**
 *
 * @author nmh14
 */
public class AcademicoExtranjeroDAO implements IAcademicoExtranjeroDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarAcademicoExtranjero(AcademicoExtranjero academico) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademicoExtranjero = conexion.prepareStatement("INSERT INTO academicoExtranjero VALUES (?,?,?)");

            objetoAcademicoExtranjero.setString(1, academico.getIdAcademico());
            objetoAcademicoExtranjero.setString(2, academico.getIdRepresentante());
            objetoAcademicoExtranjero.setString(3, academico.getPais());

            filasAfectadas = objetoAcademicoExtranjero.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoExtranjeroDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }

    @Override
    public int archivarAcademicoExtranjero(String idAcademico) throws SQLException {
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademico = conexion.prepareStatement("DELETE FROM academicoExtranjero WHERE idAcademico=?");
            objetoAcademico.setString(1, idAcademico);

            filasObtenidas = objetoAcademico.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoExtranjeroDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<AcademicoExtranjero> consultarTotalAcademicoExtranjero() throws SQLException {

        Connection conexion = null;
        ArrayList<AcademicoExtranjero> listaAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academicoExtranjero NATURAL JOIN academico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idRepresentante = respuestaConsulta.getString(2);
                String pais = respuestaConsulta.getString(3);
                String nombreCompleto = respuestaConsulta.getString(4);
                String correo = respuestaConsulta.getString(5);
                int noEstudiantes = respuestaConsulta.getInt(6);

                AcademicoExtranjero objetoAcademico = new AcademicoExtranjero();
                objetoAcademico.setIdAcademico(id);
                objetoAcademico.setNombreCompleto(nombreCompleto);
                objetoAcademico.setCorreo(correo);
                objetoAcademico.setIdRepresentante(idRepresentante);
                objetoAcademico.setPais(pais);
                objetoAcademico.setNoEstudiantes(noEstudiantes);

                listaAcademico.add(objetoAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademico;
    }

    @Override
    public ArrayList<AcademicoExtranjero> consultarPorIDAcademicoExtranjero(String idAcademico) throws SQLException {
        Connection conexion = null;

        ArrayList<AcademicoExtranjero> listaAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academicoExtranjero NATURAL JOIN academico WHERE idacademico=?";
        String idAcademicoExtrajero = idAcademico;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);

            enunciadoConsulta.setString(1, idAcademicoExtrajero);
            ResultSet objetoAcademicoExtranjero = enunciadoConsulta.executeQuery();

            while (objetoAcademicoExtranjero.next()) {
                String id = objetoAcademicoExtranjero.getString(1);
                String idRepresentante = objetoAcademicoExtranjero.getString(2);
                String pais = objetoAcademicoExtranjero.getString(3);
                String nombreCompleto = objetoAcademicoExtranjero.getString(4);
                String correo = objetoAcademicoExtranjero.getString(5);
                int noEstudiantes = objetoAcademicoExtranjero.getInt(6);

                AcademicoExtranjero objetoAcademico = new AcademicoExtranjero();
                objetoAcademico.setIdAcademico(id);
                objetoAcademico.setNombreCompleto(nombreCompleto);
                objetoAcademico.setCorreo(correo);
                objetoAcademico.setIdRepresentante(idRepresentante);
                objetoAcademico.setPais(pais);
                objetoAcademico.setNoEstudiantes(noEstudiantes);

                listaAcademico.add(objetoAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademico;
    }

    @Override
    public ArrayList<AcademicoExtranjero> consultarPorNombreYRepresentanteAcademicoExtranjero(String nombreCompleto, String idRepresentante) throws SQLException {
        Connection conexion = null;

        ArrayList<AcademicoExtranjero> listaAcademico = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academicoExtranjero NATURAL JOIN academico WHERE nombreCompleto=? AND idRepresentante=?";

        String nombreExtranjero = nombreCompleto;
        String idRepresentanteAuxiliar = idRepresentante;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);

            enunciadoConsulta.setString(1, nombreExtranjero);
            enunciadoConsulta.setString(2, idRepresentanteAuxiliar);
            
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idRepresentanteConsulta = respuestaConsulta.getString(2);
                String pais = respuestaConsulta.getString(3);
                String nombre = respuestaConsulta.getString(4);
                String correo = respuestaConsulta.getString(5);
                int noEstudiantes = respuestaConsulta.getInt(6);

                AcademicoExtranjero objetoAcademico = new AcademicoExtranjero();
                objetoAcademico.setIdAcademico(id);
                objetoAcademico.setNombreCompleto(nombre);
                objetoAcademico.setCorreo(correo);
                objetoAcademico.setIdRepresentante(idRepresentanteConsulta);
                objetoAcademico.setPais(pais);
                objetoAcademico.setNoEstudiantes(noEstudiantes);

                listaAcademico.add(objetoAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoExtranjeroDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademico;
    }

    @Override
    public int actualizarAcademicoExtranjero(AcademicoExtranjero academico) throws SQLException {
        Connection conexion = null;
        int filasAfectadas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademicoExtranjero = conexion.prepareStatement("UPDATE academicoextranjero SET pais = ? WHERE idAcademico = ?");

            objetoAcademicoExtranjero.setString(1, academico.getPais());
            objetoAcademicoExtranjero.setString(2, academico.getIdAcademico());

            filasAfectadas = objetoAcademicoExtranjero.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoExtranjeroDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }
}
