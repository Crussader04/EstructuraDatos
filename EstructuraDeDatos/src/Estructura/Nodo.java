package Estructura;

public class Nodo implements INodo
{
    int valor;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
    }

    //Getters & setters
    public int getValor() {
        return this.valor;
    }

    public boolean agregar(int valor) {
        if(valor < this.valor) {
            if(this.izquierda == null) {
                this.izquierda = new Nodo(valor);
                return true;
            } else {
                this.izquierda.agregar(valor);
            }
        } else {
            if(this.derecha == null) {
                this.derecha = new Nodo(valor);
                return true;
            } else {
                this.derecha.agregar(valor);
            }
        }
        return false;
    }

    @Override
    public void inOrden() {
        if (izquierda != null) {
            izquierda.inOrden();
        }
        System.out.print(valor + " ");
        if (derecha != null) {
            derecha.inOrden();
        }
    }

    @Override
    public void preOrden() {
        System.out.print(valor + " ");
        if (izquierda != null) {
            izquierda.preOrden();
        }
        if (derecha != null) {
            derecha.preOrden();
        }
    }

    @Override
    public void postOrden() {
        if (izquierda != null) {
            izquierda.postOrden();
        }
        if (derecha != null) {
            derecha.postOrden();
        }
        System.out.print(valor + " ");
    }
}
