/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.unit.Test.ColaboracionAcademicoDAO;

import java.sql.SQLException;
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
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author kahun
 */
public class RegistroColaboracionAcademicoTest {
    private static ColaboracionAcademicoDAO COLABORACION_ACADEMICO_DAO;
    private static ColaboracionAcademico auxiliarColaboracionAcademicoParaPruebas;
    private static ColaboracionAcademico colaboracionAcademicoParaPruebas;

    
    private static PropuestaDeColaboracionDAO PROPUESTA_DE_COLABORACION_DAO;
    private static PropuestaDeColaboracion auxiliarPropuestaDeColaboracionParaPruebas;
    private static PropuestaDeColaboracion propuestaDeColaboracionParaPruebas;

    
    private static final String DEFAULT_IDPROPUESTA = "PRCO-01";
    private static final String DEFAULT_NOMBRE_CURSO = "NOMBRE CURSO";
    private static final String DEFAULT_DISCIPLINA = "DISCIPLINA";
    private static final String DEFAULT_TIPO_DE_COLABORACION = "TIPO";
    private static final String DEFAULT_OBJETIVO_GENERAL = "OBJETIVO GENERAL";
    private static final String DEFAULT_TEMA_DE_INTERES = "TEMAS DE INTERES";
    private static final String DEFAULT_PERIODO = "PERIODO";
    private static final String DEFAULT_PERFIL_ESTUDIANTES = "PERFIL DE ESTUDIANTES";
    private static final String DEFAULT_IDIOMA = "IDIOMA";
    private static final String DEFAULT_INFORMACION_ADICIONAL = "INFORMACION ADICIONAL";
    private static final String DEFAULT_ESTADO_PROPUESTA = "ESTADO";
    
    private static final String DEFAULT_AUXILIAR_IDPROPUESTA = "AUXPRCO-01";
    private static final String DEFAULT_AUXILIAR_NOMBRE_CURSO = "NOMBRE CURSO AUX";
    private static final String DEFAULT_AUXILIAR_DISCIPLINA = "DISCIPLINA AUX";
    private static final String DEFAULT_AUXILIAR_TIPO_DE_COLABORACION = "TIPO AUX";
    private static final String DEFAULT_AUXILIAR_OBJETIVO_GENERAL = "OBJETIVO GENERAL AUX";
    private static final String DEFAULT_AUXILIAR_TEMA_DE_INTERES = "TEMAS DE INTERES AUX";
    private static final String DEFAULT_AUXILIAR_PERIODO = "PERIODO AUX";
    private static final String DEFAULT_AUXILIAR_PERFIL_ESTUDIANTES = "PERFIL DE ESTUDIANTES AUX";
    private static final String DEFAULT_AUXILIAR_IDIOMA = "IDIOMA AUX";
    private static final String DEFAULT_AUXILIAR_INFORMACION_ADICIONAL = "INFORMACION ADICIONAL AUX";
    private static final String DEFAULT_AUXILIAR_ESTADO_PROPUESTA = "ESTADO AUX";
    
    private static ColaboracionDAO COLABORACION_DAO;
    private static Colaboracion auxiliarColaboracionParaPruebas;
    private static Colaboracion colaboracionParaPruebas;
    
    private static final String DEFAULT_IDCOLABORACION = "CT-01" ;
    private static final String DEFAULT_ESTADO = "CT-01" ;
    //idPropuesta
    private static final String DEFAULT_AUXILIAR_IDCOLABORACION = "AUXCT-01" ;
    private static final String DEFAULT_AUXILIAR_ESTADO = "AUXCT-01" ;
    
    private static AcademicoUVDAO ACADEMICO_DAO;
    private static AcademicoUV auxiliarAcademicoParaPruebas;
    private static AcademicoUV academicoParaPruebas;
    
    private static final String DEFAULT_AUXILIAR_IDACADEMICO = "AUXAC-01" ;
    private static final String DEFAULT_AUXILIAR_NOMBRE_COMPLETO = "NOMBRE COMPLETO AUX";
    private static final String DEFAULT_AUXILIAR_CORREO_ACADEMICO = "CORREOAUX@gmail.com";
    private static final int DEFAULT_AUXILIAR_NO_ESTUDIANTES = 20;
    private static final String DEFAULT_AUXILIAR_NUMERO_PERSONAL = "123456";
    private static final String DEFAULT_AUXILIAR_TELEFONO = "1234567899";
    private static final String DEFAULT_AUXILIAR_PROGRAMA_EDUCATIVO = "PROGRAMA EDUCATIVO AUX";
    private static final String DEFAULT_AUXILIAR_AREA_ACADEMICA_ACADEMICO = "AREA ACADEMICA AUX";
    private static final String DEFAULT_AUXILIAR_REGION = "REGION AUX";
    private static final String DEFAULT_AUXILIAR_CATEGORIA_DE_CONTRATACION = "CATEGORIA AUX";
    private static final String DEFAULT_AUXILIAR_TIPO_DE_CONTRATACION = "TIPO CONTRATACION AUX";
    
