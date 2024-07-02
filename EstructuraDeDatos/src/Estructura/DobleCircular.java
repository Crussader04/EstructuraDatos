package Estructura;

public class DobleCircular extends DobleEnlazada {

    @Override
    public boolean agregar(int valor) {
        NodoDobleEnlazado nuevoNodo = new NodoDobleEnlazado(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.anterior = cola;
            cabeza.siguiente = cola;
            cola.anterior = cabeza;
            cola.siguiente = cabeza;
            return true;
        }
        cola.siguiente = nuevoNodo;
        nuevoNodo.anterior = cola;
        nuevoNodo.siguiente = cabeza; // Conecta el nuevo nodo de vuelta a la cabeza
        cabeza.anterior = nuevoNodo; // Conecta la cabeza anterior al nuevo nodo
        cola = nuevoNodo; // Actualiza la cola al nuevo nodo
        return true;
    }

    public int retrocederNodo() {
        if (cola == null || cola.anterior == null) {
            return -1; // No hay nodo anterior para retroceder
        }
        cola = cola.anterior;
        return cola.valor;
    }

    public int irUltimoNodo() {
        if (cola == null) {
            return -1; // Lista vacía, no hay último nodo
        }
        return cola.valor;
    }

    public int irPrimerNodo() {
        if (cabeza == null) {
            return -1; // Lista vacía, no hay primer nodo
        }
        return cabeza.valor;
    }

}

