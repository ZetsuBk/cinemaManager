package com.example.cinema.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cinema.entity.Nationalite;

import java.util.Optional;


@CrossOrigin("http://localhost:4200")
@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite, Long> {
	Page<Nationalite> findByLibelleStartsWith(@RequestParam("libelle") String libelle, Pageable pageable);

	Nationalite findBylibelle(String libelle);
}
