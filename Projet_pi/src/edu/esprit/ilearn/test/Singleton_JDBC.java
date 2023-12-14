/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.test;

<<<<<<< HEAD
import edu.esprit.ilearn.entities.Category;
import edu.esprit.ilearn.entities.Categoryrec;
import edu.esprit.ilearn.entities.Reclamation;
import edu.esprit.ilearn.services.ServiceCategoryrec;
import edu.esprit.ilearn.services.ServiceReclamation;
import edu.esprit.ilearn.utils.MyDB;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author DELL
 */
public class Singleton_JDBC {
    public static void main(String[] args){
        MyDB db =MyDB.getInstance();
        LocalDate date=LocalDate.now();
        System.out.println(""+date);
        ServiceReclamation serv= new ServiceReclamation();
        ServiceCategoryrec ca=new ServiceCategoryrec();
        Category cat=Category.autre;
        Categoryrec c1=new Categoryrec(cat);
         Category cat1=Category.feeeedback;
        Categoryrec c2=new Categoryrec(cat1);
      Category cat3=Category.feeeedback;
        Categoryrec c3=new Categoryrec(3,cat3);  
       //Reclamation r1 =new Reclamation(1,"rec1");
       //Reclamation r2 =new Reclamation(1,2,"rec2");
        Reclamation r3 =new Reclamation(5,1,2,"rec3");
        try {
            
           //serv.ajoutereclamation(r1);
           // serv.ajoutereclamation(r2);
           //serv.deletereclamation(6);
          // serv.updatereclamation(r3);
         //ca.ajoutercategory(c1);
          //ca.ajoutercategory(c2);
          //ca.deletecategory(4);
          //ca.updatecategory(c3);
         // List<Categoryrec>list=ca.readAllcat();
         // System.out.println(list);
          
           List<Reclamation>list =serv.readAll();
           System.out.println(list);
          // List<Reclamation>list1=serv.rechercheReclamationParUser(1);
           //System.out.println(list1);
        } catch (SQLException ex){
            System.out.println(ex);
            
        }
=======
import edu.esprit.ilearn.entities.Commande;
import edu.esprit.ilearn.entities.Etat;
import edu.esprit.ilearn.entities.LigneCommande;
import edu.esprit.ilearn.services.ServiceCommande;
import edu.esprit.ilearn.services.ServiceLigneCommande;
import edu.esprit.ilearn.utils.MyDB;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class Singleton_JDBC {
     public static void main(String[] args) throws SQLException {
        MyDB db =new MyDB();
        
        Etat et =Etat.passé;
         ServiceCommande serv = new ServiceCommande();
        // Commande c =new Commande(14,52,et);
       // LigneCommande p = new LigneCommande(1,1);
        int d;
       
      
         try{
            //serv.ajouter(c);
          //  serv.update(c);
             List<Commande> list = serv.readALL();
          // d = serv.Total(1);
            System.out.println(list); 
         }catch(SQLException ex){
             System.out.println("ex "+ex.getMessage());
         }
        
>>>>>>> 630c771093ec8cf466c8582a75b1c6e3c3ceb7f0
    }
}
