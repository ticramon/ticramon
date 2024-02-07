/**
 *
 * @author Ramón Méndez García
 * 
 * FormularioDomicilio
 */

package formularios;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FormularioContacto extends JPanel {
    private FramePrincipal mainFrame;
    
    JLabel labelCorreoElectronico = new JLabel("correo electronico");
    JTextField textoCorreoElectronico=new JTextField();
    JLabel labelArroba = new JLabel(" @ ");
    JComboBox comboBoxDominioCorreoElectronico=new JComboBox();
    JLabel labelNumeroTelefonico = new JLabel("Num. Tel.");
    JComboBox comboBoxPrefijoPais=new JComboBox();
    JTextField textoNumeroTelefonicoArea=new JTextField();
    JTextField textoNumeroTelefonicoCentral=new JTextField();
    JTextField textoNumeroTelefonicoLinea=new JTextField();
    JTextField textoNumeroTelefonicoExtension=new JTextField();
    JLabel labelTipoTelefono = new JLabel("Tipo");
    JComboBox comboBoxTipoTelefono=new JComboBox();
    JLabel labelCoberturaTelefonica = new JLabel("Cober. telef.");
    JLabel labelServicioInternet = new JLabel("Internet");
    JLabel labelWhatsapp = new JLabel("Whatsapp");
    JLabel labelTelegram = new JLabel("Telegram");
    JCheckBox chechboxCoberturaTelefonica = new JCheckBox();
    JCheckBox chechboxServicioInternet = new JCheckBox();
    JCheckBox chechboxWhatsapp = new JCheckBox();
    JCheckBox chechboxTelegram = new JCheckBox();
    JComboBox comboBoxTipoInternet = new JComboBox();
    JLabel labelRedSocialFacebook = new JLabel("FB");
    JTextField textoRedSocialFacebook = new JTextField();
    JLabel labelRedSocialInstagram = new JLabel("Insta");
    JTextField textoRedSocialInstagram = new JTextField();
    JLabel labelRedSocialTiktok = new JLabel("Tiktok");
    JTextField textoRedSocialTiktok = new JTextField();
    JLabel labelRedSocialTwitter = new JLabel("TW->X");
    JTextField textoRedSocialTwitter = new JTextField();
    JLabel labelRedSocialLinkedin = new JLabel("LIn");
    JTextField textoRedSocialLinkedin = new JTextField();
    JLabel labelRedSocialSnapchat = new JLabel("Snap");
    JTextField textoRedSocialSnapchat = new JTextField();
    JButton switchButton = new JButton("Terminar y agregar persona");
    
    public FormularioContacto(int width, int height) {
        setBackground(Color.DARK_GRAY);
        this.mainFrame = mainFrame;
        setLayout(null);
        
        add(labelCorreoElectronico);
        add(textoCorreoElectronico);
        add(labelArroba);
        add(comboBoxDominioCorreoElectronico);
        comboBoxDominioCorreoElectronico.addItem("gmail.com");
        comboBoxDominioCorreoElectronico.addItem("yahoo.com");
        comboBoxDominioCorreoElectronico.addItem("outlook.com.com");
        comboBoxDominioCorreoElectronico.addItem("icloud.com");
        add(labelNumeroTelefonico);
        add(labelTipoTelefono);
        add(comboBoxPrefijoPais);
        comboBoxPrefijoPais.addItem("+1");
        comboBoxPrefijoPais.addItem("+44");
        comboBoxPrefijoPais.addItem("+49");
        comboBoxPrefijoPais.addItem("+61");
        comboBoxPrefijoPais.addItem("+86");
        comboBoxPrefijoPais.addItem("+33");
        comboBoxPrefijoPais.addItem("+81");
        comboBoxPrefijoPais.addItem("+55");
        comboBoxPrefijoPais.addItem("+7");
        comboBoxPrefijoPais.addItem("+27");
        comboBoxPrefijoPais.addItem("+52");
        comboBoxPrefijoPais.addItem("+82");
        comboBoxPrefijoPais.addItem("+39");
        comboBoxPrefijoPais.addItem("+34");
        comboBoxPrefijoPais.addItem("+31");
        comboBoxPrefijoPais.addItem("+41");
        comboBoxPrefijoPais.addItem("+46");
        comboBoxPrefijoPais.addItem("+47");
        comboBoxPrefijoPais.addItem("+31");
        comboBoxPrefijoPais.addItem("+234");
        comboBoxPrefijoPais.addItem("+237");
        comboBoxPrefijoPais.addItem("+221");
        comboBoxPrefijoPais.addItem("+256");
        comboBoxPrefijoPais.addItem("+233");
        comboBoxPrefijoPais.addItem("+251");
        comboBoxPrefijoPais.addItem("+244");
        comboBoxPrefijoPais.addItem("+225");
        add(textoNumeroTelefonicoArea);
        add(textoNumeroTelefonicoCentral);
        add(textoNumeroTelefonicoLinea);
        add(textoNumeroTelefonicoExtension);
        add(comboBoxTipoTelefono);
        comboBoxTipoTelefono.addItem("Smartphone");
        comboBoxTipoTelefono.addItem("Celular simple");
        comboBoxTipoTelefono.addItem("Casa");
        comboBoxTipoTelefono.addItem("Oficina");
        add(labelCoberturaTelefonica);
        add(labelServicioInternet);
        add(labelWhatsapp);
        add(labelTelegram);
        add(chechboxCoberturaTelefonica);
        add(chechboxServicioInternet);
        add(chechboxWhatsapp);
        add(chechboxTelegram);
        add(comboBoxTipoInternet);
        comboBoxTipoInternet.addItem("");
        comboBoxTipoInternet.addItem("Fibra Optica");
        comboBoxTipoInternet.addItem("Cable coaxial");
        comboBoxTipoInternet.addItem("Microondas");
        comboBoxTipoInternet.addItem("Satelite");
        comboBoxTipoInternet.addItem("Datos moviles");
        comboBoxTipoInternet.addItem("Linea telefonica");
        add(labelRedSocialFacebook);
        add(textoRedSocialFacebook);
        add(labelRedSocialInstagram);
        add(textoRedSocialInstagram);
        add(labelRedSocialTiktok);
        add(textoRedSocialTiktok);
        add(labelRedSocialTwitter);
        add(textoRedSocialTwitter);
        add(labelRedSocialLinkedin);
        add(textoRedSocialLinkedin);
        add(labelRedSocialSnapchat);
        add(textoRedSocialSnapchat);
        add(switchButton);
        
        labelCorreoElectronico.setForeground(Color.WHITE);
        textoCorreoElectronico.setForeground(Color.WHITE);
        textoCorreoElectronico.setBackground(Color.darkGray);
        labelArroba.setForeground(Color.WHITE);
        comboBoxDominioCorreoElectronico.setForeground(Color.WHITE);
        comboBoxDominioCorreoElectronico.setBackground(Color.darkGray);
        labelNumeroTelefonico.setForeground(Color.WHITE);
        textoNumeroTelefonicoArea.setForeground(Color.WHITE);
        textoNumeroTelefonicoArea.setBackground(Color.darkGray);
        textoNumeroTelefonicoCentral.setForeground(Color.WHITE);
        textoNumeroTelefonicoCentral.setBackground(Color.darkGray);
        textoNumeroTelefonicoLinea.setForeground(Color.WHITE);
        textoNumeroTelefonicoLinea.setBackground(Color.darkGray);
        textoNumeroTelefonicoExtension.setForeground(Color.WHITE);
        textoNumeroTelefonicoExtension.setBackground(Color.darkGray);
        labelTipoTelefono.setForeground(Color.WHITE);
        comboBoxPrefijoPais.setForeground(Color.WHITE);
        comboBoxPrefijoPais.setBackground(Color.darkGray);
        comboBoxTipoTelefono.setForeground(Color.WHITE);
        comboBoxTipoTelefono.setBackground(Color.darkGray);
        labelCoberturaTelefonica.setForeground(Color.WHITE);
        labelServicioInternet.setForeground(Color.WHITE);
        labelWhatsapp.setForeground(Color.WHITE);
        labelTelegram.setForeground(Color.WHITE);
        chechboxCoberturaTelefonica.setForeground(Color.WHITE);
        chechboxCoberturaTelefonica.setBackground(Color.darkGray);
        chechboxServicioInternet.setForeground(Color.WHITE);
        chechboxServicioInternet.setBackground(Color.DARK_GRAY);
        chechboxWhatsapp.setForeground(Color.WHITE);
        chechboxWhatsapp.setBackground(Color.darkGray);
        chechboxTelegram.setForeground(Color.WHITE);
        chechboxTelegram.setBackground(Color.darkGray);
        comboBoxTipoInternet.setForeground(Color.WHITE);
        comboBoxTipoInternet.setBackground(Color.darkGray);
        labelRedSocialFacebook.setForeground(Color.WHITE);
        labelRedSocialInstagram.setForeground(Color.WHITE);
        labelRedSocialTiktok.setForeground(Color.WHITE);
        labelRedSocialTwitter.setForeground(Color.WHITE);
        labelRedSocialLinkedin.setForeground(Color.WHITE);
        labelRedSocialSnapchat.setForeground(Color.WHITE);
        textoRedSocialFacebook.setForeground(Color.WHITE);
        textoRedSocialFacebook.setBackground(Color.darkGray);
        textoRedSocialInstagram.setForeground(Color.WHITE);
        textoRedSocialInstagram.setBackground(Color.darkGray);
        textoRedSocialTiktok.setForeground(Color.WHITE);
        textoRedSocialTiktok.setBackground(Color.darkGray);
        textoRedSocialTwitter.setForeground(Color.WHITE);
        textoRedSocialTwitter.setBackground(Color.darkGray);
        textoRedSocialLinkedin.setForeground(Color.WHITE);
        textoRedSocialLinkedin.setBackground(Color.darkGray);
        textoRedSocialSnapchat.setForeground(Color.WHITE);
        textoRedSocialSnapchat.setBackground(Color.darkGray);
        switchButton.setForeground(Color.WHITE);
        switchButton.setBackground(Color.decode("#009d71"));
        
        labelCorreoElectronico.setBounds(10,10,120,20);
        textoCorreoElectronico.setBounds(140,10,160,20);
        labelArroba.setBounds(320,10,30,20);
        comboBoxDominioCorreoElectronico.setBounds(360,10,140,20);
        labelNumeroTelefonico.setBounds(10,40,70,20);
        comboBoxPrefijoPais.setBounds(90,40,50,20);
        textoNumeroTelefonicoArea.setBounds(150,40,30,20);
        textoNumeroTelefonicoCentral.setBounds(190,40,40,20);
        textoNumeroTelefonicoLinea.setBounds(240,40,40,20);
        textoNumeroTelefonicoExtension.setBounds(290,40,50,20);
        labelTipoTelefono.setBounds(360,40,50,20);
        comboBoxTipoTelefono.setBounds(420,40,80,20);
        labelCoberturaTelefonica.setBounds(10,70,75,20);
        chechboxCoberturaTelefonica.setBounds(95,70,20,20);
        labelWhatsapp.setBounds(125,70,65,20);
        chechboxWhatsapp.setBounds(200,70,20,20);
        labelTelegram.setBounds(230,70,60,20);
        chechboxTelegram.setBounds(300,70,20,20);
        labelServicioInternet.setBounds(330,70,50,20);
        chechboxServicioInternet.setBounds(390,70,20,20);
        comboBoxTipoInternet.setBounds(420,70,80,20);
        
        labelRedSocialFacebook.setBounds(10, 100, 30, 20);
        textoRedSocialFacebook.setBounds(50, 100, 110, 20);
        labelRedSocialInstagram.setBounds(170, 100, 40, 20);
        textoRedSocialInstagram.setBounds(220, 100, 110, 20);
        labelRedSocialTiktok.setBounds(340, 100, 40, 20);
        textoRedSocialTiktok.setBounds(390, 100, 110, 20);
        
        labelRedSocialSnapchat.setBounds(10, 130, 30, 20);
        textoRedSocialSnapchat.setBounds(50, 130, 110, 20);
        labelRedSocialLinkedin.setBounds(170, 130, 40, 20);
        textoRedSocialLinkedin.setBounds(220, 130, 110, 20);
        labelRedSocialTwitter.setBounds(340, 130, 40, 20);
        textoRedSocialTwitter.setBounds(390, 130, 110, 20);
        
        switchButton.setBounds(10, 160, 490, 20);
         
        // Add KeyListener to the textoOcupacion field
        textoRedSocialTwitter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Trigger the button's action when Enter is pressed
                    switchButton.doClick();
                }
            }
        });
        
    }
}
