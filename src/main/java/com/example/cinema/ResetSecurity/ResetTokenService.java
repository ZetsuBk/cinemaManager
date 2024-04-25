package com.example.cinema.ResetSecurity;

import com.example.cinema.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Service
public class ResetTokenService {

    @Autowired
    private ResettokenRepository resetTokenRepository;
    private Map<String, User> resetTokens = new HashMap<>();
    public boolean validateToken(String token) {
        Optional<Resettoken> optionalToken = resetTokenRepository.findByToken(token);
        if (optionalToken.isPresent()) {
            Resettoken resetToken = optionalToken.get();

            LocalDateTime expirationTime = resetToken.getExpirationTime();
            LocalDateTime currentTime = LocalDateTime.now();
            return !currentTime.isAfter(expirationTime);
        }
        return false;
    }
    @Transactional
    public void deleteToken(String token) {
        resetTokenRepository.deleteByToken(token);
    }

    public User getUserFromToken(String token) {
        return resetTokens.get(token);
    }

    public void invalidateToken(String token) {
        resetTokens.remove(token);
    }
    public Optional<User> findUserByPasswordToken(String passwordResetToken) {
        return Optional.ofNullable(resetTokenRepository.findByToken(passwordResetToken).get().getUser());
    }
    @Transactional
    public void deleteTokensByUser(User user) {
        resetTokenRepository.deleteByUser(user);
    }
    public String generateAndSavePasswordResetToken(User user) {
        String resetToken = UUID.randomUUID().toString();
        LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
        Resettoken resetTokenEntity = new Resettoken();
        resetTokenEntity.setToken(resetToken);
        resetTokenEntity.setUser(user);
        resetTokenEntity.setExpirationTime(expirationTime);
        resetTokenRepository.save(resetTokenEntity);
        return resetToken;
    }



}
