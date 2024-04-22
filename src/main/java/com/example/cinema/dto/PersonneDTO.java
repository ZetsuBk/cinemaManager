package com.example.cinema.dto;

import com.example.cinema.entity.Nationalite;
import com.example.cinema.entity.Film;
import com.example.cinema.entity.Personne;
import java.util.Date;
import java.util.List;

public class PersonneDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String photo;

    private Date dateNaissance;

    private Personne.TypePersonne typePersonne;

    private Date addedDate;

    private Nationalite nationalite;

    private List<Film> films;

    private List<Film> filmsRealises;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Personne.TypePersonne getTypePersonne() {
        return typePersonne;
    }

    public void setTypePersonne(Personne.TypePersonne typePersonne) {
        this.typePersonne = typePersonne;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public List<Film> getFilmsRealises() {
        return filmsRealises;
    }

    public void setFilmsRealises(List<Film> filmsRealises) {
        this.filmsRealises = filmsRealises;
    }
}
