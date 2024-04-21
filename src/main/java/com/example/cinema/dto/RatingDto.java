package com.example.cinema.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.antlr.v4.runtime.misc.NotNull;

public class RatingDto {
    @Min(0)
    @Max(5)
    private Integer score;

    private String comment;

    @NotNull
    private Integer customerId;

    public RatingDto(FilmRating filmRating) {
        this(filmRating.getScore(), filmRating.getComment(), filmRating.getPk().getCustomerId());
    }

    private RatingDto(Integer score, String comment, Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    protected RatingDto() {
    }

    public Integer getScore() {
        return score;
    }

    public String getComment() {
        return comment;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
