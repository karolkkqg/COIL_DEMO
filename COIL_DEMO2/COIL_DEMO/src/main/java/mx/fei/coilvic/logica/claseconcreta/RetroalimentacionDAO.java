package mx.fei.coilvic.logica.claseconcreta;

import mx.fei.coilvic.logica.clasedominio.Retroalimentacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IRetroalimentacionDAO;

/**
 *
 * @author nmh14
 */
public class RetroalimentacionDAO implements IRetroalimentacionDAO {

    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

    @Override
     public int registrarRetroalimentacion(Retroalimentacion retroalimentacion) throws SQLException {

        Connection conexion = null;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoRetroalimentacion = conexion.prepareStatement("INSERT INTO retroalimentacion VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            objetoRetroalimentacion.setString(1, retroalimentacion.getIdRetroalimentacion());
            objetoRetroalimentacion.setString(2, retroalimentacion.getIdColaboracion());
            objetoRetroalimentacion.setString(3, retroalimentacion.getLeGustoTrabajarEnElCurso());
            objetoRetroalimentacion.setString(4, retroalimentacion.getHerramientaQueUtilizo());
            objetoRetroalimentacion.setString(5, retroalimentacion.getSentimientoAlComunicarse());
            objetoRetroalimentacion.setString(6, retroalimentacion.getIdioma());
            objetoRetroalimentacion.setString(7, retroalimentacion.getTiempoSuficiente());
            objetoRetroalimentacion.setInt(8, retroalimentacion.getHorasTrabajadas());
            objetoRetroalimentacion.setString(9, retroalimentacion.getDisponibilidadParaElParInternacional());
            objetoRetroalimentacion.setString(10, retroalimentacion.getSentimientoAlTrabajar());
            objetoRetroalimentacion.setString(11, retroalimentacion.getRazonDeSentimientoAlTrabajar());
            objetoRetroalimentacion.setString(12, retroalimentacion.getRecomendariaCurso());
            objetoRetroalimentacion.setString(13, retroalimentacion.getInteresEnCulturaExtranjera());

            int filasAfectadas = objetoRetroalimentacion.executeUpdate();
            return filasAfectadas;

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return -1;
    }

    @Override
    public int archivarRetroalimentacion(String idRetroalimentacion) throws SQLException {
        
        Connection conexion = null;
        int filasObtenidas = 0;

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoRetroalimentacion = conexion.prepareStatement("DELETE FROM retroalimentacion WHERE idRetroalimentacion=?");
            objetoRetroalimentacion.setString(1, idRetroalimentacion);

            filasObtenidas = objetoRetroalimentacion.executeUpdate();

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }

    @Override
    public ArrayList<Retroalimentacion> consultarTotalRetroalimentacion() throws SQLException {
        
        Connection conexion = null;
        ArrayList<Retroalimentacion> listaRetroalimentacion = new ArrayList<>();

        String consultaMySQL = "SELECT * FROM retroaliemntacion";

        try {
            
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            
            while (respuestaConsulta.next()) {
                String idRetroalimentacion = respuestaConsulta.getString(1);
                String idColaboración = respuestaConsulta.getString(2);
                String gustoTrabajar = respuestaConsulta.getString(3);
                String herramientaUtilizo = respuestaConsulta.getString(4);
                String sentimientoComunicarse = respuestaConsulta.getString(5);
                String idioma = respuestaConsulta.getString(6);
                String tiempoSuficiente = respuestaConsulta.getString(7);
                int horasTrabajadas = respuestaConsulta.getInt(8);
                String disponibilidadPar = respuestaConsulta.getString(9);
                String sentimientoTrabajar = respuestaConsulta.getString(10);
                String razonSentimiento = respuestaConsulta.getString(11);
                String recomendaria = respuestaConsulta.getString(12);
                String interesCultura = respuestaConsulta.getString(13);

                
                Retroalimentacion objetoRetroalimentacion = new Retroalimentacion();
                objetoRetroalimentacion.setIdRetroalimentacion(idRetroalimentacion);
                objetoRetroalimentacion.setLeGustoTrabajarEnElCurso(gustoTrabajar);
                objetoRetroalimentacion.setHerramientaQueUtilizo(herramientaUtilizo);
                objetoRetroalimentacion.setSentimientoAlComunicarse(sentimientoComunicarse);
                objetoRetroalimentacion.setTiempoSuficiente(tiempoSuficiente);
                objetoRetroalimentacion.setHorasTrabajadas(horasTrabajadas);
                objetoRetroalimentacion.setDisponibilidadParaElParInternacional(disponibilidadPar);
                objetoRetroalimentacion.setSentimientoAlTrabajar(sentimientoTrabajar);
                objetoRetroalimentacion.setRazonDeSentimientoAlTrabajar(razonSentimiento);
                objetoRetroalimentacion.setRecomendariaCurso(recomendaria);
                objetoRetroalimentacion.setInteresEnCulturaExtranjera(interesCultura);
                objetoRetroalimentacion.setIdioma(idioma);
                objetoRetroalimentacion.setIdColaboracion(idColaboración);

                listaRetroalimentacion.add(objetoRetroalimentacion);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaRetroalimentacion;
    }
}
