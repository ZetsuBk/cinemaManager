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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cinema.controller.utils.Utils;
import com.example.cinema.entity.Nationalite;
import com.example.cinema.entity.Personne;
import com.example.cinema.service.NationaliteService;
import com.example.cinema.service.PersoneService;


@Controller
@RequestMapping("/admin/personnes")
public class AdminPersonneController {

    @Autowired
    private PersoneService service;

    @Autowired
    private NationaliteService nationaliteService;




    @GetMapping("/page/{pg}")
    public String getMethodName(@PathVariable("pg") long pg ,Model model) {
        if(pg>0){
            Page<Personne> page;
            page =  service.allByPage(pg-1);
            model.addAttribute("totalpages",page.getTotalPages());
            model.addAttribute("listPersonnes" ,page.getContent());
        }
        else{
            model.addAttribute("listPersonnes" ,service.getAll());
        }
        model.addAttribute("newPersonne",new Personne());
        model.addAttribute("nationalites",nationaliteService.getAll());
        model.addAttribute("Types",Personne.TypePersonne.values());
        return "gestionPersonne";
    }

    @GetMapping
    public String getMethodName(Model model) {
        return "redirect:/admin/personnes/page/1";
    }

    
    @PostMapping("/edit")
    public String editPersonne(@RequestParam("file")MultipartFile file,Personne personne,Model model) {
        if(!file.isEmpty() && !file.getOriginalFilename().equals("") && !file.getContentType().isEmpty()){
            if(personne.getId() != null){
                String fileName = service.getById(personne.getId()).get().getPhoto();
                if(fileName != null){
                    if(fileName.split("/").length >=3){
                        Utils.deleteFile(fileName.split("/")[2]);
                    }
            }   
            }
            personne.setPhoto(Utils.saveFile(file));
           
        }
        if(personne.getId() != null){
            personne.setPhoto(personne.getPhoto() == null ? service.getById(personne.getId()).get().getPhoto()  : personne.getPhoto());
        
        }
        service.save(personne);
        return "redirect:/admin/personnes/page/1";
    }

    @GetMapping("/delete/{id}")
    public String deletPersonne(@PathVariable("id") long id,Model model) {
        String fileName = service.getById(id).get().getPhoto();
            if(fileName != null){
                if(fileName.split("/").length >=3){
                    Utils.deleteFile(fileName.split("/")[2]);
                }
                
            }
        service.deleteById(id);
        return "redirect:/admin/personnes/page/1";
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
