/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package edu.esprit.ilearn.gui;

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
    public void start(Stage primaryStage) throws IOException {
      
        
        //StackPane root = new StackPane();
        //root.getChildren().add(btn);
       // root=FXMLLoader.load(getClass().getResource("../gui/Modiclientreclamation.fxml"));
        root=FXMLLoader.load(getClass().getResource("../gui/FXML.fxml"));
        
        Scene scene = new Scene(root, 700, 500);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
