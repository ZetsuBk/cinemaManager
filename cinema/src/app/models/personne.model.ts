import { Nationalite } from "./nationalite.model";


export interface Personne {
    id: number;
    nom: string;
    prenom: string;
    photo: string; // Assuming photo is a URL string
    dateNaissance: Date;
    typePersonne: string;
    addedDate: Date;
    nationalite: Nationalite;
  
  }
  
  
