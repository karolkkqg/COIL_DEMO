package mx.fei.coilvic.unit.Test.AlumnoDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAlumnoDAO;
import mx.fei.coilvic.logica.claseconcreta.AlumnoDAO;
import mx.fei.coilvic.logica.clasedominio.Alumno;
import mx.fei.coilvic.Prueba.unidad.AcademicoDAO.AcademicoRegistroTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nmh14
 */
public class RegistroAlumnoTest {

    private static IAlumnoDAO ALUMNO_DAO;
    private static Alumno alumnoParaPruebas;
    private static Alumno auxiliarAlumnoParaPruebas;

    private static final String DEFAULT_IDALUMNO = "AUV2324000";
    private static final String DEFAULT_NOMBRECOMPLETO = "anonimo94";
    private static final String DEFAULT_CORREO = "anonimo94@ejemplo.com";
    private static final String DEFAULT_AREA_ACADEMICA = "Area ejemplo";
    private static final String DEFAULT_MATRICULA = "sz22000000";

    private static final String DEFAULT_AUXILIAR_IDALUMNO = "AuxliarAUV2324000";
    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "Auxliar anonimo94";
    private static final String DEFAULT_AUXILIAR_CORREO = "auxliarAnonimo94@ejemplo.com";
    private static final String DEFAULT_AUXILIAR_AREA_ACADEMICA = "Area ejemplo";
    private static final String DEFAULT_AUXILIAR_MATRICULA = "sz22000000";

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

    @BeforeEach
    public void configuracionUnidad() {
        alumnoParaPruebas = Alumno.getNuevaInstancia();
        alumnoParaPruebas.setIdAlumno(DEFAULT_IDALUMNO);
        alumnoParaPruebas.setNombreAlumno(DEFAULT_NOMBRECOMPLETO);
        alumnoParaPruebas.setCorreo(DEFAULT_CORREO);
        alumnoParaPruebas.setMatricula(DEFAULT_MATRICULA);
        alumnoParaPruebas.setAreaAcademica(DEFAULT_AREA_ACADEMICA);
    }

    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            ALUMNO_DAO.archivarAlumno(alumnoParaPruebas.getIdAlumno());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void TestRegistroAlumnoExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = ALUMNO_DAO.registrarAlumno(alumnoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }

    @Test
    public void TestRegistroAlumnoMatriculaRepetidoFallido() {
        int idRegistro = -1;
        try {
            //alumnoParaPruebas.setIdAlumno(DEFAULT_AUXILIAR_MATRICULA);
            ALUMNO_DAO.registrarAlumno(alumnoParaPruebas);
            idRegistro = ALUMNO_DAO.registrarAlumno(alumnoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(idRegistro > 0);
    }
}
