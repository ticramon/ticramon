/**
 *
 * @author Ramón Méndez García
 */

package formularios;


import menu.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FramePrincipal extends JFrame{
    private JPanel currentPanel;
    private JPanel cardPanel;
    private CardLayout cardLayout;
    
    public FramePrincipal() {
        setTitle("Registro de personas a la base de datos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Obtener dimensiones de la pantalla
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int anchoPantalla = tamañoPantalla.width;
        int altoPantalla = tamañoPantalla.height;
        
        // Ajustar tamaño y limites para obtener ancho y alto maximos en JFrame
        setSize(anchoPantalla, altoPantalla);
        setBounds(0, 0, anchoPantalla, altoPantalla);
        
        // Crear instancias de paneles
        FormularioPersona panel1 = new FormularioPersona((int) (anchoPantalla * 0.2), altoPantalla, this);
        FormularioDireccion panel2 = new FormularioDireccion((int) (anchoPantalla * 0.2), altoPantalla, this);
        FormularioContacto panel3 = new FormularioContacto((int) (anchoPantalla * 0.2), altoPantalla);
        
        // Crear un CardLayout para disposicion de paneles
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.add(panel1, "persona");
        cardPanel.add(panel2, "direccion");
        cardPanel.add(panel3, "contacto");
        
        
        Menu menu = new Menu(cardLayout, cardPanel);
        
        // Create a container panel to hold the cardPanel and buttonsPanel
        JPanel containerPanel = new JPanel(new BorderLayout());
        containerPanel.add(cardPanel, BorderLayout.CENTER);
        containerPanel.add(menu, BorderLayout.WEST);

        // Add the containerPanel to the JFrame
        add(containerPanel);
        
        
    }
    
    public void showPanel(String panelName) {
        cardLayout.show(cardPanel, panelName);
    }
    
    
}
