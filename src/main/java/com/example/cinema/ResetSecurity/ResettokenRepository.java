package com.example.cinema.ResetSecurity;

import com.example.cinema.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository

public interface ResettokenRepository extends JpaRepository<Resettoken, Long> {
    Optional<Resettoken> findByToken(String token);
    void deleteByToken(String token);
    void deleteByUser(User user);
}

