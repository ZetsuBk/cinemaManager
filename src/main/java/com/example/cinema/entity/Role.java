package com.example.cinema.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.stream.Collectors;
@RequiredArgsConstructor
public enum Role {
    ADMIN,
    USER,

}
