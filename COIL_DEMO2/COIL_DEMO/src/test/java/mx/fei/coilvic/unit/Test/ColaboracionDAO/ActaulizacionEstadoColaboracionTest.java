package mx.fei.coilvic.unit.Test.ColaboracionDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IColaboracionDAO;
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nmh14
 */
public class ActaulizacionEstadoColaboracionTest {

    private static IColaboracionDAO COLABORACION_DAO;
    private static Colaboracion auxiliarColaboracionParaPruebas;

    private static final String DEFAULT_AUXILIAR_IDACOLABORACION = "EX2324001";
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

    private static final String DEFAULT_ACTAULIZACION_ESTADO = "Cerrada";
    private static final String DEFAULT_IDCOLABORACION_INEXISTENTE = "idFallido";

    @BeforeAll
    public static void configuracionGeneral() {

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
        } catch (SQLException ex) {
            Logger.getLogger(ActaulizacionEstadoColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas.getIdPropuesta());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
        } catch (SQLException excepcion) {
            Logger.getLogger(ActaulizacionEstadoColaboracionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void testActaulizacionEstadoColaboracionDiferenteInformacionExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = COLABORACION_DAO.actaulizarEstadoColaboracion(DEFAULT_AUXILIAR_IDACOLABORACION, DEFAULT_ACTAULIZACION_ESTADO);
        } catch (SQLException ex) {
            Logger.getLogger(ActaulizacionEstadoColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(idRegistro > 0);
    }
    
    @Test
    public void testActaulizacionEstadoColaboracionMismaInformacionExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = COLABORACION_DAO.actaulizarEstadoColaboracion(DEFAULT_AUXILIAR_IDACOLABORACION, DEFAULT_AUXILIAR_ESTADO);
        } catch (SQLException ex) {
            Logger.getLogger(ActaulizacionEstadoColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(idRegistro > 0);
    }
    
    @Test
    public void testActaulizacionEstadoColaboracionIDInexistenteFallido() {
        int idRegistro = -1;
        try {
            idRegistro = COLABORACION_DAO.actaulizarEstadoColaboracion(DEFAULT_IDCOLABORACION_INEXISTENTE, DEFAULT_ACTAULIZACION_ESTADO);
        } catch (SQLException ex) {
            Logger.getLogger(ActaulizacionEstadoColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(idRegistro > 0);
    }
}
