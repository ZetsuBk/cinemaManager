package com.example.cinema.module;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int anne;
    private int duree;
    private String titre;

    @OneToOne(cascade = CascadeType.ALL)
    private Genre genre;

    @OneToOne(cascade = CascadeType.ALL)
    private Nationalite nationalite;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_Artiste_director_ID")
    private Artiste director;

    public long getId() {
        return id;
    }
    public void setId(long iD) {
        id = iD;
    }
    public int getAnne() {
        return anne;
    }
    public void setAnne(int anne) {
        this.anne = anne;
    }
    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }
    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }

}   
