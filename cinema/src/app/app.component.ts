import { Component, OnInit } from '@angular/core';
import { HeaderComponent } from "./header/header.component";
import { Observable, map } from 'rxjs';
import { Film } from './models/film.model';
import { FilmService } from './services/film.service';
import { RouterOutlet } from '@angular/router';
import { CommonModule, NgFor, NgIf } from '@angular/common';
import { GenreService } from './services/genre.service';
import { Genre } from './models/genre.model';
import { NationaliteService } from './services/nationalite.service';
import { Nationalite } from './models/nationalite.model';
@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrl: './app.component.css',
    imports: [RouterOutlet, HeaderComponent,NgFor,NgIf]
})
export class AppComponent implements OnInit {
  filmId: number = 1;
  genres: Genre[] = [];
  nationalities: Nationalite[] = [];
  averageRating: number | undefined;
  averageRating$: Observable<number> | undefined;
  films: Film[] | undefined
  constructor(private filmService:  FilmService,private genreService: GenreService,private nationaliteService : NationaliteService  ) {}
  ngOnInit(): void {
    this.filmService.getAverageRatingByFilmId(this.filmId).subscribe(
      (response: any) => {
        this.averageRating = response.average;
      },
      (error) => {
        console.error('Error fetching average rating:', error);
      }
    );
    const keyword = 'G';
    const nationalite = 'American';
    const genre = 'thriller';
   this.filmService.searchFilms(keyword, nationalite, genre)
     .subscribe(data =>{
        this.films = data
        console.log(data)

     })
     this.genreService.getAllGenres().subscribe(
      (data) => {
        this.genres = data; 
      },
      (error) => {
        console.error('Error fetching genres:', error);
      }
    );
    this.nationaliteService.getAllNationalities().subscribe(
      (data) => {
        this.nationalities = data; 
      },
      (error) => {
        console.error('Error fetching nationalities:', error);
      }
    );

  }

  getActorsFullName(actors: any[]): string {
    return actors.map(actor => actor.nom + ' ' + actor.prenom).join(', ');
  }
  

  title = 'cinema';
}
