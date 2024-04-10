package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IAlumnoDAO;

/**
 *
 * @author nmh14
 */
public class AlumnoDAO implements IAlumnoDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarAlumno(Alumno alumno) throws SQLException {

        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAlumno = conexion.prepareStatement("INSERT INTO alumno VALUES (?,?,?,?,?)");

            objetoAlumno.setString(1, alumno.getIdAlumno());
            objetoAlumno.setString(2, alumno.getCorreo());
            objetoAlumno.setString(3, alumno.getAreaAcademica());
            objetoAlumno.setString(4, alumno.getMatricula());
            objetoAlumno.setString(5, alumno.getNombreAlumno());

            int filasAfectadas = objetoAlumno.executeUpdate();
            return filasAfectadas;

        } catch (SQLException excepcion) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    @Override
    public int archivarAlumno(String idAlumno) throws SQLException {

        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAlumno = conexion.prepareStatement("DELETE FROM alumno WHERE idAlumno=?");
            objetoAlumno.setString(1, idAlumno);

            filasObtenidas = objetoAlumno.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<Alumno> consultarTotalDeAlumno() throws SQLException {

        Connection conexion = null;
        ArrayList<Alumno> listaAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM alumno";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String correo = respuestaConsulta.getString(2);
                String areaAcademica = respuestaConsulta.getString(3);
                String matricula = respuestaConsulta.getString(4);
                String nombreAlumno = respuestaConsulta.getString(5);

                Alumno objetoAlumno = new Alumno();
                objetoAlumno.setIdAlumno(id);
                objetoAlumno.setCorreo(correo);
                objetoAlumno.setAreaAcademica(areaAcademica);
                objetoAlumno.setMatricula(matricula);
                objetoAlumno.setNombreAlumno(nombreAlumno);

                listaAlumno.add(objetoAlumno);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAlumno;
    }

    @Override
    public ArrayList<Alumno> consultarPorIdDeAlumno(String idAlumno) throws SQLException {

        Connection conexion = null;
        ArrayList<Alumno> listaAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM alumno WHERE idAlumno=?";
        
        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            
            enunciadoConsulta.setString(1, idAlumno);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String correo = respuestaConsulta.getString(2);
                String areaAcademica = respuestaConsulta.getString(3);
                String matricula = respuestaConsulta.getString(4);
                String nombreEstudiante = respuestaConsulta.getString(5);

                Alumno objetoAlumno = new Alumno();
                objetoAlumno.setIdAlumno(id);
                objetoAlumno.setCorreo(correo);
                objetoAlumno.setAreaAcademica(areaAcademica);
                objetoAlumno.setMatricula(matricula);
                objetoAlumno.setNombreAlumno(nombreEstudiante);

                listaAlumno.add(objetoAlumno);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAlumno;
    }

    @Override
    public ArrayList<Alumno> consultarPorMatriculaDeAlumno(String matricula) throws SQLException {
        
        Connection conexion = null;
        ArrayList<Alumno> listaAlumno = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM alumno WHERE matricula=?";
        
        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            
            
            enunciadoConsulta.setString(1, matricula);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String correo = respuestaConsulta.getString(2);
                String areaAcademica = respuestaConsulta.getString(3);
                String matriculaAlumno = respuestaConsulta.getString(4);
                String nombreAlumno = respuestaConsulta.getString(5);

                Alumno objetoAlumno = new Alumno();
                objetoAlumno.setIdAlumno(id);
                objetoAlumno.setCorreo(correo);
                objetoAlumno.setAreaAcademica(areaAcademica);
                objetoAlumno.setMatricula(matriculaAlumno);
                objetoAlumno.setNombreAlumno(nombreAlumno);

                listaAlumno.add(objetoAlumno);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAlumno;
        
    }

}
