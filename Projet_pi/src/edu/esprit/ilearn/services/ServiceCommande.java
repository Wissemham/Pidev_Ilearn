/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.services;

import edu.esprit.ilearn.entities.Commande;
import edu.esprit.ilearn.entities.Etat;
import edu.esprit.ilearn.utils.MyDB;
import java.sql.Connection;
import java.sql.Date;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceCommande implements ICommande<Commande> {
    private Connection con;
    private Statement ste;

    public ServiceCommande() {
        con = MyDB.getInstance().getConnection();
    }
    
    

    @Override
    public void ajouter(Commande c) throws SQLException {
        LocalDate myDate = LocalDate.now();
        
        ste =con.createStatement();
        String req="INSERT INTO `ilearn`.`command` (`idcommand`,`datecommand`,`total`,`etat`) VALUES('"+c.getIdCommand()+"','"+myDate+"','"+c.getTotal()+"','"+c.getEtat()+"')";
        
            ste.executeUpdate(req);
             System.out.println("Commande Ajouté avec succés");

    }

   
    @Override
    public void delete(int IdCommande) throws SQLException {
        ste = con.createStatement();
        String request ="DELETE FROM `ilearn`.`command` WHERE idcommand ="+IdCommande+"";
         
             
           ste.executeUpdate(request);
            System.out.println("Commande Supprimé avec succés");
        
           
        
    }       

    @Override
    public List<Commande> readALL() throws SQLException {
    List<Commande> commandes = new ArrayList<>();
    String req = "SELECT * FROM command c";
            
            ste =con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            
            while(rs.next()){
                int IdC =rs.getInt("idcommand");
                 Date datec = rs.getDate("datecommand");
                 int total = rs.getInt("total");
                 
                 
                 Commande c = new Commande(IdC,datec,total,Etat.valueOf(rs.getString("etat")));
                 
                 commandes.add(c);
                }
            
       
           
        
        return commandes;
    }

    @Override
    public void update(Commande c) throws SQLException {
        LocalDate myDate = LocalDate.now();
    // String request ="UPDATE `ilearn`.`command` SET `datecommand`="+myDate+", `total`="+c.getTotal()+",`etat`="+c.getEtat()+" WHERE idcommand ="+c.getIdCommande()+"";
        delete(c.getIdCommand());
        ajouter(c);
            /// ste = con.createStatement();
          // ste.executeUpdate(request);
            System.out.println("Commande Modifié avec succés");
            }
     @Override
    public void update(int idcommand,int total) throws SQLException {
        String req2 = "update `ilearn`.`command` set total = '"+total+"' where `ilearn`.`command`.`idcommand` = '"+idcommand+"'" ;
        Statement sta;
        sta = con.createStatement();
        sta.executeUpdate(req2);   
         System.out.println("Elem Commande modifier avec succés"); 
    }
   

   
}  
        

