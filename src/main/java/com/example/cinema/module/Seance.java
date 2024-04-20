package com.example.cinema.module;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date_projection;
    private Time heure_debut;
    private Time heure_fin;

    @OneToOne(cascade = CascadeType.ALL)
    private Salle salle;

    @OneToOne(cascade = CascadeType.ALL)
    private Film film;

    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }
    public Salle getSalle() {
        return salle;
    }
    public void setSalle(Salle salle) {
        this.salle = salle;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getDate_projection() {
        return date_projection;
    }
    public void setDate_projection(Date date_projection) {
        this.date_projection = date_projection;
    }
    public Time getHeure_debut() {
        return heure_debut;
    }
    public void setHeure_debut(Time heure_debut) {
        this.heure_debut = heure_debut;
    }
    public Time getHeure_fin() {
        return heure_fin;
    }
    public void setHeure_fin(Time heure_fin) {
        this.heure_fin = heure_fin;
    }
    

}
