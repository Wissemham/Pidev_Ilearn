/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.services;
import edu.esprit.ilearn.entities.Categoryrec;
import edu.esprit.ilearn.utils.MyDb;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import edu.esprit.ilearn.entities.Category;
/**
 *
 * @author DELL
 */
public class ServiceCategoryrec implements InterfaceCategory <Categoryrec> {
private Connection con;
private Statement ste;

    public ServiceCategoryrec() {
        con=MyDb.getInstance().getConnection();
    }

    @Override
    public void ajoutercategory(Categoryrec c) throws SQLException {
        ste= con.createStatement(); 
        String req="INSERT INTO `ilearn`.`categoryrec`( `category`) VALUES ('"+c.getCategory()+"')";
         ste.executeUpdate(req);
         System.out.println("categorie ajouter avec succés");
    }

    @Override
    public void updatecategory(Categoryrec c) throws SQLException {
     String req ="UPDATE `ilearn`.`categoryrec` SET `category`='"+c.getCategory()+"'WHERE `ilearn`.`categoryrec`.`idcategory`='"+c.getIdcategory()+"'";
     
             ste = con.createStatement();
          ste.executeUpdate(req);
            System.out.println("reclamation Modifié avec succés");   
    }

    @Override
    public void deletecategory(int idcategory) throws SQLException {
     ste = con.createStatement();
        String req ="DELETE FROM `ilearn`.`categoryrec` WHERE `idcategory` ="+idcategory+"";    
           ste.executeUpdate(req);
            System.out.println("categorie Supprimé avec succés");
           
    }

    @Override
    public List<Categoryrec> readAllcat() throws SQLException {
        List<Categoryrec> cat= new ArrayList<>();
      ste= con.createStatement();
      ResultSet r=ste.executeQuery("SELECT * FROM `categoryrec`");
      while (r.next()){
          int idcategory=r.getInt("idcategory");
           Categoryrec re=new Categoryrec(idcategory,Category.valueOf(r.getString("category")));
      cat.add(re);
      }
      return cat;
          
      
    }
}