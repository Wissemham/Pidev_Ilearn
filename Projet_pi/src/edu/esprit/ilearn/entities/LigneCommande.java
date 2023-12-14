/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.entities;

/**
 *
 * @author ASUS
 */
public class LigneCommande {
    private int idlignecommand ;
    private int idcommande ;
    private int idformation ;
    private float prix ;

    public LigneCommande() {
    }

    public LigneCommande(int idlignecommand, int idcommande, int idformation, float prix) {
        this.idlignecommand = idlignecommand;
        this.idcommande = idcommande;
        this.idformation = idformation;
        this.prix = prix;
    }

    public LigneCommande(int idcommande, int idformation) {
        this.idcommande = idcommande;
        this.idformation = idformation;
    }

    public LigneCommande(int idcommande, int idformation, float prix) {
        this.idcommande = idcommande;
        this.idformation = idformation;
        this.prix = prix;
    }

    public int getIdlignecommand() {
        return idlignecommand;
    }

    public void setIdlignecommand(int idlignecommand) {
        this.idlignecommand = idlignecommand;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdformation() {
        return idformation;
    }

    public void setIdformation(int idformation) {
        this.idformation = idformation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "idlignecommand=" + idlignecommand + ", idcommande=" + idcommande + ", idformation=" + idformation + ", prix=" + prix + '}';
    }

    
    
}
