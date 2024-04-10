
package mx.fei.coilvic.Prueba.unidad.AcademicoDAO;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import mx.fei.coilvic.logica.claseImplementa.IAcademicoDAO;
import mx.fei.coilvic.logica.clasedominio.Academico;
import mx.fei.coilvic.logica.claseconcreta.AcademicoDAO;

/**
 *
 * @author nmh14
 */
public class AcademicoRegistroTest {
    
    private static IAcademicoDAO ACADEMICO_DAO;
    private static Academico academicoParaPruebas;
    private static Academico auxiliarAcademicoParaPruebas;

    private static final String DEFAULT_IDACADEMICO = "UV2324000";
    private static final String DEFAULT_NOMBRECOMPLETO = "anonimo94";
    private static final String DEFAULT_CORREO = "anonimo94@ejemplo.com";
    private static final int DEFAULT_NOESTDIAINTES = 14;
    
    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "EX2324400";
    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "anonimoAuxiliar94";
    private static final String DEFAULT_AUXILIAR_CORREO = "anonimoAuxiliar94@ejemplo.com";
    private static final int DEFAULT_AUXILIAR_NOESTDIAINTES = 15;
    
    @BeforeAll
    public static void configuracionGeneral () {
        ACADEMICO_DAO = new AcademicoDAO();
        auxiliarAcademicoParaPruebas = Academico.getNuevaInstancia();
        auxiliarAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoParaPruebas.setNombreCompleto(DEFAULT_AUXILIAR_NOMBRECOMPLETO);
        auxiliarAcademicoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO);
        auxiliarAcademicoParaPruebas.setNoEstudiantes(DEFAULT_AUXILIAR_NOESTDIAINTES);
        try {
            ACADEMICO_DAO.registrarAcademico(auxiliarAcademicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @BeforeEach
    public void configuracionUnidad() {
        academicoParaPruebas = new Academico();
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRECOMPLETO);   
        academicoParaPruebas.setCorreo(DEFAULT_CORREO);   
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NOESTDIAINTES);   
    }
    
    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            ACADEMICO_DAO.archivarAcademico(academicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testRegistrarAcademicoExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }
    
    @Test
    public void testRegistrarAcademicoIdDuplicadoFallido() {
        int idRegistro = -1;
        try {
            academicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
            idRegistro = ACADEMICO_DAO.registrarAcademico(academicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(idRegistro > 0);
    }
    
}
