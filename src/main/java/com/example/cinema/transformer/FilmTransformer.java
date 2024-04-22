package com.example.cinema.transformer;

import com.example.cinema.dto.FilmDTO;
import com.example.cinema.entity.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmTransformer {

    public FilmDTO toDto(Film film) {
        FilmDTO dto = new FilmDTO();
        dto.setId(film.getId());
        dto.setTitre(film.getTitre());
        dto.setDuree(film.getDuree());
        dto.setAnnee(film.getAnnee());
        dto.setGenre(film.getGenre());
        dto.setNationalite(film.getNationalite());
        dto.setRealisateur(film.getRealisateur());
        dto.setActeurs(film.getActeurs());

        dto.setSeances(film.getSeances());
        dto.setMedias(film.getMedias());
        dto.setAddedDate(film.getAddedDate());
        return dto;
    }

    public Film toEntity(FilmDTO dto) {
        Film film = new Film();
        film.setId(dto.getId());
        film.setTitre(dto.getTitre());
        film.setDuree(dto.getDuree());
        film.setAnnee(dto.getAnnee());
        film.setGenre(dto.getGenre());
        film.setNationalite(dto.getNationalite());
        film.setRealisateur(dto.getRealisateur());
        film.setActeurs(dto.getActeurs());
        film.setSeances(dto.getSeances());
        film.setMedias(dto.getMedias());
        film.setAddedDate(dto.getAddedDate());
        return film;
    }
}
