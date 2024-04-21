package com.example.cinema.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.cinema.entity.User;
import com.example.cinema.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
@RequestMapping("/admin")
public class AdminUserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    @PostMapping
    public String postMethodName() {
        
        return "redirect:/admin/home";
    }

    @GetMapping("/")
    @PostMapping("/")
    public String postMethodName1() {
        
        return "redirect:/admin/home";
    }
    
    @GetMapping("/users/page/{pg}")
    public String getMethodName(@PathVariable("pg") long pg ,Model model) {
        if(pg>0){
            Page<User> page;
            page =  userService.allProduitint(pg-1);
            model.addAttribute("totalpages",page.getTotalPages());
            model.addAttribute("listUsers" ,page.getContent());
        }
        else{
            model.addAttribute("listUsers" ,userService.getAllUsers());
        }
        model.addAttribute("newUser",new User());

        return "gestionUser";
    }
    

    @GetMapping("/users")
    public String getMethodName(Model model) {
        return "redirect:/admin/users/page/1";
    }

    
    @PostMapping("/users/edit")
    public String editUser(User user,Model model) {
        userService.saveUser(user);
        return "redirect:/admin/users/page/1";
    }

    @GetMapping("/users/delete/{id}")
    public String deletUser(@PathVariable("id") long id,Model model) {
        userService.deleteUserById(id);
        return "redirect:/admin/users/page/1";
    }
    

    @GetMapping("/home")
    public String fgdf(){
        return "home";
    }
    
}
