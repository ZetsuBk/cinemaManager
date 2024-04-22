package com.example.cinema.repository;


import com.example.cinema.entity.Nationalite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.entity.Film;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    @Query("SELECT f FROM Film f JOIN f.nationalite n WHERE f.titre LIKE %:keyword% AND (:nationalite IS NULL OR n.libelle = :nationalite) AND (:genre IS NULL OR f.genre = :genre)")
    List<Film> findByTitleContainingAndOptionalParameters(@Param("keyword") String keyword, @Param("nationalite") String nationalite, @Param("genre") String genre);

}

