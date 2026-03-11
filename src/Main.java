import Ejercicio1ArbolGenealogico.ArbolGenealogico;

public class Main {
    public static void main(String[] args) {
        // Crear el árbol con el ancestro principal
        ArbolGenealogico arbol = new ArbolGenealogico("Carlos", "1950");

        // Hijos de Carlos
        arbol.insertar("Carlos", "Luis", "1975");
        arbol.insertar("Carlos", "Ana", "1978");
        arbol.insertar("Carlos", "Pedro", "1980");

        // Hijos de Luis
        arbol.insertar("Luis", "Miguel", "2000");
        arbol.insertar("Luis", "Laura", "2003");

        // Hijos de Ana
        arbol.insertar("Ana", "Sofia", "2005");

        // Hijos de Pedro
        arbol.insertar("Pedro", "Diego", "2010");

        // Caso de prueba: padre que no existe
        arbol.insertar("Juan", "Test", "2020");

        System.out.println("Pruebas completadas.");
        System.out.println("A)");
        System.out.println(arbol.mostrarPaAtras("Sofia").reversed());
        System.out.println("B)");
        arbol.Desc("Ana");
        System.out.println("D");
        arbol.eliminar("Ana");

        arbol.Desc("Carlos");
        System.out.println(arbol.profundidadArbol());


    }
}
