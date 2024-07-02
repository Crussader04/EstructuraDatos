package Estructura;

class ListaEnlazada implements Lista {
    private NodoEnlazado cabeza;

    @Override
    public boolean agregar(int valor) {
        NodoEnlazado nuevoNodo = new NodoEnlazado(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            return true;
        }
        NodoEnlazado actual = cabeza;
        while (actual.siguiente != null) {
            actual = actual.siguiente;
        }
        actual.siguiente = nuevoNodo;
        nuevoNodo.anterior = actual;
        return true;
    }

    @Override
    public boolean eliminar(int valor) {
        if (cabeza == null) {
            return false;
        }
        if (cabeza.valor == valor) {
            cabeza = cabeza.siguiente;
            if (cabeza != null) {
                cabeza.anterior = null;
            }
            return true;
        }
        NodoEnlazado actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.valor != valor) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = actual;
            }
            return true;
        }
        return false;
    }

    @Override
    public int tamaño() {
        int tamaño = 0;
        NodoEnlazado actual = cabeza;
        while (actual != null) {
            tamaño++;
            actual = actual.siguiente;
        }
        return tamaño;
    }

    public boolean avanzarNodo() {
        if (cabeza == null || cabeza.siguiente == null) {
            return false; // No se puede avanzar si no hay nodos o solo hay uno
        }
        cabeza = cabeza.siguiente;
        return true;
    }

    private class NodoEnlazado {
        int valor;
        NodoEnlazado anterior;
        NodoEnlazado siguiente;

        NodoEnlazado(int valor) {
            this.valor = valor;
            this.anterior = null;
            this.siguiente = null;
        }
    }
}

