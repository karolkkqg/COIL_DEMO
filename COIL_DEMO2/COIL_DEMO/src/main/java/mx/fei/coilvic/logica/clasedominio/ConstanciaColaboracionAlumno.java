/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class ConstanciaColaboracionAlumno {
    private String idAlumno;
    private String idColaboracion;
    private String rutaConstancia;
    private String nombreConstancia;
    private String fechaEmision; 

    
    
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
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
