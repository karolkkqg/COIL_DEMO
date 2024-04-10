
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.Academico;

/**
 *
 * @author kahun
 */
public interface IAcademicoDAO {
    public int registrarAcademico(Academico academico)throws SQLException;
    public int archivarAcademico(String idAcademico)throws SQLException;
    public ArrayList<Academico> consultarTotalAcademicos()throws SQLException;
    public int actualizarAcademico(Academico academico)throws SQLException;
    
}
