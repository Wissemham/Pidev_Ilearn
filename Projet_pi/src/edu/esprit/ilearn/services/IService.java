/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.esprit.ilearn.services;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MSI
 * @param <T>
 */
public interface IService<T> {
    void ajouterUtilisateur(T t) throws SQLException;
    void updateUtilisateur(T t) throws SQLException;
    void deleteUtilisateur(int t) throws SQLException;
    List<T> readAllUtilisateur() throws SQLException;
    Boolean rechercherUtilisateur(String nom ,String pwd) throws SQLException;
    String authen(String nom,String pwd) throws SQLException;
    List<T> trier() throws SQLException;
    int verifierutilisateur(String name,String email) throws SQLException;
    void updatepwd(int id,String pwd) throws SQLException;
    
}
