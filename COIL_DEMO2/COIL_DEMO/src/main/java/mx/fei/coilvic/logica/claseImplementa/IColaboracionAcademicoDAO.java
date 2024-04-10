/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.ColaboracionAcademico;
/**
 *
 * @author kahun
 */
public interface IColaboracionAcademicoDAO {
    public int registrarColaboracionAcademico(ColaboracionAcademico academicoColaboracion) throws SQLException;
    //public int archivarColaboracionAcademico(String idColaboracion) throws SQLException;
    //public ArrayList<ColaboracionAcademico> consultarTotalColaboracionAcademico() throws SQLException;
    public int archivarColaboracionAcademicoPorIdAcademico(String idacademico) throws SQLException;
    public int archivarColaboracionAcademicoPorId(String idColaboracion) throws SQLException;
    public ArrayList<ColaboracionAcademico> consultarColaboracionAcademicoPorIdAcademico(String idAcademico) throws SQLException;
    public ArrayList<ColaboracionAcademico> consultarColaboracionAcademicoPorId(String idColaboracion) throws SQLException;
    public ArrayList<ColaboracionAcademico> consultaTotalColaboracionAcademico() throws SQLException;

}
