package Estructura;

class DobleEnlazada extends ListaEnlazada {
    private NodoDobleEnlazado cabeza;
    private NodoDobleEnlazado cola;

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
        return 0;
    }

    private class NodoDobleEnlazado {
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

