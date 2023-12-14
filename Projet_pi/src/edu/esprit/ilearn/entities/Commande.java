/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.entities;

import java.sql.Date;

/**
 *
 * @author ASUS
 */
public class Commande {
    private int idcommand;
    private Date datecommand;
    private int total;
    private Enum etat;

    public Commande(String id, Etat valueOf) {
    }

    public Commande(int idcommand, Date datecommand, int total, Enum etat) {
        this.idcommand = idcommand;
        this.datecommand = datecommand;
        this.total = total;
        this.etat = etat;
    }

    public Commande(int total, Enum etat) {
        this.total = total;
        this.etat = etat;
    }


      

    public Commande(Date datecommand, int total, Enum etat) {
        this.datecommand = datecommand;
        this.total = total;
        this.etat = etat;
    }

    public Commande(int idcommand, Date datecommand, int total) {
        this.idcommand = idcommand;
        this.datecommand = datecommand;
        this.total = total;
    }

  /*  public Commande(int total, Enum etat) {
        this.total = total;
        this.etat = etat;
    }*/
    
    

    public Commande(int idcommand, int total, Enum etat) {
        this.idcommand = idcommand;
        this.total = total;
        this.etat = etat;
    }

    public Commande(int total) {
        this.total = total;
    }

    public int getIdCommand() {
        return idcommand;
    }

    public void setIdCommand(int idcommand) {
        this.idcommand = idcommand;
    }

    public Date getDatecommand() {
        return datecommand;
    }

    public void setDatecommand(Date datecommand) {
        this.datecommand = datecommand;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Enum getEtat() {
        return etat;
    }

    public void setEtat(Enum etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Commande{" + "IdCommande=" + idcommand + ", datecommand=" + datecommand + ", total=" + total + ", etat=" + etat + '}';
    }

    
    
}
