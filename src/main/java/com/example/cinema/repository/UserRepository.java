package com.example.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cinema.entity.User;



public interface  UserRepository extends JpaRepository<User,Long>{

}