package com.example.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cinema.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    @PostMapping
    public String postMethodName() {
        
        return "redirect:/admin/home";
    }
    
    @GetMapping("/users")
    public String getMethodName(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "gestionUser";
    }
    

    @GetMapping("/home")
    public String fgdf(){
        return "home";
    }
    
}
