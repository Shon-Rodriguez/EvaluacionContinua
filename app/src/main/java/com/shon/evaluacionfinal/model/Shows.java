package com.shon.evaluacionfinal.model;

public class Shows {
    private String Name; private String Genero; private String Imagen;

    public Shows(String Name, String Genero, String Imagen) {
        this.Name = Name;
        this.Genero = Genero;
        this.Imagen = Imagen;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }
}
