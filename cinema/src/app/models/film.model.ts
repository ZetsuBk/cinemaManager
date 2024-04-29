
import { Genre } from './genre.model';
import { Media } from './media.model';
import { Nationalite } from './nationalite.model';
import { Personne } from './personne.model';
import { Seance } from './seance.model';
export interface Film {
    id: number;
    titre: string;
    duree: number;
    annee: number;
    genre: Genre;
    nationalite: Nationalite;
    realisateur: Personne;
    acteurs: Personne[];
    addedDate: Date;
    medias?: Media[]; 
    seances?: Seance[]; 
  
 
  }
  