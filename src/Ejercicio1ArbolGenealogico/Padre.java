package Ejercicio1ArbolGenealogico;

import java.util.ArrayList;
import java.util.List;

public class Padre {
    private String nombrePersona;
    private String annoNaci;

    private Padre padre;
    private List<Padre> hijos;

    public Padre(String nombrePersona, String annoNaci) {
        this.nombrePersona = nombrePersona;
        this.annoNaci = annoNaci;
        this.hijos = new ArrayList<>();
    }
    public void agregarHijo(String nombrePersona, String annoNaci){
        Padre nuevo = new Padre(nombrePersona, annoNaci);
        nuevo.setPadre(this);
        hijos.add(nuevo);
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getAnnoNaci() {
        return annoNaci;
    }

    public void setAnnoNaci(String annoNaci) {
        this.annoNaci = annoNaci;
    }

    public Padre getPadre() {
        return padre;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
    }

    public List<Padre> getHijos() {
        return hijos;
    }

    public void setHijos(List<Padre> hijos) {
        this.hijos = hijos;
    }
}
