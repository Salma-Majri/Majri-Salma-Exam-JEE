package com.salma.majri.entities;

import com.salma.majri.enums.TypeMoto;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("MOTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moto extends Vehicule {
    private double cylindree;
    @Enumerated(EnumType.STRING)
    private TypeMoto typeMoto;
    private boolean casqueInclus;
}