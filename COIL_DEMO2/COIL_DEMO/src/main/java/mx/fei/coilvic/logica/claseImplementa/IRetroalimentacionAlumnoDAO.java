/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.RetroalimentacionAlumno;

public interface IRetroalimentacionAlumnoDAO {
    public int registrarRetroalimentacionAlumno(RetroalimentacionAlumno retroalimentacionAlumno)throws SQLException;
    public int archivarRetroalimentacionAlumnoPorIdRetroalimentacion(String idRetroalimentacion) throws SQLException;
    public ArrayList<RetroalimentacionAlumno> consultarRetroalimentacionAlumno() throws SQLException;
}
