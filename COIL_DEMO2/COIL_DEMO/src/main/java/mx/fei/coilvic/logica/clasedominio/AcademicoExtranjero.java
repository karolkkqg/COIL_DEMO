
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author nmh1
 */
public class AcademicoExtranjero extends Academico{
    private String idAcademico;
    private String idRepresentante;
    private String pais;
    
    public static AcademicoExtranjero getNuevaInstancia(){
        return new AcademicoExtranjero();
    }
    
    @Override
    public String getIdAcademico() {
        return idAcademico;
    }

    @Override
    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(String idUniversidad) {
        this.idRepresentante = idUniversidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
