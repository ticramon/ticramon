/**
 *
 * @author Ramón Méndez García
 */

package login;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VistaLogin extends JFrame {
    JPanel panel = new JPanel(null);
    
    private JLabel labelUsuario, labelContraseña;
    private JTextField textoUsuario;
    private JPasswordField contraseñaContraseña;
    private JButton botonLogin;
    
    
    public VistaLogin() {
        
        setTitle("Login");
        

        labelUsuario = new JLabel("Usuario");
        labelContraseña = new JLabel("Contraseña");
        textoUsuario = new JTextField(15);
        contraseñaContraseña = new JPasswordField(15);
        botonLogin = new JButton("Login");

        panel.add(labelUsuario);
        panel.add(textoUsuario);
        panel.add(labelContraseña);
        panel.add(contraseñaContraseña);
        panel.add(botonLogin);
        panel.setBounds(MAXIMIZED_HORIZ, MAXIMIZED_VERT, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
        
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
        setUndecorated(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().add(panel);
        setBackground(Color.DARK_GRAY);
        panel.setBackground(Color.darkGray);
        
        labelUsuario.setForeground(Color.WHITE);
        labelUsuario.setBounds(10, 10, 120, 20);
        textoUsuario.setForeground(Color.WHITE);
        textoUsuario.setBackground(Color.darkGray);
        textoUsuario.setBounds(180, 10, 180, 20);
        
        labelContraseña.setForeground(Color.WHITE);
        labelContraseña.setBounds(10, 40, 120, 20);
        contraseñaContraseña.setForeground(Color.WHITE);
        contraseñaContraseña.setBackground(Color.darkGray);
        contraseñaContraseña.setBounds(180, 40, 180, 20);
        
        botonLogin.setForeground(Color.WHITE);
        botonLogin.setBackground(Color.decode("#009d71"));
        botonLogin.setBounds(10, 70, 350, 20);
        
        // Add KeyListener to the contraseñaContraseña field
        contraseñaContraseña.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Trigger the button's action when Enter is pressed
                    botonLogin.doClick();
                }
            }
        });
        
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle login button click
                login();
            }
        });
    }
    
    
    public String getNombreUsuario() {
        return textoUsuario.getText();
    }

    public String getContraseña() {
        return new String(contraseñaContraseña.getPassword());
    }

    public void setLoginListener(ActionListener listener) {
        botonLogin.addActionListener(listener);
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void login() {
        // Login functionality is handled by the controller
    }
    
}
