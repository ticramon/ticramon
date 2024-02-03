/**
 *
 * @author Ramón Méndez García
 * 
 * FormularioDomicilio
 */

package formularios;
import db.ConexionDB;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FormularioDireccion extends JPanel {
    private FramePrincipal mainFrame;
    
    JLabel labelTipoCalle = new JLabel("Tipo de calle");
    JComboBox comboboxTipoCalle = new JComboBox();
    JLabel labelCalle = new JLabel("Nombre de calle");
    JTextField textoNombreCalle = new JTextField(10);
    JLabel labelNumeroExteriorCalle = new JLabel("Numero Ext.");
    JTextField textoNumeroExteriorCalle = new JTextField(3);
    JLabel labelNumeroInteriorCalle = new JLabel("Numero Int.");
    JTextField textoNumeroInteriorCalle = new JTextField(3);
    JLabel labelAdicionalDomicilio = new JLabel("Adicional");
    JTextField textoAdicionalDomicilio = new JTextField(5);
    JLabel labelContinente = new JLabel("Contin.");
    JComboBox comboBoxContinente=new JComboBox();
    JLabel labelPais = new JLabel("Pais");
    JComboBox comboBoxPais=new JComboBox();
    JLabel labelEstado = new JLabel("Estado");
    JComboBox comboBoxEstado=new JComboBox();
    JLabel labelCiudad = new JLabel("Ciudad");
    JComboBox comboBoxCiudad=new JComboBox();
    JLabel labelTipoComunidad = new JLabel("Tipo comun.");
    JComboBox comboboxTipoComunidad = new JComboBox();
    JLabel labelNombreComunidad = new JLabel("Nombre comun.");
    JTextField textoNombreComunidad = new JTextField(10);
    JLabel labelCodigoPostal = new JLabel("Codigo postal");
    JTextField textoCodigoPostal = new JTextField(3);
    JLabel labelReferenciasAdicionales = new JLabel("Referencias");
    JTextField textoReferenciasAdicionales = new JTextField(10);
    JButton switchButton = new JButton("Continuar con datos de contacto");
    
    public FormularioDireccion(int width, int height, FramePrincipal mainFrame) {
        this.mainFrame = mainFrame;
        setBackground(Color.darkGray);
        setLayout(null);
        
        
        
        add(labelTipoCalle);
        add(comboboxTipoCalle);
        comboboxTipoCalle.addItem("");
        comboboxTipoCalle.addItem("Calle");
        comboboxTipoCalle.addItem("Avenida");
        comboboxTipoCalle.addItem("Boulevard");
        comboboxTipoCalle.addItem("Callejon");
        add(labelCalle);
        add(textoNombreCalle);
        add(labelNumeroExteriorCalle);
        add(textoNumeroExteriorCalle);
        add(labelNumeroInteriorCalle);
        add(textoNumeroInteriorCalle);
        add(labelAdicionalDomicilio);
        add(textoAdicionalDomicilio);
        add(labelTipoComunidad);
        add(comboboxTipoComunidad);
        comboboxTipoComunidad.addItem("");
        comboboxTipoComunidad.addItem("Rancho");
        comboboxTipoComunidad.addItem("Colonia");
        comboboxTipoComunidad.addItem("Barrio");
        comboboxTipoComunidad.addItem("Pueblo");
        comboboxTipoComunidad.addItem("Hacienda");
        comboboxTipoComunidad.addItem("Ejido");
        add(labelNombreComunidad);
        add(textoNombreComunidad);
        add(labelCodigoPostal);
        add(textoCodigoPostal);
        add(labelContinente);
        add(comboBoxContinente);
        add(labelPais);
        add(comboBoxPais);
        add(labelEstado);
        add(comboBoxEstado);
        add(labelCiudad);
        add(comboBoxCiudad);
        add(labelReferenciasAdicionales);
        add(textoReferenciasAdicionales);
        add(switchButton);
        
        llenarComboboxContinentes();
        
        labelTipoCalle.setHorizontalAlignment(SwingConstants.LEFT);
        labelCalle.setHorizontalAlignment(SwingConstants.RIGHT);
        labelNumeroExteriorCalle.setHorizontalAlignment(SwingConstants.LEFT);
        labelNumeroInteriorCalle.setHorizontalAlignment(SwingConstants.RIGHT);
        labelAdicionalDomicilio.setHorizontalAlignment(SwingConstants.RIGHT);
        labelTipoComunidad.setHorizontalAlignment(SwingConstants.LEFT);
        labelNombreComunidad.setHorizontalAlignment(SwingConstants.RIGHT);
        labelContinente.setHorizontalAlignment(SwingConstants.LEFT);
        labelPais.setHorizontalAlignment(SwingConstants.RIGHT);
        labelEstado.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
        labelCodigoPostal.setHorizontalAlignment(SwingConstants.LEFT);
        labelReferenciasAdicionales.setHorizontalAlignment(SwingConstants.RIGHT);
        
        labelTipoCalle.setForeground(Color.WHITE);
        comboboxTipoCalle.setForeground(Color.WHITE);
        comboboxTipoCalle.setBackground(Color.darkGray);
        labelCalle.setForeground(Color.WHITE);
        textoNombreCalle.setForeground(Color.WHITE);
        textoNombreCalle.setBackground(Color.darkGray);
        labelNumeroExteriorCalle.setForeground(Color.WHITE);
        textoNumeroExteriorCalle.setForeground(Color.WHITE);
        textoNumeroExteriorCalle.setBackground(Color.darkGray);
        labelNumeroInteriorCalle.setForeground(Color.WHITE);
        textoNumeroInteriorCalle.setForeground(Color.WHITE);
        textoNumeroInteriorCalle.setBackground(Color.darkGray);
        labelAdicionalDomicilio.setForeground(Color.WHITE);
        textoAdicionalDomicilio.setForeground(Color.WHITE);
        textoAdicionalDomicilio.setBackground(Color.darkGray);
        labelTipoComunidad.setForeground(Color.WHITE);
        comboboxTipoComunidad.setForeground(Color.WHITE);
        comboboxTipoComunidad.setBackground(Color.darkGray);
        labelNombreComunidad.setForeground(Color.WHITE);
        textoNombreComunidad.setForeground(Color.WHITE);
        textoNombreComunidad.setBackground(Color.darkGray);
        labelCodigoPostal.setForeground(Color.WHITE);
        textoCodigoPostal.setForeground(Color.WHITE);
        textoCodigoPostal.setBackground(Color.darkGray);
        labelContinente.setForeground(Color.WHITE);
        comboBoxContinente.setForeground(Color.WHITE);
        comboBoxContinente.setBackground(Color.darkGray);
        labelPais.setForeground(Color.WHITE);
        comboBoxPais.setForeground(Color.WHITE);
        comboBoxPais.setBackground(Color.darkGray);
        labelEstado.setForeground(Color.WHITE);
        comboBoxEstado.setForeground(Color.WHITE);
        comboBoxEstado.setBackground(Color.darkGray);
        labelCiudad.setForeground(Color.WHITE);
        comboBoxCiudad.setForeground(Color.WHITE);
        comboBoxCiudad.setBackground(Color.darkGray);
        labelReferenciasAdicionales.setForeground(Color.WHITE);
        textoReferenciasAdicionales.setForeground(Color.WHITE);
        textoReferenciasAdicionales.setBackground(Color.darkGray);
        switchButton.setForeground(Color.WHITE);
        switchButton.setBackground(Color.decode("#009d71"));
        
        labelTipoCalle.setBounds(10,10,80,20);
        comboboxTipoCalle.setBounds(100,10,130,20);
        labelCalle.setBounds(240,10,110,20);
        textoNombreCalle.setBounds(360,10,140,20);
        
        labelNumeroExteriorCalle.setBounds(10,40,80,20);
        textoNumeroExteriorCalle.setBounds(100,40,40,20);
        labelNumeroInteriorCalle.setBounds(150,40,80,20);
        textoNumeroInteriorCalle.setBounds(240,40,40,20);
        labelAdicionalDomicilio.setBounds(290,40,60,20);
        textoAdicionalDomicilio.setBounds(360,40,140,20);
        labelTipoComunidad.setBounds(10,70,80,20);
        comboboxTipoComunidad.setBounds(100,70,130,20);
        labelNombreComunidad.setBounds(240,70,110,20);
        textoNombreComunidad.setBounds(360,70,140,20);
        labelContinente.setBounds(10,100,50,20);
        comboBoxContinente.setBounds(70,100,60,20);
        labelPais.setBounds(130,100,40,20);
        comboBoxPais.setBounds(180,100,50,20);
        labelEstado.setBounds(240,100,50,20);
        comboBoxEstado.setBounds(300,100,50,20);
        labelCiudad.setBounds(360,100,50,20);
        comboBoxCiudad.setBounds(420,100,80,20);
        
        labelCodigoPostal.setBounds(10,130,90,20);
        textoCodigoPostal.setBounds(110,130,60,20);
        labelReferenciasAdicionales.setBounds(180,130,70,20);
        textoReferenciasAdicionales.setBounds(260,130,240,20);
        
        switchButton.setBounds(10, 160, 490, 20);
        
        switchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the FormularioDireccion panel
                mainFrame.showPanel("contacto");
            }
        });
        
        comboBoxContinente.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // When a category is selected, update the subcategories in the second combo box
                    actualizarPaises((String) comboBoxContinente.getSelectedItem());
                }
            }
        });
        
        comboBoxPais.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // When a category is selected, update the subcategories in the second combo box
                    actualizarEstados((String) comboBoxPais.getSelectedItem());
                }
            }
        });

    }
    
    private void llenarComboboxContinentes() {
        try {
            // Load the JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");
            // Connect to the MariaDB database using the ConnectionDB class
            try (Connection connection = ConexionDB.getConnection()) {
                String query = "SELECT nombreContinente FROM continentes";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Clear existing items
                    comboBoxContinente.removeAllItems();
                    // Populate the ComboBox with data from the query result
                    while (resultSet.next()) {
                        String item = resultSet.getString("nombreContinente");
                        comboBoxContinente.addItem(item);
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void actualizarPaises(String continenteSeleccionado) {
        comboBoxPais.removeAllItems();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            try (Connection connection = ConexionDB.getConnection()) {
                String query = "SELECT p.nombrePais  \n" +
                "FROM paises p INNER JOIN continentes c on p.idContinente = c.idContinente\n" +
                "WHERE c.nombreContinente = ? ORDER BY p.nombrePais";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, continenteSeleccionado);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            comboBoxPais.addItem(resultSet.getString("nombrePais"));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void actualizarEstados(String paisSeleccionado) {
        comboBoxEstado.removeAllItems();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            try (Connection connection = ConexionDB.getConnection()) {
                String query = "SELECT e.nombreEstado \n" +
                "FROM estados e  INNER JOIN paises p on e.idPais = p.idPais \n" +
                "WHERE p.nombrePais = ? ORDER BY e.nombreEstado";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, paisSeleccionado);
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            comboBoxEstado.addItem(resultSet.getString("nombreEstado"));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}



