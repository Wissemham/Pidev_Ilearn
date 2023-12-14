/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.services;
import java.sql.DriverManager;
import java.sql.Connection;


import edu.esprit.ilearn.entities.Category;
import edu.esprit.ilearn.entities.Categoryrec;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import edu.esprit.ilearn.entities.Reclamation;
import edu.esprit.ilearn.entities.Utilisateur;
import edu.esprit.ilearn.utils.MyDb;
import java.sql.Date;
//import java.time.LocalDateTime;
import java.sql.Statement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ServiceReclamation implements InterfaceReclamation <Reclamation> {
private Connection con;
private Statement ste;

    public ServiceReclamation() throws SQLException, SQLException {
        con=MyDb.getInstance().getConnection();
    }
    @Override
     public int maxidcategory() throws SQLException {
         int idc=0;
        
        ServiceCategoryrec serv = new ServiceCategoryrec();
        List<Categoryrec> list = serv.readAllcat();
        for (int i=0;i<list.size();i++){
                idc=list.get(i).getIdcategory();  
        }
        System.out.println(idc);
              return idc;
              
                }

    @Override
    public void ajoutereclamation(Reclamation t) throws SQLException {
       ste= con.createStatement(); 
       LocalDate daterec=LocalDate.now();
       int c =maxidcategory();
       
      String req = "INSERT INTO `ilearn`.`reclamation`( `iduser`,`idcategory`, `datereclamation`, `contenu`) VALUES ('"+t.getUtilisateur().getIduser()+"','"+c+"','"+daterec+"','"+t.getContenu()+"')";
      ste.executeUpdate(req);
      System.out.println("reclamation ajouter avec success");
    }

   /*public void ajoutereclamation(Reclamation t) throws SQLException {
     PreparedStatement pre =con.prepareStatement("INSERT INTO `ilearn`.`reclamation`( `iduser`,`idcategory`,`datereclamation`, `contenu`) VALUES (?,?,?,?)"); 
     pre.setInt(1,t.getIduser());
     pre.setInt(2,t.getIdcategory());
      pre.setDate(3, (Date) t.getDatereclamation());
       pre.setString(4,t.getContenu());
    }*/
    
    
        @Override
    public void updatereclamation(Reclamation t) throws SQLException {
         LocalDate daterec = LocalDate.now();
          int c =maxidcategory();
          String s= "non-traite";
  // String req ="UPDATE `ilearn`.`reclamation` SET `iduser`='"+t.getIduser()+"',`idcategory`='"+c+"',`datereclamation`='"+daterec+"',`contenu`='"+t.getContenu()+"'WHERE `ilearn`.`reclamation`.`idreclamation`='"+t.getIdreclamation()+"'";
     String req ="UPDATE `ilearn`.`reclamation` SET`datereclamation`='"+daterec+"',`contenu`='"+t.getContenu()+"',`etatreclamation`='"+s+"' WHERE `ilearn`.`reclamation`.`idreclamation`='"+t.getIdreclamation()+"'";
             ste = con.createStatement();
          ste.executeUpdate(req);
            System.out.println("reclamation Modifié avec succés");
        
    }
       @Override
    public void deletereclamation(int idreclamation) throws SQLException {
        ste = con.createStatement();
        String req ="DELETE FROM `ilearn`.`reclamation` WHERE `idreclamation` ="+idreclamation+"";    
           ste.executeUpdate(req);
            System.out.println("reclamation Supprimé avec succés");
        
    }
    @Override
    public List<Reclamation> readAll() throws SQLException{
     
      List<Reclamation> arr= new ArrayList<>();
     
      
          ste= con.createStatement();
      ResultSet r=ste.executeQuery("SELECT * FROM reclamation r inner join categoryrec c on r.idcategory=c.idcategory");
     
      while (r.next()){
          
          int idreclamation=r.getInt("r.idreclamation");
          //int iduser=r.getInt("iduser");
         //int idcategory=r.getInt("c.idcategory");
         
         Date datereclamation=r.getDate("r.datereclamation");
          String contenu=r.getString("r.contenu");
      Reclamation re=new Reclamation(idreclamation,new Utilisateur(r.getInt("iduser")),new Categoryrec(Category.valueOf(r.getString("category"))),datereclamation,contenu);
      arr.add(re);
    }
      
      return arr;
    }
    @Override
     public List<Reclamation> getAll(int iduser) throws SQLException{
      List<Reclamation> arr= new ArrayList<>();
     
      
          ste= con.createStatement();
      ResultSet r=ste.executeQuery("select DISTINCTROW r.idreclamation,r.iduser,c.idcategory,c.category,r.datereclamation,r.contenu from reclamation r inner join categoryrec c on r.idcategory=c.idcategory where iduser ="+iduser+"");
     
      while (r.next()){
          
          int idreclamation=r.getInt("r.idreclamation");
 
         
         Date datereclamation=r.getDate("r.datereclamation");
          String contenu=r.getString("r.contenu");
      Reclamation re=new Reclamation(idreclamation,new Utilisateur(r.getInt("iduser")),new Categoryrec(r.getInt("c.idcategory"),Category.valueOf(r.getString("category"))),datereclamation,contenu);
       //Reclamation re =new Reclamation(r.getInt("r.idreclamation"),r.getInt("u.iduser"),r.getCategoryrec("idcategory"),r.getDate("r.datereclamation"),r.getString("r.contenu"));
      arr.add(re);
       
    }
      
      return arr;
    }   
@Override
     public List<Reclamation> getAllReclamation() throws SQLException{
      List<Reclamation> arr= new ArrayList<>();
          ste= con.createStatement();
      ResultSet r=ste.executeQuery("select DISTINCTROW r.idreclamation,r.iduser,c.idcategory,c.category,r.datereclamation,r.contenu,r.etatreclamation from reclamation r inner join categoryrec c on r.idcategory=c.idcategory ");
     
      while (r.next()){
          
          int idreclamation=r.getInt("r.idreclamation");
          int iduser=r.getInt("iduser");
         Date datereclamation=r.getDate("r.datereclamation");
          String contenu=r.getString("r.contenu");
          String etatreclamation=r.getString("r.etatreclamation");
      Reclamation re=new Reclamation(idreclamation,new Utilisateur(r.getInt("iduser")),new Categoryrec(r.getInt("c.idcategory"),Category.valueOf(r.getString("category"))),datereclamation,contenu,etatreclamation);
      arr.add(re);
       
    }
      
      return arr;
    } 

    @Override
  public void addetat() throws SQLException {
     List<Reclamation> arr= new ArrayList<>();
          ste= con.createStatement();
      ste.executeUpdate(  "ALTER TABLE `ilearn`.`reclamation` ADD etatreclamation VARCHAR(100) NOT NULL DEFAULT 'non-traite'"); 
        System.out.println("etat de reclamation a ete ajouter");
        
    } 

    @Override
    public void updateetatreclamation(Reclamation t) throws SQLException {
    LocalDate daterec = LocalDate.now(); 
    String s="traite";
    String req ="UPDATE `ilearn`.`reclamation` SET`datereclamation`='"+daterec+"',`etatreclamation`='"+s+"'WHERE `ilearn`.`reclamation`.`idreclamation`='"+t.getIdreclamation()+"'";
     ste = con.createStatement();
          ste.executeUpdate(req);
            System.out.println("etat de reclamation Modifié avec succés");
    }
        
  
    }

