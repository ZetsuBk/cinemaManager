import { Component, Input } from '@angular/core';
import { SeanceCardComponent } from "../seance-card/seance-card.component";
import { Seance } from '../moduls/seance.model';

@Component({
    selector: 'app-home',
    standalone: true,
    templateUrl: './home.component.html',
    styleUrl: './home.component.css',
    imports: [SeanceCardComponent]
})
export class HomeComponent {
    @Input() seances : Seance[]  | undefined;
}
