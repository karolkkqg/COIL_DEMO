/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.RepresentanteInstitucional;

/**
 *
 * @author kahun
 */
public interface IRepresentanteInstitucionalDAO {
    public int registrarRepresentanteInstitucional(RepresentanteInstitucional representanteInstitucional)throws SQLException;
    public int archivarRepresentanteInstitucional(String idRepresentante) throws SQLException;
    public ArrayList<RepresentanteInstitucional> consultarRepresentanteInstitucional() throws SQLException;
    public ArrayList<RepresentanteInstitucional> consultarRepresentanteInstitucionalPorNombre() throws SQLException;
}
