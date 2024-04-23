package com.example.cinema.restcontroller;

import com.example.cinema.entity.Film;
import com.example.cinema.entity.Nationalite;
import com.example.cinema.entity.Personne;
import com.example.cinema.entity.Seance;
import com.example.cinema.repository.NationaliteRepository;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.PersonneService;
import com.example.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private FilmService filmService;
    @Autowired
    NationaliteRepository nationaliteRepository;
    @Autowired
    SeanceService seanceService;

    @Autowired
    PersonneService personneService;

    @GetMapping("/search/film")
    public List<Film> searchFilms(
            @RequestParam(value = "keyword", required = false) String keyword,
            @RequestParam(value = "nationalite", required = false) String nationalite,
            @RequestParam(value = "genre", required = false) String genre) {
        return filmService.search(keyword, nationalite, genre);
    }
    @GetMapping("/allSeances")
    public List<Seance> getAllSeances() {
        return seanceService.getAllSeances();
    }
    @GetMapping("/allFilms")
    public List<Film> getAllFilms() {
        return filmService.getAllFilms();
    }
    @GetMapping("/search/seance")
    public List<Seance> searchSeances(
            @RequestParam("dateProjection") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateProjection,
            @RequestParam("filmTitle") String filmTitle) {
        return seanceService.searchSeances(dateProjection, filmTitle);
    }
    @GetMapping("getFilm/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        Optional<Film> film = filmService.getFilmById(id);
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @GetMapping("getPerson/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        Optional<Personne> personne = personneService.getPersonneById(id);
        return personne.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
