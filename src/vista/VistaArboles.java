
package vista;
import javax.swing.*;
import java.awt.*;

public class VistaArboles extends JFrame {
    private JButton btnInsertar, btnEliminar, btnBuscar, btnInorden, btnPreorden, btnPostorden, btnDiagrama, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;
    private Nodo raiz = null;

    private static class Nodo {
        int valor;
        Nodo izquierdo, derecho;

        Nodo(int valor) {
            this.valor = valor;
            this.izquierdo = null;
            this.derecho = null;
        }
    }

    public VistaArboles(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("ÁRBOL BINARIO DE BÚSQUEDA (BST)");
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Fondo principal con tono verde suave
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(230, 255, 230));
        add(panelPrincipal);

        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 10, 10));
        panelBotones.setBackground(new Color(204, 255, 204));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Operaciones del Árbol"));

        btnInsertar = new JButton("Insertar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        btnInorden = new JButton("Recorrido Inorden");
        btnPreorden = new JButton("Recorrido Preorden");
        btnPostorden = new JButton("Recorrido Postorden");
        btnDiagrama = new JButton("Mostrar Diagrama");
        btnSalir = new JButton("Salir");

        JButton[] botones = {btnInsertar, btnEliminar, btnBuscar, btnInorden, btnPreorden, btnPostorden, btnDiagrama, btnSalir};
        for (JButton b : botones) {
            b.setFont(new Font("Segoe UI", Font.BOLD, 14));
            b.setBackground(new Color(0, 153, 76));
            b.setForeground(Color.WHITE);
            b.setFocusPainted(false);
            panelBotones.add(b);
        }

        panelPrincipal.add(panelBotones, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultados del Árbol Binario"));
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        // Acciones
        btnInsertar.addActionListener(e -> insertar());
        btnEliminar.addActionListener(e -> eliminar());
        btnBuscar.addActionListener(e -> buscar());
        btnInorden.addActionListener(e -> mostrarInorden());
        btnPreorden.addActionListener(e -> mostrarPreorden());
        btnPostorden.addActionListener(e -> mostrarPostorden());
        btnDiagrama.addActionListener(e -> mostrarDiagrama());
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });

        setVisible(true);
    }

    private void insertar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para insertar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                raiz = insertarRec(raiz, valor);
                areaResultado.append("✔ Insertado: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) return new Nodo(valor);
        if (valor < nodo.valor) nodo.izquierdo = insertarRec(nodo.izquierdo, valor);
        else if (valor > nodo.valor) nodo.derecho = insertarRec(nodo.derecho, valor);
        return nodo;
    }

    private void eliminar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el valor a eliminar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                raiz = eliminarRec(raiz, valor);
                areaResultado.append("✔ Intento eliminar: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (valor < nodo.valor) nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        else if (valor > nodo.valor) nodo.derecho = eliminarRec(nodo.derecho, valor);
        else {
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;
            nodo.valor = minValor(nodo.derecho);
            nodo.derecho = eliminarRec(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    private int minValor(Nodo nodo) {
        while (nodo.izquierdo != null) nodo = nodo.izquierdo;
        return nodo.valor;
    }

    private void buscar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el valor a buscar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                boolean encontrado = buscarRec(raiz, valor);
                areaResultado.append(encontrado
                        ? "✔ Valor " + valor + " encontrado.\n"
                        : "❌ Valor " + valor + " no encontrado.\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Número inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return (valor < nodo.valor) ? buscarRec(nodo.izquierdo, valor) : buscarRec(nodo.derecho, valor);
    }

    private void mostrarInorden() {
        StringBuilder sb = new StringBuilder("Inorden: ");
        inordenRec(raiz, sb);
        sb.append("\n");
        areaResultado.append(sb.toString());
    }

    private void inordenRec(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo, sb);
            sb.append(nodo.valor).append(", ");
            inordenRec(nodo.derecho, sb);
        }
    }

    private void mostrarPreorden() {
        StringBuilder sb = new StringBuilder("Preorden: ");
        preordenRec(raiz, sb);
        sb.append("\n");
        areaResultado.append(sb.toString());
    }

    private void preordenRec(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.valor).append(", ");
            preordenRec(nodo.izquierdo, sb);
            preordenRec(nodo.derecho, sb);
        }
    }

    private void mostrarPostorden() {
        StringBuilder sb = new StringBuilder("Postorden: ");
        postordenRec(raiz, sb);
        sb.append("\n");
        areaResultado.append(sb.toString());
    }

    private void postordenRec(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            postordenRec(nodo.izquierdo, sb);
            postordenRec(nodo.derecho, sb);
            sb.append(nodo.valor).append(", ");
        }
    }

    private void mostrarDiagrama() {
        StringBuilder sb = new StringBuilder("ÁRBOL BINARIO:\n");
        generarDiagrama(raiz, sb, "", true, "");
        JOptionPane.showMessageDialog(this, sb.toString(), "Diagrama del Árbol", JOptionPane.INFORMATION_MESSAGE);
    }

    private void generarDiagrama(Nodo nodo, StringBuilder sb, String prefijo, boolean esUltimo, String dir) {
        if (nodo != null) {
            sb.append(prefijo);
            if (!dir.isEmpty()) {
                sb.append(dir.equals("L") ? "├─I⇨ " : "└─D⇨ ");
            } else {
                sb.append("└── ");
            }
            sb.append("[").append(nodo.valor).append("]").append("\n");

            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");
            boolean tieneHijosDerecho = nodo.derecho != null;
            generarDiagrama(nodo.izquierdo, sb, nuevoPrefijo, !tieneHijosDerecho, "I");
            generarDiagrama(nodo.derecho, sb, nuevoPrefijo, true, "D");
        }
    }
}

