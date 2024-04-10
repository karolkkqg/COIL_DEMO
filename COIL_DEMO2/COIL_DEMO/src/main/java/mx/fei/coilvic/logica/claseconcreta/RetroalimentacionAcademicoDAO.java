package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.RetroalimentacionAcademico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IRetroalimentacionAcademicoDAO;

/**
 *
 * @author nmh14
 */
public class RetroalimentacionAcademicoDAO implements IRetroalimentacionAcademicoDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
    public int registrarRetroalimentacionAcademico(RetroalimentacionAcademico retroalimentacionAcademico) throws SQLException {
        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAporta = conexion.prepareStatement("INSERT INTO retroaliemtacionAcademico VALUES (?,?,?)");

            objetoAporta.setString(1, retroalimentacionAcademico.getIdRetroalimentacion());
            objetoAporta.setString(2, retroalimentacionAcademico.getIdAcademico());
            objetoAporta.setString(3, retroalimentacionAcademico.getEstudianteConSuficienteTiempoParaActividades());

            int filasAfectadas = objetoAporta.executeUpdate();
            return filasAfectadas;

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    @Override
    public int archivarRetroalimentacionAcademico(String idRetroalimentacionAcademico) throws SQLException {
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoAporta = conexion.prepareStatement("DELETE FROM retroaliemtacionAcademico WHERE idRetroalimentacion=?");
            objetoAporta.setString(1, idRetroalimentacionAcademico);

            filasObtenidas = objetoAporta.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<RetroalimentacionAcademico> consultarTotalRetroalimentacionAcademico() throws SQLException {
        
        Connection conexion = null;
        ArrayList<RetroalimentacionAcademico> listaRetroalimentacionAcademico = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM retroalimentacionAcademico NATURAL JOIN retroalimentacion";

        try {

            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();

            while (respuestaConsulta.next()) {
                String idRetroalimentacion = respuestaConsulta.getString(1);
                String idAcademico = respuestaConsulta.getString(2);
                String estudianteTiempo = respuestaConsulta.getString(3);
                String gustoTrabajar = respuestaConsulta.getString(4);
                String herramientaUtilizo = respuestaConsulta.getString(5);
                String sentimientoComunicarse = respuestaConsulta.getString(6);
                String idioma = respuestaConsulta.getString(7);
                String tiempoSuficiente = respuestaConsulta.getString(8);
                int horasTrabajadas = respuestaConsulta.getInt(9);
                String disponibilidadPar = respuestaConsulta.getString(10);
                String sentimientoTrabajar = respuestaConsulta.getString(11);
                String razonSentimiento = respuestaConsulta.getString(12);
                String recomendaria = respuestaConsulta.getString(13);
                String interesCultura = respuestaConsulta.getString(14);
                String idColaboración = respuestaConsulta.getString(15);

                RetroalimentacionAcademico objetoAporta = new RetroalimentacionAcademico();
                objetoAporta.setIdAcademico(idAcademico);
                objetoAporta.setEstudianteConSuficienteTiempoParaActividades(estudianteTiempo);
                objetoAporta.setIdRetroalimentacion(idRetroalimentacion);
                objetoAporta.setLeGustoTrabajarEnElCurso(gustoTrabajar);
                objetoAporta.setHerramientaQueUtilizo(herramientaUtilizo);
                objetoAporta.setSentimientoAlComunicarse(sentimientoComunicarse);
                objetoAporta.setTiempoSuficiente(tiempoSuficiente);
                objetoAporta.setHorasTrabajadas(horasTrabajadas);
                objetoAporta.setDisponibilidadParaElParInternacional(disponibilidadPar);
                objetoAporta.setSentimientoAlTrabajar(sentimientoTrabajar);
                objetoAporta.setRazonDeSentimientoAlTrabajar(razonSentimiento);
                objetoAporta.setRecomendariaCurso(recomendaria);
                objetoAporta.setInteresEnCulturaExtranjera(interesCultura);
                objetoAporta.setIdioma(idioma);
                objetoAporta.setIdColaboracion(idColaboración);

                listaRetroalimentacionAcademico.add(objetoAporta);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionAcademicoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaRetroalimentacionAcademico;
    }

}
