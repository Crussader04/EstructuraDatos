import Estructura.*;

public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso de diferentes estructuras

        // Ejemplo de Árbol AVL
        Avl avl = new Avl();
        avl.agregar(5);
        avl.agregar(3);
        avl.agregar(7);
        avl.agregar(2);
        avl.agregar(4);
        avl.agregar(6);
        avl.agregar(8);

        System.out.println("Recorrido preOrden AVL:");
        avl.preOrden();
        System.out.println();

        System.out.println("Recorrido inOrden AVL:");
        avl.inOrden();
        System.out.println();

        System.out.println("Recorrido postOrden AVL:");
        avl.postOrden();
        System.out.println();

        // Ejemplo de Lista Circular
        ListaCircular listaCircular = new ListaCircular();
        listaCircular.agregar(1);
        listaCircular.agregar(2);
        listaCircular.agregar(3);

        System.out.println("Primer nodo en lista circular: " + listaCircular.irPrimerNodo());
        System.out.println("Último nodo en lista circular: " + listaCircular.irUltimoNodo());

        // Ejemplo de Lista Doble Circular
        DobleCircular dobleCircular = new DobleCircular();
        dobleCircular.agregar(10);
        dobleCircular.agregar(20);
        dobleCircular.agregar(30);

        System.out.println("Primer nodo en lista doble circular: " + dobleCircular.irPrimerNodo());
        System.out.println("Último nodo en lista doble circular: " + dobleCircular.irUltimoNodo());
        System.out.println("Retroceder nodo en lista doble circular: " + dobleCircular.retrocederNodo());
    }
}
