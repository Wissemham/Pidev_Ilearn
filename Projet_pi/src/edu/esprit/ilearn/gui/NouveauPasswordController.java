/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import edu.esprit.ilearn.services.ServiceUtilisateur;
import static edu.esprit.ilearn.utils.encrypt_decrypt.encrypt;
import java.net.URL;
import java.security.Key;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class NouveauPasswordController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField email;
    @FXML
    private PasswordField pwd;
    @FXML
    private PasswordField pwd1;
    @FXML
    private Button enregistrepwd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierpwd(ActionEvent event) throws SQLException, Exception {
        
        if(name.getText().equals("") || email.getText().equals("") || pwd.getText().equals("") || pwd.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Modification");
                alert.setHeaderText("Information");
                alert.setContentText("verifier vous donnes!");
                alert.show();
        }else {
            ServiceUtilisateur serv = new ServiceUtilisateur();
            int rep = serv.verifierutilisateur(name.getText(), email.getText());
            if(rep == 0){
                Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Inscription");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Utilisateur n'est pas inscrit!");
                    alert.show();
            }else{
                if(!pwd.getText().equals(pwd1.getText())){
                    Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Inscription");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("mot de passe ne sont pas même!");
                    alert.show();
                }else{
                    Key key = generateKey();
                    String encriptValue = encrypt(pwd.getText(),key);
                    serv.updatepwd(rep, encriptValue);
                }
            }
        }
            
        
    }
    private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567891234567".getBytes();
// 
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    } 
    
}
