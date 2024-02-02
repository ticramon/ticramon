/**
 *
 * @author Ramón Méndez García
 */

package elementosAdicionales;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


class ModeloCuentaRegresiva {
    private int segundos;

    ModeloCuentaRegresiva(int segundos) {
        this.segundos = segundos;
    }

    int getSegundos() {
        return segundos;
    }

    void decrement() {
        segundos--;
    }
}

class VistaCuentaRegresiva {
    private JLabel label;

    VistaCuentaRegresiva() {
        JFrame frame = new JFrame("Cuenta regresiva");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(300, 100);
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label);
        
        label.setForeground(Color.decode("#142857"));
        
        
        frame.setUndecorated(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }

    void actualizarVista(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;

        String timeString = String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
        label.setText(timeString);
    }
}

class ControladorCuentaRegresiva {
    private ModeloCuentaRegresiva modeloCuentaRegresiva;
    private VistaCuentaRegresiva vistaCuentaRegresiva;
    private Timer temporizador;

    ControladorCuentaRegresiva(ModeloCuentaRegresiva model, VistaCuentaRegresiva view) {
        this.modeloCuentaRegresiva = model;
        this.vistaCuentaRegresiva = view;

        temporizador = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarCuentaRegresiva();
            }
        });
    }

    void iniciarCuentaRegresiva() {
        temporizador.start();
    }
    
    private static void playSound(String soundFilePath) {
        try {
            File soundFile = new File(soundFilePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    private void actualizarCuentaRegresiva() {
        modeloCuentaRegresiva.decrement();
        int seconds = modeloCuentaRegresiva.getSegundos();

        vistaCuentaRegresiva.actualizarVista(seconds);

        if (seconds <= 0) {
            temporizador.stop();
            
            JOptionPane.showMessageDialog(null, "¡¡¡Tiempo!!!");
        }
    }
}

public class CuentaRegresiva {
    public static void main(String[] args) {
        ModeloCuentaRegresiva model = new ModeloCuentaRegresiva(500); // Set the initial countdown time to 1 hour, 1 minute, and 5 seconds
        VistaCuentaRegresiva view = new VistaCuentaRegresiva();
        ControladorCuentaRegresiva controller = new ControladorCuentaRegresiva(model, view);

        controller.iniciarCuentaRegresiva();
        
    }
}
