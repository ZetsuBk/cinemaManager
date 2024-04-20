package com.example.cinema.module;


import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Artiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateNaissance;
    private String nom;
    private String prenom;
    private String type;
    @OneToOne(cascade = CascadeType.ALL)
    private Nationalite nationalite;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {

        
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Nationalite getNationalite() {
        return nationalite;
    }
    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    };
}
