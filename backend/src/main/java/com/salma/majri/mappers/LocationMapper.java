package com.salma.majri.mappers;

import com.salma.majri.dtos.AgenceDTO;
import com.salma.majri.dtos.LocationDTO;
import com.salma.majri.entities.Agence;
import com.salma.majri.entities.Location;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class LocationMapper {

    public AgenceDTO fromAgence(Agence agence) {
        if (agence == null) return null;
        AgenceDTO dto = new AgenceDTO();
        BeanUtils.copyProperties(agence, dto);
        return dto;
    }

    public Agence fromAgenceDTO(AgenceDTO dto) {
        if (dto == null) return null;
        Agence agence = new Agence();
        BeanUtils.copyProperties(dto, agence);
        return agence;
    }

    public LocationDTO fromLocation(Location location) {
        if (location == null) return null;
        LocationDTO dto = new LocationDTO();
        BeanUtils.copyProperties(location, dto);
        if (location.getVehicule() != null) {
            dto.setVehiculeId(location.getVehicule().getId());
        }
        return dto;
    }

    public Location fromLocationDTO(LocationDTO dto) {
        if (dto == null) return null;
        Location location = new Location();
        BeanUtils.copyProperties(dto, location);
        return location;
    }
}