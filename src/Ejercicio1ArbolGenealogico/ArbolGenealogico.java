package Ejercicio1ArbolGenealogico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ArbolGenealogico {
    private Padre raiz;


    public ArbolGenealogico(String nombre, String annoNaci) {
        raiz = new Padre(nombre, annoNaci);
    }

    public Padre obtenerRaiz() {
        return raiz;
    }

    public void insertar(String padre, String nombrePersona, String annoNaci) {
        Padre nodoPadre = buscar(raiz, padre);
        if (nodoPadre != null) {
            nodoPadre.agregarHijo(nombrePersona, annoNaci);
        } else {
            System.out.println("Ejercicio1ArbolGenealogico.Padre no encontrado");
        }
    }

    //busqueda recursiva
    private Padre buscar(Padre actual, String nombre) {
        if (actual == null) {
            return null;
        }
        if (actual.getNombrePersona().equals(nombre)) {
            return actual;
        }

        for (Padre hijos : actual.getHijos()) {
            Padre resultadp = buscar(hijos, nombre);
            if (resultadp != null) {
                return resultadp;
            }

        }
        return null;
    }

    public ArrayList<String> mostrarPaAtras(String persona) {
        Padre per = buscar(raiz, persona);
        ArrayList<String> lista = new ArrayList<>();
        if (per != null) {
            while (per.getPadre() != null) {
                per = per.getPadre();
                lista.add(per.getNombrePersona());
            }
        } else {
            System.out.println("no esta");
        }
        return lista;
    }

    public void Desc(String nombre) {

        Padre nodo = buscar(raiz, nombre);

        if (nodo == null) {
            System.out.println("Persona no encontrada");
            return;
        }

        bfsRe(nodo);

    }

    //recorrido bfs
    public void bfsRe(Padre actual) {
        if (actual == null) return;
        Queue<Padre> cola = new LinkedList<>();
        cola.add(actual);

        while (!cola.isEmpty()) {
            Padre sacaste = cola.poll();
            System.out.println(sacaste.getNombrePersona() + " " + sacaste.getAnnoNaci());
            for (Padre hijos : sacaste.getHijos()) {
                cola.add(hijos);
            }
        }
    }

    public void recorridoPorGeneraciones() {
        if (raiz == null) {
            return;
        }
        Queue<Padre> cola = new LinkedList<>();
        cola.add(raiz);
        int generacion = 1;

        while (!cola.isEmpty()) {
            int size = cola.size();
            System.out.print("Generacion " + generacion + ": ");
            for (int i = 0; i < size; i++) {

                Padre actual = cola.poll();

                System.out.print(actual.getNombrePersona() + " ");

                for (Padre hijo : actual.getHijos()) {
                    cola.add(hijo);
                }
            }

            System.out.println();

            generacion++;
        }
    }

    public boolean eliminar(String nombre) {
        if (raiz == null)
            return false; //caso especial eliminar raíz
        if (raiz.getNombrePersona().equalsIgnoreCase(nombre)) {
            raiz = null;
            return true;
        }
        return eliminarRecursivo(raiz, nombre);
    }

    private boolean eliminarRecursivo(Padre actual, String nombre) {
        if (actual == null) return false;
        for (int i = 0; i < actual.getHijos().size(); i++) {
            Padre hijo = actual.getHijos().get(i);
            if (hijo.getNombrePersona().equalsIgnoreCase(nombre)) {
                actual.getHijos().remove(i);
                return true;
            } else {
                if (eliminarRecursivo(hijo, nombre)) return true;
            }
        }
        return false;
    }

    public int profundidadArbol() {
        return calcularAltura(raiz);
    }

    private int calcularAltura(Padre nodo) {
        if (nodo == null) {
            return 0;
        }
        int alturaMaxima = 0;
        for (Padre hijo : nodo.getHijos()) {
            int alturaHijo = calcularAltura(hijo);
            if (alturaHijo > alturaMaxima) {
                alturaMaxima = alturaHijo;
            }
        }
        return alturaMaxima +1;
    }
}
