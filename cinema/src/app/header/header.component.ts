import { NgClass, NgFor } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Genre } from '../moduls/genre.model';
import { Nationalite } from '../moduls/nationalite.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Film } from '../moduls/film.model';
import { FilmService } from '../service/film.service';

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
  date :string | undefined;
  films : Film[] |undefined;
  
  constructor(private filmService:FilmService){
    
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
   this.genres = [
    {id :1, name:'comedy'},
    {id :2 ,name:'romance'},
    {id :2 ,name:'romance'}
   ]

   this.nationalites = [
    {id:2,libelle:'spain'},
    {id:3,libelle:'usa'},
    {id :2 ,libelle:'uk'}
   ]
  }

  onSearchFilm(){
      console.log(this.searchText)
      console.log(this.genre)
      console.log(this.nationalite)
      console.log(this.date)
      this.filmService.searchFilms(this.searchText,this.nationalite,this.genre).subscribe(
        data =>{
          this.films = data;
          this.messageEvent.emit(this.films);
        }
        
      )
      // this.films =[ 
      //   {
      //     id:1,titre:'las cassassds',duree:90,annee:2001,genre: {id :1, name:'comedy'},nationalite: {id:2,libelle:'spain'},
      //     realisateur:{id:0,nom:'dsds',prenom:'dsds',photo:'/assets/photos/c.jpg',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}},
      //     acteurs:[{ id :0 ,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}}],
      //     addedDate:'dsds',
      //     medias:[],
      //     seances:[]
      //   },
      //   {
      //     id:1,titre:'las cassassds',duree:90,annee:2001,genre: {id :1, name:'comedy'},nationalite: {id:2,libelle:'spain'},
      //     realisateur:{id:0,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}},
      //     acteurs:[{ id :0 ,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}}],
      //     addedDate:'dsds',
      //     medias:[],
      //     seances:[]
      //   },{
      //     id:1,titre:'las cassassds',duree:90,annee:2001,genre: {id :1, name:'comedy'},nationalite: {id:2,libelle:'spain'},
      //     realisateur:{id:0,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}},
      //     acteurs:[{ id :0 ,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}}],
      //     addedDate:'dsds',
      //     medias:[],
      //     seances:[]
      //   },{
      //     id:1,titre:'las cassassds',duree:90,annee:2001,genre: {id :1, name:'comedy'},nationalite: {id:2,libelle:'spain'},
      //     realisateur:{id:0,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}},
      //     acteurs:[{ id :0 ,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}}],
      //     addedDate:'dsds',
      //     medias:[],
      //     seances:[]
      //   },{
      //     id:1,titre:'las cassassds',duree:90,annee:2001,genre: {id :1, name:'comedy'},nationalite: {id:2,libelle:'spain'},
      //     realisateur:{id:0,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}},
      //     acteurs:[{ id :0 ,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}}],
      //     addedDate:'dsds',
      //     medias:[],
      //     seances:[]
      //   },{
      //     id:1,titre:'las cassassds',duree:90,annee:2001,genre: {id :1, name:'comedy'},nationalite: {id:2,libelle:'spain'},
      //     realisateur:{id:0,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}},
      //     acteurs:[{ id :0 ,nom:'dsds',prenom:'dsds',photo:'sdsd',dateNaissance:'dsdsd',typePersonne:"sds",addedDate:"sds",nationalite:{id:2,libelle:'spain'}}],
      //     addedDate:'dsds',
      //     medias:[],
      //     seances:[]
      //   },
      // ]
    
  
  }

}