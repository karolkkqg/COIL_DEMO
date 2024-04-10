/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.EvaluacionAcademico;

/**
 *
 * @author kahun
 */
public interface IEvaluacionAcademicoDAO {
    public int registrarEvaluacionAcademico(EvaluacionAcademico participa)throws SQLException;
    public int archivarEvaluacionAcademico(String idAcademico) throws SQLException;
    public ArrayList<EvaluacionAcademico> consultarTotalEvaluacionAcademico() throws SQLException;
}
