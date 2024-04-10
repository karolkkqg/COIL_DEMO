package mx.fei.coilvic.unit.Test.AcademicoExtranjeroDAO;

import java.sql.SQLException;
import java.util.ArrayList;
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
import mx.fei.coilvic.Prueba.unidad.AcademicoDAO.AcademicoRegistroTest;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author nmh14
 */
public class ConsultaPorIDAcademicoExtranjeroTest {
    
   private static IAcademicoExtranjeroDAO ACADEMICOEXTRANJERO_DAO;
    private static AcademicoExtranjero auxiliarAcademicoExtranjeroParaPruebas;
    
    private static IAcademicoDAO ACADEMICO_DAO;
    private static Academico auxiliarAcademicoParaPruebas;

    
    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "AuxiliarEX2324000";
    private static final String DEFAULT_AUXILIAR_IDREPRESENTANTE = "AuxiliarREP2324001";
    private static final String DEFAULT_AUXILIAR_PAIS = "AuxiliarpaisAnonimo";
    
    private static final String DEFAULT_AUXILIAR_NOMBRECOMPLETO = "AuxiliarAnonimo94";
    private static final String DEFAULT_AUXILIAR_CORREO = "AuxiliarAnonimo94@ejemplo.com";
    private static final int DEFAULT_AUXILIAR_NOESTDIAINTES = 14;
    
    private static final String DEFAULT_AUXILIAR_IDACADEMICO_FALLIDO = "AuxiliarEX2324001";
    
    private static IRepresentanteInstitucionalDAO REPRESENTANTEINSTITUCIONAL_DAO;
    private static RepresentanteInstitucional auxiliarRepresentanteInstitucionalParaPruebas;

    private static final String DEFAULT_AUXILIAR_NOMBRE = "AuxiliarnombreAnonimo";
    private static final String DEFAULT_AUXILIAR_DIRECCION = "AuxiliardireccionAnonima";
    private static final String DEFAULT_AUXILIAR_CORREOREPRESENTANTE = "AuxiliarcorreoAnonimo";
    private static final String DEFAULT_AUXILIAR_TELEFONO = "AuxiliartelefonoAnonimo";
    private static final String DEFAULT_AUXILIAR_NOMBREUNIVERSIDAD = "AuxiliaruniversidadAnonima";
    
    @BeforeAll
    public static void configuracionGeneral () {
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
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            ACADEMICOEXTRANJERO_DAO.archivarAcademicoExtranjero(auxiliarAcademicoExtranjeroParaPruebas.getIdAcademico());
            ACADEMICO_DAO.archivarAcademico(auxiliarAcademicoParaPruebas.getIdAcademico());
            REPRESENTANTEINSTITUCIONAL_DAO.archivarRepresentanteInstitucional(auxiliarRepresentanteInstitucionalParaPruebas.getIdRepresentante());
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void TestConsultarPorIDAcademicoExtranjeroExitoso() {
         ArrayList<AcademicoExtranjero> listaResultado= new ArrayList<>();;
        try {
            listaResultado = ACADEMICOEXTRANJERO_DAO.consultarPorIDAcademicoExtranjero(DEFAULT_AUXILIAR_IDACADEMICO);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertTrue(!listaResultado.isEmpty());
    }
    
    @Test
    public void TestConsultarPorIDAcademicoExtranjeroInexistenFallido() {
         ArrayList<AcademicoExtranjero> listaResultado= new ArrayList<>();;
        try {
            listaResultado = ACADEMICOEXTRANJERO_DAO.consultarPorIDAcademicoExtranjero(DEFAULT_AUXILIAR_IDACADEMICO_FALLIDO);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicoRegistroTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(!listaResultado.isEmpty());
    }
}