    private static final String DEFAULT_IDACADEMICO = "AC-01" ;
    private static final String DEFAULT_NOMBRE_COMPLETO = "NOMBRE COMPLETO";
    private static final String DEFAULT_CORREO_ACADEMICO = "CORREO@gmail.com";
    private static final int DEFAULT_NO_ESTUDIANTES = 20;
    private static final String DEFAULT_NUMERO_PERSONAL = "12345";
    private static final String DEFAULT_TELEFONO = "1234567890";
    private static final String DEFAULT_PROGRAMA_EDUCATIVO = "PROGRAMA EDUCATIVO";
    private static final String DEFAULT_AREA_ACADEMICA_ACADEMICO = "AREA ACADEMICA";
    private static final String DEFAULT_REGION = "REGION";
    private static final String DEFAULT_CATEGORIA_DE_CONTRATACION = "CATEGORIA";
    private static final String DEFAULT_TIPO_DE_CONTRATACION = "TIPO CONTRATACION";
    
    private static final String IDCOLABORACION_INEXISTENTE = "ID INEXISTENTE";
    private static final String IDACADEMICO_INEXISTENTE = "ID ALUMNO INEXISTENTE";
    
    @BeforeAll
    static void configuracionGeneral(){
        ACADEMICO_DAO = new AcademicoUVDAO();
        auxiliarAcademicoParaPruebas = new AcademicoUV();
        auxiliarAcademicoParaPruebas = AcademicoUV.getNuevaInstancia();
        academicoParaPruebas = new AcademicoUV();
        academicoParaPruebas = AcademicoUV.getNuevaInstancia();
        
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
        
        academicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        academicoParaPruebas.setNombreCompleto(DEFAULT_NOMBRE_COMPLETO);
        academicoParaPruebas.setCorreo(DEFAULT_CORREO_ACADEMICO);
        academicoParaPruebas.setNoEstudiantes(DEFAULT_NO_ESTUDIANTES);
        academicoParaPruebas.setNumeroPersonal(DEFAULT_NUMERO_PERSONAL);
        academicoParaPruebas.setTelefono(DEFAULT_TELEFONO);
        academicoParaPruebas.setProgramaEducativo(DEFAULT_PROGRAMA_EDUCATIVO);
        academicoParaPruebas.setAreaAcademica(DEFAULT_AREA_ACADEMICA_ACADEMICO);
        academicoParaPruebas.setRegion(DEFAULT_REGION);
        academicoParaPruebas.setCategoriaDeContratacion(DEFAULT_CATEGORIA_DE_CONTRATACION);
        academicoParaPruebas.setTipoDeContratacion(DEFAULT_TIPO_DE_CONTRATACION);
        
        PROPUESTA_DE_COLABORACION_DAO = new PropuestaDeColaboracionDAO();
        auxiliarPropuestaDeColaboracionParaPruebas = new PropuestaDeColaboracion();
        auxiliarPropuestaDeColaboracionParaPruebas = PropuestaDeColaboracion.getNuevaInstancia();
        propuestaDeColaboracionParaPruebas = new PropuestaDeColaboracion();
        propuestaDeColaboracionParaPruebas = PropuestaDeColaboracion.getNuevaInstancia();
        
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
        auxiliarPropuestaDeColaboracionParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO);
        
