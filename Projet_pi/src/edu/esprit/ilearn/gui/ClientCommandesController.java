/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.esprit.ilearn.gui;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.esprit.ilearn.entities.Commande;
import edu.esprit.ilearn.entities.Etat;
import edu.esprit.ilearn.entities.LigneCommande;
import edu.esprit.ilearn.services.ICommande;
import edu.esprit.ilearn.services.ServiceCommande;
import edu.esprit.ilearn.services.ServiceLigneCommande;
import edu.esprit.ilearn.utils.MyDB;
import edu.esprit.ilearn.utils.PdfGenerator;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.Integer.toHexString;
import java.util.Formatter;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ClientCommandesController implements Initializable {
    ICommande sp = new ServiceCommande();

    @FXML
    private Button button;
    @FXML
    private Button button2;
    @FXML
    private Label label1;
    @FXML
    private Pane pane1;
    @FXML
    private ImageView image2;
    @FXML
    private TableView<Commande> tableview;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane anchor;
    @FXML
    private TableColumn<Commande, Integer> Id;
    @FXML
    private TableColumn<Commande, String> date;
    @FXML
    private TableColumn<Commande, Integer> total;
    //private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<Commande, String> etat;
    
    public ObservableList<Commande> data = FXCollections.observableArrayList();
    
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private Button Buttonn;
    @FXML
    private TableView<LigneCommande> tableview1;
    @FXML
    private TableColumn<LigneCommande, Integer> Idl;
    @FXML
    private TableColumn<LigneCommande, Integer> Idlc;
    @FXML
    private TableColumn<LigneCommande, Integer> Prix;
    
     private Parent root;
    private Stage stage;
    @FXML
    private Label captcha;
    @FXML
    private TextField text3;
    
    String g;
    @FXML
    private TextField nombre;
    
   public void viewCommande(){
  ServiceCommande ServiceCommande =new ServiceCommande();
       
        try {
            ArrayList list = (ArrayList) ServiceCommande.readALL();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            
            //System.out.println(n);
            tableview.setItems(observablelist);
           
          
            Id.setCellValueFactory(new PropertyValueFactory<>("IdCommande"));
            date.setCellValueFactory(new PropertyValueFactory<>("datecommand"));
            total.setCellValueFactory(new PropertyValueFactory<>("total"));
            etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
           // int a =56;
           //System.out.println(toHexString(a));
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
   }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            viewLigneCommande();
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
               viewCommande();
               g= GenCaptcha();
                captcha.setText(g);
       // cap.setImageCaptcha(captcha);
       /* try {
            System.out.println(rechercherFormation(5));
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
}
   //  private final ObservableList<LigneCommande> dat = FXCollections.observableArrayList();
     public void viewLigneCommande() throws SQLException{
     ServiceLigneCommande ServiceLigneCommande =new ServiceLigneCommande();
       //ImageView imgs = new ImageView(new Image(this.getClass().getResourceAsStream("téléchargement.png").toString()));
  
       try {
            ArrayList list = (ArrayList) ServiceLigneCommande.readALL();
            ObservableList observablelist = FXCollections.observableArrayList(list);
            
             String total = getnomf("idformation");
             System.out.println(total);
        
//            total = rs.getString("f.nomformation");
//           System.out.println(total);
            tableview1.setItems(observablelist);
            Idl.setCellValueFactory(new PropertyValueFactory<>("idlignecommand"));
            Idlc.setCellValueFactory(new PropertyValueFactory<>("idcommande"));
            Prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          // img.setCellValueFactory(new PropertyValueFactory<>( imgs ));
            //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
          // tableview.get;
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }
     
     
    @FXML
      public void viewLigneCommandeById() throws SQLException{
     ServiceLigneCommande ServiceLigneCommande =new ServiceLigneCommande();
     Commande c = tableview.getSelectionModel().getSelectedItem();
       // ServiceCommande servi = new ServiceCommande();
       //ImageView imgs = new ImageView(new Image(this.getClass().getResourceAsStream("téléchargement.png").toString()));
       int n =NombreLigneCommande(c.getIdCommand());
       String f = String.valueOf(n);
       nombre.setText(f);
       try {
            ArrayList list = (ArrayList) ServiceLigneCommande.readById(c.getIdCommand());
            ObservableList observablelist = FXCollections.observableArrayList(list);
            tableview1.setItems(observablelist);
            Idl.setCellValueFactory(new PropertyValueFactory<>("idlignecommand"));
            Idlc.setCellValueFactory(new PropertyValueFactory<>("idcommande"));
            Prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          // img.setCellValueFactory(new PropertyValueFactory<>( imgs ));
            //etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
          // tableview.get;
        } catch (SQLException ex) {
            Logger.getLogger(ClientCommandesController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
     }

    @FXML
    private void AjoutCommande(ActionEvent event) throws SQLException{
       if(text1.getText().equals("") || text2.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR );
            alert.setTitle("Commande");
            alert.setHeaderText("Information");
            alert.setContentText("verifier vous donnes!");
            alert.show();
        }else{
           ServiceCommande ser = new ServiceCommande();
                List<Commande> list = ser.readALL();
                Boolean rep;
                rep = rechercherCommande(text1.getText());                
                if(rep == true){
                    ServiceLigneCommande serv = new ServiceLigneCommande();     
        LigneCommande u = new LigneCommande( Integer.parseInt(text1.getText()),  Integer.parseInt(text2.getText()));
        try {
               serv.ajouterl(u);
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
       Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Ajouter");
        alert.setHeaderText("Information");
        alert.setContentText("Element Commande bien Ajouter!");
        alert.show();
          
        viewLigneCommande();
                }  
                else{
          Alert alert = new Alert(Alert.AlertType.ERROR );
                    alert.setTitle("Commande");
                    alert.setHeaderText("Erreur");
                    alert.setContentText("Commande introuvable!");
                    alert.show();}
    }
    }
    

    @FXML
    private void AjoutNewCommande(ActionEvent event) {
         Etat et =Etat.encour;
         ServiceCommande serv = new ServiceCommande(); 
        Commande c = new Commande(0,et);
        if(text3.getText().equals(g)){
        try {
               serv.ajouter(c);
                g= GenCaptcha();
                captcha.setText(g);
        } catch (SQLException ex) {
               System.out.println(ex.getMessage());
        }
        viewCommande();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Ajouter");
        alert.setHeaderText("Information");
        alert.setContentText("New commande!");
        alert.show();
        }else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION );
        alert.setTitle("Ajouter");
        alert.setHeaderText("Information");
        alert.setContentText("Verifier Captcha");
        alert.show();
        }
    }

    @FXML
    private void DeleteRowSelected(ActionEvent event) throws SQLException {
        Commande c = tableview.getSelectionModel().getSelectedItem();
        ServiceCommande servi = new ServiceCommande();
        try {
            rechercherLigneCommande(c.getIdCommand());
            servi.delete(c.getIdCommand());
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        viewCommande();
        viewLigneCommande();
    }

    @FXML
    private void DeleteLigne(ActionEvent event) throws SQLException {
        LigneCommande l = tableview1.getSelectionModel().getSelectedItem();
        ServiceLigneCommande servi = new ServiceLigneCommande();
        try {
            servi.delete(l.getIdlignecommand());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        viewLigneCommande();
    }

    @FXML
    private void refreshcommande() {
          Commande c = tableview.getSelectionModel().getSelectedItem();
        ServiceCommande servi = new ServiceCommande();
        ServiceLigneCommande ser =new ServiceLigneCommande();
        try {
           int t= ser.Total(c.getIdCommand());
            servi.update(c.getIdCommand(),t);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          viewCommande();
    }

    @FXML
    private void BackToUser(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminCommandes.fxml"));
        Scene scene = new Scene(root, 800, 650);
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public Boolean rechercherCommande(String idcommand) throws SQLException {
        
        ServiceCommande serv = new ServiceCommande();
        List<Commande> list = serv.readALL();
        for (int i=0;i<list.size();i++){
                if(Integer.parseInt(idcommand)==list.get(i).getIdCommand()){
                   return true;
                }
                    
                }
        
    return false;
    }
    public void rechercherLigneCommande(int idcommand) throws SQLException {
        
        ServiceLigneCommande serv = new ServiceLigneCommande();
        List<LigneCommande> list = serv.readALL();
        for (int i=0;i<list.size();i++){
                if(idcommand==list.get(i).getIdcommande()){
                   serv.delete(list.get(i).getIdlignecommand());
                  
                }
                    
                }
        
  
    }
     public int NombreLigneCommande(int idcommand) throws SQLException {
        int n=0;
        ServiceLigneCommande serv = new ServiceLigneCommande();
        List<LigneCommande> list = serv.readALL();
        for (int i=0;i<list.size();i++){
                if(idcommand==list.get(i).getIdcommande()){
                   n=n+1;
                  
                }
                    
                }
        
  return n;
    }
   /* @FXML
    public Boolean rechercherFormation(int idformation) throws SQLException {
        
           Connection co = null;
    
   
    
        int total = 0;

        String req = "SELECT `nomformation` AS `pt` FROM `formation` WHERE idcommand = " + idformation + "";
       Statement ste = co.createStatement();
        ResultSet rs = ste.executeQuery(req);

        
            total = rs.getInt("pt");
        if(Integer.toString(total)!=null){
            return true;
        }
        return false;
    
    }*/
    @FXML
   public void PdfGenerator(ActionEvent event) throws Exception{
       try {
          PdfGenerator.pdfs();
        Connection con = MyDB.getInstance().getConnection();
        Statement stmt = con.createStatement();
        /* Define the SQL query */
        ResultSet query_set = stmt.executeQuery("SELECT *From lignecommande");
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("C:\\Users\\ASUS\\Desktop\\java.pdf"));
        my_pdf_report.open();
        my_pdf_report.add(new Paragraph("                                       Votre Element Commande"));
        my_pdf_report.add(new Paragraph(" "));
         my_pdf_report.add(new Paragraph(" "));
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(3);
        //create a cell object
        PdfPCell table_cell;
         PdfPCell c1 = new PdfPCell(new Phrase("IdC"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    my_report_table.addCell(c1);

    c1 = new PdfPCell(new Phrase("IdF"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    my_report_table.addCell(c1);

    c1 = new PdfPCell(new Phrase("Prix DT"));
    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    my_report_table.addCell(c1);
        while (query_set.next()) {
            String dept_id = query_set.getString("idcommand");
            table_cell = new PdfPCell(new Phrase(dept_id));
            my_report_table.addCell(table_cell);
            String dept_name = query_set.getString("idformation");
            table_cell = new PdfPCell(new Phrase(dept_name));
            my_report_table.addCell(table_cell);
            String manager_id = query_set.getString("prix");
            table_cell = new PdfPCell(new Phrase(manager_id));
            my_report_table.addCell(table_cell);
//                                    String location_id=query_set.getString("Sum");
//                                    table_cell=new PdfPCell(new Phrase(location_id));
//                                    my_report_table.addCell(table_cell);
        }
        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);
        my_pdf_report.close();

        /* Close all DB related objects */
        query_set.close();
       // stmt.close();
       // con.close();
         } catch (FileNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    } catch (DocumentException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }
private static String GenCaptcha() {
 
        String captcha = null;
        char data[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9'};
        char index[]=new char[7];

        Random r=new Random();
        int i =0;

        for( i=0;i<(index.length);i++)
        {
            int ran=r.nextInt(data.length);
            index[i]=data[ran];
            captcha=String.valueOf(index);
            //System.out.println("captcha is"+captcha);
            
        }
        return captcha;
       
    }  

    @FXML
    private void ViderCommande() throws SQLException {
     Commande c = tableview.getSelectionModel().getSelectedItem();
        //ServiceCommande servi = new ServiceCommande();
        try {
            rechercherLigneCommande(c.getIdCommand());
           
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        refreshcommande();
        viewLigneCommande();
    }
     public String getnomf(String id) throws SQLException {
        String pr = null;

        String req = "SELECT nomformation FROM `formation` f Where f.idformation = "+id+"";
        Connection con = MyDB.getInstance().getConnection();
        Statement ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()) {
            pr = rs.getString("nomformation");
        }
        return pr;
    }
    }
    
//}
    

