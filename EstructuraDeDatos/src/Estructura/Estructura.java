package Estructura;

public interface Estructura {
    boolean agregar(int valor);

    public class NodoConcreto {
        public Nodo izquierdo;
        public Nodo derecho;
        public int valor;
        public Estructura.NodoConcreto izquierda;
        public Estructura.NodoConcreto derecha;

        public NodoConcreto(int valor) {

        }

        public NodoConcreto() {
        }

        public void actualizarAltura() {
        }

        public void inOrden() {
        }

        public void preOrden() {
        }

        public void postOrden() {
        }
    }
}
