package com.example.cinema.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.entity.FilmRating;

import java.util.List;


@CrossOrigin("http://localhost:4200")
@Repository

public interface FilmRatingRepository extends CrudRepository<FilmRating,Long > {

    List<FilmRating> findByFilmId(Long filmId);
}
