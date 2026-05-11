export class Agence {
  id?: number;
  nom!: string;
  adresse!: string;
  ville!: string;
  telephone!: string;
}

export class Vehicule {
  id?: number;
  matricule!: string;
  marque!: string;
  modele!: string;
  prixParJour!: number;
  dateMiseEnService!: Date;
  statut!: string;
  nombrePortes?: number;
  typeCarburant?: string;
  boiteVitesse?: string;
  cylindree?: number;
  typeMoto?: string;
  casqueInclus?: boolean;
}

export class Location {
  id?: number;
  dateDebut!: Date;
  dateFin!: Date;
  prixTotal!: number;
  vehiculeId!: number;
}
