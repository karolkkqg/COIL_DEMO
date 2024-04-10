package mx.fei.coilvic.unit.Test.AcademicoExtranjeroDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoExtranjeroDAO;
import mx.fei.coilvic.logica.claseImplementa.IRepresentanteInstitucionalDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoExtranjeroDAO;
import mx.fei.coilvic.logica.claseconcreta.RepresentanteInstitucionalDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.AcademicoExtranjero;
import mx.fei.coilvic.logica.clasedominio.RepresentanteInstitucional;

/**
 *
 * @author nmh14
 */
public class RegistroAcademicoExtranjeroTest {

    private static IAcademicoExtranjeroDAO ACADEMICOEXTRANJERO_DAO;
    private static AcademicoExtranjero academicoExtranjeroParaPruebas;
    private static AcademicoExtranjero auxiliarAcademicoExtranjeroParaPruebas;

    private static IAcademicoDAO ACADEMICO_DAO;
    private static Academico academicoParaPruebas;
    private static Academico auxiliarAcademicoParaPruebas;

    private static final String DEFAULT_IDACADEMICOEXTRANJERO = "EX2324000";
    private static final String DEFAULT_IDREPRESENTANTE = "REP2324001";
    private static final String DEFAULT_PAIS = "paisAnonimo";

    private static final String DEFAULT_NOMBRECOMPLETO = "Anonimo94";
    private static final String DEFAULT_CORREO = "Anonimo94@ejemplo.com";
    private static final int DEFAULT_NOESTDIAINTES = 14;

    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "AuxiliarEX2324000";
    private static final String DEFAULT_AUXILIAR_IDREPRESENTANTE = "AuxiliarREP2324001";
    private static final String DEFAULT_AUXILIAR_PAIS = "AuxiliarpaisAnonimo";

    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "AuxiliarAnonimo94";
    private static final String DEFAULT_AUXILIAR_CORREO = "AuxiliarAnonimo94@ejemplo.com";
    private static final int DEFAULT_AUXILIAR_NOESTDIAINTES = 14;

    private static IRepresentanteInstitucionalDAO REPRESENTANTEINSTITUCIONAL_DAO;
    private static RepresentanteInstitucional representanteInstitucionalParaPruebas;
    private static RepresentanteInstitucional auxiliarRepresentanteInstitucionalParaPruebas;

    private static final String DEFAULT_NOMBRE = "nombreAnonimo";
    private static final String DEFAULT_DIRECCION = "direccionAnonima";
    private static final String DEFAULT_CORREOREPRESENTANTE = "correoAnonimo";
    private static final String DEFAULT_TELEFONO = "telefonoAnonimo";
    private static final String DEFAULT_NOMBREUNIVERSIDAD = "universidadAnonima";

    private static final String DEFAULT_AUXILIAR_NOMBRE = "AuxiliarnombreAnonimo";
    private static final String DEFAULT_AUXILIAR_DIRECCION = "AuxiliardireccionAnonima";
    private static final String DEFAULT_AUXILIAR_CORREOREPRESENTANTE = "AuxiliarcorreoAnonimo";
    private static final String DEFAULT_AUXILIAR_TELEFONO = "AuxiliartelefonoAnonimo";
    private static final String DEFAULT_AUXILIAR_NOMBREUNIVERSIDAD = "AuxiliaruniversidadAnonima";

    @BeforeAll
    public static void configuracionGeneral() {
        ACADEMICOEXTRANJERO_DAO = new AcademicoExtranjeroDAO();
        auxiliarAcademicoExtranjeroParaPruebas = AcademicoExtranjero.getNuevaInstancia();
        auxiliarAcademicoExtranjeroParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoExtranjeroParaPruebas.setIdRepresentante(DEFAULT_AUXILIAR_IDREPRESENTANTE);
        auxiliarAcademicoExtranjeroParaPruebas.setPais(DEFAULT_AUXILIAR_PAIS);

        ACADEMICO_DAO = new AcademicoDAO();
        auxiliarAcademicoParaPruebas = Academico.getNuevaInstancia();
        auxiliarAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoParaPruebas.setNombreCompleto(DEFAULT_AUXILIAR_NOMBRECOMPLETO);
        auxiliarAcademicoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO);
        auxiliarAcademicoParaPruebas.setNoEstudiantes(DEFAULT_AUXILIAR_NOESTDIAINTES);

