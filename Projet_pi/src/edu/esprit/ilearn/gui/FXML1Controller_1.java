/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import edu.esprit.ilearn.entities.Category;
import edu.esprit.ilearn.entities.Categoryrec;
import edu.esprit.ilearn.entities.Reclamation;
import edu.esprit.ilearn.services.InterfaceCategory;
import edu.esprit.ilearn.services.InterfaceReclamation;
import edu.esprit.ilearn.services.ServiceCategoryrec;
import edu.esprit.ilearn.services.ServiceReclamation;
import edu.esprit.ilearn.utils.SendMail;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;




/**
 * FXML Controller class
 *
 * @author DELL
 */
public class FXML1Controller_1 implements Initializable {
    private TableColumn<Reclamation,Reclamation> action=new TableColumn<>();
    @FXML
    private TableView<Reclamation> tablereclamation;
    @FXML
    private TableColumn<Reclamation, Integer> columnidrec;
    @FXML
    private TableColumn<Reclamation, Integer> columniduser;
    @FXML
    private TableColumn<Reclamation, Integer> columnidcategorie;
    @FXML
    private TableColumn<Reclamation, Enum> columncategorie1;
    @FXML
    private TableColumn<Reclamation, String> columndate;
    @FXML
    private TableColumn<Reclamation, String> columncontenue;
    @FXML
    private TableColumn<Reclamation, String> columnetatreclamation;
    @FXML
    private Button accepterrecla;
    @FXML
    private Button supprimerrecla;
    @FXML
    private Button afficherrecla;
     private Stage stage;
    private Scene scene;
    private Parent root;
    private final ObservableList<Reclamation> obsReclamation = FXCollections.observableArrayList();
   
    InterfaceCategory su = new ServiceCategoryrec();
   List<Reclamation> listReclamation;
    /*public FXML1Controller() {
        try {
            this.listReclamation = sp.getAllReclamation();
        } catch (SQLException ex) {
            Logger.getLogger(FXML1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
   

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceReclamation sr =new ServiceReclamation();
           
           // sr.addetat();
        } catch (SQLException ex) {
            Logger.getLogger(FXML1Controller_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void clickaccepterrecla(ActionEvent event) throws SQLException, Exception {
          Reclamation cr = tablereclamation.getSelectionModel().getSelectedItem();
        ServiceReclamation servi = new ServiceReclamation();
        try {
           Reclamation  cc = new Reclamation(cr.getIdreclamation(),cr.getEtatreclamation());
           servi.updateetatreclamation(cc);
           SendMail.sendMail("wissem.hammouda@esprit.tn","votre reclamation et accepter ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void clicksupprimerrecla(ActionEvent event) throws SQLException {
        
        Reclamation u = tablereclamation.getSelectionModel().getSelectedItem();
        ServiceReclamation servi = new ServiceReclamation();
        try {
            servi.deletereclamation(u.getIdreclamation());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        
   

    @FXML
    private void clickafficherrecla(ActionEvent event) throws SQLException {
        ServiceReclamation ServiceReclamation =new ServiceReclamation();
        InterfaceReclamation sp = new ServiceReclamation();
       //InterfaceCategory c=new ServiceCategoryrec();
        List<Reclamation> r1=new ArrayList<Reclamation>();
        r1=sp.getAllReclamation();
            ArrayList list = (ArrayList) ServiceReclamation.getAllReclamation();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            tablereclamation.setItems(observablelist);
            System.out.print(observablelist.get(0));
            
           columnidrec.setCellValueFactory(new PropertyValueFactory<>("idreclamation"));
            columniduser.setCellValueFactory((CellDataFeatures<Reclamation, Integer> param) -> new SimpleObjectProperty<Integer>(param.getValue().getUtilisateur().getIduser()));
       
           
           columnidcategorie.setCellValueFactory((CellDataFeatures<Reclamation, Integer> param) -> new SimpleObjectProperty<Integer>(param.getValue().getCategoryrec().getIdcategory()));
       
             columncategorie1.setCellValueFactory((CellDataFeatures<Reclamation, Enum> param) -> new SimpleObjectProperty(param.getValue().getCategoryrec().getCategory()));
            columndate.setCellValueFactory(new PropertyValueFactory<>("datereclamation"));
            columncontenue.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            columnetatreclamation.setCellValueFactory(new PropertyValueFactory<>("etatreclamation"));
        action.setCellValueFactory(
                param -> new ReadOnlyObjectWrapper<>(param.getValue())
        );
        
        action.setCellFactory((TableColumn<Reclamation, Reclamation> param) -> {
            return new TableCell<Reclamation,Reclamation>(){
                @Override
                protected void updateItem(Reclamation jc, boolean empty) {
                    super.updateItem(jc, empty);
                    if (jc == null) {
                        setGraphic(null);
                        return;
                    }
                    
                    
                }
            };
        });
    };
}