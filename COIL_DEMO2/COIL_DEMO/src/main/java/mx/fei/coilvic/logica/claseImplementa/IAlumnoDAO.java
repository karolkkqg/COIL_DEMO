
package mx.fei.coilvic.logica.claseImplementa;

import mx.fei.coilvic.logica.clasedominio.Alumno;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author nmh14
 */
public interface IAlumnoDAO {
    public int registrarAlumno (Alumno estudiante) throws SQLException;
    public int archivarAlumno (String idAlumno) throws SQLException;
    public ArrayList<Alumno> consultarTotalDeAlumno () throws SQLException;
    public ArrayList<Alumno> consultarPorIdDeAlumno (String idAlumno) throws SQLException;
    public ArrayList<Alumno> consultarPorMatriculaDeAlumno (String matricula) throws SQLException;
    //Consultar a los extranjeros
    //consultar a los de la uv
}
