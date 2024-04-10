package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author nmh14
 */
public class Colaboracion {

    private String idColaboracion;
    private String idPropuesta;
    private String estado;
    
    public static Colaboracion getNuevaInstancia(){
        return new Colaboracion();
    }
    
    public String getIdColaboracion() {
        return idColaboracion;
    }

    public void setIdColaboracion(String idColaboracion) {
        this.idColaboracion = idColaboracion;
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
