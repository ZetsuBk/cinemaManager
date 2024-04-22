package com.example.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Film;
import com.example.cinema.repository.FilmRepository;

@Service
public class FilmeService {
    
    @Autowired
    private FilmRepository repo;

    public List<Film> getAll() {
        return repo.findAll();
    }

    
    public Optional<Film> getById(Long id) {
        return repo.findById(id);
    }

   
    public Film save(Film obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Page<Film> allByPage(Long pageNo){
        PageRequest pageable = PageRequest.of(Math.toIntExact(pageNo), 9);
        return repo.findAll(pageable);
    }

}
