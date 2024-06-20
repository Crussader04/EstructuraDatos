import Estructura.Arbol;
import Estructura.NodoConcreto;
import Estructura.Estructura;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArbolConcreto arbol = new ArbolConcreto();
        arbol.agregar(5);
        arbol.agregar(3);
        arbol.agregar(7);
        arbol.agregar(2);
        arbol.agregar(4);
        arbol.agregar(6);
        arbol.agregar(8);

        System.out.print("Preorden: ");
        arbol.preOrden();
        System.out.println();

        System.out.print("Inorden: ");
        arbol.inOrden();
        System.out.println();

        System.out.print("Postorden: ");
        arbol.postOrden();
        System.out.println();
    }
}

class ArbolConcreto extends Arbol {
    @Override
    public boolean agregar(int valor) {
        if (raiz == null) {
            raiz = new NodoConcreto(valor);
            return true;
        } else {
            return raiz.agregar(valor);
        }
    }
}
