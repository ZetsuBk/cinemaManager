import { Component, Input, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RatingModule } from 'primeng/rating';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { Film } from '../moduls/film.model';
import { AppComponent } from '../app.component';
import { Media } from '../moduls/media.model';
import { FilmService } from '../service/film.service';

export class score{ 
  average:number = 0.0
}

@Component({
  selector: 'app-film-card',
  standalone: true,
  imports: [RatingModule,FormsModule,AppComponent],
  templateUrl: './film-card.component.html',
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  styleUrl: './film-card.component.css'
})
export class FilmCardComponent  implements OnInit{
  constructor(private filmService : FilmService){
      filmService.getAverageRatingByFilmId(this.film?.id).subscribe(
        data => {
           this.score = data;
        }
      )
  }

  ngOnInit(): void {
    console.log(this.film)
    this.api = AppComponent.apiUrl
    // this.medias =  this.film?.medias != null ? this.film.medias : []  ;
    // for (let media of this.medias) {
    //   if(media.typeMedia == "IMAGE"){
    //     this.photo = AppComponent.apiUrl  + this.film?.medias
    //     break
    //   }
    // }
    // console.log(this.photo)
    
  }

  @Input() film:Film | undefined ;
  score:score = new score();
  api:String ="";
  medias:Media[]=[];
  photo :string=""

}
