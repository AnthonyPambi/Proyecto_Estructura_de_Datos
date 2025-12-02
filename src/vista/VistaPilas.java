package vista;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaPilas extends JFrame {
    private JButton btnPush, btnPop, btnMostrar, btnCambiar, btnDiagrama, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;

    private boolean estructuraElegida = false;
    private boolean esDinamica = true;

    private Nodo tope = null;
    private ArrayList<Integer> pilaArray = new ArrayList<>();

    private static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public VistaPilas(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("PILA (STACK)");
        setSize(750, 520);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(new Color(230, 255, 230));
        add(panelPrincipal);

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 20, 15));
        panelBotones.setBackground(new Color(204, 255, 204));
        panelBotones.setBorder(BorderFactory.createTitledBorder("Operaciones de la Pila"));

        btnPush = new JButton(" Apilar");
        btnPop = new JButton("Desapilar");
        btnMostrar = new JButton("Mostrar Pila");
        btnCambiar = new JButton("Cambiar Estructura");
        btnDiagrama = new JButton("Mostrar Diagrama");
        btnSalir = new JButton("Salir");

        JButton[] botones = {btnPush, btnPop, btnMostrar, btnCambiar, btnDiagrama, btnSalir};
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
        scroll.setBorder(BorderFactory.createTitledBorder("Resultado de Operaciones"));
        panelPrincipal.add(scroll, BorderLayout.CENTER);

        btnPush.addActionListener(e -> push());
        btnPop.addActionListener(e -> pop());
        btnMostrar.addActionListener(e -> mostrarPila());
        btnCambiar.addActionListener(e -> cambiarEstructura());
        btnDiagrama.addActionListener(e -> mostrarDiagrama());
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });

        setVisible(true);
    }

    private void elegirEstructura() {
        Object[] opciones = {"Dinámica (Lista enlazada)", "Estática (Arreglo)"};
        int opcion = JOptionPane.showOptionDialog(this,
                "¿Qué estructura desea usar para la pila?",
                "Elegir estructura",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        esDinamica = (opcion == 0);
        estructuraElegida = true;

        areaResultado.append("✔ Estructura inicial seleccionada: "
                + (esDinamica ? "Dinámica (Lista enlazada)" : "Estática (Arreglo)") + "\n");
    }

    private void push() {
        if (!estructuraElegida) {
            elegirEstructura();
        }
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para apilar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                if (esDinamica) {
                    Nodo nuevo = new Nodo(valor);
                    nuevo.siguiente = tope;
                    tope = nuevo;
                } else {
                    pilaArray.add(valor);
                }
                areaResultado.append("✔ Apilado: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void pop() {
        if (!estructuraElegida) {
            areaResultado.append("⚠ Aún no se ha elegido la estructura.\n");
            return;
        }
        if (esDinamica) {
            if (tope == null) {
                areaResultado.append("⚠ La pila (lista) está vacía.\n");
            } else {
                int valor = tope.valor;
                tope = tope.siguiente;
                areaResultado.append("✔ Desapilado: " + valor + "\n");
            }
        } else {
            if (pilaArray.isEmpty()) {
                areaResultado.append("⚠ La pila (arreglo) está vacía.\n");
            } else {
                int valor = pilaArray.remove(pilaArray.size() - 1);
                areaResultado.append("✔ Desapilado: " + valor + "\n");
            }
        }
    }

    private void mostrarDiagrama() {
        if (!estructuraElegida) {
            areaResultado.append("⚠ Aún no se ha elegido la estructura.\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("📊 DIAGRAMA GRÁFICO DE LA PILA\n");
        sb.append("-----------------------------\n");
        sb.append("TOP\n |");

        if (esDinamica) {
            Nodo temp = tope;
            while (temp != null) {
                sb.append("\n[").append(temp.valor).append("]\n ↓ ");
                temp = temp.siguiente;
            }
        } else {
            for (int i = pilaArray.size() - 1; i >= 0; i--) {
                sb.append("\n[").append(pilaArray.get(i)).append("]\n ↓ ");
            }
        }
        sb.append("\nnull\n");
        sb.append("(").append(esDinamica ? "Lista enlazada" : "Arreglo").append(")");

        JOptionPane.showMessageDialog(this, sb.toString(), "Diagrama de la pila", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarPila() {
        if (!estructuraElegida) {
            areaResultado.append("⚠ Aún no se ha elegido la estructura.\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (esDinamica) {
            sb.append("Pila (Lista enlazada): Top -> ");
            Nodo temp = tope;
            while (temp != null) {
                sb.append("[").append(temp.valor).append("] -> ");
                temp = temp.siguiente;
            }
            sb.append("null\n");
        } else {
            sb.append("Pila (Arreglo): Top -> ");
            for (int i = pilaArray.size() - 1; i >= 0; i--) {
                sb.append("[").append(pilaArray.get(i)).append("] -> ");
            }
            sb.append("null\n");
        }
        areaResultado.append(sb.toString());
    }

    private void cambiarEstructura() {
        if (!estructuraElegida) {
            JOptionPane.showMessageDialog(this, "Primero elija la estructura inicial.");
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Desea migrar los elementos a la nueva estructura?\n(Si no, la pila quedará vacía)",
                "Cambiar Estructura", JOptionPane.YES_NO_CANCEL_OPTION);

        if (opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION) return;

        boolean migrar = (opcion == JOptionPane.YES_OPTION);

        if (esDinamica) {
            pilaArray = new ArrayList<>();
            if (migrar) {
                Nodo temp = tope;
                while (temp != null) {
                    pilaArray.add(0, temp.valor);
                    temp = temp.siguiente;
                }
            }
            tope = null;
            esDinamica = false;
        } else {
            tope = null;
            if (migrar) {
                for (int i = pilaArray.size() - 1; i >= 0; i--) {
                    Nodo nuevo = new Nodo(pilaArray.get(i));
                    nuevo.siguiente = tope;
                    tope = nuevo;
                }
            }
            pilaArray.clear();
            esDinamica = true;
        }

        areaResultado.append("🔄 Estructura cambiada a: "
                + (esDinamica ? "Dinámica (Lista enlazada)" : "Estática (Arreglo)")
                + (migrar ? " con migración de datos.\n" : " (vacía).\n"));
    }
}
