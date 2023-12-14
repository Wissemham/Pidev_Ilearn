/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package edu.esprit.ilearn.test;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class NewFXMain extends Application {
    private Parent root;
    private Stage stage;
    @Override
    public void start(Stage primaryStage) {
      
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
        try{
        Parent root=FXMLLoader.load(getClass().getResource("../gui/ClientCommandes.fxml"));
       // Parent rwt=FXMLLoader.load(getClass().getResource("../gui/AdminCommandes.fxml"));
        
        
        Scene scene = new Scene(root, 1042, 680);
       //  Scene sene = new Scene(rwt, 820, 580);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
       // primaryStage.setScene(sene);
        primaryStage.show();
        }catch(Exception e){
        e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
