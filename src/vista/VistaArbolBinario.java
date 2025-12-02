package vista;
import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class VistaArbolBinario extends JFrame {

    private JButton btnInsertar, btnBuscar, btnEliminar, btnInorden, btnPreorden, btnPostorden, btnNivel, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;

    private Nodo raiz = null;

    private static class Nodo {
        int valor;
        Nodo izquierda, derecha;

        Nodo(int valor) {
            this.valor = valor;
            izquierda = derecha = null;
        }
    }

    public VistaArbolBinario(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        setTitle("Árbol Binario");
        setSize(750, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 255, 230));
        setLayout(new BorderLayout(10, 10));

        JPanel panelBotones = new JPanel(new GridLayout(2, 4, 10, 10));
        panelBotones.setBackground(new Color(230, 255, 230));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        
        btnInsertar = new JButton("Insertar");
        btnBuscar = new JButton("Buscar");
        btnEliminar = new JButton("Eliminar");
        btnInorden = new JButton("Inorden");
        btnPreorden = new JButton("Preorden");
        btnPostorden = new JButton("Postorden");
        btnNivel = new JButton("Nivel por Nivel");
        btnSalir = new JButton("Salir");

        Font btnFont = new Font("Arial", Font.BOLD, 14);
        Color btnColor = new Color(0, 153, 76);
        Color txtColor = Color.WHITE;

        for (JButton btn : new JButton[]{btnInsertar, btnBuscar, btnEliminar, btnInorden, btnPreorden, btnPostorden, btnNivel, btnSalir}) {
            btn.setFont(btnFont);
            btn.setBackground(btnColor);
            btn.setForeground(txtColor);
            panelBotones.add(btn);
        }

        add(panelBotones, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Recorridos y Operaciones"));
        add(scroll, BorderLayout.CENTER);

        btnInsertar.addActionListener(e -> insertar());
        btnBuscar.addActionListener(e -> buscar());
        btnEliminar.addActionListener(e -> eliminar());
        btnInorden.addActionListener(e -> recorrer("inorden"));
        btnPreorden.addActionListener(e -> recorrer("preorden"));
        btnPostorden.addActionListener(e -> recorrer("postorden"));
        btnNivel.addActionListener(e -> recorrer("nivel"));
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });
        
        setVisible(true);
    }

    private Nodo insertarNodo(Nodo nodo, int valor) {
        if (nodo == null) return new Nodo(valor);
        if (valor < nodo.valor) nodo.izquierda = insertarNodo(nodo.izquierda, valor);
        else if (valor > nodo.valor) nodo.derecha = insertarNodo(nodo.derecha, valor);
        return nodo;
    }

    private boolean buscarNodo(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor ? buscarNodo(nodo.izquierda, valor) : buscarNodo(nodo.derecha, valor);
    }

    private Nodo eliminarNodo(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (valor < nodo.valor) nodo.izquierda = eliminarNodo(nodo.izquierda, valor);
        else if (valor > nodo.valor) nodo.derecha = eliminarNodo(nodo.derecha, valor);
        else {
            if (nodo.izquierda == null) return nodo.derecha;
            if (nodo.derecha == null) return nodo.izquierda;
            Nodo sucesor = encontrarMin(nodo.derecha);
            nodo.valor = sucesor.valor;
            nodo.derecha = eliminarNodo(nodo.derecha, sucesor.valor);
        }
        return nodo;
    }

    private Nodo encontrarMin(Nodo nodo) {
        while (nodo.izquierda != null) nodo = nodo.izquierda;
        return nodo;
    }

    private void recorrer(String tipo) {
        StringBuilder sb = new StringBuilder();
        switch (tipo) {
            case "inorden":
                inorden(raiz, sb);
                break;
            case "preorden":
                preorden(raiz, sb);
                break;
            case "postorden":
                postorden(raiz, sb);
                break;
            case "nivel":
                nivelPorNivel(raiz, sb);
                break;
        }
        areaResultado.append("📂 Recorrido " + tipo + ": " + sb.toString() + "\n");
    }

    private void inorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            inorden(nodo.izquierda, sb);
            sb.append(nodo.valor).append(" ");
            inorden(nodo.derecha, sb);
        }
    }

    private void preorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.valor).append(" ");
            preorden(nodo.izquierda, sb);
            preorden(nodo.derecha, sb);
        }
    }

    private void postorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            postorden(nodo.izquierda, sb);
            postorden(nodo.derecha, sb);
            sb.append(nodo.valor).append(" ");
        }
    }

    private void nivelPorNivel(Nodo nodo, StringBuilder sb) {
        if (nodo == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(nodo);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            sb.append(actual.valor).append(" ");
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    private void insertar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el número a insertar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                raiz = insertarNodo(raiz, valor);
                areaResultado.append("✔ Insertado: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void buscar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el número a buscar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                boolean encontrado = buscarNodo(raiz, valor);
                areaResultado.append(encontrado ? "✔ Encontrado: " + valor + "\n" : "✖ No encontrado: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminar() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el número a eliminar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                raiz = eliminarNodo(raiz, valor);
                areaResultado.append("✔ Eliminado (si existía): " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
