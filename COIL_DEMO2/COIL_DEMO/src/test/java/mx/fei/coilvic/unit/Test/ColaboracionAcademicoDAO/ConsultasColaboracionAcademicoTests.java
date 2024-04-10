/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.unit.Test.ColaboracionAcademicoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.logica.claseconcreta.AcademicoUVDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionAcademicoDAO;
import mx.fei.coilvic.logica.claseconcreta.ColaboracionDAO;
import mx.fei.coilvic.logica.claseconcreta.PropuestaDeColaboracionDAO;
import mx.fei.coilvic.logica.clasedominio.AcademicoUV;
import mx.fei.coilvic.logica.clasedominio.Colaboracion;
import mx.fei.coilvic.logica.clasedominio.ColaboracionAcademico;
import mx.fei.coilvic.logica.clasedominio.PropuestaDeColaboracion;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


/**
 *
 * @author kahun
 */
public class ConsultasColaboracionAcademicoTests {
    private static ColaboracionAcademicoDAO COLABORACION_ACADEMICO_DAO;
    private static ColaboracionAcademico auxiliarColaboracionAcademicoParaPruebas;
    
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
    
    private static final String IDCOLABORACION_INEXISTENTE = "ID INEXISTENTE";
    private static final String IDACADEMICO_INEXISTENTE = "ID ALUMNO INEXISTENTE";

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
        
        COLABORACION_ACADEMICO_DAO = new ColaboracionAcademicoDAO();
        auxiliarColaboracionAcademicoParaPruebas = new ColaboracionAcademico();
        auxiliarColaboracionAcademicoParaPruebas = ColaboracionAcademico.getNuevaInstancia();
        
        auxiliarColaboracionAcademicoParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
        auxiliarColaboracionAcademicoParaPruebas.setIdAcademico(DEFAULT_AUXILIAR_IDACADEMICO);
        
        try {
            ACADEMICO_DAO.registrarAcademicoUV(auxiliarAcademicoParaPruebas);
            PROPUESTA_DE_COLABORACION_DAO.registrarPropuestaDeColaboracion(auxiliarPropuestaDeColaboracionParaPruebas);
            COLABORACION_DAO.registrarColaboracion(auxiliarColaboracionParaPruebas);
            COLABORACION_ACADEMICO_DAO.registrarColaboracionAcademico(auxiliarColaboracionAcademicoParaPruebas);
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasColaboracionAcademicoTests.class.getName()).log(Level.SEVERE, null, excpecion);
        }
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            COLABORACION_ACADEMICO_DAO.archivarColaboracionAcademicoPorId(auxiliarColaboracionAcademicoParaPruebas.getIdColaboracion());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
            PROPUESTA_DE_COLABORACION_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaDeColaboracionParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.eliminarAcademicoUVPorId(auxiliarAcademicoParaPruebas.getIdAcademico());
        } catch (SQLException excepcion) {
            Logger.getLogger(ConsultasColaboracionAcademicoTests.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testConsultarColaboracionAcademicoPorIdExitoso(){
        try{
           ArrayList<ColaboracionAcademico> listaResultado = COLABORACION_ACADEMICO_DAO.consultarColaboracionAcademicoPorId(auxiliarColaboracionAcademicoParaPruebas.getIdColaboracion());
           assertTrue(!listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasColaboracionAcademicoTests.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }
    
    @Test
    public void testConsultarColaboracionAcademicoPorIdInexistenteFallida(){
        try{
           ArrayList<ColaboracionAcademico> listaResultado = COLABORACION_ACADEMICO_DAO.consultarColaboracionAcademicoPorId(IDCOLABORACION_INEXISTENTE);
           assertTrue(listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasColaboracionAcademicoTests.class.getName()).log(Level.SEVERE, null, excpecion);
            
            
        }  
    }
    
    @Test
    public void testConsultarColaboracionAcademicoPorIdAcademicoExitoso(){
        try{
           ArrayList<ColaboracionAcademico> listaResultado = COLABORACION_ACADEMICO_DAO.consultarColaboracionAcademicoPorIdAcademico(auxiliarColaboracionAcademicoParaPruebas.getIdAcademico());
           assertTrue(!listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasColaboracionAcademicoTests.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }
    
    @Test
    public void testConsultarColaboracionAcademicoPorIdAcademicoInexistenteFallida(){
        try{
           ArrayList<ColaboracionAcademico> listaResultado = COLABORACION_ACADEMICO_DAO.consultarColaboracionAcademicoPorIdAcademico(IDACADEMICO_INEXISTENTE);
           assertTrue(listaResultado.isEmpty());
        }catch (SQLException excpecion){
            Logger.getLogger(ConsultasColaboracionAcademicoTests.class.getName()).log(Level.SEVERE, null, excpecion);
        }  
    }

}
