package mx.fei.coilvic.unit.Test.PropuestaDeColaboracionDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.claseImplementa.IPropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
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
public class RegistroPropuestaDeColaboracionTest {

    private static IPropuestaDeColaboracionDAO PROPUESTA_DAO;
    private static PropuestaDeColaboracion propuestaParaPruebas;
    private static PropuestaDeColaboracion auxiliarPropuestaParaPruebas;

    private static final String DEFAULT_IDPROPUESTA = "PR2324001";
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
    private static final String DEFAULT_ESTADO = "En espera de aprobacion";
    private static final int DEFAULT_NOALUMNOS = 14;

    private static final String DEFAULT_AUXILIAR_IDPROPUESTA = "AUXPR2324001";
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
    private static final String DEFAULT_AUXILIAR_ESTADO = "En espera de aprobacion auxiliar";
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
        auxiliarPropuestaParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO);
        auxiliarPropuestaParaPruebas.setNoAlumnos(DEFAULT_AUXILIAR_NOALUMNOS);

        try {
            ACADEMICO_DAO.registrarAcademico(auxiliarAcademicoParaPruebas);
            PROPUESTA_DAO.registrarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPropuestaDeColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeAll
    public static void configuracionAcademico(){
        ACADEMICO_DAO = new AcademicoDAO();
        academicoParaPruebas = Academico.getNuevaInstancia();
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);   
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);   
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOALUMNOS);
        try {
            ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroPropuestaDeColaboracionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.archivarAcademico(academicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroPropuestaDeColaboracionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @BeforeEach
    public void configuracionUnidad() {
        propuestaParaPruebas = PropuestaDeColaboracion.getNuevaInstancia();    
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
        propuestaParaPruebas.setEstado(DEFAULT_ESTADO);
        propuestaParaPruebas.setNoAlumnos(DEFAULT_NOALUMNOS);
    }

    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            PROPUESTA_DAO.archivarPropuestaDeColaboracion(propuestaParaPruebas.getIdPropuesta());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroPropuestaDeColaboracionTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void testRegistrarPropuesataDeColaboracionExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = PROPUESTA_DAO.registrarPropuestaDeColaboracion(propuestaParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPropuestaDeColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }

    @Test
    public void testRegistrarPropuesatDeColaboracionIDDuplicadoFallido() {
        int idRegistro = -1;
        try {
            propuestaParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
            idRegistro = PROPUESTA_DAO.registrarPropuestaDeColaboracion(propuestaParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroPropuestaDeColaboracionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(idRegistro > 0);
    }

}
