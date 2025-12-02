
package vista;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class VistaBusqueda extends JFrame {
    private JButton btnInsertarInicio, btnInsertarFinal,btnEliminar,btnMostrar, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;
    
     private Nodo cabeza = null;
     
     private static class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public VistaBusqueda(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("LISTA ENLAZADA");
        setSize(700, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 15, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        btnInsertarInicio = new JButton("Insertar al inicio");
        btnInsertarFinal = new JButton("Insertar al final");
        btnEliminar = new JButton("Eliminar nodo");
        btnMostrar = new JButton("Mostrar lista");
        btnSalir = new JButton("Salir");

        Font btnFont = new Font("Arial", Font.BOLD, 14);
        btnInsertarInicio.setFont(btnFont);
        btnInsertarFinal.setFont(btnFont);
        btnEliminar.setFont(btnFont);
        btnMostrar.setFont(btnFont);
        btnSalir.setFont(btnFont);

        panelBotones.add(btnInsertarInicio);
        panelBotones.add(btnInsertarFinal);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Estado de la lista"));
        add(scroll, BorderLayout.CENTER);

        //Acciones
        btnInsertarInicio.addActionListener(e -> insertarInicio());
        btnInsertarFinal.addActionListener(e -> insertarFinal());
        btnEliminar.addActionListener(e -> eliminarNodo());
        btnMostrar.addActionListener(e -> mostrarLista());
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });

        setVisible(true);
    }
    
    private void insertarInicio() {
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para insertar al inicio:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                Nodo nuevo = new Nodo(valor);
                nuevo.siguiente = cabeza;
                cabeza = nuevo;
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
                    cabeza = nuevo;
                } else {
                    Nodo temp = cabeza;
                    while (temp.siguiente != null) {
                        temp = temp.siguiente;
                    }
                    temp.siguiente = nuevo;
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
                if (cabeza == null) {
                    areaResultado.append("⚠ La lista está vacía.\n");
                    return;
                }

                if (cabeza.valor == valor) {
                    cabeza = cabeza.siguiente;
                    areaResultado.append("✔ Nodo eliminado: " + valor + "\n");
                    return;
                }

                Nodo temp = cabeza;
                while (temp.siguiente != null && temp.siguiente.valor != valor) {
                    temp = temp.siguiente;
                }

                if (temp.siguiente != null) {
                    temp.siguiente = temp.siguiente.siguiente;
                    areaResultado.append("✔ Nodo eliminado: " + valor + "\n");
                } else {
                    areaResultado.append("❌ Nodo con valor " + valor + " no encontrado.\n");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void mostrarLista() {
        if (cabeza == null) {
            areaResultado.append("⚠ La lista está vacía.\n");
            return;
        }

        StringBuilder sb = new StringBuilder("Lista: ");
        Nodo temp = cabeza;
        while (temp != null) {
            sb.append("[").append(temp.valor).append("] -> ");
            temp = temp.siguiente;
        }
        sb.append("null\n");

        areaResultado.append(sb.toString());
    }
}

