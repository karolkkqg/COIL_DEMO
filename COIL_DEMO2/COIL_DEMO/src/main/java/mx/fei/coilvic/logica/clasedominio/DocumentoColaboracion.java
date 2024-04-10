/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class DocumentoColaboracion {
    private String idColaboracion;
    private String rutaSyllabus;
    private String rutaActividades;
    private String nombreSyllabus;
    private String nombreActividades;
    private String fechaEmisionSyllabus;
    private String fechaEmisionActividades;
    
    public static DocumentoColaboracion getNuevaInstancia(){
        return new DocumentoColaboracion();
    }
    
    public String getIdColaboracion() {
        return idColaboracion;
    }

    public void setIdColaboracion(String idColaboracion) {
        this.idColaboracion = idColaboracion;
    }

    public String getRutaSyllabus() {
        return rutaSyllabus;
    }

    public void setRutaSyllabus(String rutaSyllabus) {
        this.rutaSyllabus = rutaSyllabus;
    }

    public String getRutaActividades() {
        return rutaActividades;
    }

    public void setRutaActividades(String rutaActividades) {
        this.rutaActividades = rutaActividades;
    }
    
    public String getNombreSyllabus() {
        return nombreSyllabus;
    }

    public void setNombreSyllabus(String nombreSyllabus) {
        this.nombreSyllabus = nombreSyllabus;
    }

    public String getNombreActividades() {
        return nombreActividades;
    }

    public void setNombreActividades(String nombreActividades) {
        this.nombreActividades = nombreActividades;
    }

    public String getFechaEmisionSyllabus() {
        return fechaEmisionSyllabus;
    }

    public void setFechaEmisionSyllabus(String fechaEmisionSyllabus) {
        this.fechaEmisionSyllabus = fechaEmisionSyllabus;
    }

    public String getFechaEmisionActividades() {
        return fechaEmisionActividades;
    }

    public void setFechaEmisionActividades(String fechaEmisionActividades) {
        this.fechaEmisionActividades = fechaEmisionActividades;
    }

}
