package com.example.cinema.restcontroller;

import com.example.cinema.entity.Film;
import com.example.cinema.entity.Nationalite;
import com.example.cinema.repository.NationaliteRepository;
import com.example.cinema.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private FilmService filmService;
    @Autowired
    NationaliteRepository nationaliteRepository;



    @GetMapping("/search")
    public List<Film> searchFilms(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "nationalite", required = false) String nationalite,
            @RequestParam(value = "genre", required = false) String genre) {

        return filmService.search(keyword, nationalite, genre);
    }
}
