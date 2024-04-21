package com.example.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cinema.entity.Customers;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {

}
