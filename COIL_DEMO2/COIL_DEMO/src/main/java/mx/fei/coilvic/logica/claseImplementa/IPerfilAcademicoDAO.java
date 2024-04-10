/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.PerfilAcademico;

public interface IPerfilAcademicoDAO{
    public int registrarPerfilAcademico(PerfilAcademico perfilAcademico)throws SQLException;
    public int archivarPerfilAcademicoPorIdAcademico(String idAcademico) throws SQLException;
    public ArrayList<PerfilAcademico> consultarPerfilAcademico() throws SQLException;
}

