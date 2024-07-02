package Estructura;

public class Avl extends Arbol {

    public int equilibrio(NodoConcreto nodo) {
        if (nodo == null) return 0;
        return altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
    }

    @Override
    public boolean agregar(int valor) {
        if (raiz == null) {
            raiz = new NodoConcreto(valor);
            return true;
        } else {
            raiz = insertar(raiz, valor);
            return true;
        }
    }

    private NodoConcreto insertar(NodoConcreto nodo, int valor) {
        if (nodo == null) {
            return new NodoConcreto(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertar((NodoConcreto) nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertar((NodoConcreto) nodo.derecha, valor);
        } else {
            // El valor ya existe en el árbol, no se permite duplicados
            return nodo;
        }

        // Actualizar la altura del nodo actual
        nodo.actualizarAltura();

        // Calcular el equilibrio del nodo
        int equilibrio = equilibrio(nodo);

        // Casos de rotación
        // Caso izquierda-izquierda
        if (equilibrio > 1 && valor < nodo.izquierda.valor) {
            return rotarDerecha(nodo);
        }
        // Caso derecha-derecha
        if (equilibrio < -1 && valor > nodo.derecha.valor) {
            return rotarIzquierda(nodo);
        }
        // Caso izquierda-derecha
        if (equilibrio > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        // Caso derecha-izquierda
        if (equilibrio < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        // Si no se requiere rotación, retornar el nodo sin cambios
        return nodo;
    }

    private NodoConcreto rotarDerecha(NodoConcreto nodo) {
        NodoConcreto nodoIzquierdo = (NodoConcreto) nodo.izquierda;
        NodoConcreto nodoDerechoIzquierdo = (NodoConcreto) nodoIzquierdo.derecha;

        // Realizar la rotación
        nodoIzquierdo.derecha = nodo;
        nodo.izquierda = nodoDerechoIzquierdo;

        // Actualizar alturas
        nodo.actualizarAltura();
        nodoIzquierdo.actualizarAltura();

        // Devolver la nueva raíz
        return nodoIzquierdo;
    }

    private NodoConcreto rotarIzquierda(NodoConcreto nodo) {
        NodoConcreto nodoDerecho = (NodoConcreto) nodo.derecha;
        NodoConcreto nodoIzquierdoDerecho = (NodoConcreto) nodoDerecho.izquierda;

        // Realizar la rotación
        nodoDerecho.izquierda = nodo;
        nodo.derecha = nodoIzquierdoDerecho;

        // Actualizar alturas
        nodo.actualizarAltura();
        nodoDerecho.actualizarAltura();

        // Devolver la nueva raíz
        return nodoDerecho;
    }
}



