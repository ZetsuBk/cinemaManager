package com.example.cinema.repository;


import com.example.cinema.entity.Nationalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// <<<<<<< HEAD
// =======
import org.springframework.data.repository.query.Param;
// >>>>>>> origin/JwtSecurity
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.entity.Film;
import com.example.cinema.entity.Personne;

import java.util.List;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
// <<<<<<< HEAD

    @Query("SELECT p FROM Personne p WHERE p NOT IN (SELECT a FROM Film f JOIN f.acteurs a WHERE f = ?1)")
    List<Personne> findActorsNotInFilm(Film film);
// =======
    @Query("SELECT f FROM Film f JOIN f.nationalite n JOIN f.genre g WHERE f.titre LIKE %:keyword% AND (:nationalite IS NULL OR n.libelle = :nationalite) AND (:genre IS NULL OR g.name = :genre)")
    List<Film> findByTitleContainingAndOptionalParameters(
            @Param("keyword") String keyword,
            @Param("nationalite") String nationalite,
            @Param("genre") String genre);
    Optional<Film> findById(Long id);
// >>>>>>> origin/JwtSecurity
}

