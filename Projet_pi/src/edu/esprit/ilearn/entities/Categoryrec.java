/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.entities;

/**
 *
 * @author DELL
 */
public class Categoryrec {
    private int idcategory;
    private Enum category ;

    public Categoryrec() {
    }

    public Categoryrec(int idcategory, Enum category) {
        this.idcategory = idcategory;
        this.category = category;
    }

    public Categoryrec(int idcategory) {
        this.idcategory = idcategory;
    }
    

    public Categoryrec(Enum Category) {
        this.category = Category;
    }

    public int getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(int idcategory) {
        this.idcategory = idcategory;
    }

    public Enum getCategory() {
        return category;
    }

    public void setCategory(Enum Category) {
        this.category = Category;
    }

    @Override
    public String toString() {
        return "Categoryrec{" + "idcategory=" + idcategory + ", Category=" + category + '}';
    }
    
    
}    


