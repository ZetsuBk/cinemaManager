package com.example.cinema.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.cinema.controller.utils.Utils;
import com.example.cinema.entity.Film;
import com.example.cinema.entity.Media;
import com.example.cinema.entity.Personne;
import com.example.cinema.repository.NationaliteRepository;
import com.example.cinema.service.FilmeService;
import com.example.cinema.service.GenreService;
import com.example.cinema.service.MediaService;
import com.example.cinema.service.NationaliteService;
import com.example.cinema.service.PersoneService;

@Controller
@RequestMapping("/admin/films")
public class AdminFilmController {
    

    @Autowired
    private FilmeService service;
    @Autowired
    private NationaliteService nationaliteService;
    @Autowired
    private GenreService genreService ;
    @Autowired
    private PersoneService personeService;
    @Autowired
    private MediaService mediaService;

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
        Film film = service.getById(id).get();
        model.addAttribute("film",film);
        model.addAttribute("newFilm",new Film());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("nationalites", nationaliteService.getAll());
        List<Personne> personnes = service.getActorsNotInFilm(film);
        if(film.getRealisateur() != null){
            personnes.remove(film.getRealisateur());
        }
        model.addAttribute("notMyPersonnes", personnes);
        model.addAttribute("MyActeurs", film.getActeurs());
        model.addAttribute("MyDirecteurs", film.getRealisateur());
        model.addAttribute("mode", "Edit");
        model.addAttribute("medias", film.getMedias());
        return "gestionFilmEdit";
    }
    
    @GetMapping("/{film}/add/acteur/{acteur}")
    public String addActeur(@PathVariable("film") long filmId ,@PathVariable("acteur") long acteurId) {
        Film film = service.getById(filmId).get();
        if(film != null){
            List<Personne> acteurs = film.getActeurs();
            Personne personne = personeService.getById(acteurId).get();
            if(personne != null){
                acteurs.add(personne);
                film.setActeurs(acteurs);
                service.save(film);
            }
            return "redirect:/admin/films/forword/"+filmId;
        }
        return "redirect:/admin/films/";
    }

    @PostMapping("/upload/{filmId}")
    public String UploadFile(@RequestParam("file")MultipartFile file,@PathVariable("filmId") long filmId) {
        Media media = new Media();
        Film film = service.getById(filmId).get();
        if(film != null){
            if (file.getContentType().startsWith("image/")) {
                media.setTypeMedia(Media.TypeMedia.IMAGE);
                media.setMedia(Utils.saveFile(file));
                media.setFilm(film);
                media =  mediaService.save(media);
            }
            else if (file.getContentType().startsWith("video/")) {
                media.setTypeMedia(Media.TypeMedia.VIDEO);
                media.setMedia(Utils.saveFile(file));
                media.setFilm(film);
                media =  mediaService.save(media);
            }
            
        }
        
        return "redirect:/admin/films/forword/"+filmId;
    }
    

    @GetMapping("/{film}/add/directeur/{dir}")
    public String addDirecteur(@PathVariable("film") long filmId ,@PathVariable("dir") long dirId) {
        Film film = service.getById(filmId).get();
        if(film != null){
            Personne personne = personeService.getById(dirId).get();
            if(personne != null){
                film.setRealisateur(personne);
                service.save(film);
            }
            return "redirect:/admin/films/forword/"+filmId;
        }
        return "redirect:/admin/films/";
    }

    @GetMapping("/{film}/delete/directeur/")
    public String deleteDirecteur(@PathVariable("film") long filmId) {
        Film film = service.getById(filmId).get();
        if(film != null){
            film.setRealisateur(null);
            service.save(film);
            return "redirect:/admin/films/forword/"+filmId;
        }
        return "redirect:/admin/films/";
    }

    @GetMapping("/{film}/delete/acteur/{act}")
    public String deleteActeur(@PathVariable("film") long filmId,@PathVariable("act") Long acteurID) {
        Film film = service.getById(filmId).get();
        if(film != null){
            List<Personne> acteurs = film.getActeurs();
            if(acteurs.size() >0){
                Personne acteur = personeService.getById(acteurID).get();
                if(acteur !=null){
                    acteurs.remove(acteur);
                    film.setActeurs(acteurs);
                    service.save(film);
                } 
            } 
            return "redirect:/admin/films/forword/"+filmId;
        }
        return "redirect:/admin/films/";
    }
    
    
    
    @PostMapping("/edit")
    public String editFilm(Film film,Model model) {
        if(film != null){
            if(film.getId() != null){
                Film filmP = service.getById(film.getId()).get();
                if(filmP != null){
                    film.setActeurs(filmP.getActeurs());
                    film.setRealisateur(filmP.getRealisateur());
                    service.save(film);
                    return "redirect:/admin/films/forword/"+film.getId();
                }
                
            }
            else{
                service.save(film);
            }
        }
        return "redirect:/admin/films";
    }

    @GetMapping("/delete/{id}")
    public String deletFilm(@PathVariable("id") long id,Model model) {
        service.deleteById(id);
        return "redirect:/admin/films/page/1";
    }


}
