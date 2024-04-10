
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author nmh14
 */
public class RetroalimentacionAcademico extends Retroalimentacion{
    private String idRetroaliemntacion;
    private String idAcademico;
    private String estudianteConSuficienteTiempoParaActividades;
    
    public static RetroalimentacionAcademico getNuevaInstancia () {
        return new RetroalimentacionAcademico();
    }
    
    public String getIdRetroalimentacion() {
        return idRetroaliemntacion;
    }

    public void setIdRetroalimentacion(String idRetroalimentacion) {
        this.idRetroaliemntacion = idRetroalimentacion;
    }

    public String getIdAcademico() {
        return idAcademico;
    }

    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getEstudianteConSuficienteTiempoParaActividades() {
        return estudianteConSuficienteTiempoParaActividades;
    }

    public void setEstudianteConSuficienteTiempoParaActividades(String estudianteConSuficienteTiempoParaActividades) {
        this.estudianteConSuficienteTiempoParaActividades = estudianteConSuficienteTiempoParaActividades;
    }
    
    
}
