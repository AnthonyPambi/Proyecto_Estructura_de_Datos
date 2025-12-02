
package main;
import vista.VistaLogin;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VistaLogin();
        });
    }
}