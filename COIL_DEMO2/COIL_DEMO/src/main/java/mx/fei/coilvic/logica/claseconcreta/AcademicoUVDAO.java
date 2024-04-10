package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.AcademicoUV;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoUVDAO;

/**
 *
 * @author kahun
 */
public class AcademicoUVDAO implements IAcademicoUVDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarAcademicoUV(AcademicoUV academicoUV) throws SQLException {
        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademicoUV = conexion.prepareStatement("INSERT INTO academicouv VALUES (?,?,?,?,?,?,?,?)");

            objetoAcademicoUV.setString(1, academicoUV.getIdAcademico());
            objetoAcademicoUV.setString(2, academicoUV.getNumeroPersonal());
            objetoAcademicoUV.setString(3, academicoUV.getTelefono());
            objetoAcademicoUV.setString(4, academicoUV.getProgramaEducativo());
            objetoAcademicoUV.setString(5, academicoUV.getAreaAcademica());
            objetoAcademicoUV.setString(6, academicoUV.getRegion());
            objetoAcademicoUV.setString(7, academicoUV.getCategoriaDeContratacion());
            objetoAcademicoUV.setString(8, academicoUV.getTipoDeContratacion());

            int filasAfectadas = objetoAcademicoUV.executeUpdate();
            return filasAfectadas;
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    @Override
    public int eliminarAcademicoUVPorId(String idAcademico) throws SQLException {
        Connection conexion = null;
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademicoUV = conexion.prepareStatement("DELETE FROM academicouv WHERE idacademico=?");
            objetoAcademicoUV.setString(1, idAcademico);
            filasObtenidas = objetoAcademicoUV.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<AcademicoUV> consultarAcademicoUVPorId(String idAcademico) throws SQLException {
        Connection conexion = null;
        ArrayList<AcademicoUV> listaAcademicoUV = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academicouv NATURAL JOIN academico WHERE idacademico=?";
        String idAcademicoUV = idAcademico;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);

            enunciadoConsulta.setString(1, idAcademicoUV);
            
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String numeroPersonal = respuestaConsulta.getString(2);
                String telefono = respuestaConsulta.getString(3);
                String programaEducativo = respuestaConsulta.getString(4);
                String areaAcademica = respuestaConsulta.getString(5);
                String region = respuestaConsulta.getString(6);
                String categoriaDeContratacion = respuestaConsulta.getString(7);
                String tipoDeContratacion = respuestaConsulta.getString(8);
                String nombreCompleto = respuestaConsulta.getString(9);
                String correo = respuestaConsulta.getString(10);
                int noEstudiantes = respuestaConsulta.getInt(11);

                AcademicoUV objetoAcademicoUV = new AcademicoUV();
                objetoAcademicoUV.setIdAcademico(id);
                objetoAcademicoUV.setNombreCompleto(nombreCompleto);
                objetoAcademicoUV.setCorreo(correo);
                objetoAcademicoUV.setNoEstudiantes(noEstudiantes);
                objetoAcademicoUV.setNumeroPersonal(numeroPersonal);
                objetoAcademicoUV.setTelefono(telefono);
                objetoAcademicoUV.setProgramaEducativo(programaEducativo);
                objetoAcademicoUV.setAreaAcademica(areaAcademica);
                objetoAcademicoUV.setRegion(region);
                objetoAcademicoUV.setTipoDeContratacion(tipoDeContratacion);
                objetoAcademicoUV.setCategoriaDeContratacion(categoriaDeContratacion);

                listaAcademicoUV.add(objetoAcademicoUV);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademicoUV;
    }

