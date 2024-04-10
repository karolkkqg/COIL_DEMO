package mx.fei.coilvic.unit.Test.RetroalimentacionDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.unit.Test.ColaboracionDAO.RegistroColaboracionTest;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionDAO;
import mx.fei.coilvic.logica.claseImplementa.IRetroalimentacionDAO;
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.RetroalimentacionDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import mx.fei.coilvic.logica.clasedominio.Retroalimentacion;
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
public class RegistroRetroalimentacionTest {

    private static IRetroalimentacionDAO RETROALIMENTACION_DAO;
    private static Retroalimentacion retroaliemntacioParaPruebas;
    private static Retroalimentacion auxiliarRetroaliemntacioParaPruebas;

    private static final String DEFAULT_IDRETROALIMENTACION = "RA2324001";
    private static final String DEFAULT_IDCOLABORACION = "CN2324001";
    private static final String DEFAULT_LEGUSTOTRABAJARENELCURSO = "respuesta anonima";
    private static final String DEFAULT_HERRAMIENTAQUEUTILIZO = "plataforma anonima";
    private static final String DEFAULT_SENTIMIENTOALCOMUNICARSE = "sentimiento anonimo";
    private static final String DEFAULT_IDIOMA = "idioma ejemplo";
    private static final String DEFAULT_TIEMPOSUFICIENTE = "respuesat anonima de tiempo";
    private static final int DEFAULT_HORASTRABAJADAS = 3;
    private static final String DEFAULT_DISPONIBILIDADPARAELPARINTERNACIONAL = "respuesat anonima";
    private static final String DEFAULT_SENTIMIENTOALTRABAJAR = "sentimiento de trabajo anonimo";
    private static final String DEFAULT_RAZONDESENTIMIENTOALTRABAJAR = "razon anonima";
    private static final String DEFAULT_RECOMENDARIACURSO = "recomendaciones anonimas";
    private static final String DEFAULT_INTERESENCULTURAEXTRANJERA = "interes ejemplo";

    private static final String DEFAULT_IDRETROALIMENTACION_AUXILIAR_ = "RA2324001 auxiliar";
    private static final String DEFAULT_LEGUSTOTRABAJARENELCURSO_AUXILIAR_ = "respuesta auxiliar anonima";
    private static final String DEFAULT_HERRAMIENTAQUEUTILIZO_AUXILIAR_ = "plataforma auxiliar anonima";
    private static final String DEFAULT_SENTIMIENTOALCOMUNICARSE_AUXILIAR_ = "sentimiento auxiliar anonimo";
    private static final String DEFAULT_IDIOMA_AUXILIAR_ = "idioma auxiliar ejemplo";
    private static final String DEFAULT_TIEMPOSUFICIENTE_AUXILIAR_ = "respuesat auxiliar anonima de tiempo";
    private static final int DEFAULT_HORASTRABAJADAS_AUXILIAR_ = 3;
    private static final String DEFAULT_DISPONIBILIDADPARAELPARINTERNACIONAL_AUXILIAR_ = "respuesat auxiliar anonima";
    private static final String DEFAULT_SENTIMIENTOALTRABAJAR_AUXILIAR_ = "sentimiento de trabajo auxiliar anonimo";
    private static final String DEFAULT_RAZONDESENTIMIENTOALTRABAJAR_AUXILIAR_ = "razon auxiliar anonima";
    private static final String DEFAULT_RECOMENDARIACURSO_AUXILIAR_ = "recomendaciones auxiliares anonimas";
    private static final String DEFAULT_INTERESENCULTURAEXTRANJERA_AUXILIAR_ = "interes auxiliar ejemplo";

    private static IColaboracionDAO COLABORACION_DAO;
    private static Colaboracion colaboracionParaPruebas;
    private static Colaboracion auxiliarColaboracionParaPruebas;

    private static final String DEFAULT_IDPROPUESTA = "anonimo94";
    private static final String DEFAULT_ESTADO = "Abierto";

    private static final String DEFAULT_AUXILIAR_IDACOLABORACION = "EX2324000";
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

