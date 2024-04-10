/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class ColaboracionAcademico {
    private String idColaboracion;
    private String idAcademico;
    
    public static ColaboracionAcademico getNuevaInstancia(){
        return new ColaboracionAcademico();
    }

    public String getIdColaboracion() {
        return idColaboracion;
    }

    public void setIdColaboracion(String idColaboracion) {
        this.idColaboracion = idColaboracion;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }
    
}
