/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ramonmg
 */
// Clase para la conexion a bases de datos
public class ConexionDB {
    
    private static final String sgbd = "mariadb";
    private static final String host = "localhost";
    private static final String port = "3306";
    private static final String database = "ticramon";
    private static final String JDBC_URL = "jdbc:"+sgbd+"://"+host+":"+port+"/"+database;
    private static final String DB_USER = "ticramon";
    private static final String DB_PASSWORD = "soportetecnico";

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
    }
}