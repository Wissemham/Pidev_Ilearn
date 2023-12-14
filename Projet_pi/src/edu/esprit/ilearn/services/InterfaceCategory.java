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
 * @param <categoryrec>
 */
public interface InterfaceCategory <categoryrec> {
    void ajoutercategory (categoryrec c) throws SQLException;
    void updatecategory (categoryrec c) throws SQLException;
    void deletecategory (int idcategory) throws SQLException;
    List <categoryrec> readAllcat() throws SQLException; 
}
