/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import edu.esprit.ilearn.entities.Category;
import edu.esprit.ilearn.entities.Categoryrec;
import edu.esprit.ilearn.entities.Reclamation;
import edu.esprit.ilearn.entities.Utilisateur;
import edu.esprit.ilearn.services.ServiceCategoryrec;
import edu.esprit.ilearn.services.ServiceReclamation;
import edu.esprit.ilearn.utils.SendMail;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ReclamationclientajoutController implements Initializable {

    @FXML
    private Button bouton_envoyerrecla;
    @FXML
    private Button bouton_annulerrecla;
    @FXML
    private TextField iduserrecla;
    @FXML
    private ComboBox<String> categorierecla;
    @FXML
    private TextArea contenuerecla;
    @FXML
    private Button consulterreclamation;
    @FXML
    private Button bouton_retourrecla;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("avis","feeeedback","rapport","autre");
        categorierecla.setItems(list);
    }    

    @FXML
    private void clikenvoyerrecla(ActionEvent event) throws SQLException, Exception {
        if(iduserrecla.getText().equals("") || contenuerecla.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR );
            alert.setTitle("Commande");
            alert.setHeaderText("Information");
            alert.setContentText("verifier vous donnes!");
            alert.show();
        }else{ 
         ServiceCategoryrec ca=new ServiceCategoryrec();
         ServiceReclamation serv= new ServiceReclamation();
        LocalDate daterec=LocalDate.now();
            Categoryrec cat = new Categoryrec((Category.valueOf(categorierecla.getValue())));
           
   Reclamation r = new Reclamation(new Utilisateur(Integer.parseInt(iduserrecla.getText())),contenuerecla.getText()); 
    try {
    ca.ajoutercategory(cat);
   serv.ajoutereclamation(r);
   SendMail.sendMail("wissem.hammouda@esprit.tn","reclamation envoyer");
 
     } catch (SQLException ex) {
               System.out.println(ex.getMessage());
     }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Ajouter");
        alert.setHeaderText("Information");
        alert.setContentText("reclamation bien Ajouter!");
        alert.show();
            
    } 
    }

    @FXML
    private void clikannulerrecla(ActionEvent event) {
    contenuerecla.setText("");  
    iduserrecla.setText("");
    categorierecla.getSelectionModel().clearSelection();    
    }
    

    @FXML
    private void clikconsulterreclamation(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("../gui/Modiclientreclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show();   
    }   
    

    @FXML
    private void clikretourrecla(ActionEvent event) {
    }
    
}
