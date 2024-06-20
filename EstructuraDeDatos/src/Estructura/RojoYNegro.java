package Estructura;

class RojoYNegro extends Arbol {
    public void presentarRojo() {
    }

    public void presentarNegro() {
        if (raiz != null) {
            raiz.presentarNegro();
        } else {
            System.out.println("Árbol vacío");
        }
    }

    @Override
    public boolean agregar(int valor) {
        if (raiz == null) {
            raiz = new NodoConcreto(valor);
            return true;
        } else {
            boolean agregado = raiz.agregar(valor);
            if (agregado) {
            }
            return agregado;
        }
    }
}

