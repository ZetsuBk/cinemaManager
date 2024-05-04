import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seance } from '../moduls/seance.model';


@Injectable({
  providedIn: 'root'
})
export class SeanceService {
   private apiUrl = 'http://localhost:8080/api2/user';
 constructor(private http: HttpClient) { }
 searchSeances(dateProjection: Date |  undefined, filmTitle: string, otherParams?: any): Observable<Seance[]> {
  let params = new HttpParams();
  if (dateProjection) {
    params = params.set('dateProjection', dateProjection.toString());
  }
  if (filmTitle) {
    params = params.set('filmTitle', filmTitle);
  }


  const url = `${this.apiUrl}/search/seance`; 
  return this.http.get<Seance[]>(url, { params });
}
}
