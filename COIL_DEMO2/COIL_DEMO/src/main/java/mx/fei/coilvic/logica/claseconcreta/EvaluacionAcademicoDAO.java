/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.claseconcreta;

/**
 *
 * @author kahun
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IEvaluacionAcademicoDAO;
import mx.fei.coilvic.logica.clasedominio.EvaluacionAcademico;

public class EvaluacionAcademicoDAO implements IEvaluacionAcademicoDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarEvaluacionAcademico(EvaluacionAcademico participa) throws SQLException {
        Connection conexion = null;    
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoEvaluacionAcademico = conexion.prepareStatement("INSERT INTO evaluacionacademico VALUES (?,?,?)");

            objetoEvaluacionAcademico.setString(1, participa.getIdAcademico());
            objetoEvaluacionAcademico.setString(2, participa.getIdCursoTaller());
            objetoEvaluacionAcademico.setString(3, participa.getEstadoDeAprobacion());

            int filasAfectadas = objetoEvaluacionAcademico.executeUpdate();
            return filasAfectadas;
        } catch (SQLException excepcion) {
            Logger.getLogger(EvaluacionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    @Override
    public int archivarEvaluacionAcademico(String idAcademico) throws SQLException {
        Connection conexion = null;

        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoUniversidad = conexion.prepareStatement("DELETE FROM evaluacionacaedmico WHERE idAcademico=?");
            objetoUniversidad.setString(1, idAcademico);
            filasObtenidas = objetoUniversidad.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(EvaluacionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    public ArrayList<EvaluacionAcademico> consultarTotalEvaluacionAcademico() throws SQLException {
        Connection conexion = null;
        ArrayList<EvaluacionAcademico> listaParticipa = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM evaluacionacademico";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String id = respuestaConsulta.getString(1);
                String idCursoTaller = respuestaConsulta.getString(2);
                String academicoAprobado = respuestaConsulta.getString(3);

                EvaluacionAcademico objetoEvaluacionAcademico = new EvaluacionAcademico();
                objetoEvaluacionAcademico.setIdAcademico(id);
                objetoEvaluacionAcademico.setIdCursoTaller(idCursoTaller);
                objetoEvaluacionAcademico.setEstadoDeAprobacion(academicoAprobado);


                listaParticipa.add(objetoEvaluacionAcademico);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(EvaluacionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaParticipa;
    }
}
