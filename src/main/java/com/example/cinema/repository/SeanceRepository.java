package com.example.cinema.repository;


import jakarta.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.entity.Seance;

import java.util.Date;
import java.util.List;


@CrossOrigin("http://localhost:4200")
@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
	List<Seance> findByDateProjection(@Temporal(TemporalType.DATE) Date dateProjection);
	List<Seance> findByDateProjectionAndFilm_TitreContaining(Date dateProjection, String title);

}
