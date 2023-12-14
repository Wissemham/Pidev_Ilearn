/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.esprit.ilearn.services;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author DELL
 * @param <Reclamation>
 
 */
public interface InterfaceReclamation <Reclamation> {
    void ajoutereclamation(Reclamation t) throws SQLException;
    void updatereclamation (Reclamation t) throws SQLException;
    void deletereclamation (int idreclamation) throws SQLException;
    List <Reclamation> readAll() throws SQLException;
    public List<Reclamation> getAll(int iduser) throws SQLException;
     public List<Reclamation> getAllReclamation() throws SQLException;
    public int maxidcategory() throws SQLException;
    void  addetat() throws SQLException;
    void updateetatreclamation (Reclamation t) throws SQLException;
}
