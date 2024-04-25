import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RatingModule } from 'primeng/rating';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Film } from '../moduls/film.model';

@Component({
  selector: 'app-film-card',
  standalone: true,
  imports: [RatingModule,FormsModule],
  templateUrl: './film-card.component.html',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  styleUrl: './film-card.component.css'
})
export class FilmCardComponent {

  @Input() film:Film | undefined ;
  score:number = 3;
  media:string="";
}
