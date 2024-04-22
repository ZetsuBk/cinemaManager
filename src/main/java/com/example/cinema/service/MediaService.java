package com.example.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Media;
import com.example.cinema.repository.MediaRepository;

@Service
public class MediaService {
    
    @Autowired
    private MediaRepository repo ; 

    public List<Media> getAll() {
        return repo.findAll();
    }

    
    public Optional<Media> getById(Long id) {
        return repo.findById(id);
    }

   
    public Media save(Media obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    

}
