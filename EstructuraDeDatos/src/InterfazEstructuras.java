import Estructura.Avl;
import Estructura.DobleCircular;
import Estructura.ListaCircular;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazEstructuras extends JFrame {
    private Avl avl = new Avl();
    private ListaCircular listaCircular = new ListaCircular();
    private DobleCircular dobleCircular = new DobleCircular();

    private JTextArea outputArea;

    public InterfazEstructuras() {
        setTitle("Interfaz de Estructuras");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton btnAvl = new JButton("Recorrido AVL");
        btnAvl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                outputArea.append("Recorrido preOrden AVL:\n");
                avl.preOrden();
                outputArea.append("\n\nRecorrido inOrden AVL:\n");
                avl.inOrden();
                outputArea.append("\n\nRecorrido postOrden AVL:\n");
                avl.postOrden();
            }
        });

        JButton btnListaCircular = new JButton("Lista Circular");
        btnListaCircular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                outputArea.append("Primer nodo en lista circular: " + listaCircular.irPrimerNodo() + "\n");
                outputArea.append("Último nodo en lista circular: " + listaCircular.irUltimoNodo() + "\n");
            }
        });

        JButton btnDobleCircular = new JButton("Lista Doble Circular");
        btnDobleCircular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                outputArea.append("Primer nodo en lista doble circular: " + dobleCircular.irPrimerNodo() + "\n");
                outputArea.append("Último nodo en lista doble circular: " + dobleCircular.irUltimoNodo() + "\n");
                outputArea.append("Retroceder nodo en lista doble circular: " + dobleCircular.retrocederNodo() + "\n");
            }
        });

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(btnAvl, BorderLayout.NORTH);
        panel.add(btnListaCircular, BorderLayout.WEST);
        panel.add(btnDobleCircular, BorderLayout.EAST);
        panel.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InterfazEstructuras interfaz = new InterfazEstructuras();
                interfaz.setVisible(true);
            }
        });
    }
}

