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
import edu.esprit.ilearn.utils.encrypt_decrypt;
import static edu.esprit.ilearn.utils.encrypt_decrypt.encrypt;
import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.crypto.spec.SecretKeySpec;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class USERController implements Initializable {

//    @FXML
//    private AnchorPane Birth_day;
    @FXML
    private TableView<Utilisateur> tableuser;
    @FXML
    private TableColumn<Utilisateur, String> id;
    @FXML
    private TableColumn<Utilisateur, String> nom;
    @FXML
    private TableColumn<Utilisateur, String> username;
    @FXML
    private TableColumn<Utilisateur, String> userpwd;
    @FXML
    private TableColumn<Utilisateur, LocalDate> BirthDay;
    @FXML
    private TableColumn<Utilisateur, String> email;
    @FXML
    private TableColumn<Utilisateur, String> role;
    @FXML
    private AnchorPane Birth_day;
    @FXML
    private TextField user_name;
    @FXML
    private TextField user_username;
    @FXML
    private TextField user_userpwd;
    @FXML
    private TextField user_email;
    @FXML
    private DatePicker user_birth;
    @FXML
    private ComboBox<String> user_role;
    @FXML
    private Button ajouter;
    @FXML
    private Button afficher;
    @FXML
    private Button deletebutton;
    @FXML
    private Button modifier;
    @FXML
    private Button modification;
    @FXML
    private TextField user_id;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ServiceUtilisateur serv = new ServiceUtilisateur() ;
        try {
            ArrayList list = (ArrayList) serv.readAllUtilisateur();
            ObservableList observableList = FXCollections.observableArrayList(list);
            tableuser.setItems(observableList);
            id.setCellValueFactory(new PropertyValueFactory<>("iduser"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            username.setCellValueFactory(new PropertyValueFactory<>("username"));
            userpwd.setCellValueFactory(new PropertyValueFactory<>("userpwd"));
            BirthDay.setCellValueFactory(new PropertyValueFactory<>("daten"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            role.setCellValueFactory(new PropertyValueFactory<>("role"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        ObservableList<String> list = FXCollections.observableArrayList("admin","formateur","etudiant");
        user_role.setItems(list);
    }    

    @FXML
    private void ajouteruser(ActionEvent event) throws SQLException, Exception {
        if(user_name.getText().equals("") || user_username.getText().equals("") || user_userpwd.getText().equals("") || user_email.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Inscription");
            alert.setHeaderText("Information");
            alert.setContentText("verifier vous donnes!");
            alert.show();
            
        }else if(ValidMail.validateEmailAddress(user_email.getText())==true){
            ServiceUtilisateur serv = new ServiceUtilisateur();
            List<Utilisateur> list = serv.readAllUtilisateur();
                Boolean rep;
                rep = serv.rechercherUtilisateur(user_username.getText(),user_userpwd.getText());
                if(rep){
                    Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Inscription");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Utilisateur est deja inscri!");
                    alert.show();
                    
                } else{
                    Key key = generateKey();
                    String encriptValue = encrypt(user_userpwd.getText(),key);
                    Utilisateur u = new Utilisateur(user_name.getText(), user_username.getText(),encriptValue,user_birth.getValue(), user_email.getText(),Role.valueOf(user_role.getValue()));                   
                    serv.ajouterUtilisateur(u);
                    SendMail.sendMail(u.getEmail());
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
                    alert.setTitle("Inscription");
                    alert.setHeaderText("Information");
                    alert.setContentText("inscription bien Ajouter!");
                    alert.show();
                    user_name.setText("");
                    user_username.setText("");
                    user_userpwd.setText("");
                    user_birth.setValue(null);
                    user_email.setText("");
                    user_role.getSelectionModel().clearSelection();
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
    private void affficheruser(ActionEvent event) {
        ServiceUtilisateur ser = new ServiceUtilisateur() ;
        try {
            ArrayList list = (ArrayList) ser.readAllUtilisateur();
            ObservableList observableList = FXCollections.observableArrayList(list);
            tableuser.setItems(observableList);
            id.setCellValueFactory(new PropertyValueFactory<>("iduser"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            username.setCellValueFactory(new PropertyValueFactory<>("username"));
            userpwd.setCellValueFactory(new PropertyValueFactory<>("userpwd"));
            BirthDay.setCellValueFactory(new PropertyValueFactory<>("daten"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            role.setCellValueFactory(new PropertyValueFactory<>("role"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
    }
        
    
}

    @FXML
    private void delete(ActionEvent event) {
        Utilisateur u = tableuser.getSelectionModel().getSelectedItem();
        ServiceUtilisateur servi = new ServiceUtilisateur();
        try {
            servi.deleteUtilisateur(u.getIduser());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        affficheruser(event);
    }

    @FXML
    private void modifieruser(ActionEvent event) throws Exception {
        Key key = generateKey();
        Utilisateur ut = tableuser.getSelectionModel().getSelectedItem();
        String id = Integer.toString(ut.getIduser());
        user_id.setText(id);
        user_name.setText(ut.getNom());
        user_username.setText(ut.getUsername());
        user_userpwd.setText(encrypt_decrypt.decrypt(ut.getUserpwd(), key) );
        user_birth.setValue(ut.getDaten());
        user_email.setText(ut.getEmail());
        
    }

    @FXML
    private void enregistre(ActionEvent event) throws SQLException, Exception {
        if(user_id.getText().equals("") || user_name.getText().equals("") || user_username.getText().equals("") || user_userpwd.getText().equals("") || user_email.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Modification");
                alert.setHeaderText("Information");
                alert.setContentText("verifier vous donnes!");
                alert.show();
        } else if(ValidMail.validateEmailAddress(user_email.getText())==true){
        ServiceUtilisateur s = new ServiceUtilisateur();
        Key key = generateKey();
        String encriptValue = encrypt(user_userpwd.getText(),key);
        int id = Integer.parseInt(user_id.getText());
        Utilisateur uti = new Utilisateur(id,user_name.getText(), user_username.getText(), encriptValue,user_birth.getValue(), user_email.getText());
        
               s.updateUtilisateur(uti);
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Modification");
        alert.setHeaderText("Information");
        alert.setContentText("modification a éte enregistré !");
        alert.show();
        user_id.setText("");
        user_name.setText("");
        user_username.setText("");
        user_userpwd.setText("");
        user_birth.setValue(null);
        user_email.setText("");
        user_role.getSelectionModel().clearSelection();
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Invalid Mail");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Verifier votre mail!");
                    alert.show();
                        }  
    }
    

    @FXML
    private void retourhome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/HOME.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                //stage.setTitle("Interface 2");
                stage.show();
    }

    @FXML
    private void trier(ActionEvent event) {
        ServiceUtilisateur ser = new ServiceUtilisateur() ;
        try {
            ArrayList list = (ArrayList) ser.trier();
            ObservableList observableList = FXCollections.observableArrayList(list);
            tableuser.setItems(observableList);
            id.setCellValueFactory(new PropertyValueFactory<>("iduser"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            username.setCellValueFactory(new PropertyValueFactory<>("username"));
            userpwd.setCellValueFactory(new PropertyValueFactory<>("userpwd"));
            BirthDay.setCellValueFactory(new PropertyValueFactory<>("daten"));
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            role.setCellValueFactory(new PropertyValueFactory<>("role"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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
