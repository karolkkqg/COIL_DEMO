
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class AcademicoUV extends Academico{
    private String idAcademico;
    private String numeroDePersonal;
    private String telefono;
    private String programaEducativo;
    private String areaAcademica;
    private String region;
    private String categoriaDeContratacion;
    private String tipoDeContratacion;
    
    public static AcademicoUV getNuevaInstancia () {
        return new AcademicoUV();
    }
    
    public String getIdAcademico() {
        return idAcademico;
    }
    
    public void setIdAcademico(String idAcademico) {
        this.idAcademico = idAcademico;
    }

    public String getNumeroPersonal() {
        return numeroDePersonal;
    }

    public void setNumeroPersonal(String numeroPersonal) {
        this.numeroDePersonal = numeroPersonal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public String getAreaAcademica() {
        return areaAcademica;
    }

    public void setAreaAcademica(String areaAcademica) {
        this.areaAcademica = areaAcademica;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCategoriaDeContratacion() {
        return categoriaDeContratacion;
    }

    public void setCategoriaDeContratacion(String categoriaDeContratacion) {
        this.categoriaDeContratacion = categoriaDeContratacion;
    }

    public String getTipoDeContratacion() {
        return tipoDeContratacion;
    }

    public void setTipoDeContratacion(String tipoDeContratacion) {
        this.tipoDeContratacion = tipoDeContratacion;
    }
            
}
