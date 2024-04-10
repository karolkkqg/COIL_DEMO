/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.Prueba.unidad.ConstanciaColaboracionAcademicoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseconcreta.AcademicoUVDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.ConstanciaColaboracionAcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.clasedominio.AcademicoUV;
import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import mx.fei.coilvic.logica.clasedominio.ConstanciaColaboracionAcademico;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author kahun
 */
public class ConsultasConstanciaColaboracionAcademicoTest {
        private static AcademicoUVDAO ACADEMICO_DAO;
    private static AcademicoUV auxiliarAcademicoParaPruebas;
    
    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "AC-01" ;
    private static final String DEFAULT_AUXILIAR_NOMBRE_COMPLETO = "NOMBRE COMPLETO";
    private static final String DEFAULT_AUXILIAR_CORREO_ACADEMICO = "CORREO@gmail.com";
    private static final int DEFAULT_AUXILIAR_NO_ESTUDIANTES = 20;
    private static final String DEFAULT_AUXILIAR_NUMERO_PERSONAL = "12345";
    private static final String DEFAULT_AUXILIAR_TELEFONO = "1234567890";
    private static final String DEFAULT_AUXILIAR_PROGRAMA_EDUCATIVO = "PROGRAMA EDUCATIVO";
    private static final String DEFAULT_AUXILIAR_AREA_ACADEMICA_ACADEMICO = "AREA ACADEMICA";
    private static final String DEFAULT_AUXILIAR_REGION = "REGION";
    private static final String DEFAULT_AUXILIAR_CATEGORIA_DE_CONTRATACION = "CATEGORIA";
    private static final String DEFAULT_AUXILIAR_TIPO_DE_CONTRATACION = "TIPO CONTRATACION";
    
    private static PropuestaDeColaboracionDAO PROPUESTA_DE_COLABORACION_DAO;
    private static PropuestaDeColaboracion auxiliarPropuestaDeColaboracionParaPruebas;
    
    private static final String DEFAULT_AUXILIAR_IDPROPUESTA = "PRCO-01";
    private static final String DEFAULT_AUXILIAR_NOMBRE_CURSO = "NOMBRE CURSO";
    private static final String DEFAULT_AUXILIAR_DISCIPLINA = "DISCIPLINA";
    private static final String DEFAULT_AUXILIAR_TIPO_DE_COLABORACION = "TIPO";
    private static final String DEFAULT_AUXILIAR_OBJETIVO_GENERAL = "OBJETIVO GENERAL";
    private static final String DEFAULT_AUXILIAR_TEMA_DE_INTERES = "TEMAS DE INTERES";
    private static final String DEFAULT_AUXILIAR_PERIODO = "PERIODO";
    private static final String DEFAULT_AUXILIAR_PERFIL_ESTUDIANTES = "PERFIL DE ESTUDIANTES";
    private static final String DEFAULT_AUXILIAR_IDIOMA = "IDIOMA";
    private static final String DEFAULT_AUXILIAR_INFORMACION_ADICIONAL = "INFORMACION ADICIONAL";
    private static final String DEFAULT_AUXILIAR_ESTADO_PROPUESTA = "ESTADO";
    
    private static ColaboracionDAO COLABORACION_DAO;
    private static Colaboracion auxiliarColaboracionParaPruebas;
    
    private static final String DEFAULT_AUXILIAR_IDCOLABORACION = "CT-01" ;
    private static final String DEFAULT_AUXILIAR_ESTADO = "CT-01" ;
    //idPropuesta
    
    private static ConstanciaColaboracionAcademicoDAO CONSTANCIA_COLABORACION_ACADEMICO_DAO;
    private static ConstanciaColaboracionAcademico auxiliarConstanciaColaboracionAcademicoParaPruebas;
    
    private static final String DEFAULT_AUXILIAR_RUTA_CONSTANCIA = "RUTA/CONSTANCIA";
    private static final String DEFAULT_AUXILIAR_NOMBRE_CONSTANCIA = "NOMBRE CONSTANCIA.pdf";
    private static final String DEFAULT_AUXILIAR_FECHA_EMISION = "FECHA EMISION";

