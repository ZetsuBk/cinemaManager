import { Film } from "./film.model";
import { Salle } from "./salle.model";

export interface Seance {
    id: number;
    dateProjection: String;
    heureDebut: Date;
    heureFin: Date;
    film: Film;
    salle: Salle;
  
  
  }
  
