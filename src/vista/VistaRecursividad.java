
package vista;
import javax.swing.*;
import java.awt.*;

public class VistaRecursividad extends JFrame {
    private JButton btnAgregarNodo, btnMostrarAdelante, btnMostrarAtras, btnEliminarNodo, btnProbarCircularidad, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;

    private NodoDoble cabeza = null;
    private NodoDoble cola = null;

    private static class NodoDoble {
        String valor;
        NodoDoble siguiente;
        NodoDoble anterior;

        NodoDoble(String valor) {
            this.valor = valor;
            this.siguiente = this.anterior = null;
        }
    }

    public VistaRecursividad(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("Lista Circulares");
        setSize(750, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(230, 255, 230));
        add(panelPrincipal);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 20, 15));
        panelBotones.setBackground(new Color(204, 255, 204));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Operaciones de la Lista Circular"));

        btnAgregarNodo = new JButton("Agregar Nodo");
        btnMostrarAdelante = new JButton("Mostrar adelante");
        btnMostrarAtras = new JButton("Mostrar Atrás");
        btnEliminarNodo = new JButton("Eliminar Nodo");
        btnProbarCircularidad = new JButton("Probar Circularidad");
        btnSalir = new JButton("Salir");

        JButton[] botones = {btnAgregarNodo, btnMostrarAdelante, btnMostrarAtras, btnEliminarNodo, btnProbarCircularidad, btnSalir};
        for (JButton b : botones) {
            b.setFont(new Font("Segoe UI", Font.BOLD, 14));
            b.setBackground(new Color(0, 153, 76));
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            panelBotones.add(b);
        }

        panelPrincipal.add(panelBotones, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 16));
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("LISTA CIRCULAR DOBLE"));
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        btnAgregarNodo.addActionListener(e -> agregarNodo());
        btnMostrarAdelante.addActionListener(e -> mostrarAdelante());
        btnMostrarAtras.addActionListener(e -> mostrarAtras());
        btnEliminarNodo.addActionListener(e -> {
            String valor = JOptionPane.showInputDialog(this, "Ingrese el valor del nodo a eliminar:");
            if (valor != null && !valor.trim().isEmpty()) {
                eliminarNodo(valor.trim());
            }
        });
        btnProbarCircularidad.addActionListener(e -> demostrarCircularidad());
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });

        setVisible(true);
    }

    private void agregarNodo() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el valor del nodo:");
        if (input != null && !input.trim().isEmpty()) {
            NodoDoble nuevo = new NodoDoble(input.trim());

            if (cabeza == null) {
                cabeza = cola = nuevo;
                cabeza.siguiente = cabeza.anterior = cabeza;
            } else {
                nuevo.anterior = cola;
                nuevo.siguiente = cabeza;
                cola.siguiente = nuevo;
                cabeza.anterior = nuevo;
                cola = nuevo;
            }
            areaResultado.append("Nodo agregado: " + input.trim() + "\n");
        }
    }

    private void mostrarAdelante() {
        if (cabeza == null) {
            areaResultado.append("La lista está vacía.\n");
            return;
        }
        StringBuilder sb = new StringBuilder("Recorrido hacia adelante:\n");
        NodoDoble temp = cabeza;
        do {
            sb.append("[").append(temp.valor).append("] ");
            temp = temp.siguiente;
        } while (temp != cabeza);
        sb.append("\n");
        areaResultado.append(sb.toString());
    }

    private void mostrarAtras() {
        if (cola == null) {
            areaResultado.append("La lista está vacía.\n");
            return;
        }
        StringBuilder sb = new StringBuilder("Recorrido hacia atrás:\n");
        NodoDoble temp = cola;
        do {
            sb.append("[").append(temp.valor).append("] ");
            temp = temp.anterior;
        } while (temp != cola);
        sb.append("\n");
        areaResultado.append(sb.toString());
    }

    private void demostrarCircularidad() {
        if (cabeza == null) {
            areaResultado.append("La lista está vacía.\n");
            return;
        }

        areaResultado.append("Demostrando circularidad (dos vueltas completas):\n");
        NodoDoble temp = cabeza;
        int pasos = 0;
        int maxPasos = contarNodos() * 3;

        while (pasos < maxPasos) {
            areaResultado.append("[" + temp.valor + "] ");
            temp = temp.siguiente;
            pasos++;
        }
        areaResultado.append("\n");
    }

    private int contarNodos() {
        if (cabeza == null) return 0;

        int contador = 0;
        NodoDoble temp = cabeza;
        do {
            contador++;
            temp = temp.siguiente;
        } while (temp != cabeza);
        return contador;
    }

    private void eliminarNodo(String valor) {
        if (cabeza == null) {
            areaResultado.append("La lista está vacía.\n");
            return;
        }

        NodoDoble actual = cabeza;
        boolean encontrado = false;

        do {
            if (actual.valor.equals(valor)) {
                encontrado = true;

                if (actual == cabeza && actual == cola) {
                    cabeza = cola = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    cabeza.anterior = cola;
                    cola.siguiente = cabeza;
                } else if (actual == cola) {
                    cola = cola.anterior;
                    cola.siguiente = cabeza;
                    cabeza.anterior = cola;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }

                areaResultado.append("Nodo eliminado: " + valor + "\n");
                return;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);

        if (!encontrado) {
            areaResultado.append("Nodo con valor '" + valor + "' no encontrado.\n");
        }
    }
}


