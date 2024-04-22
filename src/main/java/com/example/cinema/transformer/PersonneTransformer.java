package com.example.cinema.transformer;

import com.example.cinema.dto.PersonneDTO;
import com.example.cinema.entity.Personne;
import org.springframework.stereotype.Component;

@Component
public class PersonneTransformer {

    public PersonneDTO toDto(Personne personne) {
        PersonneDTO dto = new PersonneDTO();
        dto.setId(personne.getId());
        dto.setNom(personne.getNom());
        dto.setPrenom(personne.getPrenom());
        dto.setPhoto(personne.getPhoto());
        dto.setDateNaissance(personne.getDateNaissance());
        dto.setTypePersonne(personne.getTypePersonne());
        dto.setAddedDate(personne.getAddedDate());
        dto.setNationalite(personne.getNationalite());

        dto.setFilms(personne.getFilms());
        dto.setFilmsRealises(personne.getFilmsRealises());
        return dto;
    }

    public Personne toEntity(PersonneDTO dto) {
        Personne personne = new Personne();
        personne.setId(dto.getId());
        personne.setNom(dto.getNom());
        personne.setPrenom(dto.getPrenom());
        personne.setPhoto(dto.getPhoto());
        personne.setDateNaissance(dto.getDateNaissance());
        personne.setTypePersonne(dto.getTypePersonne());
        personne.setAddedDate(dto.getAddedDate());
        personne.setNationalite(dto.getNationalite());
        personne.setFilms(dto.getFilms());
        personne.setFilmsRealises(dto.getFilmsRealises());
        return personne;
    }
}

