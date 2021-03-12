package com.mendes.controller;

import com.mendes.model.entity.Location;
import com.mendes.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by mendesmustafa on 12.03.2021.
 */

@Controller
@RequestMapping("/location")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Location> locations = locationService.list();
        model.addAttribute("locations", locations);
        return "location-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        return "location-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("location") Location location) {
        locationService.save(location);
        return "redirect:/location/list";
    }
}
