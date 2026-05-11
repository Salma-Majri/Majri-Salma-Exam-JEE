import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Agence, Vehicule, Location as LocationModel } from '../models/location';

@Injectable({
  providedIn: 'root'
})
export class Location {

  private host = 'http://localhost:8087/api';

  constructor(private http: HttpClient) { }

  public getAgences(): Observable<Array<Agence>> {
    return this.http.get<Array<Agence>>(`${this.host}/agences`);
  }

  public saveAgence(agence: Agence): Observable<Agence> {
    return this.http.post<Agence>(`${this.host}/agences`, agence);
  }

  public getVehicules(): Observable<Array<Vehicule>> {
    return this.http.get<Array<Vehicule>>(`${this.host}/vehicules`);
  }

  public getLocations(): Observable<Array<LocationModel>> {
    return this.http.get<Array<LocationModel>>(`${this.host}/locations`);
  }

  public createLocation(location: LocationModel): Observable<LocationModel> {
    return this.http.post<LocationModel>(`${this.host}/locations`, location);
  }
}
