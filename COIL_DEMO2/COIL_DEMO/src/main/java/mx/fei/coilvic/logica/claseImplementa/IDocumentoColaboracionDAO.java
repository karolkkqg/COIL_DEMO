/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mx.fei.coilvic.logica.claseImplementa;

import java.sql.SQLException;
import java.util.ArrayList;
import mx.fei.coilvic.logica.clasedominio.DocumentoColaboracion;

/**
 *
 * @author kahun
 */
public interface IDocumentoColaboracionDAO {
    public int registrarDocumentosColaboracion(DocumentoColaboracion documentosColaboracion)throws SQLException;
    public int archivarDocumentosColaboracionPorIdColaboracion(String idColaboracion) throws SQLException;
    public ArrayList<DocumentoColaboracion> consultarDocumentosColaboracionPorIdColaboracion(String idColaboracion) throws SQLException;    
    public ArrayList<DocumentoColaboracion> consultaTotalDocumentosColaboracion() throws SQLException;    

}
