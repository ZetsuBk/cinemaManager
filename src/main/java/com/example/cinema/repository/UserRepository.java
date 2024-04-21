package com.example.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.entity.User;

import java.util.Optional;


public interface  UserRepository extends JpaRepository<User,Long>{

    Optional<User> findByEmail(String email);

    boolean existsUserByEmail(String email);
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
}