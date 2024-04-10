
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class Academico {

    private String idAcademico;
    private String nombreCompleto;
    private String correo;
    private int noEstudiantes;
    
    public static Academico getNuevaInstancia(){
        return new Academico();
    }
    
    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNoEstudiantes() {
        return noEstudiantes;
    }

    public void setNoEstudiantes(int noEstudiantes) {
        this.noEstudiantes = noEstudiantes;
    }

}
