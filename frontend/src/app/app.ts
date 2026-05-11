import { Component, signal, computed, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule, NgClass, NgForOf, NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Location } from './services/location';
import { Vehicule } from './models/location';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, FormsModule, NgClass, NgForOf, NgIf],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App implements OnInit {
  protected readonly title = signal('AppEnset');
  protected readonly vehicules = signal<Array<Vehicule>>([]);

  // 1. Signal dial l-kalma lli k-n-qlbo 3liha
  protected readonly searchTerm = signal<string>('');

  // 2. Filtrage automatique (computed signal)
  protected readonly filteredVehicules = computed(() => {
    const term = this.searchTerm().toLowerCase().trim();
    if (!term) return this.vehicules();

    return this.vehicules().filter(v =>
      v.marque.toLowerCase().includes(term) ||
      v.modele.toLowerCase().includes(term) ||
      v.matricule.toLowerCase().includes(term)
    );
  });

  constructor(private locationService: Location) {}

  ngOnInit(): void {
    this.locationService.getVehicules().subscribe({
      next: (data) => {
        this.vehicules.set(data);
      },
      error: (err) => {
        console.error("Backend error: ", err);
      }
    });
  }
}
