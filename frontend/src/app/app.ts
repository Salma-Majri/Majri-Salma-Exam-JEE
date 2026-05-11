import { Component, signal, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Location } from './services/location';
import { Vehicule } from './models/location';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('AppEnset');
  protected readonly vehicules = signal<Array<Vehicule>>([]);
  protected readonly errorMessage = signal<string>('');

  constructor(private locationService: Location) {}

  ngOnInit(): void {
    this.locationService.getVehicules().subscribe({
      next: (data) => {
        this.vehicules.set(data);
      },
      error: (err) => {
        this.errorMessage.set("Impossible de se connecter !");
        console.error(err);
      }
    });
  }
}
