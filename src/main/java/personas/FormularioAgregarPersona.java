/**
 *
 * @author Ramón Méndez García
 */
package personas;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class FormularioAgregarPersona extends JFrame {

    JFrame frame = new JFrame("Registro de personas a la base de datos");
    JPanel panel = new JPanel(null);
    
    JLabel labelNombre = new JLabel("Nombre");
    JLabel labelApellidoPaterno = new JLabel("Apellido Paterno");
    JLabel labelApellidoMaterno = new JLabel("Apellido Materno");
    JLabel labelSexo = new JLabel("Sexo");
    // Etiquetas para fecha de nacimiento
    JLabel labelAño = new JLabel("Año:");
    JLabel labelMes = new JLabel("Mes:");
    JLabel labelDia = new JLabel("Dia:");
    JTextField textNombre = new JTextField(10);
    JTextField textApellidoPaterno = new JTextField(10);
    JTextField textApellidoMaterno = new JTextField(10);
    ButtonGroup gbsexo = new ButtonGroup();
    JRadioButton radioBotonMasculino = new JRadioButton("M");
    JRadioButton radioBotonFemenino = new JRadioButton("F");
    // Create year dropdown
    static JComboBox<Integer> comboBoxAño = new JComboBox<>();
    // Create month dropdown
    static JComboBox<Integer> comboBoxMes = new JComboBox<>();
    // Create day dropdown
    static JComboBox<Integer> comboBoxDia = new JComboBox<>();
    int añoActual = Calendar.getInstance().get(Calendar.YEAR);
    JButton botonAgregarPersona = new JButton("Agregar persona");
    
    public FormularioAgregarPersona() {
        
        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setSize(MAXIMIZED_HORIZ, MAXIMIZED_VERT);
        setUndecorated(false);
        setVisible(true);
        setLocationRelativeTo(null);
        getContentPane().add(panel);
        panel.setBackground(Color.darkGray);
        panel.setBounds(MAXIMIZED_HORIZ, MAXIMIZED_VERT, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
        panel.add(labelNombre);        
        panel.add(textNombre);        
        panel.add(labelApellidoPaterno);        
        panel.add(textApellidoPaterno);        
        panel.add(labelApellidoMaterno);        
        panel.add(textApellidoMaterno);        
        panel.add(labelSexo);        
        panel.add(radioBotonMasculino);        
        gbsexo.add(radioBotonMasculino);        
        panel.add(radioBotonFemenino);        
        gbsexo.add(radioBotonFemenino);        
        panel.add(labelAño);
        panel.add(comboBoxAño);
        actualizarAños();
        panel.add(labelMes);
        panel.add(comboBoxMes);
        actualizarMeses();
        panel.add(labelDia);
        panel.add(comboBoxDia);
        actualizarDias();
        panel.add(botonAgregarPersona);

        // Add ActionListeners to update the days based on the selected year and month
        comboBoxAño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDias();
            }
        });
        
        comboBoxMes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarDias();
            }
        });
        
        panel.setBounds(0, 0, MAXIMIZED_HORIZ, MAXIMIZED_VERT);
        
        labelNombre.setForeground(Color.WHITE);
        labelNombre.setBounds(10, 10, 120, 20);
        textNombre.setForeground(Color.WHITE);
        textNombre.setBounds(180, 10, 180, 20);
        textNombre.setBackground(Color.darkGray);
        
        labelApellidoPaterno.setForeground(Color.WHITE);
        labelApellidoPaterno.setBounds(10, 40, 120, 20);
        textApellidoPaterno.setForeground(Color.WHITE);
        textApellidoPaterno.setBounds(180, 40, 180, 20);
        textApellidoPaterno.setBackground(Color.darkGray);
        
        labelApellidoMaterno.setForeground(Color.WHITE);
        labelApellidoMaterno.setBounds(10, 70, 120, 20);
        textApellidoMaterno.setForeground(Color.WHITE);
        textApellidoMaterno.setBounds(180, 70, 180, 20);
        textApellidoMaterno.setBackground(Color.darkGray);
        
        labelSexo.setForeground(Color.WHITE);
        labelSexo.setBounds(10, 100, 120, 20);
        radioBotonMasculino.setForeground(Color.WHITE);
        radioBotonMasculino.setBackground(Color.darkGray);
        radioBotonMasculino.setBounds(180, 100, 90, 20);
        radioBotonFemenino.setForeground(Color.WHITE);
        radioBotonFemenino.setBackground(Color.darkGray);
        radioBotonFemenino.setBounds(270, 100, 90, 20);
        
        labelAño.setForeground(Color.WHITE);
        labelAño.setBounds(10, 130, 30, 20);
        comboBoxAño.setForeground(Color.WHITE);
        comboBoxAño.setBackground(Color.darkGray);
        comboBoxAño.setBounds(50, 130, 70, 20);
        labelMes.setForeground(Color.WHITE);
        labelMes.setBounds(130, 130, 30, 20);
        comboBoxMes.setForeground(Color.WHITE);
        comboBoxMes.setBackground(Color.darkGray);
        comboBoxMes.setBounds(170, 130, 70, 20);
        labelDia.setForeground(Color.WHITE);
        labelDia.setBounds(250, 130, 30, 20);
        comboBoxDia.setForeground(Color.WHITE);
        comboBoxDia.setBackground(Color.darkGray);
        comboBoxDia.setBounds(290, 130, 70, 20);
        
        botonAgregarPersona.setForeground(Color.WHITE);
        botonAgregarPersona.setBackground(Color.darkGray);
        botonAgregarPersona.setBounds(10, 160, 360, 20);
        
    }

    // Method to update the items in the dayComboBox based on the selected year and month
    private static void actualizarDias() {
        int añoSeleccionado = (int) comboBoxAño.getSelectedItem();
        int mesSeleccionado = (int) comboBoxMes.getSelectedItem();

        // Clear existing items
        comboBoxDia.removeAllItems();

        // Get the maximum number of days in the selected month and year
        int maximoDias = getDiasDelMes(añoSeleccionado, mesSeleccionado);

        // Add new items based on the maximum days
        for (int dia = 1; dia <= maximoDias; dia++) {
            comboBoxDia.addItem(dia);
        }
    }

    // Method to update the items in the yearComboBox
    private static void actualizarAños() {
        // Simulate updating the years dynamically
        int añoActual = Calendar.getInstance().get(Calendar.YEAR);

        // Clear existing items
        comboBoxAño.removeAllItems();

        // Add new items based on the current year
        for (int año = añoActual; año >= añoActual - 120; año--) {
            comboBoxAño.addItem(año);
        }
    }

    // Method to update the items in the monthComboBox
    private static void actualizarMeses() {
        // Clear existing items
        comboBoxMes.removeAllItems();

        // Add new items for months
        for (int mes = 1; mes <= 12; mes++) {
            comboBoxMes.addItem(mes);
        }
    }

    // Method to get the maximum number of days in a month for a given year
    private static int getDiasDelMes(int año, int mes) {
        Calendar calendario = Calendar.getInstance();
        calendario.set(año, mes - 1, 1); // Month is 0-based in Calendar class
        return calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
    }
    
    public static void main(String[] args) {
        FormularioAgregarPersona fap = new FormularioAgregarPersona();
    }
    
}
