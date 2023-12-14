/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.esprit.ilearn.services;


import edu.esprit.ilearn.entities.LigneCommande;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 * @param <LigneCommande>
 */
public interface ICommande_Elem<LigneCommande> {
    
    void ajouterl(LigneCommande lc) throws  SQLException;
    void update(int idlignecommand,int prix) throws SQLException;
    void delete (int idlignecommand) throws SQLException;
    List<LigneCommande> readALL() throws SQLException;
    List<LigneCommande> readById(int id) throws SQLException;
    public int Total(int id) throws SQLException;
    public int getprix(int id) throws SQLException;
}
