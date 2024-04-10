/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.ConstanciaColaboracionAlumno;

/**
 *
 * @author kahun
 */
public interface IConstanciaColaboracionAlumnoDAO {
    public int registrarConstanciaColaboracionAlumno(ConstanciaColaboracionAlumno constanciaColaboracionAlumno)throws SQLException;
    public int archivarConstanciaColaboracionAlumnoPorIdAlumno(String idAlumno) throws SQLException;
    public int archivarConstanciaColaboracionAlumnoPorIdColaboracion(String idColaboracion) throws SQLException;
    public ArrayList<ConstanciaColaboracionAlumno> consultarConstanciaColaboracionAlumnoPorIdColaboracion(String idColaboracion) throws SQLException;    
    public ArrayList<ConstanciaColaboracionAlumno> consultarConstanciaColaboracionAlumnoPorIdAcademico(String idAlumno) throws SQLException;
    public ArrayList<ConstanciaColaboracionAlumno> consultaTotalConstanciaColaboracionAlumno() throws SQLException; 

}