    private static final String IDCOLABORACION_INEXISTENTE = "ID COLABORACION INEXISTENTE";
    private static final String IDACADEMICO_INEXISTENTE = "ID ACADEMICO INEXISTENTE";    
    
    @BeforeAll
    static void configuracionGeneral(){
        ACADEMICO_DAO = new AcademicoUVDAO();
        auxiliarAcademicoParaPruebas = new AcademicoUV();
        auxiliarAcademicoParaPruebas = AcademicoUV.getNuevaInstancia();
        
        auxiliarAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarAcademicoParaPruebas.setNombreCompleto(DEFAULT_AUXILIAR_NOMBRE_COMPLETO);
        auxiliarAcademicoParaPruebas.setCorreo(DEFAULT_AUXILIAR_CORREO_ACADEMICO);
        auxiliarAcademicoParaPruebas.setNoEstudiantes(DEFAULT_AUXILIAR_NO_ESTUDIANTES);
        auxiliarAcademicoParaPruebas.setNumeroPersonal(DEFAULT_AUXILIAR_NUMERO_PERSONAL);
        auxiliarAcademicoParaPruebas.setTelefono(DEFAULT_AUXILIAR_TELEFONO);
        auxiliarAcademicoParaPruebas.setProgramaEducativo(DEFAULT_AUXILIAR_PROGRAMA_EDUCATIVO);
        auxiliarAcademicoParaPruebas.setAreaAcademica(DEFAULT_AUXILIAR_AREA_ACADEMICA_ACADEMICO);
        auxiliarAcademicoParaPruebas.setRegion(DEFAULT_AUXILIAR_REGION);
        auxiliarAcademicoParaPruebas.setCategoriaDeContratacion(DEFAULT_AUXILIAR_CATEGORIA_DE_CONTRATACION);
        auxiliarAcademicoParaPruebas.setTipoDeContratacion(DEFAULT_AUXILIAR_TIPO_DE_CONTRATACION);
        
        PROPUESTA_DE_COLABORACION_DAO = new PropuestaDeColaboracionDAO();
        auxiliarPropuestaDeColaboracionParaPruebas = new PropuestaDeColaboracion();
        auxiliarPropuestaDeColaboracionParaPruebas = PropuestaDeColaboracion.getNuevaInstancia();
        
        auxiliarPropuestaDeColaboracionParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
        auxiliarPropuestaDeColaboracionParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarPropuestaDeColaboracionParaPruebas.setNombreCurso(DEFAULT_AUXILIAR_NOMBRE_CURSO);
        auxiliarPropuestaDeColaboracionParaPruebas.setDisciplina(DEFAULT_AUXILIAR_DISCIPLINA);
        auxiliarPropuestaDeColaboracionParaPruebas.setTipoDeColaboracion(DEFAULT_AUXILIAR_TIPO_DE_COLABORACION);
        auxiliarPropuestaDeColaboracionParaPruebas.setObjetivoGeneral(DEFAULT_AUXILIAR_OBJETIVO_GENERAL);
        auxiliarPropuestaDeColaboracionParaPruebas.setTemasDeInteres(DEFAULT_AUXILIAR_TEMA_DE_INTERES);
        auxiliarPropuestaDeColaboracionParaPruebas.setPeriodo(DEFAULT_AUXILIAR_PERIODO);
        auxiliarPropuestaDeColaboracionParaPruebas.setPerfilEstudiantes(DEFAULT_AUXILIAR_PERFIL_ESTUDIANTES);
        auxiliarPropuestaDeColaboracionParaPruebas.setIdioma(DEFAULT_AUXILIAR_IDIOMA);
        auxiliarPropuestaDeColaboracionParaPruebas.setInformacionAdicional(DEFAULT_AUXILIAR_INFORMACION_ADICIONAL);        
        auxiliarPropuestaDeColaboracionParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO_PROPUESTA);

        
        COLABORACION_DAO = new ColaboracionDAO();
        auxiliarColaboracionParaPruebas = new Colaboracion();
        auxiliarColaboracionParaPruebas = Colaboracion.getNuevaInstancia();
        
        auxiliarColaboracionParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
        auxiliarColaboracionParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
        auxiliarColaboracionParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO);
        
        CONSTANCIA_COLABORACION_ACADEMICO_DAO = new ConstanciaColaboracionAcademicoDAO();
        auxiliarConstanciaColaboracionAcademicoParaPruebas = new ConstanciaColaboracionAcademico();
        auxiliarConstanciaColaboracionAcademicoParaPruebas = ConstanciaColaboracionAcademico.getNuevaInstancia();
        
        auxiliarConstanciaColaboracionAcademicoParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
        auxiliarConstanciaColaboracionAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        auxiliarConstanciaColaboracionAcademicoParaPruebas.setRutaConstancia(DEFAULT_AUXILIAR_RUTA_CONSTANCIA);
        auxiliarConstanciaColaboracionAcademicoParaPruebas.setNombreConstancia(DEFAULT_AUXILIAR_NOMBRE_CONSTANCIA);
        auxiliarConstanciaColaboracionAcademicoParaPruebas.setFechaEmision(DEFAULT_AUXILIAR_FECHA_EMISION);
        
        try {
            ACADEMICO_DAO.registrarAcademicoUV(auxiliarAcademicoParaPruebas);
            PROPUESTA_DE_COLABORACION_DAO.registrarPropuestaDeColaboracion(auxiliarPropuestaDeColaboracionParaPruebas);
            COLABORACION_DAO.registrarColaboracion(auxiliarColaboracionParaPruebas);
            CONSTANCIA_COLABORACION_ACADEMICO_DAO.registrarConstanciaColaboracionAcademico(auxiliarConstanciaColaboracionAcademicoParaPruebas);
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            CONSTANCIA_COLABORACION_ACADEMICO_DAO.archivarConstanciaColaboracionAcademicoPorIdColaboracion(auxiliarConstanciaColaboracionAcademicoParaPruebas.getIdColaboracion());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
            PROPUESTA_DE_COLABORACION_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaDeColaboracionParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.eliminarAcademicoUVPorId(auxiliarAcademicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testConsultarConstanciaColaboracionAcademicoPorIdColaboracionExitoso(){
        try{
           ArrayList<ConstanciaColaboracionAcademico> listaResultado = CONSTANCIA_COLABORACION_ACADEMICO_DAO.consultarConstanciaColaboracionAcademicoPorIdColaboracion(auxiliarConstanciaColaboracionAcademicoParaPruebas.getIdColaboracion());
           assertTrue(!listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }
    
    @Test
    public void testConsultarConstanciaColaboracionAcademicoPorIdColaboracionInexistenteFallida(){
        try{
           ArrayList<ConstanciaColaboracionAcademico> listaResultado = CONSTANCIA_COLABORACION_ACADEMICO_DAO.consultarConstanciaColaboracionAcademicoPorIdColaboracion(IDCOLABORACION_INEXISTENTE);
           assertTrue(listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }
    
    @Test
    public void testConsultarConstanciaColaboracionAcademicoPorIdAcademicoExitoso(){
        try{
           ArrayList<ConstanciaColaboracionAcademico> listaResultado = CONSTANCIA_COLABORACION_ACADEMICO_DAO.consultarConstanciaColaboracionAcademicoPorIdAcademico(auxiliarConstanciaColaboracionAcademicoParaPruebas.getIdAcademico());
           assertTrue(!listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }
    
    @Test
    public void testConsultarConstanciaColaboracionAcademicoPorIdAcademicoInexistenteFallida(){
        try{
           ArrayList<ConstanciaColaboracionAcademico> listaResultado = CONSTANCIA_COLABORACION_ACADEMICO_DAO.consultarConstanciaColaboracionAcademicoPorIdAcademico(IDACADEMICO_INEXISTENTE);
           assertTrue(listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }
    
    @Test
    public void testConsultaTotalConstanciaColaboracionAcademicoExitoso(){
        try{
           ArrayList<ConstanciaColaboracionAcademico> listaResultado = CONSTANCIA_COLABORACION_ACADEMICO_DAO.consultaTotalConstanciaColaboracionAcademico();
           assertTrue(!listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasConstanciaColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }

}