        propuestaDeColaboracionParaPruebas.setIdPropuesta(DEFAULT_IDPROPUESTA);
        propuestaDeColaboracionParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
        propuestaDeColaboracionParaPruebas.setNombreCurso(DEFAULT_NOMBRE_CURSO);
        propuestaDeColaboracionParaPruebas.setDisciplina(DEFAULT_DISCIPLINA);
        propuestaDeColaboracionParaPruebas.setTipoDeColaboracion(DEFAULT_TIPO_DE_COLABORACION);
        propuestaDeColaboracionParaPruebas.setObjetivoGeneral(DEFAULT_OBJETIVO_GENERAL);
        propuestaDeColaboracionParaPruebas.setTemasDeInteres(DEFAULT_TEMA_DE_INTERES);
        propuestaDeColaboracionParaPruebas.setPeriodo(DEFAULT_PERIODO);
        propuestaDeColaboracionParaPruebas.setPerfilEstudiantes(DEFAULT_PERFIL_ESTUDIANTES);
        propuestaDeColaboracionParaPruebas.setIdioma(DEFAULT_IDIOMA);
        propuestaDeColaboracionParaPruebas.setInformacionAdicional(DEFAULT_INFORMACION_ADICIONAL);
        propuestaDeColaboracionParaPruebas.setEstado(DEFAULT_ESTADO_PROPUESTA);

        
        COLABORACION_DAO = new ColaboracionDAO();
        auxiliarColaboracionParaPruebas = new Colaboracion();
        auxiliarColaboracionParaPruebas = Colaboracion.getNuevaInstancia();
        colaboracionParaPruebas = new Colaboracion();
        colaboracionParaPruebas = Colaboracion.getNuevaInstancia();
        
        auxiliarColaboracionParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
        auxiliarColaboracionParaPruebas.setIdPropuesta(DEFAULT_AUXILIAR_IDPROPUESTA);
        auxiliarColaboracionParaPruebas.setEstado(DEFAULT_AUXILIAR_ESTADO);
        
        colaboracionParaPruebas.setIdColaboracion(DEFAULT_IDCOLABORACION);
        colaboracionParaPruebas.setIdPropuesta(DEFAULT_IDPROPUESTA);
        colaboracionParaPruebas.setEstado(DEFAULT_ESTADO);
       
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
            
            ACADEMICO_DAO.registrarAcademicoUV(academicoParaPruebas);
            PROPUESTA_DE_COLABORACION_DAO.registrarPropuestaDeColaboracion(propuestaDeColaboracionParaPruebas);
            COLABORACION_DAO.registrarColaboracion(colaboracionParaPruebas);
            
        }catch (SQLException excpecion){
            Logger.getLogger(RegistroColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excpecion);
        }
    }
    
    @AfterAll
    public static void eliminarConfiguracionGeneral() {
        try {
            COLABORACION_ACADEMICO_DAO.archivarColaboracionAcademicoPorId(auxiliarColaboracionAcademicoParaPruebas.getIdColaboracion());
            COLABORACION_DAO.archivarColaboracion(auxiliarColaboracionParaPruebas.getIdColaboracion());
            PROPUESTA_DE_COLABORACION_DAO.archivarPropuestaDeColaboracion(auxiliarPropuestaDeColaboracionParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.eliminarAcademicoUVPorId(auxiliarAcademicoParaPruebas.getIdAcademico());
            
            COLABORACION_DAO.archivarColaboracion(colaboracionParaPruebas.getIdColaboracion());
            PROPUESTA_DE_COLABORACION_DAO.archivarPropuestaDeColaboracion(propuestaDeColaboracionParaPruebas.getIdPropuesta());
            ACADEMICO_DAO.eliminarAcademicoUVPorId(academicoParaPruebas.getIdAcademico());
            
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @BeforeEach
    public void configuracionUnidad() {
        colaboracionAcademicoParaPruebas.setIdColaboracion(DEFAULT_IDCOLABORACION);
        colaboracionAcademicoParaPruebas.setIdAcademico(DEFAULT_IDACADEMICO);
    }
    
    @AfterEach
    public void eliminarConfiguracionUnidad() {
        try {
            COLABORACION_ACADEMICO_DAO.archivarColaboracionAcademicoPorId(colaboracionAcademicoParaPruebas.getIdColaboracion());
        } catch (SQLException excepcion) {
            Logger.getLogger(RegistroColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, excepcion);
        }
    }
    
    @Test
    public void testRegistrarColaboracionAcademicoExitoso() {
        int idRegistro = -1;
        try {
            idRegistro = COLABORACION_ACADEMICO_DAO.registrarColaboracionAcademico(colaboracionAcademicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(1, idRegistro);
    }
    
    @Test
    public void testRegistrarColaboracionAcademicoPorIDDuplicadoFallido() {
        int idRegistro = -1;
        try {
            colaboracionAcademicoParaPruebas.setIdColaboracion(DEFAULT_AUXILIAR_IDCOLABORACION);
            idRegistro = COLABORACION_ACADEMICO_DAO.registrarColaboracionAcademico(colaboracionAcademicoParaPruebas);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroColaboracionAcademicoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertFalse(idRegistro > 0);
    }

}
