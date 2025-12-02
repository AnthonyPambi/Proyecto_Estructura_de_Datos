
package vista;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaColas extends JFrame {

    private JButton btnEnqueue, btnDequeue, btnMostrar, btnCambiar, btnDiagrama, btnSalir;
    private JTextArea areaResultado;
    private JFrame menuPrincipal;

    private boolean estructuraElegida = false;
    private boolean esDinamica = true;

    private Nodo frente = null, fin = null;  
    private ArrayList<Integer> colaArray = new ArrayList<>();  

    private static class Nodo {
        int valor;
        Nodo siguiente;
        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }

    public VistaColas(JFrame menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        setTitle("COLA ");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelBotones = new JPanel(new GridLayout(1, 6, 10, 10));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        btnEnqueue = new JButton("Encolar");
        btnDequeue = new JButton("Desencolar");
        btnMostrar = new JButton("Mostrar Cola");
        btnCambiar = new JButton("Cambiar Estructura");
        btnDiagrama = new JButton("Mostrar Diagrama");
        btnSalir = new JButton("Salir");

        Font btnFont = new Font("Arial", Font.BOLD, 14);
        btnEnqueue.setFont(btnFont);
        btnDequeue.setFont(btnFont);
        btnMostrar.setFont(btnFont);
        btnCambiar.setFont(btnFont);
        btnDiagrama.setFont(btnFont);
        btnSalir.setFont(btnFont);

        panelBotones.add(btnEnqueue);
        panelBotones.add(btnDequeue);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnCambiar);
        panelBotones.add(btnDiagrama);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.NORTH);

        areaResultado = new JTextArea();
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Estado de la Cola"));
        add(scroll, BorderLayout.CENTER);

        
        btnEnqueue.addActionListener(e -> enqueue());
        btnDequeue.addActionListener(e -> dequeue());
        btnMostrar.addActionListener(e -> mostrarCola());
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
                "¿Qué estructura desea usar para la cola?",
                "Elegir estructura",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, opciones, opciones[0]);

        esDinamica = (opcion == 0);
        estructuraElegida = true;

        areaResultado.append("✔ Estructura inicial seleccionada: "
                + (esDinamica ? "Dinámica (Lista enlazada)\n" : "Estática (Arreglo)\n"));
    }

    
    private void enqueue() {
        if (!estructuraElegida) {
            elegirEstructura();
        }
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para encolar:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                int valor = Integer.parseInt(input.trim());
                if (esDinamica) {
                    Nodo nuevo = new Nodo(valor);
                    if (frente == null) {
                        frente = fin = nuevo;
                    } else {
                        fin.siguiente = nuevo;
                        fin = nuevo;
                    }
                } else {
                    colaArray.add(valor);
                }
                areaResultado.append("✔ Encolado: " + valor + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

   
    private void dequeue() {
        if (!estructuraElegida) {
            areaResultado.append("⚠ Aún no se ha elegido la estructura.\n");
            return;
        }

        if (esDinamica) {
            if (frente == null) {
                areaResultado.append("⚠ La cola (lista) está vacía.\n");
            } else {
                int valor = frente.valor;
                frente = frente.siguiente;
                if (frente == null) fin = null; // se vació
                areaResultado.append("✔ Desencolado: " + valor + "\n");
            }
        } else {
            if (colaArray.isEmpty()) {
                areaResultado.append("⚠ La cola (arreglo) está vacía.\n");
            } else {
                int valor = colaArray.remove(0);
                areaResultado.append("✔ Desencolado: " + valor + "\n");
            }
        }
    }

   
    private void mostrarCola() {
        if (!estructuraElegida) {
            areaResultado.append("⚠ Aún no se ha elegido la estructura.\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        if (esDinamica) {
            sb.append("Cola (Lista enlazada): Inicio -> ");
            Nodo temp = frente;
            while (temp != null) {
                sb.append("[").append(temp.valor).append("] -> ");
                temp = temp.siguiente;
            }
            sb.append("null\n");
        } else {
            sb.append("Cola (Arreglo): Inicio -> ");
            for (int i = 0; i < colaArray.size(); i++) {
                sb.append("[").append(colaArray.get(i)).append("] -> ");
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
                "¿Desea migrar los elementos a la nueva estructura?\n(Si no, la cola quedará vacía)",
                "Cambiar Estructura", JOptionPane.YES_NO_CANCEL_OPTION);

        if (opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION) return;

        boolean migrar = (opcion == JOptionPane.YES_OPTION);

        if (esDinamica) {
            colaArray = new ArrayList<>();
            if (migrar) {
                Nodo temp = frente;
                while (temp != null) {
                    colaArray.add(temp.valor);
                    temp = temp.siguiente;
                }
            }
            frente = fin = null;
            esDinamica = false;
        } else {
            frente = fin = null;
            if (migrar) {
                for (int i = 0; i < colaArray.size(); i++) {
                    Nodo nuevo = new Nodo(colaArray.get(i));
                    if (frente == null) {
                        frente = fin = nuevo;
                    } else {
                        fin.siguiente = nuevo;
                        fin = nuevo;
                    }
                }
            }
            colaArray.clear();
            esDinamica = true;
        }

        areaResultado.append("🔄 Estructura cambiada a: "
                + (esDinamica ? "Dinámica (Lista enlazada)" : "Estática (Arreglo)")
                + (migrar ? " con migración de datos.\n" : " (vacía).\n"));
    }

    
    private void mostrarDiagrama() {
        if (!estructuraElegida) {
            areaResultado.append("⚠ Aún no se ha elegido la estructura.\n");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("📊 DIAGRAMA GRÁFICO DE LA COLA\n");
        sb.append("------------------------------\n");
        sb.append("INICIO\n |\n");

        if (esDinamica) {
            Nodo temp = frente;
            while (temp != null) {
                sb.append("[").append(temp.valor).append("]\n");
                sb.append(" ↓ \n");
                temp = temp.siguiente;
            }
        } else {
            for (int i = 0; i < colaArray.size(); i++) {
                sb.append("[").append(colaArray.get(i)).append("]\n");
                sb.append(" ↓ \n");
            }
        }
        sb.append("null\n");
        sb.append("(").append(esDinamica ? "Lista enlazada" : "Arreglo").append(")");

        JOptionPane.showMessageDialog(this, sb.toString(), "Diagrama de la Cola", JOptionPane.INFORMATION_MESSAGE);
    }
}

