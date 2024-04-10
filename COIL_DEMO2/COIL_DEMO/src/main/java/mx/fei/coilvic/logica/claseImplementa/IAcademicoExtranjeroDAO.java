
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.AcademicoExtranjero;
/**
 *
 * @author nmh14
 */
public interface IAcademicoExtranjeroDAO {
    public int registrarAcademicoExtranjero(AcademicoExtranjero academico) throws SQLException;
    public int archivarAcademicoExtranjero(String idAcademico) throws SQLException;
    public ArrayList<AcademicoExtranjero> consultarTotalAcademicoExtranjero() throws SQLException;
    public ArrayList<AcademicoExtranjero> consultarPorIDAcademicoExtranjero(String idAcademico) throws SQLException;
    public ArrayList<AcademicoExtranjero> consultarPorNombreYRepresentanteAcademicoExtranjero(String nombreCompleto, String idAcademico) throws SQLException;
    public int actualizarAcademicoExtranjero(AcademicoExtranjero academico) throws SQLException;
}
