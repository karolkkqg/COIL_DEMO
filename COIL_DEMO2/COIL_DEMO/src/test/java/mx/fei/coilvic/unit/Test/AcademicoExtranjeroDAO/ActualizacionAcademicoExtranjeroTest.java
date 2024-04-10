package mx.fei.coilvic.unit.Test.AcademicoExtranjeroDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoExtranjeroDAO;
import mx.fei.coilvic.logica.claseImplementa.IRepresentanteInstitucionalDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.AcademicoExtranjeroDAO;
import mx.fei.coilvic.logica.claseconcreta.RepresentanteInstitucionalDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.clasedominio.AcademicoExtranjero;
import mx.fei.coilvic.logica.clasedominio.RepresentanteInstitucional;
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
public class ActualizacionAcademicoExtranjeroTest {
    
    private static IAcademicoExtranjeroDAO ACADEMICOEXTRANJERO_DAO;
    private static AcademicoExtranjero academicoExtranjeroParaPruebas;
    private static AcademicoExtranjero auxiliarAcademicoExtranjeroParaPruebas;
    
    private static IAcademicoDAO ACADEMICO_DAO;
    private static Academico academicoParaPruebas;
    
    private static final String DEFAULT_IDACADEMICOEXTRANJERO = "EX2324010";
    private static final String DEFAULT_IDREPRESENTANTE = "REP2324001";
    private static final String DEFAULT_PAIS = "paisAnonimo";
    
    private static final String DEFAULT_NOMBRECOMPLETO = "Anonimo94";
    private static final String DEFAULT_CORREO = "Anonimo94@ejemplo.com";
    private static final int DEFAULT_NOESTDIAINTES = 14;
    
    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "AuxiliarEX2324000";
    private static final String DEFAULT_AUXILIAR_IDREPRESENTANTE = "AuxiliarREP2324001";
    private static final String DEFAULT_AUXILIAR_PAIS = "AuxiliarpaisAnonimo";
    
    private static IRepresentanteInstitucionalDAO REPRESENTANTEINSTITUCIONAL_DAO;
    private static RepresentanteInstitucional representanteInstitucionalParaPruebas;

    private static final String DEFAULT_NOMBRE = "nombreAnonimo";
    private static final String DEFAULT_DIRECCION = "direccionAnonima";
    private static final String DEFAULT_CORREOREPRESENTANTE = "correoAnonimo";
    private static final String DEFAULT_TELEFONO = "telefonoAnonimo";
    private static final String DEFAULT_NOMBREUNIVERSIDAD = "universidadAnonima";

    
    @BeforeAll
    public static void configuracionGeneral () {
        ACADEMICOEXTRANJERO_DAO = new AcademicoExtranjeroDAO();
        auxiliarAcademicoExtranjeroParaPruebas = AcademicoExtranjero.getNuevaInstancia();
        auxiliarAcademicoExtranjeroParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoExtranjeroParaPruebas.setIdRepresentante(DEFAULT_AUXILIAR_IDREPRESENTANTE);
        auxiliarAcademicoExtranjeroParaPruebas.setPais(DEFAULT_AUXILIAR_PAIS);
    }
    
    @BeforeAll
    public static void configuaracionauxiliarAcademicoExtranjeroParaPruebasAcademico () {
        ACADEMICO_DAO = new AcademicoDAO();
        academicoParaPruebas = Academico.getNuevaInstancia();
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICOEXTRANJERO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOESTDIAINTES);
        try {
            ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @BeforeAll
    public static void configuaracionRepresentanteInstitucional () {
        REPRESENTANTEINSTITUCIONAL_DAO = new RepresentanteInstitucionalDAO();
        representanteInstitucionalParaPruebas = RepresentanteInstitucional.getNuevaInstancia();
        representanteInstitucionalParaPruebas.setIdRepresentante(DEFAULT_IDREPRESENTANTE);
        representanteInstitucionalParaPruebas.setNombre(DEFAULT_NOMBRE);
        representanteInstitucionalParaPruebas.setDireccion(DEFAULT_DIRECCION);
        representanteInstitucionalParaPruebas.setCorreo(DEFAULT_CORREOREPRESENTANTE);
        representanteInstitucionalParaPruebas.setTelefono(DEFAULT_TELEFONO);
        representanteInstitucionalParaPruebas.setNombreUniversidad(DEFAULT_NOMBREUNIVERSIDAD);

        try {
            REPRESENTANTEINSTITUCIONAL_DAO.registrarRepresentanteInstitucional(representanteInstitucionalParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(academicoParaPruebas.getIdAcademico());
            REPRESENTANTEINSTITUCIONAL_DAO.archivarRepresentanteInstitucional(representanteInstitucionalParaPruebas.getIdRepresentante());
            ACADEMICOEXTRANJERO_DAO.archivarAcademicoExtranjero(auxiliarAcademicoExtranjeroParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @BeforeEach
    public void configuracionUnidad() {
        academicoExtranjeroParaPruebas = new AcademicoExtranjero();
        academicoExtranjeroParaPruebas.setIdAcademico(DEFAULT_IDACADEMICOEXTRANJERO);
        academicoExtranjeroParaPruebas.setIdRepresentante(DEFAULT_IDREPRESENTANTE);
        academicoExtranjeroParaPruebas.setPais(DEFAULT_PAIS);
        try {
            ACADEMICOEXTRANJERO_DAO.registrarAcademicoExtranjero(academicoExtranjeroParaPruebas);
        } catch (SQLException excepcion) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            ACADEMICOEXTRANJERO_DAO.archivarAcademicoExtranjero(academicoExtranjeroParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testActualizacionAcademicoExtranjeroExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = ACADEMICOEXTRANJERO_DAO.actualizarAcademicoExtranjero(auxiliarAcademicoExtranjeroParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }
    
    @Test
    public void testActualizacionAcademicoExtranjeroMismaInformacionExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = ACADEMICOEXTRANJERO_DAO.actualizarAcademicoExtranjero(academicoExtranjeroParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(ActualizacionAcademicoExtranjeroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }
}
