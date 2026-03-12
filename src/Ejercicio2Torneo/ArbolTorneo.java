package Ejercicio2Torneo;

public class ArbolTorneo {
    private NodoTorneo raiz;

    public NodoTorneo getRaiz() {
        return raiz;
    }

    public void crearArbol(){
        NodoTorneo QF1 = new NodoTorneo("Equipo1", "Equipo2","QF1");
        NodoTorneo QF2 = new NodoTorneo("Equipo3","Equipo4","QF2");
        NodoTorneo QF3 = new NodoTorneo("Equipo5","Equipo6","QF3");
        NodoTorneo QF4 = new NodoTorneo("Equipo7","Equipo8","QF4");

        NodoTorneo SF1 = new NodoTorneo(null, null, "SF1");
        NodoTorneo SF2 = new NodoTorneo(null, null, "SF2");

        NodoTorneo Final = new NodoTorneo(null, null, "Final");

        SF1.setIzquierda(QF1);
        SF1.setDerecha(QF2);

        SF2.setIzquierda(QF3);
        SF2.setDerecha(QF4);

        Final.setIzquierda(SF1);
        Final.setDerecha(SF2);

        raiz = Final;
    }

    public void recorrerYSimular(NodoTorneo nodo){
        if(nodo == null){
            return;
        }
        recorrerYSimular(nodo.getIzquierda());
        recorrerYSimular(nodo.getDerecha());
        if(nodo.getIzquierda() != null && nodo.getDerecha() != null){

            nodo.setEquipo1(nodo.getIzquierda().getGanador());
            nodo.setEquipo2(nodo.getDerecha().getGanador());
        }
        if(Math.random() < 0.5){
            nodo.setGanador(nodo.getEquipo1());
        }else{
            nodo.setGanador(nodo.getEquipo2());
        }
    }
    public void mostrarBracket(NodoTorneo nodo, String espacio){

        if(nodo == null){
            return;
        }

        System.out.println(
                espacio +
                        nodo.getRonda() + ": " +
                        nodo.getEquipo1() + " vs " +
                        nodo.getEquipo2() +
                        " -> Ganador: " +
                        nodo.getGanador()
        );

        mostrarBracket(nodo.getIzquierda(), espacio + "   ");
        mostrarBracket(nodo.getDerecha(), espacio + "   ");
    }

}
