/**
 *
 * @author Ramón Méndez García
 */

package login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModeloUsuario {
    private Connection conexion;

    public ModeloUsuario(Connection conexion) {
        this.conexion = conexion;
    }

    public boolean autenticarUsuario(String nombreUsuario, String contraseña) {
        try {
            String consulta = "SELECT * FROM usuarios WHERE nombreUsuario = ? AND contraseña = ?";
            try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
                statement.setString(1, nombreUsuario);
                statement.setString(2, contraseña);

                try (ResultSet resultadoConsulta = statement.executeQuery()) {
                    return resultadoConsulta.next();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
