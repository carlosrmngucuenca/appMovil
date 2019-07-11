package com.example.danny.autov2;

/**
 * Created by danny on 21/05/17.
 */

public class DatosAdapter {

    String Nombre;
    String Costo;
    int id;
    int Imagen;

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DatosAdapter(String nombre, String costo) {
        Nombre = nombre;
        Costo = costo;
    }

    public DatosAdapter(){

    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCosto() {
        return Costo;
    }

    public void setCosto(String costo) {
        Costo = costo;
    }
}
