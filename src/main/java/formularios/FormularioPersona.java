/**
 *
 * @author Ramón Méndez García
 */

package formularios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;

public class FormularioPersona extends JPanel{
    private FramePrincipal mainFrame;
    
    
    JLabel labelNombre = new JLabel("Nombre");
    JLabel labelSobrenombre = new JLabel("Sobrenombre");
    JLabel labelApellidoPaterno = new JLabel("Ap. Paterno");
    JLabel labelApellidoMaterno = new JLabel("Ap. Materno");
    JLabel labelSexo = new JLabel("Sexo");
    // Etiquetas para fecha de nacimiento
    JLabel labelAño = new JLabel("Año:");
    JLabel labelMes = new JLabel("Mes:");
    JLabel labelDia = new JLabel("Dia:");
    JLabel labelEstadoCivil = new JLabel("Estado civil:");
    JLabel labelSituacionLaboral = new JLabel("Sit. laboral:");
    JLabel labelOficioProfesion = new JLabel("Ocupacion:");
    JTextField textNombre = new JTextField(10);
    JTextField textSobrenombre = new JTextField(10);
    JTextField textApellidoPaterno = new JTextField(10);
    JTextField textApellidoMaterno = new JTextField(10);
    ButtonGroup grupoBotonesSexo = new ButtonGroup();
    JRadioButton radioBotonMasculino = new JRadioButton("M");
    JRadioButton radioBotonFemenino = new JRadioButton("F");
    // Create year dropdown
    static JComboBox<Integer> comboboxAño = new JComboBox<>();
    // Create month dropdown
    static JComboBox<Integer> comboboxMes = new JComboBox<>();
    // Create day dropdown
    static JComboBox<Integer> comboboxDia = new JComboBox<>();
    static JComboBox<String> comboboxEstadoCivil = new JComboBox<>();
    Checkbox checkBoxEstudio = new Checkbox("Estudio");
    Checkbox checkBoxTrabajo = new Checkbox("Trabajo");
    JTextField textoOcupacion = new JTextField(10);
    JButton botonAgregarPersona = new JButton("Continuar con domicilio");
    