    @BeforeAll
    public static void configuracionGeneral() {

        RETROALIMENTACION_DAO = new RetroalimentacionDAO();
        auxiliarRetroaliemntacioParaPruebas = Retroalimentacion.getNuevaInstancia();

        auxiliarRetroaliemntacioParaPruebas.setIdRetroalimentacion(DEFAULT_IDRETROALIMENTACION_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDACOLABORACION);
        auxiliarRetroaliemntacioParaPruebas.setLeGustoTrabajarEnElCurso(DEFAULT_LEGUSTOTRABAJARENELCURSO_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setHerramientaQueUtilizo(DEFAULT_HERRAMIENTAQUEUTILIZO_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setSentimientoAlComunicarse(DEFAULT_SENTIMIENTOALCOMUNICARSE_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setIdioma(DEFAULT_IDIOMA_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setTiempoSuficiente(DEFAULT_TIEMPOSUFICIENTE_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setHorasTrabajadas(DEFAULT_HORASTRABAJADAS_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setDisponibilidadParaElParInternacional(DEFAULT_DISPONIBILIDADPARAELPARINTERNACIONAL_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setSentimientoAlTrabajar(DEFAULT_SENTIMIENTOALTRABAJAR_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setRazonDeSentimientoAlTrabajar(DEFAULT_RAZONDESENTIMIENTOALTRABAJAR_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setRecomendariaCurso(DEFAULT_RECOMENDARIACURSO_AUXILIAR_);
        auxiliarRetroaliemntacioParaPruebas.setInteresEnCulturaExtranjera(DEFAULT_INTERESENCULTURAEXTRANJERA_AUXILIAR_);

        COLABORACION_DAO = new ColaboracionDAO();
        auxiliarColaboracionParaPruebas = Colaboracion.getNuevaInstancia();
        auxiliarColaboracionParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDACOLABORACION);
        auxiliarColaboracionParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
        auxiliarColaboracionParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO);

        ACADEMICO_DAO = new AcademicoDAO();
        auxiliarAcademicoParaPruebas = Academico.getNuevaInstancia();
        auxiliarAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoParaPruebas.setNombreCompleto(DEFAULT_AUXILIAR_NOMBRECOMPLETO);
        auxiliarAcademicoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO);
        auxiliarAcademicoParaPruebas.setNoEstudiantes(DEFAULT_AUXILIAR_NOALUMNOS);

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
            PROPUESTA_DAO.registrarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas);
            COLABORACION_DAO.registrarColaboracion(auxiliarColaboracionParaPruebas);
            RETROALIMENTACION_DAO.registrarRetroalimentacion(auxiliarRetroaliemntacioParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public static void configuracionAcademico() {
        academicoParaPruebas = new Academico();
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOALUMNOS);
        try {
            ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    
    public static void configuracionPropuesta() {
        propuestaParaPruebas = new PropuestaDeColaboracion();
        PROPUESTA_DAO = new PropuestaDeColaboracionDAO();
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
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    
    public static void configuracionColaboracion() {
        COLABORACION_DAO = new ColaboracionDAO();
        colaboracionParaPruebas = new Colaboracion();
        colaboracionParaPruebas.setIdColaboracion(DEFAULT_IDCOLABORACION);
        colaboracionParaPruebas.setIdPropuesta(DEFAULT_IDPROPUESTA);
        colaboracionParaPruebas.setEstado(DEFAULT_ESTADO);
        try {
            COLABORACION_DAO.registrarColaboracion(colaboracionParaPruebas);
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            RETROALIMENTACION_DAO.archivarRetroalimentacion(auxiliarRetroaliemntacioParaPruebas.getIdRetroalimentacion());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            COLABORACION_DAO.archivarColaboracion(colaboracionParaPruebas.getIdColaboracion());
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(propuestaParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.archivarAcademico(academicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @BeforeEach
    public void configuracionUnidad() {
        retroaliemntacioParaPruebas = new Retroalimentacion();
        RETROALIMENTACION_DAO = new RetroalimentacionDAO();
        retroaliemntacioParaPruebas.setIdRetroalimentacion(DEFAULT_IDRETROALIMENTACION);
        retroaliemntacioParaPruebas.setIdColaboracion(DEFAULT_IDCOLABORACION);
        retroaliemntacioParaPruebas.setLeGustoTrabajarEnElCurso(DEFAULT_LEGUSTOTRABAJARENELCURSO);
        retroaliemntacioParaPruebas.setHerramientaQueUtilizo(DEFAULT_HERRAMIENTAQUEUTILIZO);
        retroaliemntacioParaPruebas.setSentimientoAlComunicarse(DEFAULT_SENTIMIENTOALCOMUNICARSE);
        retroaliemntacioParaPruebas.setIdioma(DEFAULT_IDIOMA);
        retroaliemntacioParaPruebas.setTiempoSuficiente(DEFAULT_TIEMPOSUFICIENTE);
        retroaliemntacioParaPruebas.setHorasTrabajadas(DEFAULT_HORASTRABAJADAS);
        retroaliemntacioParaPruebas.setDisponibilidadParaElParInternacional(DEFAULT_DISPONIBILIDADPARAELPARINTERNACIONAL);
        retroaliemntacioParaPruebas.setSentimientoAlTrabajar(DEFAULT_SENTIMIENTOALTRABAJAR);
        retroaliemntacioParaPruebas.setRazonDeSentimientoAlTrabajar(DEFAULT_RAZONDESENTIMIENTOALTRABAJAR);
        retroaliemntacioParaPruebas.setRecomendariaCurso(DEFAULT_RECOMENDARIACURSO);
        retroaliemntacioParaPruebas.setInteresEnCulturaExtranjera(DEFAULT_INTERESENCULTURAEXTRANJERA);
    }
    
    @AfterEach
    public void eliminarConfiguracionUnidad () {
        try {
            RETROALIMENTACION_DAO.archivarRetroalimentacion(retroaliemntacioParaPruebas.getIdRetroalimentacion());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testRegistroRetroalimentacionExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = RETROALIMENTACION_DAO.registrarRetroalimentacion(retroaliemntacioParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(idRegistro> 0);
    }
}
