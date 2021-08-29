package com.fagenius.spring.data.jpa.demo.services;

import com.fagenius.spring.data.jpa.demo.entities.Location;
import com.fagenius.spring.data.jpa.demo.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(){
        List<Location> locations = new ArrayList<>();
        locationRepository.findAll().forEach(locations::add);
        return locations;
    }

    public Optional<Location> getLocation(String id){
        return locationRepository.findById(id);
    }

    public void addLocation(Location location){
        locationRepository.save(location);
    }

    public void updateLocation(Location location, String id){
        locationRepository.save(location);
    }

    public void deleteLocation(String id){
        locationRepository.deleteById(id);
    }
}
