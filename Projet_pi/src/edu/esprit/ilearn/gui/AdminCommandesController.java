/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import com.mysql.cj.result.Row;
import edu.esprit.ilearn.entities.Commande;
import edu.esprit.ilearn.entities.Etat;
import edu.esprit.ilearn.entities.LigneCommande;
import edu.esprit.ilearn.services.ServiceCommande;
import edu.esprit.ilearn.services.ServiceLigneCommande;
import edu.esprit.ilearn.utils.MyDB;
import edu.esprit.ilearn.utils.SendMail;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminCommandesController implements Initializable {

    @FXML
    private TableView<Commande> tableviewadmin;
    @FXML
    private TableColumn<Commande, Integer> Id;
    @FXML
    private TableColumn<Commande, String> date;
    @FXML
    private TableColumn<Commande, Integer> total;
    @FXML
    private TableColumn<Commande, String> etat;
    @FXML
    private Button buttonn;
    @FXML
    private ComboBox<String> combo;
    @FXML
    private TableView<LigneCommande> tab;
    @FXML
    private TableColumn<LigneCommande, Integer> t;
    @FXML
    private TableColumn<LigneCommande, Integer> idi;
    @FXML
    private TableColumn<LigneCommande, Integer> idf;
    @FXML
    private TableColumn<LigneCommande, Integer> pri;

    /**
     * Initializes the controller class.
     */
    public void viewCommandeadmin() {
        ServiceCommande ServiceCommande = new ServiceCommande();

        try {
            ArrayList list = (ArrayList) ServiceCommande.readALL();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            tableviewadmin.setItems(observablelist);
            Id.setCellValueFactory(new PropertyValueFactory<>("IdCommande"));
            date.setCellValueFactory(new PropertyValueFactory<>("datecommand"));
            total.setCellValueFactory(new PropertyValueFactory<>("total"));
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void viewLigneCommande() {
        ServiceLigneCommande ServiceLigneCommande = new ServiceLigneCommande();

        try {
            ArrayList list = (ArrayList) ServiceLigneCommande.readALL();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            tab.setItems(observablelist);
            int id = 4;
            t.setCellValueFactory(new PropertyValueFactory<>("idlignecommand"));
            idi.setCellValueFactory(new PropertyValueFactory<>("idcommande"));
            idf.setCellValueFactory(new PropertyValueFactory<>("idformation"));
            pri.setCellValueFactory(new PropertyValueFactory<>("prix"));
            //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        viewLigneCommande();
        viewCommandeadmin();
        ObservableList<String> list = FXCollections.observableArrayList("passé", "encour", "expidié");
        combo.setItems(list);
    }

    @FXML
    private void modifieretat(ActionEvent event) throws Exception {
        Commande c = (Commande) tableviewadmin.getSelectionModel().getSelectedItem();
        // String id = Integer.toString(c.getIdCommande());
        ServiceCommande lc = new ServiceCommande();
        Commande cc = new Commande(c.getIdCommand(), c.getTotal(), Etat.valueOf(combo.getValue()));
        String e = Etat.valueOf(combo.getValue()).toString();
        SendMail.sendMail("alahammouda456@gmail.com", e);
        // Etat et =Etat.valueOf(combo.getValue());
        try {
            lc.update(cc);
            viewCommandeadmin();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void enregistermodification(ActionEvent event) {
        ServiceCommande s = new ServiceCommande();
        //  int id = Integer.parseInt(user_id.getText());
        //   Commande c = new Commande(idIdCommande);
        //  try {
        ////         s.update(uti);
        /*  } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }*/
    }

    @FXML
    private void viewLigneCommandeById(ActionEvent event) {
        ServiceLigneCommande ServiceLigneCommande =new ServiceLigneCommande();
     Commande c = tableviewadmin.getSelectionModel().getSelectedItem();
       // ServiceCommande servi = new ServiceCommande();
       //ImageView imgs = new ImageView(new Image(this.getClass().getResourceAsStream("téléchargement.png").toString()));
        try {
            ArrayList list = (ArrayList) ServiceLigneCommande.readById(c.getIdCommand());
            ObservableList observablelist = FXCollections.observableArrayList(list);
             tab.setItems(observablelist);
            t.setCellValueFactory(new PropertyValueFactory<>("idlignecommand"));
            idi.setCellValueFactory(new PropertyValueFactory<>("idcommande"));
            idf.setCellValueFactory(new PropertyValueFactory<>("idformation"));
            pri.setCellValueFactory(new PropertyValueFactory<>("prix"));
          // img.setCellValueFactory(new PropertyValueFactory<>( imgs ));
            //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
          // tableview.get;
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     
    }

}
