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
import { Seance } from './models/seance.model';
import { SeanceService } from './services/seance.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  filmId: number = 1;
  genres: Genre[] = [];
  nationalities: Nationalite[] = [];
  averageRating: number | undefined;
  averageRating$: Observable<number> | undefined;
  films: Film[] | undefined;

  constructor(
    private filmService: FilmService,
    private genreService: GenreService,
    private nationaliteService: NationaliteService,
    private seanceService: SeanceService 
  ) {}

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
    this.filmService.searchFilms(keyword, nationalite, genre).subscribe(
      (data) => {
        this.films = data;
        console.log('Films found:', data);
      },
      (error) => {
        console.error('Error fetching films:', error);
      }
    );
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
    const dateProjection = new Date('2024-04-22');  // Replace with your desired date
    const filmTitle = 'G'; 
    this.seanceService.searchSeances(dateProjection,filmTitle).subscribe(
      (seances: Seance[]) => {
        console.log('Seances found:', seances);
      },
      (error) => {
        console.error('Error fetching seances:', error);
      }
    );
  }

  getActorsFullName(actors: any[]): string {
    return actors.map((actor) => actor.nom + ' ' + actor.prenom).join(', ');
  }

  title = 'cinema';
}