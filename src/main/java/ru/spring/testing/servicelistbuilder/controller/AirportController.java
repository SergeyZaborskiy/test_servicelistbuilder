package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.service.AirportService;

import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping
    public String showAirportsPage(Model model){
        List<Airport> airportList = airportService.showAllAirportList();
        model.addAttribute("airports", airportList);
        return "airports/index";
    }

    @GetMapping("/new")
    public String showNewAirportForm(@ModelAttribute("airport") Airport airport, Model model) {
        model.addAttribute(airport);
        return "airports/form";
    }

    @PostMapping
    public String addNewAirport(@ModelAttribute("airport") Airport airport, Model model) {
        airportService.saveOrUpdate(airport);
        return "redirect:/airports";
    }

    @DeleteMapping("/{id}")
    public String deleteAirport(@PathVariable long id, Model model) {
        airportService.deleteAirportById(id);
        return "redirect:/airports";
    }

    @PutMapping("/{id}")
    public String findAirportById(@PathVariable long id, Model model){
        Airport airport = airportService.findAirportById(id);
        model.addAttribute("airport", airport);
        return "airports/form";
    }

}
