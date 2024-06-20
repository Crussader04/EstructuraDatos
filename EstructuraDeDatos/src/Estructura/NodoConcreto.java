package Estructura;

public class NodoConcreto extends Nodo {
    public NodoConcreto(int valor) {
        super(valor);
    }

    @Override
    public boolean agregar(int valor) {
        boolean result = true;
        if (valor < this.valor) {
            if (this.izquierda == null) {
                this.izquierda = new NodoConcreto(valor);
            } else {
                result = this.izquierda.agregar(valor);
            }
        } else if (valor > this.valor) {
            if (this.derecha == null) {
                this.derecha = new NodoConcreto(valor);
            } else {
                result = this.derecha.agregar(valor);
            }
        } else {
            result = false;
        }
        return result;
    }
}

