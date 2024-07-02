package Estructura;

class RojoYNegro extends Arbol {

    private static final boolean ROJO = true;
    private static final boolean NEGRO = false;

    @Override
    public boolean agregar(int valor) {
        if (raiz == null) {
            raiz = new NodoRojoNegro(valor, NEGRO); // La raíz siempre es negra
            return true;
        } else {
            raiz = (NodoRojoNegro) insertar(raiz, valor);
            ((NodoRojoNegro) raiz).color = NEGRO; // Aseguramos que la raíz siempre sea negra después de la inserción
            return true;
        }
    }

    private Object insertar(Estructura.NodoConcreto raiz, int valor) {
        return null;
    }

    private Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) {
            return new NodoRojoNegro(valor, ROJO); // Nuevo nodo siempre es rojo
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertar(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertar(nodo.derecha, valor);
        } else {
            // Valor ya existe en el árbol, no se permiten duplicados
            return nodo;
        }

        // Casos de balanceo específicos de Rojo y Negro
        if (esRojo(nodo.derecha) && !esRojo(nodo.izquierda)) {
            nodo = rotarIzquierda(nodo);
        }
        if (esRojo(nodo.izquierda) && esRojo(nodo.izquierda.izquierda)) {
            nodo = rotarDerecha(nodo);
        }
        if (esRojo(nodo.izquierda) && esRojo(nodo.derecha)) {
            cambiarColores(nodo);
        }

        return nodo;
    }

    private boolean esRojo(Nodo nodo) {
        if (nodo == null) {
            return false; // Nodos nulos son considerados negros
        }
        return nodo instanceof NodoRojoNegro && ((NodoRojoNegro) nodo).color == ROJO;
    }

    private Nodo rotarDerecha(Nodo nodo) {
        Nodo izquierda = nodo.izquierda;
        nodo.izquierda = izquierda.derecha;
        izquierda.derecha = nodo;
        ((NodoRojoNegro) izquierda).color = ((NodoRojoNegro) nodo).color;
        ((NodoRojoNegro) nodo).color = ROJO;
        return izquierda;
    }

    private Nodo rotarIzquierda(Nodo nodo) {
        Nodo derecha = nodo.derecha;
        nodo.derecha = derecha.izquierda;
        derecha.izquierda = nodo;
        ((NodoRojoNegro) derecha).color = ((NodoRojoNegro) nodo).color;
        ((NodoRojoNegro) nodo).color = ROJO;
        return derecha;
    }

    private void cambiarColores(Nodo nodo) {
        ((NodoRojoNegro) nodo).color = ROJO;
        ((NodoRojoNegro) nodo.izquierda).color = NEGRO;
        ((NodoRojoNegro) nodo.derecha).color = NEGRO;
    }

    private class NodoRojoNegro extends Nodo {
        boolean color; // true = rojo, false = negro

        NodoRojoNegro(int valor, boolean color) {
            super(valor);
            this.color = color;
        }

        @Override
        public void presentarNegro() {
            if (!color) {
                System.out.print(valor + "(Negro) ");
            } else {
                System.out.print(valor + "(Rojo) ");
            }
        }
    }
}
