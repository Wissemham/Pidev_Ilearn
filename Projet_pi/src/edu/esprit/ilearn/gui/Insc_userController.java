/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import edu.esprit.ilearn.entities.Role;
import edu.esprit.ilearn.entities.Utilisateur;
import edu.esprit.ilearn.services.ServiceUtilisateur;
import edu.esprit.ilearn.utils.SendMail;
import edu.esprit.ilearn.utils.ValidMail;
import static edu.esprit.ilearn.utils.encrypt_decrypt.encrypt;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class Insc_userController implements Initializable {

    @FXML
    private ComboBox<String> insc_role;
    @FXML
    private TextField insc_name;
    @FXML
    private TextField insc_username;
    @FXML
    private TextField insc_userpwd;
    @FXML
    private TextField insc_email;
    @FXML
    private DatePicker insc_date;
    @FXML
    private Button reset_inscription;
    @FXML
    private Button button_inscription;
    @FXML
    private Button retour_home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("formateur","etudiant");
        insc_role.setItems(list);
    }    

    @FXML
    private void inscription_reset(ActionEvent event) {
        insc_name.setText("");
        insc_username.setText("");
        insc_userpwd.setText("");
        insc_date.setValue(null);
        insc_email.setText("");
        insc_role.getSelectionModel().clearSelection();
        
    }

    @FXML
    private void inscription(ActionEvent event) throws SQLException, Exception  {
       
            if(insc_name.getText().equals("") || insc_username.getText().equals("") || insc_userpwd.getText().equals("") || insc_email.getText().equals("") ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Inscription");
                alert.setHeaderText("Information");
                alert.setContentText("verifier vous donnes!");
                alert.show();
            } else if(ValidMail.validateEmailAddress(insc_email.getText())==true){
                 ServiceUtilisateur serv = new ServiceUtilisateur();
                List<Utilisateur> list = serv.readAllUtilisateur();
                Boolean rep;
                rep = serv.rechercherUtilisateur(insc_username.getText(),insc_userpwd.getText());
                if(rep){
                    Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Inscription");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Utilisateur est deja inscri!");
                    alert.show();
                    
                } else{
                    Key key = generateKey();
                    String encriptValue = encrypt(insc_userpwd.getText(),key);
                     Utilisateur u = new Utilisateur(insc_name.getText(), insc_username.getText(), encriptValue,insc_date.getValue(), insc_email.getText(),Role.valueOf(insc_role.getValue()));
              
                    serv.ajouterUtilisateur(u);
                    SendMail.sendMail(insc_email.getText());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
                    alert.setTitle("Inscription");
                    alert.setHeaderText("Information");
                    alert.setContentText("inscription bien Ajouter!");
                    alert.show(); 
                    inscription_reset(event);
                }              
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Invalid Mail");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Verifier votre mail!");
                    alert.show();
            }
           
             }

    @FXML
    private void home_retour(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("../gui/HOME.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                //stage.setTitle("Interface 2");
                stage.show();
    }
    
   private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "1234567891234567".getBytes();
// 
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    } 
}
