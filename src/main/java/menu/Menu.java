/**
 *
 * @author Ramón Méndez García
 */

package menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Menu extends JPanel{
    private CardLayout cardLayout;
    private JPanel cardPanel;

    JButton botonPersona = new JButton("Personas");
    JButton botonBusqueda = new JButton("Busqueda");
    JButton botonContacto = new JButton("Contacto");
    JButton botonGenerarClave = new JButton("Generar clave");
    JButton botonSalir = new JButton("Salir");
    
    public Menu(CardLayout cardLayout, JPanel cardPanel) {
        setBackground(Color.DARK_GRAY);
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        
        
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //setLayout(null);
        setLayout(new GridLayout(0, 1));
        
        add(botonPersona);
        add(botonBusqueda);
        add(botonContacto);
        add(botonGenerarClave);
        add(botonSalir);
        
        botonPersona.setForeground(Color.decode("#009d71"));
        botonPersona.setBackground(Color.WHITE);
        botonBusqueda.setForeground(Color.decode("#009d71"));
        botonBusqueda.setBackground(Color.WHITE);
        botonContacto.setForeground(Color.decode("#009d71"));
        botonContacto.setBackground(Color.WHITE);
        botonGenerarClave.setForeground(Color.decode("#009d71"));
        botonGenerarClave.setBackground(Color.WHITE);
        botonSalir.setForeground(Color.decode("#009d71"));
        botonSalir.setBackground(Color.WHITE);
        
        
        add(Box.createVerticalGlue()); // Top alignment
        add(botonPersona);
        add(Box.createVerticalStrut(20)); // Spacing between buttons
        add(botonBusqueda);
        add(Box.createVerticalStrut(20)); // Spacing between buttons
        add(botonContacto);
        add(Box.createVerticalStrut(20)); // Spacing between buttons
        add(botonGenerarClave);
        add(Box.createVerticalStrut(20)); // Spacing between buttons
        add(botonSalir);
        add(Box.createVerticalGlue()); // Bottom alignment
        
        
        botonPersona.setPreferredSize(new Dimension(150, 10));
        botonBusqueda.setPreferredSize(new Dimension(150, 10));
        botonContacto.setPreferredSize(new Dimension(150, 10));
        botonGenerarClave.setPreferredSize(new Dimension(150, 10));
        botonSalir.setPreferredSize(new Dimension(150, 10));
        
        
        botonPersona.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "persona");
            }
        });
        
        botonBusqueda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "direccion");
            }
        });
        
        botonContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "contacto");
            }
        });
        
        
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la aplicacion si se hace clic
                System.exit(0);
            }
        });
    }
}
