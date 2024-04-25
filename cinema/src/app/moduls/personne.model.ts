import { Nationalite } from "./nationalite.model";


export interface Personne {
    id: number;
    nom: string;
    prenom: string;
    photo: string; // Assuming photo is a URL string
    dateNaissance: string;
    typePersonne: string;
    addedDate: string;
    nationalite: Nationalite;
  
  }
  
  
