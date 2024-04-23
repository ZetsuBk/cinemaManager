package com.example.cinema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Salle;
import com.example.cinema.repository.SalleRepository;

@Service
public class SalleService {
    
    @Autowired
    private SalleRepository repo;

    public List<Salle> getAll() {
        return repo.findAll();
    }
}
