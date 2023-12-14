/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class MyDB {
     final String url = "jdbc:mysql://localhost:3306/ilearn";
    final String login = "root";
    final String password = "";
    Connection connexion;
    static MyDB instance;

    public MyDB() {
        try {
            connexion
                    = DriverManager.getConnection(url ,login, password);
            System.out.println("Connexion établie");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion à la base de données "+ex.getMessage());
        }
    }
    
    public static  MyDB getInstance(){
        if(instance == null)
            instance = new MyDB();
        return instance;
    }
     public Connection getConnection(){
        return connection;
    }
    
    public Connection getConnection(){
        return connexion;
    }
}
