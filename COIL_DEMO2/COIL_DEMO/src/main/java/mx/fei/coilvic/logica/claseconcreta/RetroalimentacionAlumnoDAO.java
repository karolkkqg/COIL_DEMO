/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.claseconcreta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.fei.coilvic.basededatos.AdministradorBaseDeDatos;
import mx.fei.coilvic.logica.claseImplementa.IRetroalimentacionAlumnoDAO;
import mx.fei.coilvic.logica.clasedominio.RetroalimentacionAlumno;
/**
 *
 * @author kahun
 */
public class RetroalimentacionAlumnoDAO implements IRetroalimentacionAlumnoDAO {
    AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();
    
    
    @Override
    public int registrarRetroalimentacionAlumno(RetroalimentacionAlumno retroalimentacionAlumno) throws SQLException {
        Connection conexion=null;
        int filasAfectadas=0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoRetroalimentacionAlumno = conexion.prepareStatement("INSERT INTO retroaliemtnacionAlumno VALUES (?,?,?,?,?,?)");
            
            objetoRetroalimentacionAlumno.setString(1, retroalimentacionAlumno.getIdAlumno());
            objetoRetroalimentacionAlumno.setString(2, retroalimentacionAlumno.getIdRetroalimentacion());
            objetoRetroalimentacionAlumno.setString(3, retroalimentacionAlumno.getInteresEstudiarExtranjero());
            objetoRetroalimentacionAlumno.setString(4, retroalimentacionAlumno.getElProfesorConoceElPlanDeEstudios());
            objetoRetroalimentacionAlumno.setString(5, retroalimentacionAlumno.getGustoTrabajoColaborativoCOILVIC());
            objetoRetroalimentacionAlumno.setString(6, retroalimentacionAlumno.getCursoFormaEvaluarActividades());
            filasAfectadas = objetoRetroalimentacionAlumno.executeUpdate(); 
            
        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasAfectadas;
    }
    
    
    public int archivarRetroalimentacionAlumnoPorIdRetroalimentacion(String idRetroalimentacion) throws SQLException{
        Connection conexion = null;
        
        int filasObtenidas = 0;
        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement objetoRetroalimentacionAlumno = conexion.prepareStatement("DELETE FROM retroalimetnacionalumno WHERE idRetroalimentacion=?");
            objetoRetroalimentacionAlumno.setString(1, idRetroalimentacion);
            filasObtenidas = objetoRetroalimentacionAlumno.executeUpdate();
        } catch (SQLException excepcion) {
            Logger.getLogger(AcademicoUVDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        } finally {
            administradorAccesoBase.cerrarConexion();
        }
        return filasObtenidas;
    }
    
    
    public ArrayList<RetroalimentacionAlumno> consultarRetroalimentacionAlumno() throws SQLException{
        Connection conexion = null;
        ArrayList<RetroalimentacionAlumno> listaRetroalimentacionAlumno = new ArrayList<>();
        AdministradorBaseDeDatos administradorAccesoBase = new AdministradorBaseDeDatos();

        String consultaMySQL = "SELECT * FROM proporciona";

        try {
            conexion = administradorAccesoBase.obtenerConexion();
            PreparedStatement enunciadoConsulta = conexion.prepareStatement(consultaMySQL);
            ResultSet respuestaConsulta = enunciadoConsulta.executeQuery();
            while (respuestaConsulta.next()) {
                String idAlumno = respuestaConsulta.getString(1);
                String id = respuestaConsulta.getString(2);
                String interesEstudiarExtranjero = respuestaConsulta.getString(3);
                String elProfesorConoceElPlanDeEStudios = respuestaConsulta.getString(4);
                String gustoTrabajoColaborativoCOILVIC = respuestaConsulta.getString(5);
                String cursoFormaEvaluarActividades = respuestaConsulta.getString(6);

                RetroalimentacionAlumno objetoRetroalimentacionAlumno = new RetroalimentacionAlumno();
                
                objetoRetroalimentacionAlumno.setIdAlumno(idAlumno);
                objetoRetroalimentacionAlumno.setIdRetroalimentacion(id);
                objetoRetroalimentacionAlumno.setInteresEstudiarExtranjero(interesEstudiarExtranjero);
                objetoRetroalimentacionAlumno.setElProfesorConoceElPlanDeEstudios(elProfesorConoceElPlanDeEStudios);
                objetoRetroalimentacionAlumno.setGustoTrabajoColaborativoCOILVIC(gustoTrabajoColaborativoCOILVIC);
                objetoRetroalimentacionAlumno.setCursoFormaEvaluarActividades(cursoFormaEvaluarActividades);

                listaRetroalimentacionAlumno.add(objetoRetroalimentacionAlumno);
            }

        } catch (SQLException excepcion) {
            Logger.getLogger(RetroalimentacionAlumnoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally {
            administradorAccesoBase.cerrarConexion();
        }
        return listaRetroalimentacionAlumno;
    }
}

