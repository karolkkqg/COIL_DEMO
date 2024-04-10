
package mx.fei.coilvic.logica.claseImplementa;

import mx.fei.coilvic.logica.clasedominio.AcademicoUV;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kahun
 */
public interface IAcademicoUVDAO {
    public int registrarAcademicoUV(AcademicoUV academicoUV)throws SQLException;
    public int eliminarAcademicoUVPorId(String idacademico) throws SQLException;
    public ArrayList<AcademicoUV> consultarAcademicoUVPorId(String idacademico) throws SQLException;
    public ArrayList<AcademicoUV> consultarTotalAcademicoUV () throws SQLException;
    public ArrayList<AcademicoUV> consultarAcademicoUVNumeroDePersonal (String numeroDePersonal) throws SQLException;
    public int actualizarAcademicoUV(AcademicoUV academicoUV)throws SQLException;
}
