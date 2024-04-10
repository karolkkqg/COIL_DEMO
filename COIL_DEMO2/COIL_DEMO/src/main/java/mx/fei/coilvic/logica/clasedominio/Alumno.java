
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author nmh14
 */
public class Alumno {
    private String idAlumno;
    private String correo;
    private String areaAcademica;
    private String matricula;
    private String nombreAlumno;
    
    public static Alumno getNuevaInstancia () {
        return new Alumno();
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idEstudiante) {
        this.idAlumno = idEstudiante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(String areaAcademico) {
        this.areaAcademica = areaAcademico;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreEstudiante) {
        this.nombreAlumno = nombreEstudiante;
    }
    
    
}
