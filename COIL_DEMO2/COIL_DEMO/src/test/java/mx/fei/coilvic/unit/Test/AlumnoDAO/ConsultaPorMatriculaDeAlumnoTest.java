package mx.fei.coilvic.unit.Test.AlumnoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAlumnoDAO;
import mx.fei.coilvic.logica.claseconcreta.AlumnoDAO;
import mx.fei.coilvic.logica.clasedominio.Alumno;
import mx.fei.coilvic.Prueba.unidad.AcademicoDAO.AcademicoRegistroTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nmh14
 */
public class ConsultaPorMatriculaDeAlumnoTest {

    private static IAlumnoDAO ALUMNO_DAO;
    private static Alumno auxiliarAlumnoParaPruebas;

    private static final String DEFAULT_AUXILIAR_IDALUMNO = "AuxliarAUV2324000";
    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "Auxliar anonimo94";
    private static final String DEFAULT_AUXILIAR_CORREO = "auxliarAnonimo94@ejemplo.com";
    private static final String DEFAULT_AUXILIAR_AREA_ACADEMICA = "Area ejemplo";
    private static final String DEFAULT_AUXILIAR_MATRICULA = "sz22000000";

    private static final String DEFAULT_AUXILIAR_MATRICULA_FALLIDO = "sz22000001";

    @BeforeAll
    public static void configuracionGeneral() {
        ALUMNO_DAO = new AlumnoDAO();
        auxiliarAlumnoParaPruebas = Alumno.getNuevaInstancia();
        auxiliarAlumnoParaPruebas.setIdAlumno(DEFAULT_AUXILIAR_IDALUMNO);
        auxiliarAlumnoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO);
        auxiliarAlumnoParaPruebas.setNombreAlumno(DEFAULT_AUXILIAR_NOMBRECOMPLETO);
        auxiliarAlumnoParaPruebas.setMatricula(DEFAULT_AUXILIAR_MATRICULA);
        auxiliarAlumnoParaPruebas.setAreaAcademica(DEFAULT_AUXILIAR_AREA_ACADEMICA);
        try {
            ALUMNO_DAO.registrarAlumno(auxiliarAlumnoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ALUMNO_DAO.archivarAlumno(auxiliarAlumnoParaPruebas.getIdAlumno());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void TestConsultaPorMatriculaDeAlumnoExitoso() {
        ArrayList<Alumno> listaResultado = new ArrayList<>();;
        try {
            listaResultado = ALUMNO_DAO.consultarPorMatriculaDeAlumno(DEFAULT_AUXILIAR_MATRICULA);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(!listaResultado.isEmpty());
    }

    @Test
    public void TestConsultaPorMatriculaDeAlumnoInexisteFallido() {
        ArrayList<Alumno> listaResultado = new ArrayList<>();;
        try {
            listaResultado = ALUMNO_DAO.consultarPorMatriculaDeAlumno(DEFAULT_AUXILIAR_MATRICULA_FALLIDO);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(!listaResultado.isEmpty());
    }
}
