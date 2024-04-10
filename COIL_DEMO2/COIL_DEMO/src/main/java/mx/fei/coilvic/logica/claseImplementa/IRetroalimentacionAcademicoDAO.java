
package mx.fei.coilvic.logica.claseImplementa;

import mx.fei.coilvic.logica.clasedominio.RetroalimentacionAcademico;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nmh14
 */
public interface IRetroalimentacionAcademicoDAO {
    
    public int registrarRetroalimentacionAcademico(RetroalimentacionAcademico feedbackAcademico) throws SQLException;
    public int archivarRetroalimentacionAcademico(String idRetroalimentacionAcademico) throws SQLException;
    public ArrayList<RetroalimentacionAcademico> consultarTotalRetroalimentacionAcademico() throws SQLException;
}
