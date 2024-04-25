package com.example.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Nationalite;
import com.example.cinema.repository.NationaliteRepository;

@Service
public class NationaliteService {
    
    @Autowired
    private NationaliteRepository repo;

    // Get all users
    public List<Nationalite> getAll() {
        return repo.findAll();
    }

    // Get user by ID
    public Optional<Nationalite> getById(Long id) {
        return repo.findById(id);
    }

    // Add or update a user
    public Nationalite save(Nationalite obj) {
        return repo.save(obj);
    }

    // Delete user by ID
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

}