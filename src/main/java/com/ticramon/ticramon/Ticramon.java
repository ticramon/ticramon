/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ticramon.ticramon;

import db.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JFrame;
import login.ControladorLogin;
import login.ModeloUsuario;
import login.VistaLogin;

/**
 *
 * @author Ramón Méndez García
 */
public class Ticramon {

    public static void main(String[] args) {
        try {
            // Instantiate the model, view, and controller
            Connection conexionDB = ConexionDB.getConnection();
            ModeloUsuario modelo = new ModeloUsuario(conexionDB);
            VistaLogin vista = new VistaLogin();
            ControladorLogin controlador = new ControladorLogin(vista, modelo);

            // Set up the login view
            vista.setVisible(true);
            vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vista.setLocationRelativeTo(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
