package com.example.cinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.cinema.entity.Media;


@CrossOrigin("http://localhost:4200")
@Repository
public interface MediaRepository extends JpaRepository<Media, Long> {

}
