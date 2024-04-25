package com.example.cinema.service;

import com.example.cinema.entity.Personne;
import com.example.cinema.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    private PersonneRepository personneRepository;

    public Optional<Personne> getPersonneById(Long id) {
        return personneRepository.findById(id);
    }
}
