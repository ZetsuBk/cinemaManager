import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RatingModule } from 'primeng/rating';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'app-seance-card',
  standalone: true,
  imports: [FormsModule,RatingModule],
  templateUrl: './seance-card.component.html',
  styleUrl: './seance-card.component.css'
})
export class SeanceCardComponent {
  score:number=3;
}
