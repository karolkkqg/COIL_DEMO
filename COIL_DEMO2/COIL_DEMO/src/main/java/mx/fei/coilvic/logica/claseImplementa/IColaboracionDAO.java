
package mx.fei.coilvic.logica.claseImplementa;

import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nmh14
 */
public interface IColaboracionDAO {
    public int registrarColaboracion(Colaboracion colaboracion) throws SQLException;
    public int archivarColaboracion(String idColaboracion) throws SQLException;
    public ArrayList<Colaboracion> consultarTotalColaboracion() throws SQLException;
    public ArrayList<Colaboracion> consultarPorIdColaboracion(String id) throws SQLException;
    public ArrayList<Colaboracion> consultarPorEstadoColaboracion(String estado) throws SQLException;
    public int actaulizarEstadoColaboracion(String idColaboracion, String estado) throws SQLException;
}
