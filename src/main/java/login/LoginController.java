/**
 *
 * @author Ramón Méndez García
 */

package login;
import db.ConexionDB;
import formularios.FramePrincipal;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginController {
    private VistaLogin vistaLogin;
    private ModeloUsuario modeloUsuario;

    public LoginController(VistaLogin vistaLogin, ModeloUsuario modeloUsuario) {
        this.vistaLogin = vistaLogin;
        this.modeloUsuario = modeloUsuario;
        this.vistaLogin.setLoginListener(new LoginListener());
    }

    private class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nombreUsuario = vistaLogin.getNombreUsuario();
            String contraseña = vistaLogin.getContraseña();

            try {
                // Establish database connection
                Connection conexionDB = ConexionDB.getConnection();

                ModeloUsuario modeloUsuario = new ModeloUsuario(conexionDB);

                if (modeloUsuario.autenticarUsuario(nombreUsuario, contraseña)) {
                    JOptionPane.showMessageDialog(vistaLogin, "Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                    openMainApplication();
                } else {
                    vistaLogin.showErrorMessage("Invalid username or password");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    private void openMainApplication() {
        FramePrincipal example = new FramePrincipal();
        example.setVisible(true);
        vistaLogin.dispose(); // Close the login frame after successful login
    }
}
