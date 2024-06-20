package Estructura;

class Avl extends Arbol {
    public int equilibrio() {
        // Implementación específica de AVL
        return 0;
    }

    @Override
    public boolean agregar(int valor) {
        // Implementación específica de AVL
        if (raiz == null) {
            raiz = new NodoConcreto(valor);
            return true;
        } else {
            boolean agregado = raiz.agregar(valor);
            if (agregado) {
                // Implementar la lógica de balanceo de AVL aquí
            }
            return agregado;
        }
    }
}

