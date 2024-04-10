package mx.fei.coilvic.unit.Test.RetroalimentacionDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionDAO;
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseImplementa.IRetroalimentacionDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.RetroalimentacionDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;
import mx.fei.coilvic.logica.clasedominio.Retroalimentacion;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nmh14
 */
public class ConsultaTotalRetroalimentacionTest {
    
    private static IRetroalimentacionDAO RETROALIMENTACION_DAO;
    private static Retroalimentacion auxiliarRetroaliemntacioParaPruebas;

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
    private static Colaboracion auxiliarColaboracionParaPruebas;

    private static final String DEFAULT_AUXILIAR_IDACOLABORACION = "EX2324000";
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
            Logger.getLogger(ConsultaTotalRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas.getIdPropuesta());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
            RETROALIMENTACION_DAO.archivarRetroalimentacion(auxiliarRetroaliemntacioParaPruebas.getIdRetroalimentacion());
        } catch (SQLException excepcion) {
            Logger.getLogger(ConsultaTotalRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testConsultaTotalRetroalimentacionExitoso() {
         ArrayList<Retroalimentacion> listaResultado= new ArrayList<>();;
        try {
            listaResultado = RETROALIMENTACION_DAO.consultarTotalRetroalimentacion();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaTotalRetroalimentacionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(!listaResultado.isEmpty());
    }
}
