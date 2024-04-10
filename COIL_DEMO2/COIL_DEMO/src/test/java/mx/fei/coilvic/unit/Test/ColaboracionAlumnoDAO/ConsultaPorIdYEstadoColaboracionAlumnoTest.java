
package mx.fei.coilvic.unit.Test.ColaboracionAlumnoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IAlumnoDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionAlumnoDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionDAO;
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.AlumnoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionAlumnoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.Alumno;
import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import mx.fei.coilvic.logica.clasedominio.ColaboracionAlumno;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;
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
public class ConsultaPorIdYEstadoColaboracionAlumnoTest {
    
    private static IColaboracionAlumnoDAO COLABORACIONALUMNO_DAO;
    private static ColaboracionAlumno auxiliarColaboracionAlumnoParaPruebas;

    private static final String DEFAULT_AUXILIAR_IDCOLABORACION = "CN2324001";
    private static final String DEFAULT_AUXILIAR_IDALUMNO = "anonimo94";

    private static IColaboracionDAO COLABORACION_DAO;
    private static Colaboracion auxiliarColaboracionParaPruebas;

    private static final String DEFAULT_AUXILIAR_IDPROPUESTA = "anonimo94Auxiliar";
    private static final String DEFAULT_AUXILIAR_ESTADO = "Abierto";

    private static IPropuestaDeColaboracionDAO PROPUESTA_DAO;
    private static PropuestaDeColaboracion auxiliarPropuestaParaPruebas;

    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "EX2324000";
    private static final String DEFAULT_AUXILIAR_NOMBRECURSO = "nombre ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_DISCIPLINA = "disciplina ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_TIPODECOLABORACION = "coil auxiliar";
    private static final String DEFAULT_AUXILIAR_OBJETIVOGENERAL = "objetivo ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_TEMASDEINTERES = "temas ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_PERIODO = "2023-2024 auxiliar";
    private static final String DEFAULT_AUXILIAR_PERFILESTUDIANTES = "perfil ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_IDIOMA = "idioma ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_INFORMACIONADICIONAL = "informacion ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_ESTADO_PROPUESTA = "En espera de aprobacion auxiliar";
    private static final int DEFAULT_AUXILIAR_NOALUMNOS = 14;

    private static IAcademicoDAO ACADEMICO_DAO;
    private static Academico auxiliarAcademicoParaPruebas;

    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "anonimoAuxiliar94";
    private static final String DEFAULT_AUXILIAR_CORREO = "anonimoAuxiliar94@ejemplo.com";

    private static IAlumnoDAO ALUMNO_DAO;
    private static Alumno auxiliarAlumnoParaPruebas;

    private static final String DEFAULT_AUXILIAR_NOMBREALUMNO = "Auxliar anonimo94";
    private static final String DEFAULT_AUXILIAR_CORREOALUMNO = "auxliarAnonimo94@ejemplo.com";
    private static final String DEFAULT_AUXILIAR_AREA_ACADEMICA = "Area ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_MATRICULA = "sz22000001";

    private static final String DEFAULT_AUXILIAR_IDCOLABORACION_INEXISTENTE = "CN2324000";
    private static final String DEFAULT_AUXILIAR_IDALUMNO_INEXISTENTE = "anonimo94Auxiliar";

    @BeforeAll
    public static void configuracionGeneral() {

        COLABORACION_DAO = new ColaboracionDAO();
        auxiliarColaboracionParaPruebas = Colaboracion.getNuevaInstancia();
        auxiliarColaboracionParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
        auxiliarColaboracionParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
        auxiliarColaboracionParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO);

        COLABORACIONALUMNO_DAO = new ColaboracionAlumnoDAO();
        auxiliarColaboracionAlumnoParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
        auxiliarColaboracionAlumnoParaPruebas.setIdAlumno(DEFAULT_AUXILIAR_IDALUMNO);

