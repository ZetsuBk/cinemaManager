package com.example.cinema.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Personne;
import com.example.cinema.repository.PersonneRepository;

@Service
public class PersoneService {
    
    @Autowired
    private PersonneRepository repo;

    // Get all users
    public List<Personne> getAll() {
        return repo.findAll();
    }

    // Get user by ID
    public Optional<Personne> getById(Long id) {
        return repo.findById(id);
    }

    // Add or update a user
    public Personne save(Personne obj) {
        return repo.save(obj);
    }

    // Delete user by ID
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Page<Personne> allByPage(Long pageNo){
        PageRequest pageable = PageRequest.of(Math.toIntExact(pageNo), 9);
        return repo.findAll(pageable);
    }
}
