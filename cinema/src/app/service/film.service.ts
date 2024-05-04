
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Film } from '../moduls/film.model';
import { AppComponent } from '../app.component';
import { score } from '../film-card/film-card.component';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  private apiUrl = AppComponent.apiUrl +'/api2/user'; 

  constructor(private http: HttpClient) { }

  searchFilms(keyword?: string, nationalite?: string, genre?: string): Observable<Film[]> {
    let params = new HttpParams();
    if (keyword != undefined) {
      params = params.set('keyword', keyword);
    }
    if (nationalite) {
      params = params.set('nationalite', nationalite);
    }
    if (genre) {
      params = params.set('genre', genre);
    }

    return this.http.get<Film[]>(`${this.apiUrl}/search/film`, { params });
  }


  getAverageRatingByFilmId(filmId: number | undefined): Observable<score> {
   
    return this.http.get<score>(`${this.apiUrl}/average/${filmId}`);
  }
  getFilmById(id: number): Observable<Film> {
    return this.http.get<Film>(`${this.apiUrl}/getFilm/${id}`);
  }


}

