package com.example.cinema.service;

import com.example.cinema.entity.Film;
import com.example.cinema.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;

    public List<Film> search(String keyword, String nationalite, String genre) {
        return filmRepository.findByTitleContainingAndOptionalParameters(keyword, nationalite, genre);
    }

}
