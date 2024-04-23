package com.example.cinema.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.cinema.entity.Seance;
import com.example.cinema.repository.SeanceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SeanceService {
    
    @Autowired
    private SeanceRepository repo;

    public List<Seance> getAll() {
        return repo.findAll();
    }

    
    public Optional<Seance> getById(Long id) {
        return repo.findById(id);
    }

   
    public Seance save(Seance obj) {
        return repo.save(obj);
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public Page<Seance> allByPage(Long pageNo){
        PageRequest pageable = PageRequest.of(Math.toIntExact(pageNo), 9);
        return repo.findAll(pageable);
    }

    

}
