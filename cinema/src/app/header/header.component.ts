import { NgClass } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { flatMap } from 'rxjs';

@Component({
    selector: 'app-header',
    standalone: true,
    templateUrl: './header.component.html',
    styleUrl: './header.component.css',
    imports: [RouterLink, NgClass]
})
export class HeaderComponent implements OnInit{
  @Input() nav:number = 0;

  isFilms:boolean=false;
  isSeance:boolean=false;

  ngOnInit(): void {
   this.isFilms = this.nav ==2;
   this.isSeance = this.nav ==1;
  }
}
