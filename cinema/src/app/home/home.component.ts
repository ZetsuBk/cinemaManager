import { Component } from '@angular/core';
import { SeanceCardComponent } from "../seance-card/seance-card.component";

@Component({
    selector: 'app-home',
    standalone: true,
    templateUrl: './home.component.html',
    styleUrl: './home.component.css',
    imports: [SeanceCardComponent]
})
export class HomeComponent {

}
