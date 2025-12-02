
package vista;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VistaOrdenamiento extends JFrame {
    private JButton btnInsertarInicio, btnInsertarFinal, btnEliminar, btnMostrarAdelante, btnMostrarAtras, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;

    private Nodo cabeza = null;
    private Nodo cola = null;

    private static class Nodo {
        int valor;
        Nodo siguiente;
        Nodo anterior;

        Nodo(int valor) {
            this.valor = valor;
        }
    }

    public VistaOrdenamiento(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("LISTA DOBLEMENTE ENLAZADA");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelBotones = new JPanel(new GridLayout(1, 6, 15, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        panelBotones.setBackground(new Color(230, 255, 230));

        btnInsertarInicio = crearBoton("Insertar al inicio");
        btnInsertarFinal = crearBoton("Insertar al final");
        btnEliminar = crearBoton("Eliminar nodo");
        btnMostrarAdelante = crearBoton("Mostrar adelante");
        btnMostrarAtras = crearBoton("Mostrar atrás");
        btnSalir = crearBoton("Salir");

        panelBotones.add(btnInsertarInicio);
        panelBotones.add(btnInsertarFinal);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrarAdelante);
        panelBotones.add(btnMostrarAtras);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Estado de la lista"));
        add(scroll, BorderLayout.CENTER);

        getContentPane().setBackground(new Color(230, 255, 230));

        btnInsertarInicio.addActionListener(e -> insertarInicio());
        btnInsertarFinal.addActionListener(e -> insertarFinal());
        btnEliminar.addActionListener(e -> eliminarNodo());
        btnMostrarAdelante.addActionListener(e -> mostrarAdelante());
        btnMostrarAtras.addActionListener(e -> mostrarAtras());
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });

        setVisible(true);
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setBackground(new Color(0, 153, 76));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        return btn;
    }

    private void insertarInicio() {
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para insertar al inicio:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                Nodo nuevo = new Nodo(valor);
                if (cabeza == null) {
                    cabeza = cola = nuevo;
                } else {
                    nuevo.siguiente = cabeza;
                    cabeza.anterior = nuevo;
                    cabeza = nuevo;
                }
                areaResultado.append("✔ Nodo insertado al inicio: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void insertarFinal() {
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para insertar al final:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                Nodo nuevo = new Nodo(valor);
                if (cabeza == null) {
                    cabeza = cola = nuevo;
                } else {
                    cola.siguiente = nuevo;
                    nuevo.anterior = cola;
                    cola = nuevo;
                }
                areaResultado.append("✔ Nodo insertado al final: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarNodo() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el número del nodo a eliminar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                Nodo actual = cabeza;
                while (actual != null && actual.valor != valor) {
                    actual = actual.siguiente;
                }

                if (actual == null) {
                    areaResultado.append("❌ Nodo con valor " + valor + " no encontrado.\n");
                    return;
                }

                if (actual == cabeza) {
                    cabeza = cabeza.siguiente;
                    if (cabeza != null) cabeza.anterior = null;
                    else cola = null;
                } else if (actual == cola) {
                    cola = cola.anterior;
                    cola.siguiente = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                }

                areaResultado.append("✔ Nodo eliminado: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarAdelante() {
        if (cabeza == null) {
            areaResultado.append("⚠ La lista está vacía.\n");
            return;
        }
        StringBuilder sb = new StringBuilder("Lista adelante: ");
        Nodo temp = cabeza;
        while (temp != null) {
            sb.append("[").append(temp.valor).append("] <-> ");
            temp = temp.siguiente;
        }
        sb.append("null\n");
        areaResultado.append(sb.toString());
    }

    private void mostrarAtras() {
        if (cola == null) {
            areaResultado.append("⚠ La lista está vacía.\n");
            return;
        }
        StringBuilder sb = new StringBuilder("Lista atrás: ");
        Nodo temp = cola;
        while (temp != null) {
            sb.append("[").append(temp.valor).append("] <-> ");
            temp = temp.anterior;
        }
        sb.append("null\n");
        areaResultado.append(sb.toString());
    }
}

