package com.example.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Genre;
import com.example.cinema.repository.GenreRepository;

@Service
public class GenreService {
    
    @Autowired
    private GenreRepository repo;

    public List<Genre> getAll() {
        return repo.findAll();
    }

    
    public Optional<Genre> getById(Long id) {
        return repo.findById(id);
    }

   
    public Genre save(Genre obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }
}
