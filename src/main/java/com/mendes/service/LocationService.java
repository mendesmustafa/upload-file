package com.mendes.service;

import com.mendes.model.dto.LocationDto;
import com.mendes.model.entity.Location;
import com.mendes.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by mendesmustafa on 12.03.2021.
 */

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location findById(Long id) {
        Location location = null;
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isPresent()) {
            location = locationOptional.get();
        }
        return location;
    }

    public LocationDto getById(Long id) {
        Location location = findById(id);
        return fillLocationDto(location);
    }

    public LocationDto save(LocationDto locationDto) {
        Location location = new Location();
        location.setCity(locationDto.getCity());
        location.setDistrict(locationDto.getDistrict());
        locationRepository.save(location);
        locationDto.setId(location.getId());
        return locationDto;
    }

    public List<LocationDto> list() {
        return locationRepository.findAll().stream().map(this::fillLocationDto).collect(Collectors.toList());
    }

    private LocationDto fillLocationDto(Location location) {
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setCity(location.getCity());
        locationDto.setDistrict(location.getDistrict());
        return locationDto;
    }

    public void save(String city, String district) {
        Location location = new Location();
        location.setCity(city);
        location.setDistrict(district);
        locationRepository.save(location);
    }
}