        ACADEMICO_DAO = new AcademicoDAO();
        auxiliarAcademicoParaPruebas = Academico.getNuevaInstancia();
        auxiliarAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoParaPruebas.setNombreCompleto(DEFAULT_AUXILIAR_NOMBRECOMPLETO);
        auxiliarAcademicoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO);
        auxiliarAcademicoParaPruebas.setNoEstudiantes(DEFAULT_AUXILIAR_NOALUMNOS);

        ALUMNO_DAO = new AlumnoDAO();
        auxiliarAlumnoParaPruebas = Alumno.getNuevaInstancia();
        auxiliarAlumnoParaPruebas.setIdAlumno(DEFAULT_AUXILIAR_IDALUMNO);
        auxiliarAlumnoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREOALUMNO);
        auxiliarAlumnoParaPruebas.setNombreAlumno(DEFAULT_AUXILIAR_NOMBREALUMNO);
        auxiliarAlumnoParaPruebas.setMatricula(DEFAULT_AUXILIAR_MATRICULA);
        auxiliarAlumnoParaPruebas.setAreaAcademica(DEFAULT_AUXILIAR_AREA_ACADEMICA);

        PROPUESTA_DAO = new PropuestaDeColaboracionDAO();
        auxiliarPropuestaParaPruebas = PropuestaDeColaboracion.getNuevaInstancia();
        auxiliarPropuestaParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
        auxiliarPropuestaParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarPropuestaParaPruebas.setNombreCurso(DEFAULT_AUXILIAR_NOMBRECURSO);
        auxiliarPropuestaParaPruebas.setDisciplina(DEFAULT_AUXILIAR_DISCIPLINA);
        auxiliarPropuestaParaPruebas.setTipoDeColaboracion(DEFAULT_AUXILIAR_TIPODECOLABORACION);
        auxiliarPropuestaParaPruebas.setObjetivoGeneral(DEFAULT_AUXILIAR_OBJETIVOGENERAL);
        auxiliarPropuestaParaPruebas.setTemasDeInteres(DEFAULT_AUXILIAR_TEMASDEINTERES);
        auxiliarPropuestaParaPruebas.setPeriodo(DEFAULT_AUXILIAR_PERIODO);
        auxiliarPropuestaParaPruebas.setPerfilEstudiantes(DEFAULT_AUXILIAR_PERFILESTUDIANTES);
        auxiliarPropuestaParaPruebas.setIdioma(DEFAULT_AUXILIAR_IDIOMA);
        auxiliarPropuestaParaPruebas.setInformacionAdicional(DEFAULT_AUXILIAR_INFORMACIONADICIONAL);
        auxiliarPropuestaParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO_PROPUESTA);
        auxiliarPropuestaParaPruebas.setNoAlumnos(DEFAULT_AUXILIAR_NOALUMNOS);

        try {
            ACADEMICO_DAO.registrarAcademico(auxiliarAcademicoParaPruebas);
            ALUMNO_DAO.registrarAlumno(auxiliarAlumnoParaPruebas);
            PROPUESTA_DAO.registrarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas);
            COLABORACION_DAO.registrarColaboracion(auxiliarColaboracionParaPruebas);
            COLABORACIONALUMNO_DAO.registrarColaboracionAlumno(auxiliarColaboracionAlumnoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPorIdYEstadoColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            ALUMNO_DAO.archivarAlumno(auxiliarAlumnoParaPruebas.getIdAlumno());
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas.getIdPropuesta());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
            COLABORACIONALUMNO_DAO.archivarColaboracionAlumno(auxiliarColaboracionAlumnoParaPruebas.getIdAlumno());
        } catch (SQLException excepcion) {
            Logger.getLogger(ConsultaPorIdYEstadoColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void TestConsultaPorIdYEstadoColaboracionAlumnoExitoso() {
        ArrayList<ColaboracionAlumno> listaResultado = new ArrayList<>();
        try {
            listaResultado = COLABORACIONALUMNO_DAO.consultarPorIdYEstadoColaboracionAlumno(DEFAULT_AUXILIAR_IDCOLABORACION, DEFAULT_AUXILIAR_ESTADO);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPorIdYEstadoColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(!listaResultado.isEmpty());
    }

    @Test
    public void TestConsultaPorIdInexistenteYEstadoColaboracionAlumnoTestFallido() {
        ArrayList<ColaboracionAlumno> listaResultado = new ArrayList<>();
        try {
            listaResultado = COLABORACIONALUMNO_DAO.consultarPorIdYEstadoColaboracionAlumno
        (DEFAULT_AUXILIAR_IDCOLABORACION_INEXISTENTE, DEFAULT_AUXILIAR_ESTADO);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPorIdYEstadoColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(!listaResultado.isEmpty());
    }
    
    @Test
    public void TestConsultaPorIdYEstadoInexistenteColaboracionAlumnoTestFallido() {
        ArrayList<ColaboracionAlumno> listaResultado = new ArrayList<>();
        try {
            listaResultado = COLABORACIONALUMNO_DAO.consultarPorIdYEstadoColaboracionAlumno
        (DEFAULT_AUXILIAR_IDCOLABORACION, DEFAULT_AUXILIAR_IDALUMNO_INEXISTENTE);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaPorIdYEstadoColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(!listaResultado.isEmpty());
    }
}
