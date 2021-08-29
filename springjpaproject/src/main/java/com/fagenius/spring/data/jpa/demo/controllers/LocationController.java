package com.fagenius.spring.data.jpa.demo.controllers;

import com.fagenius.spring.data.jpa.demo.entities.Location;
import com.fagenius.spring.data.jpa.demo.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public List<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

    @RequestMapping(value = "/locations/add",method = RequestMethod.POST)
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.GET )
    public Optional<Location> getLocation(@PathVariable String id){
        return locationService.getLocation(id);
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.PUT)
    public void updateLocation(@RequestBody Location location, @PathVariable String id){
        for (int i=0; i<locationService.getAllLocations().size(); i++){
            Location ln = locationService.getAllLocations().get(i);
            if(ln.getId().equals(id)){
                locationService.updateLocation(location,id);
            }
        }
    }

    @RequestMapping(value = "/locations/{id}", method = RequestMethod.DELETE)
    public void deleteLocation(@PathVariable String id){
        locationService.deleteLocation(id);
    }

}
