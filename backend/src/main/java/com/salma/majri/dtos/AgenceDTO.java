package com.salma.majri.dtos;

import lombok.Data;

@Data
public class AgenceDTO {
    private Long id;
    private String nom;
    private String adresse;
    private String ville;
    private String telephone;
}