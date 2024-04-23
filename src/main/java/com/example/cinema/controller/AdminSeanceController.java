package com.example.cinema.controller;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.entity.Seance;
import com.example.cinema.service.FilmeService;
import com.example.cinema.service.SalleService;
import com.example.cinema.service.SeanceService;



@Controller
@RequestMapping("/admin/seances")
public class AdminSeanceController {

    @Autowired
    private SeanceService service;
    @Autowired
    private FilmeService filmeService;
    @Autowired
    private SalleService salleService;

    @GetMapping("/page/{pg}")
    public String getMethodName(@PathVariable("pg") long pg ,Model model) {
        if(pg>0){
            Page<Seance> page;
            page =  service.allByPage(pg-1);
            model.addAttribute("totalpages",page.getTotalPages());
            model.addAttribute("listSeances" ,page.getContent());
        }
        else{
            model.addAttribute("listSeances" ,service.getAll());
        }
        model.addAttribute("newSeance",new Seance());
        model.addAttribute("films",filmeService.getAll());
        model.addAttribute("salles",salleService.getAll());
        return "gestionSeance";
    }

    @GetMapping
    public String getMethodName(Model model) {
        return "redirect:/admin/seances/page/1";
    }

    @GetMapping("/")
    public String getMethod(Model model) {
        return "redirect:/admin/seances/page/1";
    }
    
    @PostMapping("/edit")
    public String editSeance(Seance seance,Model model) {
        service.save(seance);
        return "redirect:/admin/seances/page/1";
    }

    @GetMapping("/delete/{id}")
    public String deletSeance(@PathVariable("id") long id,Model model) {
        service.deleteById(id);
        return "redirect:/admin/seances/page/1";
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date parsedDate = dateFormat.parse(text);
                    setValue(new Date(parsedDate.getTime()));
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });
    }
}
