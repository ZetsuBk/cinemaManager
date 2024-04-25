import { Component, Input, OnInit } from '@angular/core';
import { FilmCardComponent } from '../film-card/film-card.component';
import { Film } from '../moduls/film.model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { GroupArrayPipe } from '../Utils/groupArray.pipe';

@Component({
  selector: 'app-films',
  standalone: true,
  imports: [FilmCardComponent,CommonModule,FormsModule,GroupArrayPipe],
  templateUrl: './films.component.html',
  styleUrl: './films.component.css'
})
export class FilmsComponent {
  @Input() films : Film[] =[]


}
