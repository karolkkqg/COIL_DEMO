
package mx.fei.coilvic.logica.claseImplementa;

import mx.fei.coilvic.logica.clasedominio.Retroalimentacion;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nmh14
 */
public interface IRetroalimentacionDAO {
    public int registrarRetroalimentacion(Retroalimentacion retroalimentacion) throws SQLException;
    public int archivarRetroalimentacion(String retroalimentacion) throws SQLException;
    public ArrayList<Retroalimentacion> consultarTotalRetroalimentacion() throws SQLException;
}
