package com.salma.majri.services;

import com.salma.majri.dtos.AgenceDTO;
import com.salma.majri.dtos.LocationDTO;
import java.util.List;

public interface LocationService {
    AgenceDTO saveAgence(AgenceDTO agenceDTO);
    List<AgenceDTO> listAgences();
    LocationDTO createLocation(LocationDTO locationDTO) throws Exception;
    List<LocationDTO> listLocations();
}