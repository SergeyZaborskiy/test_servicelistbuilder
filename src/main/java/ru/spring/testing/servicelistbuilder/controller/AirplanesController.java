package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.service.AirplaneService;


import java.util.List;

@Controller
@RequestMapping("/airplanes")
public class AirplanesController {

    @Autowired
    AirplaneService airplaneService;

    @GetMapping
    public String showAirplanePage(Model model){
        List<Airplane> airplaneList = airplaneService.showAllAirplaneList();
        model.addAttribute("airplanes", airplaneList);
        return "airplanes/index";
    }

    @GetMapping("/new")
    public String showNewAirplaneForm(Model model) {
        Airplane airplane = new Airplane(" ", " ", 0, 0);
        model.addAttribute("airplane", airplane);
        return "airplanes/form";
    }

    @PostMapping
    public String addNewAirplane(@ModelAttribute("airplane") Airplane airplane, Model model) {
        airplaneService.saveOrUpdate(airplane);
        return "redirect:/airplanes";
    }

    @DeleteMapping("/{id}")
    public String deleteAirplane(@PathVariable long id, Model model) {
        airplaneService.deleteAirplaneById(id);
        return "redirect:/airplanes";
    }

    @PutMapping("/{id}")
    public String findAirplaneById(@PathVariable long id, Model model){
        Airplane airplane = airplaneService.findAirplaneById(id);
        model.addAttribute("airplane", airplane);
        return "airplanes/form";
    }

}
