package Estructura;

class DobleEnlazada extends ListaEnlazada {
    protected NodoDobleEnlazado cabeza;
    protected NodoDobleEnlazado cola;

    @Override
    public boolean agregar(int valor) {
        NodoDobleEnlazado nuevoNodo = new NodoDobleEnlazado(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            return true;
        }
        cola.siguiente = nuevoNodo;
        nuevoNodo.anterior = cola;
        cola = nuevoNodo;
        return true;
    }

    public int retrocederNodo() {
        if (cola == null || cola.anterior == null) {
            return -1; // No hay nodo anterior para retroceder
        }
        cola = cola.anterior;
        return cola.valor;
    }

    protected class NodoDobleEnlazado {
        int valor;
        NodoDobleEnlazado siguiente;
        NodoDobleEnlazado anterior;

        NodoDobleEnlazado(int valor) {
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
        }
    }
}



