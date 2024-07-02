package Estructura;

public class ListaCircular extends ListaEnlazada {

    private NodoEnlazado cabeza;

    @Override
    public boolean agregar(int valor) {
        NodoEnlazado nuevoNodo = new NodoEnlazado(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza; // Hace que la cabeza apunte a sí misma en una lista circular vacía
        } else {
            NodoEnlazado actual = cabeza;
            while (actual.siguiente != cabeza) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
            nuevoNodo.siguiente = cabeza; // Hace que el nuevo nodo apunte de vuelta a la cabeza, cerrando el círculo
        }
        return true;
    }

    public int irUltimoNodo() {
        if (cabeza == null) {
            return -1; // Lista vacía, no hay último nodo
        }
        NodoEnlazado actual = cabeza;
        while (actual.siguiente != cabeza) {
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public int irPrimerNodo() {
        if (cabeza == null) {
            return -1; // Lista vacía, no hay primer nodo
        }
        return cabeza.valor;
    }

    private class NodoEnlazado {
        int valor;
        NodoEnlazado siguiente;

        NodoEnlazado(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }
}

