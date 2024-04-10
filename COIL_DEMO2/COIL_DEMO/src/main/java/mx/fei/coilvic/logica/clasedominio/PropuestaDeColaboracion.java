package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author nmh14
 */
public class PropuestaDeColaboracion {

    private String idPropuesta;
    private String idAcademico;
    private String nombreCurso;
    private String disciplina;
    private String tipoDeColaboracion;
    private String objetivoGeneral;
    private String temasDeInteres;
    private String periodo;
    private String perfilEstudiantes;
    private String idioma;
    private String informacionAdicional;
    private String estado;
    private int noAlumnos;

    public static PropuestaDeColaboracion getNuevaInstancia() {
        return new PropuestaDeColaboracion();
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getTipoDeColaboracion() {
        return tipoDeColaboracion;
    }

    public void setTipoDeColaboracion(String tipoDeColaboracion) {
        this.tipoDeColaboracion = tipoDeColaboracion;
    }

    public String getObjetivoGeneral() {
        return objetivoGeneral;
    }

    public void setObjetivoGeneral(String objetivoGeneral) {
        this.objetivoGeneral = objetivoGeneral;
    }

    public String getTemasDeInteres() {
        return temasDeInteres;
    }

    public void setTemasDeInteres(String temasDeInteres) {
        this.temasDeInteres = temasDeInteres;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getPerfilEstudiantes() {
        return perfilEstudiantes;
    }

    public void setPerfilEstudiantes(String perfilEstudiantes) {
        this.perfilEstudiantes = perfilEstudiantes;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNoAlumnos() {
        return noAlumnos;
    }

    public void setNoAlumnos(int noAlumnos) {
        this.noAlumnos = noAlumnos;
    }

}
