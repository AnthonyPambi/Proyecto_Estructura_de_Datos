
package vista;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VistaArreglos extends JFrame {
    private MenuPrincipal menuPrincipal;
    private ArrayList<Integer> arreglo;
    private JTextArea areaMostrar;

    public VistaArreglos(MenuPrincipal menu) {
        this.menuPrincipal = menu;
        this.arreglo = new ArrayList<>();

        setTitle("Gestión de Lista");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

       
        JPanel panelBotones = new JPanel(new GridLayout(2, 5, 18, 12));
        JButton btnInsertarInicio = new JButton("Insertar al inicio");
        JButton btnInsertarFinal = new JButton("Insertar al final");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnModificar = new JButton("Modificar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnInsertarInicio);
        panelBotones.add(btnInsertarFinal);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.NORTH);

        
        areaMostrar = new JTextArea();
        areaMostrar.setEditable(false);
        areaMostrar.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaMostrar);
        scroll.setBorder(BorderFactory.createTitledBorder("Lista actual"));
        add(scroll, BorderLayout.CENTER);

      
        btnInsertarInicio.addActionListener(e -> {
       String input = JOptionPane.showInputDialog(this, "Ingrese un número para insertar al inicio:");
       if (input != null) {
        try {
            int valor = Integer.parseInt(input.trim());
            arreglo.add(0, valor); 
            actualizarArea();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
         }
          });
        
        btnInsertarFinal.addActionListener(e -> {
        String input = JOptionPane.showInputDialog(this, "Ingrese un número para insertar al final:");
        if (input != null) {
        try {
            int valor = Integer.parseInt(input.trim());
            arreglo.add(valor); 
            actualizarArea();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
          }
         }
        });


        
        btnEliminar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese un número para eliminar:");
            if (input != null) {
                try {
                    int valor = Integer.parseInt(input.trim());
                    if (arreglo.remove((Integer) valor)) {
                        actualizarArea();
                    } else {
                        JOptionPane.showMessageDialog(this, "El valor no se encontró en la Lista.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        
        btnModificar.addActionListener(e -> {
            String inputViejo = JOptionPane.showInputDialog(this, "Ingrese el número a modificar:");
            if (inputViejo != null) {
                try {
                    int valorViejo = Integer.parseInt(inputViejo.trim());
                    int index = arreglo.indexOf(valorViejo);
                    if (index >= 0) {
                        String inputNuevo = JOptionPane.showInputDialog(this, "Ingrese el nuevo valor:");
                        if (inputNuevo != null) {
                            try {
                                int valorNuevo = Integer.parseInt(inputNuevo.trim());
                                arreglo.set(index, valorNuevo);
                                actualizarArea();
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(this, "Ingrese un número válido para el nuevo valor", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "El valor a modificar no se encontró.", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un número válido para modificar", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        btnBuscar.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Ingrese un número para buscar:");
            if (input != null) {
                try {
                    int valor = Integer.parseInt(input.trim());
                    int index = arreglo.indexOf(valor);
                    if (index >= 0) {
                        JOptionPane.showMessageDialog(this, "Valor encontrado en la posición: " + index);
                    } else {
                        JOptionPane.showMessageDialog(this, "Valor no encontrado en la Lista.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Ingrese un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        
        btnSalir.addActionListener(e -> {
            this.dispose();
            menuPrincipal.setVisible(true);
        });

        actualizarArea();
        setVisible(true);
    }

    private void actualizarArea() {
        areaMostrar.setText(arreglo.toString());
    }
}


