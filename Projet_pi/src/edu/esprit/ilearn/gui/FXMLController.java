/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

<<<<<<< HEAD
import edu.esprit.ilearn.entities.Category;
import edu.esprit.ilearn.entities.Categoryrec;
import edu.esprit.ilearn.entities.Reclamation;
import edu.esprit.ilearn.services.ServiceCategoryrec;
import edu.esprit.ilearn.services.ServiceReclamation;
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
=======
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0

/**
 * FXML Controller class
 *
<<<<<<< HEAD
 * @author DELL
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField iduserrecla;
    @FXML
    private ComboBox<String> categorierecla;
    @FXML
    private TextArea contenuerecla;
    @FXML
    private Button bouton_envoyerrecla;
    @FXML
    private Button bouton_annulerrecla;
    @FXML
    private Button bouton_retourrecla;
    @FXML
    private Button consulterreclamation;

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
    private void clikenvoyerrecla(ActionEvent event){
         ServiceReclamation serv= new ServiceReclamation();
        ServiceCategoryrec ca=new ServiceCategoryrec();
        LocalDate daterec=LocalDate.now();
        //contenuerecla.setText("");
            Categoryrec cat = new Categoryrec( Category.valueOf(categorierecla.getValue()));
            //cat.setId(Integer.valueOf(iduser.getText()));
   Reclamation r = new Reclamation(0,Integer.parseInt(iduserrecla.getText()),10,contenuerecla.getText()); 
    try {
    serv.ajoutereclamation(r);
    ca.ajoutercategory(cat);
     } catch (SQLException ex) {
               System.out.println(ex.getMessage());
     }
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Ajouter");
        alert.setHeaderText("Information");
        alert.setContentText("reclamation bien Ajouter!");
        alert.show();
            
    }

    @FXML
    private void clikannulerrecla(ActionEvent event) {
        
    }

    @FXML
    private void clikretourrecla(ActionEvent event) {
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
=======
 * @author ASUS
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0
    
}
