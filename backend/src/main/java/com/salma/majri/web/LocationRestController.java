package com.salma.majri.web;

import com.salma.majri.dtos.AgenceDTO;
import com.salma.majri.dtos.LocationDTO;
import com.salma.majri.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.salma.majri.entities.Vehicule;
import com.salma.majri.repositories.VehiculeRepository;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin("*")
public class LocationRestController {

    private final LocationService locationService;
    private final VehiculeRepository vehiculeRepository;

    @GetMapping("/agences")
    public List<AgenceDTO> getAgences() {
        return locationService.listAgences();
    }

    @PostMapping("/agences")
    public AgenceDTO saveAgence(@RequestBody AgenceDTO agenceDTO) {
        return locationService.saveAgence(agenceDTO);
    }

    @GetMapping("/locations")
    public List<LocationDTO> getLocations() {
        return locationService.listLocations();
    }

    @PostMapping("/locations")
    public LocationDTO createLocation(@RequestBody LocationDTO locationDTO) throws Exception {
        return locationService.createLocation(locationDTO);
    }


    @GetMapping("/vehicules")
    public List<Vehicule> getVehicules() {
        return vehiculeRepository.findAll();
    }
}