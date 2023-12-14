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
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class ModiclientreclamationController_2 implements Initializable {
 //private TableColumn<Reclamation,Reclamation> action=new TableColumn<>();
    @FXML
    private TableView<Reclamation> tableclientreclamation;
    @FXML
    private TableColumn<Reclamation, Integer> id_reclmation;
     @FXML
    private TableColumn<Reclamation, Integer> idcategory;
    @FXML
    private TableColumn<Reclamation, Enum> coloncategorieclient;
    @FXML
    private TableColumn<Reclamation, String> datereclamation;
    @FXML
    private TableColumn<Reclamation,String > contenuereclamation;
    @FXML
    private Button modifierrecla;
    @FXML
    private Button suprimerreclam;
    @FXML
    private Button retourajoutereclam;
    @FXML
    private ComboBox<String> modifiercategoryrecla;
    @FXML
    private TextField textidcategory;
    @FXML
    private TextField textidreclamation;
    @FXML
    private TextArea textcontenureclamation;
    @FXML
    private Button enregistrerreclam;
    @FXML
    private TextField iduserreclamationi;
    @FXML
    private TableView<Categoryrec> tablecategory;
    @FXML
    private TableColumn<Categoryrec, Integer> clientidcategreclam;
    @FXML
    private TableColumn<Categoryrec, Enum> categoryclientrecla;
    @FXML
    private Button supprimer;
    @FXML
    private Button modier;
    
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> list = FXCollections.observableArrayList("avis","feeeedback","rapport","autre");
        modifiercategoryrecla.setItems(list);
        viewreclamation();
        viewcategoryreclamation();
    } 
    public void viewcategoryreclamation(){
        ServiceCategoryrec ServiceCategoryrec =new ServiceCategoryrec();
        try{
            ArrayList list = (ArrayList) ServiceCategoryrec.readAllcat();
            ObservableList observablelist = FXCollections.observableArrayList(list);
           tablecategory.setItems(observablelist);
           clientidcategreclam.setCellValueFactory(new PropertyValueFactory<>("idcategory"));
            categoryclientrecla.setCellValueFactory(new PropertyValueFactory<>("category"));
            } catch (SQLException ex) {
            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
public void viewreclamation() {
    try {
    ServiceReclamation ServiceReclamation =new ServiceReclamation();
       
        
            ArrayList list = (ArrayList) ServiceReclamation.getAll(1);
            ObservableList observablelist = FXCollections.observableArrayList(list);
            tableclientreclamation.setItems(observablelist);
           id_reclmation.setCellValueFactory(new PropertyValueFactory<>("idreclamation"));
           
           idcategory.setCellValueFactory((TableColumn.CellDataFeatures<Reclamation, Integer> param) -> new SimpleObjectProperty<Integer>(param.getValue().getCategoryrec().getIdcategory()));
       
            coloncategorieclient.setCellValueFactory((TableColumn.CellDataFeatures<Reclamation, Enum> param) -> new SimpleObjectProperty(param.getValue().getCategoryrec().getCategory()));
           
            datereclamation.setCellValueFactory(new PropertyValueFactory<>("datereclamation"));
            contenuereclamation.setCellValueFactory(new PropertyValueFactory<>("contenu"));
                    //action.setCellValueFactory(
                //param -> new ReadOnlyObjectWrapper<>(param.getValue())
        //);
        
       /*action.setCellFactory((TableColumn<Reclamation, Reclamation> param) -> {
            return new TableCell<Reclamation,Reclamation>();/*{
                @Override
                protected void updateItem(Reclamation jc, boolean empty) {
                    super.updateItem(jc, empty);
                    if (jc == null) {
                        setGraphic(null);
                       // return;
                    }
                }
            };*/
        } catch (SQLException ex) {
            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    

    @FXML
    private void clickmodifierrecla(ActionEvent event) {
        Reclamation r = (Reclamation) tableclientreclamation.getSelectionModel().getSelectedItem();
        String idrec=Integer.toString(r.getIdreclamation());       
        textidreclamation.setText(idrec);
        String iduserrec=Integer.toString(r.getUtilisateur().getIduser());       
        iduserreclamationi.setText(iduserrec);
        String idcat=Integer.toString(r.getCategoryrec().getIdcategory());
       textidcategory.setText(idcat);
       
       textcontenureclamation.setText(r.getContenu());
    }
     @FXML
    private void clikenregistrerrecla(ActionEvent event) throws SQLException  {
    
        ServiceReclamation  sr = new ServiceReclamation();
       // try {
        int idrec = Integer.parseInt(textidreclamation.getText());
        int iduserec = Integer.parseInt(iduserreclamationi.getText());
        int idcatrecla = Integer.parseInt(textidcategory.getText()); 
        Reclamation rec = new Reclamation(idrec,new Utilisateur(iduserec),new Categoryrec(idcatrecla),textcontenureclamation.getText());
  
               sr.updatereclamation(rec);
              // viewreclamation();
        //} catch (SQLException ex) {
          //  Logger.getLogger(ModiclientreclamationController.class.getName()).log(Level.SEVERE, null, ex);
       // }
   viewreclamation();
    }

    @FXML
    private void cliksuprimerrecla(ActionEvent event) throws SQLException {
        Reclamation u = tableclientreclamation.getSelectionModel().getSelectedItem();
        Reclamation c=tableclientreclamation.getSelectionModel().getSelectedItem();
        ServiceReclamation servi = new ServiceReclamation();
        ServiceCategoryrec cat=new ServiceCategoryrec () ;
        try {
            servi.deletereclamation(u.getIdreclamation());
            cat.deletecategory(u.getCategoryrec().getIdcategory());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        viewreclamation();
    }

    @FXML
    private void clikretourreclamation(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("../gui/Reclamationclientajout.fxml"));
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node) event.getSource())
                        .getScene().getWindow();
                stage.setScene(scene);
                stage.show(); 
        
        
    }

    @FXML
    private void clikiduserreclamation(ActionEvent event) {
    }
    

    @FXML
    private void clikdeletecategoryclient(ActionEvent event) {
           Categoryrec cr = tablecategory.getSelectionModel().getSelectedItem();
        ServiceCategoryrec servi = new ServiceCategoryrec();
        try {
            servi.deletecategory(cr.getIdcategory());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       viewcategoryreclamation(); 
    }

    @FXML
    private void clikclientmodifiercategory(ActionEvent event) {
        Categoryrec cr = tablecategory.getSelectionModel().getSelectedItem();
        ServiceCategoryrec servi = new ServiceCategoryrec();
        try {
           Categoryrec  cc = new Categoryrec(cr.getIdcategory(),Category.valueOf( modifiercategoryrecla.getValue()));
           servi.updatecategory(cc);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       viewcategoryreclamation(); 
    }

   
}
