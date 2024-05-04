import { NgClass, NgFor } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Genre } from '../moduls/genre.model';
import { Nationalite } from '../moduls/nationalite.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Film } from '../moduls/film.model';
import { FilmService } from '../service/film.service';
import { GenreService } from '../service/genre.service';
import { NationaliteService } from '../service/nationalite.service';
import { Seance } from '../moduls/seance.model';
import { SeanceService } from '../service/seance.service';

@Component({
    selector: 'app-header',
    standalone: true,
    templateUrl: './header.component.html',
    styleUrl: './header.component.css',
    imports: [RouterLink, NgClass,NgFor,CommonModule,FormsModule]
})
export class HeaderComponent implements OnInit{
  @Input() nav:number = 0;
  @Output() messageEvent = new EventEmitter<Film[]>();

  isFilms:boolean=false;
  isSeance:boolean=false;

  genres : Genre[] | undefined;
  nationalites: Nationalite[] | undefined;
  
  searchText : string = "";
  genre : string ="";
  nationalite :string ="";
  date :Date | undefined;
  films : Film[] |undefined;
  seances : Seance[] | undefined;
  constructor(private filmService:FilmService,private genreService : GenreService, private nationaliteService : NationaliteService,private seanceService : SeanceService){
    
  }

  ngOnInit(): void {
   this.isFilms = this.nav ==2;
   this.isSeance = this.nav ==1;
   if(this.isFilms){
    this.onSearchFilm();
    this.fillFiltersFilms();
  }else if(this.isSeance) {

  }

  }

  fillFiltersFilms(){
    this.genreService.getAllGenres().subscribe(data =>{
      this.genres = data;
   })

   this.nationaliteService.getAllNationalities().subscribe(data=>{
    this.nationalites = data;
   })
   
  }

  onSearchFilm(){
      this.filmService.searchFilms(this.searchText,this.nationalite,this.genre).subscribe(
        data =>{
          this.films = data;
          this.messageEvent.emit(this.films);
        }
        
      )
      
  
  }

  onSearchSeance(){
    this.seanceService.searchSeances(this.date,this.searchText).subscribe(data =>{
        this.seances = data;
        
    })
  }

}