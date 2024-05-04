package com.example.cinema.restcontroller;
import com.example.cinema.entity.Film;
import com.example.cinema.entity.FilmRating;
import com.example.cinema.entity.Personne;
import com.example.cinema.entity.Seance;
import com.example.cinema.repository.FilmRatingRepository;
import com.example.cinema.repository.NationaliteRepository;
import com.example.cinema.service.FilmRatingService;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.PersonneService;
import com.example.cinema.service.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api2/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
    @Autowired
    private FilmService filmService;
    @Autowired
    NationaliteRepository nationaliteRepository;
    @Autowired
    SeanceService seanceService;
    @Autowired
    private final FilmRatingService filmRatingService;
    @Autowired
    private final FilmRatingRepository filmRatingRepository;
    @Autowired
    PersonneService personneService;

    public UserController(FilmRatingService filmRatingService, FilmRatingRepository filmRatingRepository) {
        this.filmRatingService = filmRatingService;
        this.filmRatingRepository = filmRatingRepository;
    }

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


    @GetMapping("/getPerson/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        Optional<Personne> personne = personneService.getPersonneById(id);
        return personne.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/allFilmRating")
    public ResponseEntity<List<FilmRating>> getAllFilmRatings() {
        List<FilmRating> filmRatings = filmRatingService.getAllFilmRatings();
        return ResponseEntity.ok(filmRatings);
    }

    @GetMapping("/getFilmRating/{id}")
    public ResponseEntity<FilmRating> getFilmRatingById(@PathVariable Long id) {
        Optional<FilmRating> filmRating = filmRatingService.getFilmRatingById(id);
        return filmRating.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/addFilmRating/{userId}")
    public ResponseEntity<FilmRating> createFilmRating(@RequestBody FilmRating filmRating,
                                                       @PathVariable("userId") Long userId) {
        FilmRating createdFilmRating = filmRatingService.createFilmRating(filmRating, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFilmRating);
    }
    @GetMapping("getFilmRatingByFilmId/{filmId}")
    public ResponseEntity<List<FilmRating>> getFilmRatingsByFilmId(@PathVariable Long filmId) {
        List<FilmRating> filmRatings = filmRatingService.getFilmRatingsByFilmId(filmId);
        return ResponseEntity.ok(filmRatings);
    }
    @GetMapping(path = "/average/{filmId}")
    public Map<String, Double> getAverage(@PathVariable(value = "filmId") Long filmId) {
        List<FilmRating> filmRatings = filmRatingRepository.findByFilmId(filmId);
        if(filmRatings.size() >0 ){
            double averageScore = calculateAverageScore(filmRatings);
            return Map.of("average", averageScore);
        }
        return Map.of("average", 0.0d);
       
    }
    private double calculateAverageScore(List<FilmRating> filmRatings) {
        if (filmRatings.isEmpty()) {
            throw new NoSuchElementException("Film has no ratings");
        }
        int totalScore = 0;
        for (FilmRating filmRating : filmRatings) {
            totalScore += filmRating.getScore();
        }
        return (double) totalScore / filmRatings.size();
    }
}
