/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.ConstanciaColaboracionAcademico;
/**
 *
 * @author kahun
 */
public interface IConstanciaColaboracionAcademicoDAO {
    public int registrarConstanciaColaboracionAcademico(ConstanciaColaboracionAcademico constanciaColaboracionAcademico)throws SQLException;
    public int archivarConstanciaColaboracionAcademicoPorIdAcademico(String idacademico) throws SQLException;
    public int archivarConstanciaColaboracionAcademicoPorIdColaboracion(String idColaboracion) throws SQLException;
    public ArrayList<ConstanciaColaboracionAcademico> consultarConstanciaColaboracionAcademicoPorIdColaboracion(String idColaboracion) throws SQLException;
    public ArrayList<ConstanciaColaboracionAcademico> consultarConstanciaColaboracionAcademicoPorIdAcademico(String idAcademico) throws SQLException;
    public ArrayList<ConstanciaColaboracionAcademico> consultaTotalConstanciaColaboracionAcademico() throws SQLException;

}
