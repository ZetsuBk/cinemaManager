package com.example.cinema.dto;

import java.util.Objects;

public class FilmRatingDTO {

    private Long id;
    private Integer score;
    private String comment;
    private Long filmId; // Assuming filmId is needed in DTO instead of Film object
    private Integer userId;

    public FilmRatingDTO() {
    }

    public FilmRatingDTO(Long id, Integer score, String comment, Long filmId, Integer userId) {
        this.id = id;
        this.score = score;
        this.comment = comment;
        this.filmId = filmId;
        this.userId = userId;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    // Override equals and hashCode methods if necessary

    @Override
    public boolean equals(Object o) {
        if (this == o){return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        FilmRatingDTO that = (FilmRatingDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment) &&
                Objects.equals(filmId, that.filmId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, score, comment, filmId, userId);
    }
}
