/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import edu.esprit.ilearn.entities.Reclamation;
import edu.esprit.ilearn.services.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXML1Controller implements Initializable {

    @FXML
    private TableView<Reclamation> tablereclamation;
   
    @FXML
    private Button accepterrecla;
    @FXML
    private Button supprimerrecla;
    @FXML
    private Button afficherrecla;
    @FXML
    private TableColumn<Reclamation, Integer> columnidrec;
    @FXML
    private TableColumn<Reclamation, Integer> columniduser;
    @FXML
    private TableColumn<Reclamation, Integer> columnidcategorie;
    
    @FXML
    private TableColumn<Reclamation, String> columndate;
    @FXML
    private TableColumn<Reclamation, String> columncontenue;
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void clickaccepterrecla(ActionEvent event) {
    }

    @FXML
    private void clicksupprimerrecla(ActionEvent event) {
        
        Reclamation u = tablereclamation.getSelectionModel().getSelectedItem();
        ServiceReclamation servi = new ServiceReclamation();
        try {
            servi.deletereclamation(u.getIdreclamation());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        
   

    @FXML
    private void clickafficherrecla(ActionEvent event) {
        ServiceReclamation ServiceReclamation =new ServiceReclamation();
       
        try {
            ArrayList list = (ArrayList) ServiceReclamation.readAll();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            tablereclamation.setItems(observablelist);
           columnidrec.setCellValueFactory(new PropertyValueFactory<>("idreclamation"));
            columniduser.setCellValueFactory(new PropertyValueFactory<>("iduser"));
            columnidcategorie.setCellValueFactory(new PropertyValueFactory<>("idcategory"));
            columndate.setCellValueFactory(new PropertyValueFactory<>("datereclamation"));
            columncontenue.setCellValueFactory(new PropertyValueFactory<>("contenu"));
        } catch (SQLException ex) {
            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
