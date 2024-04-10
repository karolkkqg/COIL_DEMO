/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

public class PerfilAcademico {
    private String idAcademico;
    private String idiomas;
    private int cantidadDeColaboraciones;
    private int participacionEnCursos;
    private String experienciasEducativasDeInteres;
    
    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getCantidadDeColaboraciones() {
        return cantidadDeColaboraciones;
    }

    public void setCantidadDeColaboraciones(int cantidadDeColaboraciones) {
        this.cantidadDeColaboraciones = cantidadDeColaboraciones;
    }

    public int getParticipacionEnCursos() {
        return participacionEnCursos;
    }

    public void setParticipacionEnCursos(int participacionEnCursos) {
        this.participacionEnCursos = participacionEnCursos;
    }

    public String getExperienciasEducativasDeInteres() {
        return experienciasEducativasDeInteres;
    }

    public void setExperienciasEducativasDeInteres(String experienciasEducativasDeInteres) {
        this.experienciasEducativasDeInteres = experienciasEducativasDeInteres;
    }
}

