package com.example.cinema.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cinema.entity.Personne;

import java.sql.Date;



@CrossOrigin("http://localhost:4200")
@Repository
public interface PersonneRepository extends JpaRepository<Personne, Long> {
	Page<Personne> findByTypePersonne(@RequestParam("typePersonne") Personne.TypePersonne typePersonne, Pageable pageable);
	Page<Personne> findByDateNaissanceGreaterThanEqual(@RequestParam("dateNs") Date dateNs, Pageable pageable);
	Page<Personne> findByNomContainingOrPrenomContaining(@RequestParam("nom") String nom,@RequestParam("prenom") String prenom, Pageable pageable);
}
