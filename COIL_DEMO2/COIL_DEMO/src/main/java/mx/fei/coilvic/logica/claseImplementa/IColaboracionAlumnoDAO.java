
package mx.fei.coilvic.logica.claseImplementa;

import mx.fei.coilvic.logica.clasedominio.ColaboracionAlumno;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nmh14
 */
public interface IColaboracionAlumnoDAO {
    public int registrarColaboracionAlumno(ColaboracionAlumno alumnoColaboracion) throws SQLException;
    public int archivarColaboracionAlumno(String idColaboracion) throws SQLException;
    public ArrayList<ColaboracionAlumno> consultarPorIdAlumnoColaboracionAlumno(String idAlumno) throws SQLException;
    public ArrayList<ColaboracionAlumno> consultarPorIdColaboracionAlumno(String idColaboracion) throws SQLException;
    public ArrayList<ColaboracionAlumno> consultarPorIdYEstadoColaboracionAlumno(String idColaboracion, String estado) throws SQLException;
    //Consulta por nombre
}
