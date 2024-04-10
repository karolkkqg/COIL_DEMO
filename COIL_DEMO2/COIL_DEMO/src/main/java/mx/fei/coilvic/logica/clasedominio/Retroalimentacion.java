package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author nmh14
 */
public class Retroalimentacion {

    private String IdRetroalimentacion;
    private String IdColaboracion;
    private String LeGustoTrabajarEnElCurso;
    private String HerramientaQueUtilizo;
    private String SentimientoAlComunicarse;
    private String Idioma;
    private String TiempoSuficiente;
    private int HorasTrabajadas;
    private String DisponibilidadParaElParInternacional;
    private String SentimientoAlTrabajar;
    private String RazonDeSentimientoAlTrabajar;
    private String RecomendariaCurso;
    private String InteresEnCulturaExtranjera;

    public static Retroalimentacion getNuevaInstancia() {
        return new Retroalimentacion();
    }

    public String getIdRetroalimentacion() {
        return IdRetroalimentacion;
    }

    public void setIdRetroalimentacion(String IdRetroalimentacion) {
        this.IdRetroalimentacion = IdRetroalimentacion;
    }

    public String getIdColaboracion() {
        return IdColaboracion;
    }

    public void setIdColaboracion(String IdColaboracion) {
        this.IdColaboracion = IdColaboracion;
    }

    public String getLeGustoTrabajarEnElCurso() {
        return LeGustoTrabajarEnElCurso;
    }

    public void setLeGustoTrabajarEnElCurso(String LeGustoTrabajarEnElCurso) {
        this.LeGustoTrabajarEnElCurso = LeGustoTrabajarEnElCurso;
    }

    public String getHerramientaQueUtilizo() {
        return HerramientaQueUtilizo;
    }

    public void setHerramientaQueUtilizo(String HerramientaQueUtilizo) {
        this.HerramientaQueUtilizo = HerramientaQueUtilizo;
    }

    public String getSentimientoAlComunicarse() {
        return SentimientoAlComunicarse;
    }

    public void setSentimientoAlComunicarse(String SentimientoAlComunicarse) {
        this.SentimientoAlComunicarse = SentimientoAlComunicarse;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public String getTiempoSuficiente() {
        return TiempoSuficiente;
    }

    public void setTiempoSuficiente(String TiempoSuficiente) {
        this.TiempoSuficiente = TiempoSuficiente;
    }

    public int getHorasTrabajadas() {
        return HorasTrabajadas;
    }

    public void setHorasTrabajadas(int HorasTrabajadas) {
        this.HorasTrabajadas = HorasTrabajadas;
    }

    public String getDisponibilidadParaElParInternacional() {
        return DisponibilidadParaElParInternacional;
    }

    public void setDisponibilidadParaElParInternacional(String DisponibilidadParaElParInternacional) {
        this.DisponibilidadParaElParInternacional = DisponibilidadParaElParInternacional;
    }

    public String getSentimientoAlTrabajar() {
        return SentimientoAlTrabajar;
    }

    public void setSentimientoAlTrabajar(String SentimientoAlTrabajar) {
        this.SentimientoAlTrabajar = SentimientoAlTrabajar;
    }

    public String getRazonDeSentimientoAlTrabajar() {
        return RazonDeSentimientoAlTrabajar;
    }

    public void setRazonDeSentimientoAlTrabajar(String RazonDeSentimientoAlTrabajar) {
        this.RazonDeSentimientoAlTrabajar = RazonDeSentimientoAlTrabajar;
    }

    public String getRecomendariaCurso() {
        return RecomendariaCurso;
    }

    public void setRecomendariaCurso(String RecomendariaCurso) {
        this.RecomendariaCurso = RecomendariaCurso;
    }

    public String getInteresEnCulturaExtranjera() {
        return InteresEnCulturaExtranjera;
    }

    public void setInteresEnCulturaExtranjera(String InteresEnCulturaExtranjera) {
        this.InteresEnCulturaExtranjera = InteresEnCulturaExtranjera;
    }

}
