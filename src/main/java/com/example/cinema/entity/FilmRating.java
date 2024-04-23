package com.example.cinema.entity;


import java.util.Objects;

import com.example.cinema.entity.Film;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;

@Getter
@Entity
public class FilmRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Min(0)
    @Max(5)
    private Integer score;
    @Column
    private String comment;
    @ManyToOne
    @JsonIgnore
    private Film film;
    @ManyToOne
    private User user;
    public FilmRating( Integer score, String comment,Film film) {
        this.score = score;
        this.comment = comment;
        this.film=film;
    }

    protected FilmRating() {
    }


    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
