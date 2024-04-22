package com.example.cinema.Auth;

import com.example.cinema.config.JwtService;
import com.example.cinema.repository.UserRepository;
import com.example.cinema.entity.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private  final  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request, HttpServletResponse response) {
        try {
            if (userRepository.existsByUsername(request.getUsername())) {
                return AuthenticationResponse.builder()
                        .errorMessage("Username already in use")
                        .build();
            }
            if (userRepository.existsUserByEmail(request.getEmail())) {
                return AuthenticationResponse.builder()
                        .errorMessage("Email already in use")
                        .build();
            }
            var user = User.builder()
                    .email(request.getEmail())
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .build();
            var savedUser = userRepository.save(user);
            var jwtToken = jwtService.generateToken((UserDetails) savedUser);
            Cookie cookie = new Cookie("AuthCookie", jwtToken);
            cookie.setMaxAge(1800);
            cookie.setPath("/");
            response.addCookie(cookie);

            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .build();
        } catch (DataIntegrityViolationException ex) {
            if (ex.getMessage().contains("duplicate key value violates unique constraint \"uknlcolwbx8ujaen5h0u2kr2bn2\"")) {
                return AuthenticationResponse.builder()
                        .errorMessage("The username already exists")
                        .build();
            } else {
                return AuthenticationResponse.builder()
                        .errorMessage("An error occurred during registration")
                        .build();
            }
        }
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
            var user = userRepository.findByEmail(request.getEmail())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            var jwtToken = jwtService.generateToken((UserDetails) user);

            Cookie cookie = new Cookie("AuthCookie", jwtToken);
            cookie.setMaxAge(1800);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .build();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw e;
        }
    }

}