        REPRESENTANTEINSTITUCIONAL_DAO = new RepresentanteInstitucionalDAO();
        auxiliarRepresentanteInstitucionalParaPruebas = RepresentanteInstitucional.getNuevaInstancia();
        auxiliarRepresentanteInstitucionalParaPruebas.setIdRepresentante(DEFAULT_AUXILIAR_IDREPRESENTANTE);
        auxiliarRepresentanteInstitucionalParaPruebas.setNombre(DEFAULT_AUXILIAR_NOMBRE);
        auxiliarRepresentanteInstitucionalParaPruebas.setDireccion(DEFAULT_AUXILIAR_DIRECCION);
        auxiliarRepresentanteInstitucionalParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREOREPRESENTANTE);
        auxiliarRepresentanteInstitucionalParaPruebas.setTelefono(DEFAULT_AUXILIAR_TELEFONO);
        auxiliarRepresentanteInstitucionalParaPruebas.setNombreUniversidad(DEFAULT_AUXILIAR_NOMBREUNIVERSIDAD);

        try {
            ACADEMICO_DAO.registrarAcademico(auxiliarAcademicoParaPruebas);
            REPRESENTANTEINSTITUCIONAL_DAO.registrarRepresentanteInstitucional(auxiliarRepresentanteInstitucionalParaPruebas);
            ACADEMICOEXTRANJERO_DAO.registrarAcademicoExtranjero(auxiliarAcademicoExtranjeroParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuaracionAcademico() {
        ACADEMICO_DAO = new AcademicoDAO();
        academicoParaPruebas = Academico.getNuevaInstancia();
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICOEXTRANJERO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOESTDIAINTES);
        try {
            ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @BeforeAll
    public static void configuaracionRepresentanteInstitucional() {
        REPRESENTANTEINSTITUCIONAL_DAO = new RepresentanteInstitucionalDAO();
        representanteInstitucionalParaPruebas = RepresentanteInstitucional.getNuevaInstancia();
        representanteInstitucionalParaPruebas.setIdRepresentante(DEFAULT_AUXILIAR_IDREPRESENTANTE);
        representanteInstitucionalParaPruebas.setNombre(DEFAULT_NOMBRE);
        representanteInstitucionalParaPruebas.setDireccion(DEFAULT_DIRECCION);
        representanteInstitucionalParaPruebas.setCorreo(DEFAULT_CORREOREPRESENTANTE);
        representanteInstitucionalParaPruebas.setTelefono(DEFAULT_TELEFONO);
        representanteInstitucionalParaPruebas.setNombreUniversidad(DEFAULT_NOMBREUNIVERSIDAD);

        try {
            REPRESENTANTEINSTITUCIONAL_DAO.registrarRepresentanteInstitucional(representanteInstitucionalParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICOEXTRANJERO_DAO.archivarAcademicoExtranjero(auxiliarAcademicoExtranjeroParaPruebas.getIdAcademico());
            REPRESENTANTEINSTITUCIONAL_DAO.archivarRepresentanteInstitucional(auxiliarRepresentanteInstitucionalParaPruebas.getIdRepresentante());
            REPRESENTANTEINSTITUCIONAL_DAO.archivarRepresentanteInstitucional(representanteInstitucionalParaPruebas.getIdRepresentante());
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            ACADEMICO_DAO.archivarAcademico(academicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @BeforeEach
    public void configuracionUnidad() {
        academicoExtranjeroParaPruebas = new AcademicoExtranjero();
        academicoExtranjeroParaPruebas.setIdAcademico(DEFAULT_IDACADEMICOEXTRANJERO);
        academicoExtranjeroParaPruebas.setIdRepresentante(DEFAULT_IDREPRESENTANTE);
        academicoExtranjeroParaPruebas.setPais(DEFAULT_PAIS);
    }

    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            ACADEMICOEXTRANJERO_DAO.archivarAcademicoExtranjero(academicoExtranjeroParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }

    @Test
    public void testRegistrarAcademicoExtranjeroExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = ACADEMICOEXTRANJERO_DAO.registrarAcademicoExtranjero(academicoExtranjeroParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(idRegistro > 0);
    }

    @Test
    public void testRegistrarAcademicoIDDuplicadoFallido() {
        int idRegistro = -1;
        try {
            academicoExtranjeroParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
            idRegistro = ACADEMICOEXTRANJERO_DAO.registrarAcademicoExtranjero(academicoExtranjeroParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(idRegistro > 0);
    }
}
