package com.example.cinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.dto.InlineFilm;
import com.example.cinema.entity.Film;
import com.example.cinema.entity.Personne;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@Repository
@RepositoryRestResource(excerptProjection = InlineFilm.class)
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("SELECT p FROM Personne p WHERE p NOT IN (SELECT a FROM Film f JOIN f.acteurs a WHERE f = ?1)")
    List<Personne> findActorsNotInFilm(Film film);
}
