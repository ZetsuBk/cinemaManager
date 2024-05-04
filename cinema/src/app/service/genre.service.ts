import { Injectable, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Genre } from '../moduls/genre.model';

@Injectable({
  providedIn: 'root'
})
export class GenreService {
  private apiUrl = 'http://localhost:8080/api2/user'; 
  constructor(private http: HttpClient) { }
  getAllGenres(): Observable<Genre[]> {
    return this.http.get<Genre[]>(`${this.apiUrl}/getAllGenre`);
  }
}
