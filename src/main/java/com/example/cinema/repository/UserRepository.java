package com.example.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.module.User;

public interface  UserRepository extends JpaRepository<User,Long>{

}