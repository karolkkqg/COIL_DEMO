/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class ConstanciaColaboracionAcademico {
    private String idAcademico;
    private String idColaboracion;
    private String rutaConstancia;
    private String nombreConstancia;
    private String fechaEmision; 

    public static ConstanciaColaboracionAcademico getNuevaInstancia(){
        return new ConstanciaColaboracionAcademico();
    }
    
    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getIdColaboracion() {
        return idColaboracion;
    }

    public void setIdColaboracion(String idColaboracion) {
        this.idColaboracion = idColaboracion;
    }

    public String getRutaConstancia() {
        return rutaConstancia;
    }

    public void setRutaConstancia(String rutaConstancia) {
        this.rutaConstancia = rutaConstancia;
    }
    
    public String getNombreConstancia() {
        return nombreConstancia;
    }

    public void setNombreConstancia(String nombreConstancia) {
        this.nombreConstancia = nombreConstancia;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
