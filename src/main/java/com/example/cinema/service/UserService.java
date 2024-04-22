package com.example.cinema.service;

import com.example.cinema.ResetSecurity.ResetTokenService;
import com.example.cinema.ResetSecurity.ResettokenRepository;
import com.example.cinema.entity.User;
import com.example.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
  @Autowired
  private  ResetTokenService resetTokenService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Add or update a user
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Delete user by ID
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public Page<User> allProduitint(Long pageNo){
        Pageable pageable = PageRequest.of(Math.toIntExact(pageNo), 9);
        return userRepository.findAll(pageable);
    }
    public boolean emailExists(String email) {
        return userRepository.existsUserByEmail(email);
    }

    public void initiatePasswordReset(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            resetTokenService.deleteTokensByUser(user);
            String resetToken = resetTokenService.generateAndSavePasswordResetToken(user);
            emailService.sendResetPasswordEmail(user, resetToken);
        }
    }
}
