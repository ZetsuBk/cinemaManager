package com.example.cinema.service;

import com.example.cinema.entity.Seance;
import com.example.cinema.repository.SeanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class SeanceService {
  @Autowired
    private  SeanceRepository seanceRepository;

    public List<Seance> getAllSeances() {
        return seanceRepository.findAll();
    }

    public List<Seance> searchSeances(Date dateProjection, String filmTitle) {
        return seanceRepository.findByDateProjectionAndFilm_TitreContaining(dateProjection, filmTitle);
    }
}


