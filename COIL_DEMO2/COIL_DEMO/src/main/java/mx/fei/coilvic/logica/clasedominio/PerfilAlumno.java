/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class PerfilAlumno {
    private String idAlumno;
    private String idioma;
    private int cantidadDeColaboraciones;
    private String experienciasEducativasDeInteres; 
    
    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getCantidadDeColaboraciones() {
        return cantidadDeColaboraciones;
    }

    public void setCantidadDeColaboraciones(int cantidadDeColaboraciones) {
        this.cantidadDeColaboraciones = cantidadDeColaboraciones;
    }

    public String getExperienciasEducativasDeInteres() {
        return experienciasEducativasDeInteres;
    }

    public void setExperienciasEducativasDeInteres(String experienciasEducativasDeInteres) {
        this.experienciasEducativasDeInteres = experienciasEducativasDeInteres;
    }
    
}
