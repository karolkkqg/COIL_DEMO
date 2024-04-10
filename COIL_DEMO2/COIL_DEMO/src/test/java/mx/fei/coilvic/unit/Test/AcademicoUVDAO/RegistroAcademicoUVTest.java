package mx.fei.coilvic.unit.Test.AcademicoUVDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoUVDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoUVDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.AcademicoUV;
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
public class RegistroAcademicoUVTest {

    private static IAcademicoUVDAO ACADEMICOUV_DAO;
    private static AcademicoUV academicoUVParaPruebas;
    private static AcademicoUV auxiliarAcademicoUVParaPruebas;

    private static IAcademicoDAO ACADEMICO_DAO;
    private static Academico academicoParaPruebas;
    private static Academico auxiliarAcademicoParaPruebas;

    private static final String DEFAULT_IDACADEMICOUV = "UV2324000";
    private static final String DEFAULT_NUMERODEPERSONAL = "EJANONIMO09";
    private static final String DEFAULT_TELEFONO = "000-000-000-000";
    private static final String DEFAULT_PROGRAMAEDUCATIVO = "ProgramaAnonimo";
    private static final String DEFAULT_AREAACADEMICA = "Area Anonima";
    private static final String DEFAULT_REGION = "Regio Anonima";
    private static final String DEFAULT_CATEGORIADECONTRATACION = "Categoria Anonima";
    private static final String DEFAULT_TIPODECONTRATACION = "Contratcion anonima";

    private static final String DEFAULT_AUXILIAR_IDACADEMICOUV = "AuxiliarUV2324000";
    private static final String DEFAULT_AUXILIAR_NUMERODEPERSONAL = "AuxiliarEJANONIMO09";
    private static final String DEFAULT_AUXILIAR_TELEFONO = "000-000-000-001";
    private static final String DEFAULT_AUXILIAR_PROGRAMAEDUCATIVO = "ProgramaAnonimo Auxiliar";
    private static final String DEFAULT_AUXILIAR_AREAACADEMICA = "Area Anonima Auxiliar";
    private static final String DEFAULT_AUXILIAR_REGION = "Regio Anonima Auxiliar";
    private static final String DEFAULT_AUXILIAR_CATEGORIADECONTRATACION = "Categoria Anonima Auxiliar";
    private static final String DEFAULT_AUXILIAR_TIPODECONTRATACION = "Contratcion anonima Auxiliar";

    private static final String DEFAULT_NOMBRECOMPLETO = "Anonimo94";
    private static final String DEFAULT_CORREO = "Anonimo94@ejemplo.com";
    private static final int DEFAULT_NOESTDIAINTES = 14;

    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "AuxiliarAnonimo94";
    private static final String DEFAULT_AUXILIAR_CORREO = "AuxiliarAnonimo94@ejemplo.com";
    private static final int DEFAULT_AUXILIAR_NOESTDIAINTES = 14;

    @BeforeAll
    public static void configuracionGeneral() {
        ACADEMICOUV_DAO = new AcademicoUVDAO();
        auxiliarAcademicoUVParaPruebas = AcademicoUV.getNuevaInstancia();
        auxiliarAcademicoUVParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICOUV); 
        auxiliarAcademicoUVParaPruebas.setNumeroPersonal(DEFAULT_AUXILIAR_NUMERODEPERSONAL); 
        auxiliarAcademicoUVParaPruebas.setTelefono(DEFAULT_AUXILIAR_TELEFONO); 
        auxiliarAcademicoUVParaPruebas.setProgramaEducativo(DEFAULT_AUXILIAR_PROGRAMAEDUCATIVO);
        auxiliarAcademicoUVParaPruebas.setAreaAcademica(DEFAULT_AUXILIAR_AREAACADEMICA);
        auxiliarAcademicoUVParaPruebas.setRegion(DEFAULT_AUXILIAR_REGION);
        auxiliarAcademicoUVParaPruebas.setCategoriaDeContratacion(DEFAULT_AUXILIAR_CATEGORIADECONTRATACION);
        auxiliarAcademicoUVParaPruebas.setTipoDeContratacion(DEFAULT_AUXILIAR_TIPODECONTRATACION);

        ACADEMICO_DAO = new AcademicoDAO();
        auxiliarAcademicoParaPruebas = Academico.getNuevaInstancia();
        auxiliarAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICOUV);
        auxiliarAcademicoParaPruebas.setNombreCompleto(DEFAULT_AUXILIAR_NOMBRECOMPLETO);
        auxiliarAcademicoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO);
        auxiliarAcademicoParaPruebas.setNoEstudiantes(DEFAULT_AUXILIAR_NOESTDIAINTES);

        try {
            ACADEMICO_DAO.registrarAcademico(auxiliarAcademicoParaPruebas);
            ACADEMICOUV_DAO.registrarAcademicoUV(auxiliarAcademicoUVParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuaracionAcademico() {
        ACADEMICO_DAO = new AcademicoDAO();
        academicoParaPruebas = Academico.getNuevaInstancia();
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICOUV);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOESTDIAINTES);
        try {
            ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            ACADEMICOUV_DAO.eliminarAcademicoUVPorId(auxiliarAcademicoUVParaPruebas.getIdAcademico());
            ACADEMICO_DAO.archivarAcademico(academicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @BeforeEach
    public void configuracionUnidad() {
        ACADEMICOUV_DAO = new AcademicoUVDAO();
        academicoUVParaPruebas = new AcademicoUV(); 
        academicoUVParaPruebas.setNumeroPersonal(DEFAULT_NUMERODEPERSONAL); 
        academicoUVParaPruebas.setTelefono(DEFAULT_TELEFONO); 
        academicoUVParaPruebas.setProgramaEducativo(DEFAULT_PROGRAMAEDUCATIVO);
        academicoUVParaPruebas.setAreaAcademica(DEFAULT_AREAACADEMICA);
        academicoUVParaPruebas.setRegion(DEFAULT_REGION);
        academicoUVParaPruebas.setCategoriaDeContratacion(DEFAULT_CATEGORIADECONTRATACION);
        academicoUVParaPruebas.setTipoDeContratacion(DEFAULT_TIPODECONTRATACION);
    }

    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            ACADEMICOUV_DAO.eliminarAcademicoUVPorId(academicoUVParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void testRegistrarAcademicoUVExitoso() {
        int idRegistro = -1;
        try {
            academicoUVParaPruebas.setIdAcademico(DEFAULT_IDACADEMICOUV);
            idRegistro = ACADEMICOUV_DAO.registrarAcademicoUV(academicoUVParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }

    @Test
    public void testRegistrarAcademicoUVIDDuplicadoFallido() {
        assertDoesNotThrow(() -> {
            academicoUVParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICOUV);
            int idRegistro = ACADEMICOUV_DAO.registrarAcademicoUV(academicoUVParaPruebas);
            assertTrue(idRegistro > 0, "El registro de AcademicoUV falló");
        });

    }
}
