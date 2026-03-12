package Ejercicio2Torneo;

public class NodoTorneo{
    private String equipo1;
    private String equipo2;
    private String ganador;
    private String ronda;
    private  NodoTorneo izquierda;
    private NodoTorneo derecha;

    public NodoTorneo(String equipo1, String equipo2, String ronda) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;;
        this.ronda = ronda;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

    public String getRonda() {
        return ronda;
    }

    public void setRonda(String ronda) {
        this.ronda = ronda;
    }

    public NodoTorneo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoTorneo izquierda) {
        this.izquierda = izquierda;
    }

    public NodoTorneo getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoTorneo derecha) {
        this.derecha = derecha;
    }
}