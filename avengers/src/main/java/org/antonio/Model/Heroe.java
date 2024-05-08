package org.antonio.Model;

public class Heroe {
    private String nombre;
    private String superpoderes;
    private String biografia;

    public Heroe(String nombre, String superpoderes, String biografia) {
        this.nombre = nombre;
        this.superpoderes = superpoderes;
        this.biografia = biografia;
    }

    public Heroe(){}
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setSuperpoderes(String superpoderes) {
        this.superpoderes = superpoderes;
    }


    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }


    public String getNombre() {
        return nombre;
    }

    public String getSuperpoderes() {
        return superpoderes;
    }

    public String getBiografia() {
        return biografia;
    }
}
