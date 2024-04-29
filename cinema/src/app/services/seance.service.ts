import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seance } from '../models/seance.model';

@Injectable({
  providedIn: 'root'
})
export class SeanceService {
  // private apiUrl = 'http://localhost:8080/api2/user';
  // constructor(private http: HttpClient) { }
  // searchSeances(dateProjection?: Date , titre?: string, genre?: string): Observable<Seance[]> {
  //   let params = new HttpParams();
  //   if (keyword) {
  //     params = params.set('keyword', keyword);
  //   }
  //   if (nationalite) {
  //     params = params.set('nationalite', nationalite);
  //   }
  //   if (genre) {
  //     params = params.set('genre', genre);
  //   }
  //   return this.http.get<Seance[]>(`${this.apiUrl}/search/seance`, { params });
  // }
}