    @Override
    public ArrayList<AcademicoUV> consultarTotalAcademicoUV() throws SQLException {
        Connection conexion = null;
        ArrayList<AcademicoUV> listaAcademicoUV = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academicouv NATURAL JOIN academico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String numeroPersonal = respuestaConsulta.getString(2);
                String telefono = respuestaConsulta.getString(3);
                String programaEducativo = respuestaConsulta.getString(4);
                String areaAcademica = respuestaConsulta.getString(5);
                String region = respuestaConsulta.getString(6);
                String categoriaDeContratacion = respuestaConsulta.getString(7);
                String tipoDeContratacion = respuestaConsulta.getString(8);
                String nombreCompleto = respuestaConsulta.getString(9);
                String correo = respuestaConsulta.getString(10);
                int noEstudiantes = respuestaConsulta.getInt(11);

                AcademicoUV objetoAcademicoUV = new AcademicoUV();
                objetoAcademicoUV.setIdAcademico(id);
                objetoAcademicoUV.setNombreCompleto(nombreCompleto);
                objetoAcademicoUV.setCorreo(correo);
                objetoAcademicoUV.setNoEstudiantes(noEstudiantes);
                objetoAcademicoUV.setNumeroPersonal(numeroPersonal);
                objetoAcademicoUV.setTelefono(telefono);
                objetoAcademicoUV.setProgramaEducativo(programaEducativo);
                objetoAcademicoUV.setAreaAcademica(areaAcademica);
                objetoAcademicoUV.setRegion(region);
                objetoAcademicoUV.setTipoDeContratacion(tipoDeContratacion);
                objetoAcademicoUV.setCategoriaDeContratacion(categoriaDeContratacion);

                listaAcademicoUV.add(objetoAcademicoUV);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademicoUV;
    }

    @Override
    public ArrayList<AcademicoUV> consultarAcademicoUVNumeroDePersonal(String numeroDePersonal) throws SQLException {
        Connection conexion = null;
        ArrayList<AcademicoUV> listaAcademicoUV = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM academicouv NATURAL JOIN academico WHERE numeroPersonal=?";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);

            enunciadoConsulta.setString(1, numeroDePersonal);
            
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String numeroPersonalUV = respuestaConsulta.getString(2);
                String telefono = respuestaConsulta.getString(3);
                String programaEducativo = respuestaConsulta.getString(4);
                String areaAcademica = respuestaConsulta.getString(5);
                String region = respuestaConsulta.getString(6);
                String categoriaDeContratacion = respuestaConsulta.getString(7);
                String tipoDeContratacion = respuestaConsulta.getString(8);
                String nombreCompleto = respuestaConsulta.getString(9);
                String correo = respuestaConsulta.getString(10);
                int noEstudiantes = respuestaConsulta.getInt(11);

                AcademicoUV objetoAcademicoUV = new AcademicoUV();
                objetoAcademicoUV.setIdAcademico(id);
                objetoAcademicoUV.setNombreCompleto(nombreCompleto);
                objetoAcademicoUV.setCorreo(correo);
                objetoAcademicoUV.setNoEstudiantes(noEstudiantes);
                objetoAcademicoUV.setNumeroPersonal(numeroPersonalUV);
                objetoAcademicoUV.setTelefono(telefono);
                objetoAcademicoUV.setProgramaEducativo(programaEducativo);
                objetoAcademicoUV.setAreaAcademica(areaAcademica);
                objetoAcademicoUV.setRegion(region);
                objetoAcademicoUV.setTipoDeContratacion(tipoDeContratacion);
                objetoAcademicoUV.setCategoriaDeContratacion(categoriaDeContratacion);

                listaAcademicoUV.add(objetoAcademicoUV);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaAcademicoUV;
    }

    @Override
    public int actualizarAcademicoUV(AcademicoUV academicoUV) throws SQLException {
        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAcademicoUV = conexion.prepareStatement("UPDATE academicouv SET numeroPersonal = ?, telefono = ?,"
                    + " programaEducativo = ?, areaAcademica = ?, region = ?, categoriaDeContratacion = ?, tipoDeContratacion = ?"
                    + " WHERE idAcademico = ?");

            objetoAcademicoUV.setString(1, academicoUV.getNumeroPersonal());
            objetoAcademicoUV.setString(2, academicoUV.getTelefono());
            objetoAcademicoUV.setString(3, academicoUV.getProgramaEducativo());
            objetoAcademicoUV.setString(4, academicoUV.getAreaAcademica());
            objetoAcademicoUV.setString(5, academicoUV.getRegion());
            objetoAcademicoUV.setString(6, academicoUV.getCategoriaDeContratacion());
            objetoAcademicoUV.setString(7, academicoUV.getTipoDeContratacion());
            objetoAcademicoUV.setString(8, academicoUV.getIdAcademico());

            int filasAfectadas = objetoAcademicoUV.executeUpdate();
            return filasAfectadas;
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }
}
