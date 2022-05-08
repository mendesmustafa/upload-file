package com.mendes.controller;

import com.mendes.model.dto.LocationDto;
import com.mendes.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * Created by mendesmustafa on 12.03.2021.
 */

@Controller
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("locations", locationService.list());
        return "location-list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("location", locationService.getById(id));
        return "location-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("location") LocationDto locationDto) {
        locationService.save(locationDto);
        return "redirect:/location/list";
    }
}
