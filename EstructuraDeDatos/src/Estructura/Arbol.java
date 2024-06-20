package Estructura;

public abstract class Arbol implements Estructura {
    protected Nodo raiz;

    public void inOrden() {
        if (raiz != null) {
            raiz.inOrden();
        }
    }

    public void preOrden() {
        if (raiz != null) {
            raiz.preOrden();
        }
    }

    public void postOrden() {
        if (raiz != null) {
            raiz.postOrden();
        }
    }

    @Override
    public abstract boolean agregar(int valor);
}

