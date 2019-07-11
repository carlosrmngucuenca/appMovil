package com.example.danny.autov2;

/**
 * Created by danny on 21/05/17.
 */

public class PersonaLogin {

    String Nombre;
    String Apellido;
    String Correo;
    String Usuario;
    String idConductor;

    public PersonaLogin(String nombre, String apellido, String correo, String usuario, String idConductor) {
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Usuario = usuario;
        this.idConductor = idConductor;
    }

    public String getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(String idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }


}
