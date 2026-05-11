export interface Vehicule {
  id?: number;
  matricule: string;
  marque: string;
  modele: string;
  prixParJour: number;
  dateMiseEnService: Date;
  statut: string;
  nombrePortes?: number;
  typeCarburant?: string;
  boiteVitesse?: string;
  cylindree?: number;
  typeMoto?: string;
  casqueInclus?: boolean;
}
