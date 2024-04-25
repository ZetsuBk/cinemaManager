
import { Film } from "./film.model";

export class Media {
    id: number;
    media: string;
    typeMedia: string;
    addedDate: Date;
    film: Film;
  
    constructor(
      id: number,
      media: string,
      typeMedia: string,
      addedDate: Date,
      film: Film
    ) {
      this.id = id;
      this.media = media;
      this.typeMedia = typeMedia;
      this.addedDate = addedDate;
      this.film = film;
    }
  }
  
