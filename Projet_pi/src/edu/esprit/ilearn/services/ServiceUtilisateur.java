/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.services;
import edu.esprit.ilearn.entities.Utilisateur;
import edu.esprit.ilearn.utils.MyDb;
import java.sql.SQLException;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;
import edu.esprit.ilearn.entities.Role; 
import edu.esprit.ilearn.utils.encrypt_decrypt;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author MSI
 */
public class ServiceUtilisateur implements IService<Utilisateur>{
    private Connection con;
    private Statement ste;
    
    

    public ServiceUtilisateur() {
        con = MyDb.getInstance().getConnection();
        
        
    }
//    private static final String ALGORITHM = "AES";
//    private static final byte[] keyValue = "1234567891234567".getBytes();
// 
//    private static Key generateKey() throws Exception {
//        Key key = new SecretKeySpec(keyValue, ALGORITHM);
//        return key;
//    }
    
    /**
     *
     * @param t
     * @throws SQLException
     */
    @Override
    public void ajouterUtilisateur(Utilisateur t) throws SQLException {
//        Key key = generateKey();
//        String p = encrypt_decrypt.decrypt(t.getUserpwd(), key);
        ste = con.createStatement();
        String req="INSERT INTO `ilearn`.`user` (`nom`,`username`,`userpwd`,`daten`,`email`,`role`) VALUES('"+t.getNom()+"','"+t.getUsername()+"','"+t.getUserpwd()+"','"+t.getDaten()+"','"+t.getEmail()+"','"+t.getRole()+"')";
        ste.executeUpdate(req);
    }
    /*
    public void ajouter2(Utilisateur t) throws SQLException{
        PreparedStatement pre = com.preparedStatement("INSERT INTO `i-learn`,`utilisateur` (`nom`,...) VALUES(?,?,?...);");
        //pre.setString(1,t.getnom);....
        pre.executeUpdate
    }
*/
    
    @Override
    public void updateUtilisateur(Utilisateur t) throws SQLException {
        String req2 = "update user set nom = '"+t.getNom()+"',username = '"+t.getUsername()+"',userpwd = '"+t.getUserpwd()+"',daten = '"+t.getDaten()+"',email = '"+t.getEmail()+"' where `ilearn`.`user`.`iduser` = '"+t.getIduser()+"'" ;
        Statement sta;
        sta = con.createStatement();
        sta.executeUpdate(req2);
    }

    @Override
    public void deleteUtilisateur(int id) throws SQLException {
        Statement st;
        String req1 = "delete from user where `iduser` = '"+id+"'";
            st = con.createStatement();
            st.executeUpdate(req1);
           
        
        
    }

    @Override
    public List<Utilisateur> readAllUtilisateur() throws SQLException {
        List<Utilisateur> arr = new ArrayList<>();
        String req ="select * from user";
        ste = con.createStatement();
        ResultSet r = ste.executeQuery(req);
        while(r.next()){
            int iduser = r.getInt(1);
            String nom = r.getString("nom");
            String username = r.getString("username") ;
            String userpwd = r.getString(4);
            LocalDate daten = r.getDate(5).toLocalDate();
            String email = r.getString(6);
            
//            System.out.println(Role.valueOf(r.getString("role")));
           Utilisateur u = new Utilisateur(iduser,nom, username, userpwd, daten, email,Role.valueOf(r.getString("role")));
           
            
           arr.add(u);
        }
        
        return arr;
        
        
    }

    @Override
    public Boolean rechercherUtilisateur(String nom, String pwd) throws SQLException {
           String req="select `username` as nom , `userpwd` as pwd from user where `username`='"+nom+"' and `userpwd`='"+pwd+"'";
           ste = con.createStatement();
           ResultSet r = ste.executeQuery(req);
           String name="";
           String pass="";
           while(r.next()){
            name =r.getString("nom");
            pass =r.getString("pwd");
        }
           if(!name.equals("") && !pass.equals(""))
               return true;
           return false;
    }

    @Override
    public String authen(String nom, String pwd) throws SQLException {
        String role ="";
        String req ="select `role` as `rol` from user where `username`='"+nom+"' and `userpwd`='"+pwd+"'";
        ste = con.createStatement();
        ResultSet r = ste.executeQuery(req);
        while(r.next()){
            return r.getString("rol");
        
        }
        return role;
    }

    @Override
    public List<Utilisateur> trier() throws SQLException {
               List<Utilisateur> arr = new ArrayList<>();
        String req ="select * from user order by role";
        ste = con.createStatement();
        ResultSet r = ste.executeQuery(req);
        while(r.next()){
            int iduser = r.getInt(1);
            String nom = r.getString("nom");
            String username = r.getString("username") ;
            String userpwd = r.getString(4);
            LocalDate daten = r.getDate(5).toLocalDate();
            String email = r.getString(6);
            
//            System.out.println(Role.valueOf(r.getString("role")));
           Utilisateur u = new Utilisateur(iduser,nom, username, userpwd, daten, email,Role.valueOf(r.getString("role")));
           
            
           arr.add(u);
        }
        
        return arr; 

    }

    @Override
    public int verifierutilisateur(String name, String email) throws SQLException {
        String req ="select iduser as `id` from `user` where `username`='"+name+"' and `email`='"+email+"' ";
        ste = con.createStatement();
        ResultSet r = ste.executeQuery(req);
        while(r.next()){
          return r.getInt("id");  
        }
        return 0;
        
    }

    @Override
    public void updatepwd(int id, String pwd) throws SQLException {
        String req2 = "update user set userpwd='"+pwd+"' where iduser='"+id+"'";
        Statement sta;
        sta = con.createStatement();
        sta.executeUpdate(req2);
        
    }
    
}
