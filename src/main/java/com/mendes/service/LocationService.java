package com.mendes.service;

import com.mendes.model.entity.Location;
import com.mendes.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by mendesmustafa on 12.03.2021.
 */

@Service
public class LocationService {

    private LocationRepository locationRepository;

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

    public Location save(Location model) {
        locationRepository.save(model);
        return model;
    }

    public List<Location> list() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

    public void save(String city, String district) {
        Location location = new Location();
        location.setCity(city);
        location.setDistrict(district);
        locationRepository.save(location);
    }
}
