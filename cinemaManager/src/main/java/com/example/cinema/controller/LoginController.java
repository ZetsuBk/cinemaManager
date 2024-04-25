package com.example.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String getMethodName(Model model) {
        return "login";
    }
}
