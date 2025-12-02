
package vista;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder; 
import javax.swing.border.LineBorder;  

public class VistaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JTextField campoEmpresa;
    private JButton btnIngresar;

    public VistaLogin() {
        setTitle("Estructura de Datos - Acceso"); //
        setSize(400, 350); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(new BorderLayout()); 

        JLabel titulo = new JLabel("<html><center><b>ESTRUCTURA DE DATOS</b><br><span style='font-size:14px;'>Curso Sof-s-ma-3-2</span></center></html>", JLabel.CENTER);
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 24)); 
        titulo.setForeground(new Color(50, 70, 90)); 
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 10, 20, 10)); 
        add(titulo, BorderLayout.NORTH);

        JPanel panelCampos = new JPanel(new GridLayout(3, 2, 15, 15)); 
        panelCampos.setBackground(new Color(245, 245, 245)); 
        panelCampos.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); 

        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        LineBorder fieldBorder = new LineBorder(new Color(180, 180, 180), 1, true); 
        EmptyBorder fieldPadding = new EmptyBorder(5, 10, 5, 10); 

        // Campo de Usuario
        JLabel lblUsuario = new JLabel("<html><b>👤 Usuario:</b></html>"); 
        lblUsuario.setFont(labelFont);
        panelCampos.add(lblUsuario);
        campoUsuario = new JTextField();
        campoUsuario.setFont(labelFont); 
        campoUsuario.setBorder(BorderFactory.createCompoundBorder(fieldBorder, fieldPadding)); 
        panelCampos.add(campoUsuario);

        // Campo de Contraseña
        JLabel lblContrasena = new JLabel("<html><b>🔒 Contraseña:</b></html>");
        lblContrasena.setFont(labelFont);
        panelCampos.add(lblContrasena);
        campoContrasena = new JPasswordField();
        campoContrasena.setFont(labelFont);
        campoContrasena.setBorder(BorderFactory.createCompoundBorder(fieldBorder, fieldPadding));
        panelCampos.add(campoContrasena);

        // Campo de Empresa
        JLabel lblEmpresa = new JLabel("<html><b>🏢 Empresa:</b></html>");
        lblEmpresa.setFont(labelFont);
        panelCampos.add(lblEmpresa);
        campoEmpresa = new JTextField();
        campoEmpresa.setFont(labelFont);
        campoEmpresa.setBorder(BorderFactory.createCompoundBorder(fieldBorder, fieldPadding));
        panelCampos.add(campoEmpresa);

        add(panelCampos, BorderLayout.CENTER);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 16)); 
        btnIngresar.setBackground(new Color(60, 140, 220)); 
        btnIngresar.setForeground(Color.WHITE); 
        btnIngresar.setFocusPainted(false);
        btnIngresar.setBorder(new EmptyBorder(10, 20, 10, 20)); 
        btnIngresar.setPreferredSize(new Dimension(150, 50)); 

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(new Color(245, 245, 245)); 
        panelBoton.add(btnIngresar);
        panelBoton.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0)); 
        add(panelBoton, BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(245, 245, 245));

        btnIngresar.addActionListener(e -> validarCredenciales());

        setVisible(true); 
    }

    private void validarCredenciales() {
        String usuario = campoUsuario.getText().trim();
        String contrasena = new String(campoContrasena.getPassword()).trim();
        String empresa = campoEmpresa.getText().trim();

        if (usuario.equals("A") && contrasena.equals("123") && empresa.equalsIgnoreCase("UG")) {
            JOptionPane.showMessageDialog(this, "✅ Acceso concedido", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); 
            
            new MenuPrincipal(); 
            
        } else {
            JOptionPane.showMessageDialog(this, "❌ Usuario, contraseña o empresa incorrectos", "Error de Acceso", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VistaLogin());
    }
}