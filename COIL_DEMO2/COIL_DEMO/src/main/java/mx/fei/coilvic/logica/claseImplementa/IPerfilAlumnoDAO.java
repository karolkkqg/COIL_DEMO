/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.PerfilAlumno;

/**
 *
 * @author kahun
 */
public interface IPerfilAlumnoDAO {
    public int registrarPerfilAlumno(PerfilAlumno perfilAlumno)throws SQLException;
    public int archivarPerfilAlumnoPorIdAlumno(String idAlumno) throws SQLException;
    public ArrayList<PerfilAlumno> consultarPerfilAlumno() throws SQLException;
}
