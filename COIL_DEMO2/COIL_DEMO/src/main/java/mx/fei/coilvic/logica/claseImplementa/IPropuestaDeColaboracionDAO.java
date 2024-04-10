
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;

/**
 *
 * @author nmh14
 */
public interface IPropuestaDeColaboracionDAO {
    public int registrarPropuestaDeColaboracion(PropuestaDeColaboracion colaboracion) throws SQLException;
    public int archivarPropuestaDeColaboracion(String id) throws SQLException;
    
}
