package mx.fei.coilvic.unit.Test.ColaboracionAlumnoDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IAlumnoDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionAlumnoDAO;
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.AlumnoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionAlumnoDAO;
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
public class RegistroColaboracionAlumnoTest {

    private static IColaboracionAlumnoDAO COLABORACIONALUMNO_DAO;
    private static ColaboracionAlumno colaboracionAlumnoParaPruebas;
    private static ColaboracionAlumno auxiliarColaboracionAlumnoParaPruebas;

    private static final String DEFAULT_IDCOLABORACION = "CN2324001";
    private static final String DEFAULT_IDALUMNO = "anonimo94";

    private static final String DEFAULT_AUXILIAR_IDCOLABORACION = "CN2324001";
    private static final String DEFAULT_AUXILIAR_IDALUMNO = "anonimo94";

    private static IColaboracionDAO COLABORACION_DAO;
    private static Colaboracion colaboracionParaPruebas;
    private static Colaboracion auxiliarColaboracionParaPruebas;

    private static final String DEFAULT_IDPROPUESTA = "anonimo94";
    private static final String DEFAULT_ESTADO_COLABORACION = "Abierto";

    private static final String DEFAULT_AUXILIAR_IDPROPUESTA = "anonimo94Auxiliar";
    private static final String DEFAULT_AUXILIAR_ESTADO = "Abierto";

    private static IPropuestaDeColaboracionDAO PROPUESTA_DAO;
    private static PropuestaDeColaboracion propuestaParaPruebas;
    private static PropuestaDeColaboracion auxiliarPropuestaParaPruebas;

    private static final String DEFAULT_IDACADEMICO = "UV2324000";
    private static final String DEFAULT_NOMBRECURSO = "nombre ejemplo";
    private static final String DEFAULT_DISCIPLINA = "disciplina ejemplo";
    private static final String DEFAULT_TIPODECOLABORACION = "coil";
    private static final String DEFAULT_OBJETIVOGENERAL = "objetivo ejemplo";
    private static final String DEFAULT_TEMASDEINTERES = "temas ejemplo";
    private static final String DEFAULT_PERIODO = "2023-2024";
    private static final String DEFAULT_PERFILESTUDIANTES = "perfil ejemplo";
    private static final String DEFAULT_IDIOMA = "idioma ejemplo";
    private static final String DEFAULT_INFORMACIONADICIONAL = "informacion ejemplo";
    private static final String DEFAULT_ESTADO_PROPUESTA = "En espera de aprobacion";
    private static final int DEFAULT_NOALUMNOS = 14;

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
    private static Academico academicoParaPruebas;
    private static Academico auxiliarAcademicoParaPruebas;

    private static final String DEFAULT_NOMBRECOMPLETO = "anonimo94";
    private static final String DEFAULT_CORREO = "anonimo94@ejemplo.com";

    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "anonimoAuxiliar94";
    private static final String DEFAULT_AUXILIAR_CORREO = "anonimoAuxiliar94@ejemplo.com";

    private static IAlumnoDAO ALUMNO_DAO;
    private static Alumno alumnoParaPruebas;
    private static Alumno auxiliarAlumnoParaPruebas;

    private static final String DEFAULT_NOMBREALUMNO = "Anonimo94";
    private static final String DEFAULT_CORREOALUMNO = "Anonimo94@ejemplo.com";
    private static final String DEFAULT_AREA_ACADEMICA = "Area ejemplo";
    private static final String DEFAULT_MATRICULA = "sz22000000";

    private static final String DEFAULT_AUXILIAR_NOMBREALUMNO = "Auxliar anonimo94";
    private static final String DEFAULT_AUXILIAR_CORREOALUMNO = "auxliarAnonimo94@ejemplo.com";
    private static final String DEFAULT_AUXILIAR_AREA_ACADEMICA = "Area ejemplo auxiliar";
    private static final String DEFAULT_AUXILIAR_MATRICULA = "sz22000001";

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
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuracionAcademico() {
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOALUMNOS);
        try {
            ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuracionAlumno() {
        alumnoParaPruebas.setIdAlumno(DEFAULT_IDALUMNO);
        alumnoParaPruebas.setNombreAlumno(DEFAULT_NOMBREALUMNO);
        alumnoParaPruebas.setCorreo(DEFAULT_CORREOALUMNO);
        alumnoParaPruebas.setMatricula(DEFAULT_MATRICULA);
        alumnoParaPruebas.setAreaAcademica(DEFAULT_AREA_ACADEMICA);
        try {
            ALUMNO_DAO.registrarAlumno(alumnoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuracionPropuesta() {
        propuestaParaPruebas.setIdPropuesta(DEFAULT_IDPROPUESTA);
        propuestaParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        propuestaParaPruebas.setNombreCurso(DEFAULT_NOMBRECURSO);
        propuestaParaPruebas.setDisciplina(DEFAULT_DISCIPLINA);
        propuestaParaPruebas.setTipoDeColaboracion(DEFAULT_TIPODECOLABORACION);
        propuestaParaPruebas.setObjetivoGeneral(DEFAULT_OBJETIVOGENERAL);
        propuestaParaPruebas.setTemasDeInteres(DEFAULT_TEMASDEINTERES);
        propuestaParaPruebas.setPeriodo(DEFAULT_PERIODO);
        propuestaParaPruebas.setPerfilEstudiantes(DEFAULT_PERFILESTUDIANTES);
        propuestaParaPruebas.setIdioma(DEFAULT_IDIOMA);
        propuestaParaPruebas.setInformacionAdicional(DEFAULT_INFORMACIONADICIONAL);
        propuestaParaPruebas.setEstado(DEFAULT_ESTADO_PROPUESTA);
        propuestaParaPruebas.setNoAlumnos(DEFAULT_NOALUMNOS);
        try {
            PROPUESTA_DAO.registrarPropuestaDeColaboracion(propuestaParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuracionColaboracion() {
        colaboracionParaPruebas.setIdColaboracion(DEFAULT_IDCOLABORACION);
        colaboracionParaPruebas.setIdPropuesta(DEFAULT_IDPROPUESTA);
        colaboracionParaPruebas.setEstado(DEFAULT_ESTADO_COLABORACION);
        try {
            COLABORACION_DAO.registrarColaboracion(colaboracionParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @BeforeEach
    public void configuracionUnidad() {
        colaboracionAlumnoParaPruebas.setIdColaboracion(DEFAULT_IDCOLABORACION);
        colaboracionAlumnoParaPruebas.setIdAlumno(DEFAULT_IDALUMNO);
    }

    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
          COLABORACIONALUMNO_DAO.archivarColaboracionAlumno(DEFAULT_IDCOLABORACION);
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void testRegistroColaboracionAlumnoExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = COLABORACIONALUMNO_DAO.registrarColaboracionAlumno(colaboracionAlumnoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAlumnoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }
}