    public FormularioPersona(int width, int height, FramePrincipal mainFrame) {
        setBackground(Color.DARK_GRAY);
        this.mainFrame = mainFrame;
        
        setLayout(null);
        
        populateYears();
        populateMonths();
        updateDays();
        
        
        add(labelNombre);        
        add(textNombre);        
        add(labelSobrenombre);        
        add(textSobrenombre);        
        add(labelApellidoPaterno);        
        add(textApellidoPaterno);        
        add(labelApellidoMaterno);        
        add(textApellidoMaterno);        
        add(labelSexo);      
        grupoBotonesSexo.add(radioBotonMasculino);        
        grupoBotonesSexo.add(radioBotonFemenino);        
        add(radioBotonMasculino);        
        add(radioBotonFemenino);        
        add(labelAño);
        add(comboboxAño);
        add(labelMes);
        add(comboboxMes);
        add(labelDia);
        add(comboboxDia);
        add(labelEstadoCivil);
        add(labelSituacionLaboral);
        add(labelOficioProfesion);
        add(comboboxEstadoCivil);
        add(checkBoxEstudio);
        add(checkBoxTrabajo);
        add(textoOcupacion);
        add(botonAgregarPersona);
        
        
        labelNombre.setForeground(Color.WHITE);
        textNombre.setForeground(Color.WHITE);
        textNombre.setBackground(Color.darkGray);
        labelSobrenombre.setForeground(Color.WHITE);
        textSobrenombre.setForeground(Color.WHITE);
        textSobrenombre.setBackground(Color.darkGray);
        labelApellidoPaterno.setForeground(Color.WHITE);
        textApellidoPaterno.setForeground(Color.WHITE);
        textApellidoPaterno.setBackground(Color.darkGray);
        labelApellidoMaterno.setForeground(Color.WHITE);
        textApellidoMaterno.setForeground(Color.WHITE);
        textApellidoMaterno.setBackground(Color.darkGray);
        labelSexo.setForeground(Color.WHITE);
        radioBotonMasculino.setForeground(Color.WHITE);
        radioBotonMasculino.setBackground(Color.darkGray);
        radioBotonFemenino.setForeground(Color.WHITE);
        radioBotonFemenino.setBackground(Color.darkGray);
        labelAño.setForeground(Color.WHITE);
        comboboxAño.setForeground(Color.WHITE);
        comboboxAño.setBackground(Color.darkGray);
        labelMes.setForeground(Color.WHITE);
        comboboxMes.setForeground(Color.WHITE);
        comboboxMes.setBackground(Color.darkGray);
        labelDia.setForeground(Color.WHITE);
        comboboxDia.setForeground(Color.WHITE);
        comboboxDia.setBackground(Color.darkGray);
        labelEstadoCivil.setForeground(Color.WHITE);
        labelSituacionLaboral.setForeground(Color.WHITE);
        labelOficioProfesion.setForeground(Color.WHITE);
        comboboxEstadoCivil.setForeground(Color.WHITE);
        checkBoxEstudio.setForeground(Color.WHITE);
        checkBoxTrabajo.setForeground(Color.WHITE);
        textoOcupacion.setForeground(Color.WHITE);
        comboboxEstadoCivil.setBackground(Color.darkGray);
        checkBoxEstudio.setBackground(Color.darkGray);
        checkBoxTrabajo.setBackground(Color.darkGray);
        textoOcupacion.setBackground(Color.darkGray);
        botonAgregarPersona.setForeground(Color.WHITE);
        botonAgregarPersona.setBackground(Color.decode("#009d71"));
        
        labelApellidoPaterno.setBounds(10, 10, 70, 20);
        textApellidoPaterno.setBounds(90, 10, 150, 20);
        labelApellidoMaterno.setBounds(260, 10, 80, 20);
        textApellidoMaterno.setBounds(350, 10, 150, 20);
        labelNombre.setBounds(10, 40, 70, 20);
        textNombre.setBounds(90, 40, 150, 20);
        labelSobrenombre.setBounds(260, 40, 90, 20);
        textSobrenombre.setBounds(350, 40, 150, 20);
        labelAño.setBounds(10, 70, 30, 20);
        comboboxAño.setBounds(50, 70, 70, 20);
        labelMes.setBounds(130, 70, 30, 20);
        comboboxMes.setBounds(170, 70, 70, 20);
        labelDia.setBounds(250, 70, 30, 20);
        comboboxDia.setBounds(290, 70, 70, 20);
        labelSexo.setBounds(370, 70, 30, 20);
        radioBotonMasculino.setBounds(410, 70, 40, 20);
        radioBotonFemenino.setBounds(460, 70, 40, 20);
        
        labelEstadoCivil.setBounds(10, 100, 110, 20);
        comboboxEstadoCivil.setBounds(130, 100, 110, 20);
        comboboxEstadoCivil.addItem("Soltero");
        comboboxEstadoCivil.addItem("Casado");
        comboboxEstadoCivil.addItem("Divorciado");
        comboboxEstadoCivil.addItem("Viudo");
        comboboxEstadoCivil.addItem("Union libre");
        comboboxEstadoCivil.addItem("Separado");
        comboboxEstadoCivil.addItem("En una relacion / comprometido");
        labelSituacionLaboral.setBounds(250, 100, 90, 20);
        checkBoxEstudio.setBounds(350, 100, 70, 20);
        checkBoxTrabajo.setBounds(430, 100, 70, 20);
        
        labelOficioProfesion.setBounds(10, 130, 80, 20);
        textoOcupacion.setBounds(100, 130, 400, 20);
        
        botonAgregarPersona.setBounds(10, 160, 490, 20);
        
        
        // Add KeyListener to the textoOcupacion field
        textoOcupacion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Trigger the button's action when Enter is pressed
                    botonAgregarPersona.doClick();
                }
            }
        });
        
        botonAgregarPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the FormularioDireccion panel
                mainFrame.showPanel("direccion");
            }
        });
        
        // Add item listeners for year and month dropdowns
        comboboxAño.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateDays();
            }
        });

        comboboxMes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                updateDays();
            }
        });
    }
    
    private void populateYears() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int year = currentYear; year >= 1900; year--) {
            comboboxAño.addItem(year);
        }
    }

    private void populateMonths() {
        for (int month = 1; month <= 12; month++) {
            comboboxMes.addItem(month);
        }
    }

    private void updateDays() {
        int selectedYear = (int) comboboxAño.getSelectedItem();
        int selectedMonth = (int) comboboxMes.getSelectedItem();

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, selectedYear);
        calendar.set(Calendar.MONTH, selectedMonth - 1); // Calendar months are 0-based
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        comboboxDia.removeAllItems();

        for (int day = 1; day <= maxDays; day++) {
            comboboxDia.addItem(day);
        }
    }

}
