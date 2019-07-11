package com.example.danny.autov2;

/**
 * Created by danny on 14/04/17.
 */

public class Persona {

    public String Nombre;
    public String Apellido;
    public String Correo;
    public String Contraseña;
    public String Nusuario;

    public Persona(String nombre, String apellido, String correo, String contraseña, String nusuario) {
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Contraseña = contraseña;
        Nusuario = nusuario;
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

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }

    public String getNusuario() {
        return Nusuario;
    }

    public void setNusuario(String nusuario) {
        Nusuario = nusuario;
    }
}
