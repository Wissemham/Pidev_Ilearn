/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.services;

import edu.esprit.ilearn.entities.LigneCommande;
import edu.esprit.ilearn.utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceLigneCommande implements ICommande_Elem<LigneCommande> {

    private Connection con;
    private Statement ste;

    public ServiceLigneCommande() {
        con = MyDB.getInstance().getConnection();
    }

    @Override
    public int getprix(int id) throws SQLException {
        int pr = 0;

        String req = "SELECT `prix` AS `ptotal` FROM `formation` WHERE idformation = " + id + "";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()) {
            pr = rs.getInt("ptotal");
        }
        return pr;
    }

    @Override
    public void ajouterl(LigneCommande lc) throws SQLException {
        int pri = getprix(lc.getIdformation());
        ste = con.createStatement();
        String req = "INSERT INTO `ilearn`.`lignecommande` (`idcommand`,`idformation`,`prix`) VALUES('" + lc.getIdcommande() + "'," + lc.getIdformation() + "," + pri + ")";
        // String req="INSERT INTO `ilearn`.`lignecommande`(`idcommand`) SELECT `idcommand` from `ilearn`.`command`    ";
        ste.executeUpdate(req);
        System.out.println("Elem Commande Ajouté avec succés");
    }

    @Override
    public void update(int idlignecommand, int prix) throws SQLException {
        String req2 = "update `ilearn`.`lignecommande` set prix = '" + prix + "' where `ilearn`.`lignecommande`.`idlignecommand` = '" + idlignecommand + "'";
        Statement sta;
        sta = con.createStatement();
        sta.executeUpdate(req2);
        System.out.println("Elem Commande modifier avec succés");
    }

    @Override
    public void delete(int idlignecommand) throws SQLException {
        ste = con.createStatement();
        String request = "DELETE FROM `ilearn`.`lignecommande` WHERE idlignecommand =" + idlignecommand + "";

        ste.executeUpdate(request);
        System.out.println("Commande Supprimé avec succés");
    }

    @Override
    public List<LigneCommande> readALL() throws SQLException {
        List<LigneCommande> arr = new ArrayList<>();

        String req = "SELECT * FROM `lignecommande` l INNER JOIN `formation` f ON l.idformation = f.idformation";

        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()) {
            int IdCc = rs.getInt("l.idlignecommand");
            int IdCl = rs.getInt("l.idcommand");
            int IdF = rs.getInt("f.idformation");
            float pri = rs.getFloat("f.prix");

            LigneCommande c = new LigneCommande(IdCc, IdCl, IdF, pri);

            arr.add(c);
        }

        return arr;

    }

    @Override
    public int Total(int id) throws SQLException {
        int total = 0;

        String req = "SELECT SUM(`prix`) AS `ptotal` FROM `lignecommande` WHERE idcommand = " + id + "";
        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()) {
            total = rs.getInt("ptotal");
        }
        return total;
    }

    @Override
    public List<LigneCommande> readById(int id) throws SQLException {
 List<LigneCommande> arr = new ArrayList<>();

        String req = "SELECT * FROM `lignecommande` WHERE idcommand = " + id + "";

        ste = con.createStatement();
        ResultSet rs = ste.executeQuery(req);

        while (rs.next()) {
            int IdCc = rs.getInt("idlignecommand");
            int IdCl = rs.getInt("idcommand");
            int IdF = rs.getInt("idformation");
            float pri = rs.getFloat("prix");

            LigneCommande c = new LigneCommande(IdCc, IdCl, IdF, pri);

            arr.add(c);
        }

        return arr;    }
     

       
}
