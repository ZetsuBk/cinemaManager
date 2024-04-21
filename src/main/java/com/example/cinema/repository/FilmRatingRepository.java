package com.example.cinema.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.dto.FilmRating;
import com.example.cinema.dto.FilmRatingPk;

import java.util.List;
import java.util.Optional;



@CrossOrigin("http://localhost:4200")
@Repository

public interface FilmRatingRepository extends CrudRepository<FilmRating, FilmRatingPk> {

    List<FilmRating> findByPkFilmId(Long filmId);

    Optional<FilmRating> findByPkFilmIdAndPkCustomerId(Long tourId, Long customerId);
}
