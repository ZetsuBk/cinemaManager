
import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Film } from '../models/film.model';
import { Seance } from '../models/seance.model';
@Injectable({
  providedIn: 'root'
})
export class FilmService {
  private apiUrl = 'http://localhost:8080/api2/user'; 

  constructor(private http: HttpClient) { }
  searchFilms(keyword?: string, nationalite?: string, genre?: string): Observable<Film[]> {
    let params = new HttpParams();
    if (keyword) {
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
   
  getAverageRatingByFilmId(filmId: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/average/${filmId}`);
  }
  getFilmById(id: number): Observable<Film> {
    return this.http.get<Film>(`${this.apiUrl}/getFilm/${id}`);
  }
  
 
}

