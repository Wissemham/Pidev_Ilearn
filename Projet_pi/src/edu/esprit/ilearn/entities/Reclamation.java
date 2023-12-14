/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.entities;

//import java.time.LocalDateTime;
import java.util.Date;


/**
 *
 * @author DELL
 */
public class Reclamation  {
   private int idreclamation;
    private Utilisateur utilisateur;
   
    private Categoryrec categoryrec; 
    private Date datereclamation;
    private String contenu;
    private String etatreclamation;
    public Reclamation() {
    }

    public Reclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public Reclamation(int idreclamation, Utilisateur utilisateur, Categoryrec categoryrec, Date datereclamation, String contenu, String etatreclamation) {
        this.idreclamation = idreclamation;
        this.utilisateur = utilisateur;
        this.categoryrec = categoryrec;
        this.datereclamation = datereclamation;
        this.contenu = contenu;
        this.etatreclamation = etatreclamation;
    }

    public Reclamation(int idreclamation, Utilisateur utilisateur, Categoryrec categoryrec, Date datereclamation, String contenu) {
        this.idreclamation = idreclamation;
        this.utilisateur = utilisateur;
        this.categoryrec = categoryrec;
        this.datereclamation = datereclamation;
        this.contenu = contenu;
    }

    public Reclamation(int idreclamation, Utilisateur utilisateur, Date datereclamation, String contenu) {
        this.idreclamation = idreclamation;
        this.utilisateur = utilisateur;
        this.datereclamation = datereclamation;
        this.contenu = contenu;
    }

    public Reclamation(int idreclamation, Utilisateur utilisateur, Categoryrec categoryrec, String contenu) {
        this.idreclamation = idreclamation;
        this.utilisateur = utilisateur;
        this.categoryrec = categoryrec;
        this.contenu = contenu;
    }

    public Reclamation(int idreclamation, String etatreclamation) {
        this.idreclamation = idreclamation;
        this.etatreclamation = etatreclamation;
    }

   

   

   

    /*public Reclamation(int idreclamation, String contenu) {
        this.idreclamation = idreclamation;
        this.contenu = contenu;
    }*/

   

    public Reclamation(Utilisateur utilisateur, String contenu) {
        this.utilisateur = utilisateur;
        this.contenu = contenu;
    }

    public Reclamation(Utilisateur utilisateur, String contenu, String etatreclamation) {
        this.utilisateur = utilisateur;
        this.contenu = contenu;
        this.etatreclamation = etatreclamation;
    }

    public Reclamation(Utilisateur utilisateur, Categoryrec categoryrec, Date datereclamation, String contenu) {
        this.utilisateur = utilisateur;
        this.categoryrec = categoryrec;
        this.datereclamation = datereclamation;
        this.contenu = contenu;
    }

    
    



    public Reclamation(int idreclamation, Date datereclamation, String etatreclamation) {
        this.idreclamation = idreclamation;
        this.datereclamation = datereclamation;
        this.etatreclamation = etatreclamation;
    }

    public Reclamation(Utilisateur utilisateur, Categoryrec categoryrec, String contenu) {
        this.utilisateur = utilisateur;
        this.categoryrec = categoryrec;
        this.contenu = contenu;
    }

   
    public int getIdreclamation() {
        return idreclamation;
    }
    public void setIdreclamation(int idreclamation) {
        this.idreclamation = idreclamation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    

    public Categoryrec getCategoryrec() {
        return categoryrec;
    }

    public void setCategoryrec(Categoryrec categoryrec) {
        this.categoryrec = categoryrec;
    }
    public Date getDatereclamation() {
        return datereclamation;
    }

    public void setDatereclamation(Date datereclamation) {
        this.datereclamation = datereclamation;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getEtatreclamation() {
        return etatreclamation;
    }

    public void setEtatreclamation(String etatreclamation) {
        this.etatreclamation = etatreclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "idreclamation=" + idreclamation + ", utilisateur=" + utilisateur + ", categoryrec=" + categoryrec + ", datereclamation=" + datereclamation + ", contenu=" + contenu + ", etatreclamation=" + etatreclamation + '}';
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idreclamation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        return this.idreclamation == other.idreclamation;
    }
}
