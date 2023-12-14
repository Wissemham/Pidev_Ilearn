/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import edu.esprit.ilearn.entities.Role;
import edu.esprit.ilearn.entities.Utilisateur;
import edu.esprit.ilearn.services.ServiceUtilisateur;
import static edu.esprit.ilearn.utils.encrypt_decrypt.encrypt;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class HOMEController implements Initializable {

    @FXML
    private TextField loginhome;
    @FXML
    private TextField pwdhome;
    @FXML
    private Button button_créer_compte;
    @FXML
    private Button connecter;
    private Connection con;
    private Statement ste;
    @FXML
    private Button pwdoublier;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void créer_compte(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/insc_user.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Inscription");
                stage.show();
    }

    @FXML
    private void se_connecter(ActionEvent event) throws IOException, SQLException, Exception {
            ServiceUtilisateur serv = new ServiceUtilisateur();
             Key key = generateKey();
            String decriptValue = encrypt(pwdhome.getText(),key);
            String nom = loginhome.getText();
            //String pwd = pwdhome.getText();
            String role = serv.authen(nom, decriptValue);
//            for (int i=0;i<list.size();i++){
//                String s = list.get(i).getUsername();
//                String s1 = list.get(i).getUserpwd();
//                if (s.equals(nom) && s1.equals(pwd)){
                    if(role.equals("admin")){
                        Parent root = FXMLLoader.load(getClass().getResource("../gui/USER.fxml"));
                        Scene scene = new Scene(root);
                        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                        stage.setScene(scene);
                        //stage.setTitle("Interface 2");
                        stage.show();
                    }
 
    
    }
     private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567891234567".getBytes();
// 
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    } 

    @FXML
    private void pwd_oublier(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/NouveauPassword.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Mot de passe oublier");
                stage.show();
    }
    
}
