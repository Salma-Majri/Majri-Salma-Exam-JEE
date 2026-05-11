package com.salma.majri.entities;

import com.salma.majri.enums.TypeCarburant;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("VOITURE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voiture extends Vehicule {
    private int nombrePortes;
    @Enumerated(EnumType.STRING)
    private TypeCarburant typeCarburant;
    private String boiteVitesse;
}