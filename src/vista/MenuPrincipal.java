
package vista;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menú Principal - Estructura de Datos");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 20));

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBackground(new Color(230, 245, 255));
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(25, 0, 15, 0));
        
        JLabel tituloPrincipal = new JLabel("<html><center><b>Explora Estructuras de Datos</b><br><span style='font-size:14px;'>Selecciona una opción para comenzar</span></center></html>", JLabel.CENTER);
        tituloPrincipal.setFont(new Font("Segoe UI", Font.BOLD, 28));
        tituloPrincipal.setForeground(new Color(40, 60, 80));
        panelSuperior.add(tituloPrincipal);
        add(panelSuperior, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel(new GridLayout(0, 2, 20, 20));
        panelBotones.setBackground(new Color(248, 250, 252));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(30, 50, 40, 50));

        String[] opciones = {
            "Listas Simples", "Lista Simplemente Enlazadas", "Lista Doblemente Enlazadas",
            "Lista Circulares", "Pilas", "Colas", "Árboles", "Árboles Binarios","Árboles AVL", "Salir"
        };
        
        Font botonFont = new Font("Segoe UI", Font.BOLD, 18);
        Color botonBackground = new Color(90, 160, 230);
        Color botonForeground = Color.WHITE;

        for (String texto : opciones) {
            JButton boton = new JButton(texto);
            boton.setFont(botonFont);
            boton.setBackground(botonBackground);
            boton.setForeground(botonForeground);
            boton.setFocusPainted(false);
            boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 130, 190), 1),
                new EmptyBorder(15, 25, 15, 25)
            ));
            
            panelBotones.add(boton);

            switch (texto) {
                case "Listas Simples":
                    boton.addActionListener(e -> {
                        new VistaArreglos(this);
                        setVisible(false);
                    });
                    break;
                case "Lista Simplemente Enlazadas":
                    boton.addActionListener(e -> {
                        new VistaBusqueda(this);
                        setVisible(false);
                    });
                    break;
                case "Lista Doblemente Enlazadas":
                    boton.addActionListener(e -> {
                        new VistaOrdenamiento(this);
                        setVisible(false);
                    });
                    break;
                case "Lista Circulares":
                    boton.addActionListener(e -> {
                        new VistaRecursividad(this);
                        setVisible(false);
                    });
                    break;
                case "Pilas":
                    boton.addActionListener(e -> {
                        new VistaPilas(this);
                        setVisible(false);
                    });
                    break;
                case "Colas":
                    boton.addActionListener(e -> {
                        new VistaColas(this);
                        setVisible(false);
                    });
                    break;
                case "Árboles":
                    boton.addActionListener(e -> {
                        new VistaArboles(this);
                        setVisible(false);
                    });
                    break;
                case "Árboles Binarios":
                    boton.addActionListener(e -> {
                        new VistaArbolBinario(this);
                        setVisible(false);
                    });
                    break;
                    case "Árboles AVL":
                    boton.addActionListener(e -> {                        
                        new ArbolesAVLVista();                        
                        setVisible(false);                       
                    });
                    break;
                case "Salir":
                    boton.setBackground(new Color(220, 70, 70));
                    boton.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(180, 50, 50), 1),
                        new EmptyBorder(15, 25, 15, 25)
                    ));
                    boton.addActionListener(e -> {
                        int confirm = JOptionPane.showConfirmDialog(this,
                            "¿Estás seguro de que quieres salir?", "Confirmar Salida",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (confirm == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    });
                    break;
            }
        }

        add(panelBotones, BorderLayout.CENTER);
        
        JPanel panelPie = new JPanel();
        panelPie.setBackground(new Color(230, 245, 255));
        JLabel footerLabel = new JLabel("<html><i style='font-size:10px;'>Desarrollado para Curso Sof-s-ma-3-2</i></html>");
        footerLabel.setForeground(new Color(100, 120, 140));
        panelPie.add(footerLabel);
        add(panelPie, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuPrincipal());
    }
}
