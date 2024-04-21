package com.example.cinema.dto;



import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.example.cinema.entity.Nationalite;
import com.example.cinema.entity.Personne;





@Projection(name = "inlinePersonne", types = { Personne.class })
public interface InlinePersonne {
    Long getId();
    String getNom();
    String getPrenom();
    String getPhoto();
    Date getDateNaissance();
    Personne.TypePersonne getTypePersonne();
    Date getAddedDate();
    Nationalite getNationalite();
}