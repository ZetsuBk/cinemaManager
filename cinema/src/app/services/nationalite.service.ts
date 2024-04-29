import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Nationalite } from '../models/nationalite.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class NationaliteService {
  private apiUrl = 'http://localhost:8080/api2/user'; 

  constructor(private http: HttpClient) {  }
  getAllNationalities(): Observable<Nationalite[]> {
    return this.http.get<Nationalite[]>(`${this.apiUrl}/getAllNationality`);
  }
}
