/**
 *
 * @author Ramón Méndez García
 */

package tablas;



import db.ConexionDB;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class ConsultaSQL extends JFrame {

    private JTable table;

    public ConsultaSQL() {
        setTitle("MariaDB JTable Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        table = new JTable();

        // Set layout
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Fetch data from MariaDB and populate the table
        fetchAndPopulateData();

        setSize(600, 400);
        setLocationRelativeTo(null);
    }

    private void fetchAndPopulateData() {
        // SQL query
        final String query = "SELECT nombreUsuario FROM usuarios";

        try {
            // Establish a connection to the database
            Connection conexionDB = ConexionDB.getConnection();
            // Create a statement
            Statement statement = conexionDB.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Get metadata about the result set
            int columnCount = resultSet.getMetaData().getColumnCount();

            // Create a vector to hold column names
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(resultSet.getMetaData().getColumnName(i));
            }

            // Create a vector to hold data
            Vector<Vector<Object>> data = new Vector<>();
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                data.add(row);
            }

            // Create a DefaultTableModel and set it to the JTable
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table.setModel(model);

            // Close resources
            resultSet.close();
            statement.close();
            conexionDB.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ConsultaSQL example = new ConsultaSQL();
            example.setVisible(true);
        });
    }
}
