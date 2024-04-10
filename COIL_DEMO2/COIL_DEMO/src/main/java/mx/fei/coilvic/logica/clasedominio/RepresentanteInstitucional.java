/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvic.logica.clasedominio;

/**
 *
 * @author kahun
 */
public class RepresentanteInstitucional {
    private String idRepresentante;
    private String nombre;
    private String direccion;
    private String correo;
    private String telefono;
    private String nombreUniversidad;
    
    public static RepresentanteInstitucional getNuevaInstancia(){
        return new RepresentanteInstitucional();
    }

    public String getIdRepresentante() {
        return idRepresentante;
    }

    public void setIdRepresentante(String idRepresentante) {
        this.idRepresentante = idRepresentante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }
    
}
