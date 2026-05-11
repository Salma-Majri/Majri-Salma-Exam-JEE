package com.salma.majri.services.impl;

import com.salma.majri.dtos.AgenceDTO;
import com.salma.majri.dtos.LocationDTO;
import com.salma.majri.entities.Agence;
import com.salma.majri.entities.Location;
import com.salma.majri.entities.Vehicule;
import com.salma.majri.mappers.LocationMapper;
import com.salma.majri.repositories.AgenceRepository;
import com.salma.majri.repositories.LocationRepository;
import com.salma.majri.repositories.VehiculeRepository;
import com.salma.majri.services.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;
    private final LocationRepository locationRepository;
    private final LocationMapper dtoMapper;

    @Override
    public AgenceDTO saveAgence(AgenceDTO agenceDTO) {
        Agence agence = dtoMapper.fromAgenceDTO(agenceDTO);
        Agence savedAgence = agenceRepository.save(agence);
        return dtoMapper.fromAgence(savedAgence);
    }

    @Override
    public List<AgenceDTO> listAgences() {
        List<Agence> agences = agenceRepository.findAll();
        return agences.stream()
                .map(dtoMapper::fromAgence)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO createLocation(LocationDTO locationDTO) throws Exception {
        Vehicule vehicule = vehiculeRepository.findById(locationDTO.getVehiculeId())
                .orElseThrow(() -> new Exception("Vehicule non trouve avec l'ID: " + locationDTO.getVehiculeId()));

        Location location = dtoMapper.fromLocationDTO(locationDTO);
        location.setVehicule(vehicule);

        Location savedLocation = locationRepository.save(location);
        return dtoMapper.fromLocation(savedLocation);
    }

    @Override
    public List<LocationDTO> listLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(dtoMapper::fromLocation)
                .collect(Collectors.toList());
    }
}