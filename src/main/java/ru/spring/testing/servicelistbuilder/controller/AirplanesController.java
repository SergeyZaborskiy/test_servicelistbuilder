package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.service.AirplaneService;


import java.util.List;

@Controller
@RequestMapping("/airplanes")
public class AirplanesController {

    @Autowired
    AirplaneService airplaneService;

    @GetMapping
    public String showAirportsPage(Model model){
        List<Airplane> airplaneList = airplaneService.showAllAirportList();
        model.addAttribute("airplanes", airplaneList);
        return "airplanes/index";
    }

    @GetMapping("/new")
    public String showNewAirportForm(@ModelAttribute("airplane") Airplane airplane, Model model) {
        model.addAttribute(airplane);
        return "airports/form";
    }

    @PostMapping
    public String addNewAirport(@ModelAttribute("airplane") Airplane airplane, Model model) {
        airplaneService.saveOrUpdate(airplane);
        return "redirect:/airports";
    }

    @DeleteMapping("/{id}")
    public String deleteAirplane(@PathVariable long id, Model model) {
        airplaneService.deleteAirplaneById(id);
        return "redirect:/airplanes";
    }

    @PutMapping("/{id}")
    public String findAirplaneById(@PathVariable long id, Model model){
        Airport airport = airplaneService.findAirplaneById(id);
        model.addAttribute("airplane", airport);
        return "airplanes/form";
    }

}
