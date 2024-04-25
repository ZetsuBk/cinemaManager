import { Component } from '@angular/core';
import { HomeComponent } from "../home/home.component";
import { ActivatedRoute, Router } from '@angular/router';
import { CommonModule, NgIf } from '@angular/common';
import { FilmsComponent } from "../films/films.component";
import { HeaderComponent } from "../header/header.component";

@Component({
    selector: 'app-body',
    standalone: true,
    templateUrl: './body.component.html',
    styleUrl: './body.component.css',
    imports: [HomeComponent, NgIf, FilmsComponent, HeaderComponent]
})
export class BodyComponent {
  isHomeRoute: boolean = false;
  isFilmRoute: boolean = false;
  nav : number = 0;

  constructor(private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.url.subscribe(url => {
      this.isHomeRoute = url[0]?.path === 'seances';
      this.isFilmRoute = url[0]?.path === 'films';
    });
    this.nav = this.isHomeRoute ? 1 : this.isFilmRoute ? 2 : 0 ;
  }
}
