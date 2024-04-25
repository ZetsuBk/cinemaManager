package com.example.cinema.service;


import com.example.cinema.entity.FilmRating;
import com.example.cinema.entity.User;
import com.example.cinema.repository.FilmRatingRepository;
import com.example.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FilmRatingService {
    @Autowired
    private final FilmRatingRepository filmRatingRepository;
    @Autowired
    private UserRepository userRepository;

    public FilmRatingService(FilmRatingRepository filmRatingRepository) {
        this.filmRatingRepository = filmRatingRepository;
    }


    public List<FilmRating> getAllFilmRatings() {
        Iterable<FilmRating> filmRatingsIterable = filmRatingRepository.findAll();
        return StreamSupport.stream(filmRatingsIterable.spliterator(), false)
                .collect(Collectors.toList());
    }

    public Optional<FilmRating> getFilmRatingById(Long id) {
        return filmRatingRepository.findById(id);
    }
    public List<FilmRating> getFilmRatingsByFilmId(Long filmId) {
        return filmRatingRepository.findByFilmId(filmId);
    }

    public FilmRating createFilmRating(FilmRating filmRating, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        filmRating.setUser(user);
        return filmRatingRepository.save(filmRating);
    }
}

