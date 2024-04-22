package com.example.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.cinema.controller.utils.Utils;
import com.example.cinema.entity.Film;
import com.example.cinema.repository.NationaliteRepository;
import com.example.cinema.service.FilmeService;
import com.example.cinema.service.GenreService;
import com.example.cinema.service.NationaliteService;

@Controller
@RequestMapping("/admin/films")
public class AdminFilmController {
    

    @Autowired
    private FilmeService service;
    @Autowired
    private NationaliteService nationaliteService;
    @Autowired
    private GenreService genreService ;

    @GetMapping("/page/{pg}")
    public String getMethodName(@PathVariable("pg") long pg ,Model model) {
        if(pg>0){
            Page<Film> page;
            page =  service.allByPage(pg-1);
            model.addAttribute("totalpages",page.getTotalPages());
            model.addAttribute("listFilms" ,page.getContent());
        }
        else{
            model.addAttribute("listFilms" ,service.getAll());
        }
        model.addAttribute("newFilm",new Film());
        return "gestionFilm";
    }

    @GetMapping
    public String getMethodName(Model model) {
        return "redirect:/admin/films/page/1";
    }

    @GetMapping("/")
    public String getMethodName() {
        return "redirect:/admin/films/page/1";
    }
    
    @GetMapping("/forword/{id}")
    public String forwordd(@PathVariable("id") long id,Model model) {
        model.addAttribute("film",service.getById(id).get());
        model.addAttribute("newFilm",new Film());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("nationalites", nationaliteService.getAll());
        return "gestionFilmEdit";
    }
    
    
    // @PostMapping("/edit")
    // public String editFilm(@RequestParam("file")MultipartFile file,Film personne,Model model) {
    //     if(!file.isEmpty() && !file.getOriginalFilename().equals("") && !file.getContentType().isEmpty()){
    //         if(personne.getId() != null){
    //             String fileName = service.getById(personne.getId()).get().getPhoto();
    //             if(fileName != null){
    //                 if(fileName.split("/").length >=3){
    //                     Utils.deleteFile(fileName.split("/")[2]);
    //                 }
    //         }   
    //         }
    //         personne.setPhoto(Utils.saveFile(file));
           
    //     }
    //     if(personne.getId() != null){
    //         personne.setPhoto(personne.getPhoto() == null ? service.getById(personne.getId()).get().getPhoto()  : personne.getPhoto());
        
    //     }
    //     service.save(personne);
    //     return "redirect:/admin/personnes/page/1";
    // }

    @GetMapping("/delete/{id}")
    public String deletFilm(@PathVariable("id") long id,Model model) {
        service.deleteById(id);
        return "redirect:/admin/films/page/1";
    }


    // @InitBinder
    // public void initBinder(WebDataBinder binder) {
    //     binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
    //         @Override
    //         public void setAsText(String text) throws IllegalArgumentException {
    //             try {
    //                 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //                 java.util.Date parsedDate = dateFormat.parse(text);
    //                 setValue(new Date(parsedDate.getTime()));
    //             } catch (ParseException e) {
    //                 setValue(null);
    //             }
    //         }
    //     });
    // }
}
