/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.services;

import edu.esprit.ilearn.entities.Etat;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 * @param <Commande>

 */
public interface ICommande<Commande> {
    void ajouter(Commande c) throws  SQLException;
    void update(Commande c) throws SQLException;
    void delete (int IdCommande) throws SQLException;
    List<Commande> readALL() throws SQLException;
    public void update(int idcommand,int total) throws SQLException ;
     //public Boolean rechercherCommande(int idcommand) throws SQLException ;
}
