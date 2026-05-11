package com.salma.majri;

import com.salma.majri.entities.*;
import com.salma.majri.enums.StatutVehicule;
import com.salma.majri.enums.TypeCarburant;
import com.salma.majri.enums.TypeMoto;
import com.salma.majri.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AgenceRepository agenceRepository,
                            VehiculeRepository vehiculeRepository,
                            LocationRepository locationRepository) {
        return args -> {
            Agence agence1 = agenceRepository.save(new Agence(null, "Agence Mohammedia", "Bd Hassan II", "Mohammedia", "0523123456"));
            Agence agence2 = agenceRepository.save(new Agence(null, "Agence Casablanca", "Anfa", "Casablanca", "0522987654"));
            Voiture voiture = new Voiture();
            voiture.setMarque("Dacia");
            voiture.setModele("Sandero");
            voiture.setMatricule("12345-A-1");
            voiture.setPrixParJour(300.0);
            voiture.setDateMiseEnService(new Date());
            voiture.setStatut(StatutVehicule.DISPONIBLE);
            voiture.setAgence(agence1);
            voiture.setNombrePortes(5);
            voiture.setTypeCarburant(TypeCarburant.DIESEL);
            voiture.setBoiteVitesse("Manuelle");
            vehiculeRepository.save(voiture);

            Moto moto = new Moto();
            moto.setMarque("Yamaha");
            moto.setModele("TMAX");
            moto.setMatricule("67890-B-20");
            moto.setPrixParJour(500.0);
            moto.setDateMiseEnService(new Date());
            moto.setStatut(StatutVehicule.DISPONIBLE);
            moto.setAgence(agence2);
            moto.setCylindree(530.0);
            moto.setTypeMoto(TypeMoto.SPORTIVE);
            moto.setCasqueInclus(true);
            vehiculeRepository.save(moto);

            Location location = new Location(null, new Date(), new Date(), 900.0, voiture);
            locationRepository.save(location);

            System.out.println("--- Couche DAO testee avec succes ! ---");
        };
    }
}