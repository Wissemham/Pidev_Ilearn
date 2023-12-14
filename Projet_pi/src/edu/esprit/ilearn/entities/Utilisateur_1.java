/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.esprit.ilearn.entities;

import java.time.LocalDate;
//import java.util.Date;

/**
 *
 * @author MSI
 */
public class Utilisateur_1 {
    private int iduser;
    private String nom;
    private String username;
    private String userpwd;
    private LocalDate daten;
    private String email;
    private Enum role;

    public Utilisateur_1() {
    }

    public Utilisateur_1(int iduser, String nom, String username, String userpwd, LocalDate daten, String email, Enum role) {
        this.iduser = iduser;
        this.nom = nom;
        this.username = username;
        this.userpwd = userpwd;
        this.daten = daten;
        this.email = email;
        this.role = role;
    }

    public Utilisateur_1(String nom, String username, String userpwd, LocalDate daten, String email,Enum role) {
        this.nom = nom;
        this.username = username;
        this.userpwd = userpwd;
        this.daten = daten;
        this.email = email;
        this.role = role;
    }

    public Utilisateur_1(int iduser, String nom, String username, String userpwd, LocalDate daten, String email) {
        this.iduser = iduser;
        this.nom = nom;
        this.username = username;
        this.userpwd = userpwd;
        this.daten = daten;
        this.email = email;
    }

    public Utilisateur_1(int iduser) {
        this.iduser = iduser;
    }

    

  
  
    

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
/*
    public Date getDaten() {
        return daten;
    }

    public void setDaten(Date daten) {
        this.daten = daten;
    }

   */

    public LocalDate getDaten() {
        return daten;
    }

    public void setDaten(LocalDate daten) {
        this.daten = daten;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "iduser=" + iduser + ", nom=" + nom + ", username=" + username + ", userpwd=" + userpwd + ", daten=" + daten + ", email=" + email + ", role=" + role + '}';
    }

    
    
}