package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.entity.FlightInfo;
import ru.spring.testing.servicelistbuilder.service.AirplaneService;
import ru.spring.testing.servicelistbuilder.service.AirportService;
import ru.spring.testing.servicelistbuilder.service.FlightInfoService;

import java.util.List;

@Controller
@RequestMapping("/flightInfo")
public class FlightInfoController {

    @Autowired
    FlightInfoService flightInfoService;
    @Autowired
    AirportService airportService;
    @Autowired
    AirplaneService airplaneService;

    @GetMapping
    public String showFlightInfoPage(Model model){
        List<FlightInfo> flightInfoList = flightInfoService.showAllFlightInfoList();
        model.addAttribute("flightInfoList", flightInfoList);
        return "flightInfo/index";
    }

    @GetMapping("/new")
    public String showFlightInfoForm(@ModelAttribute("flightInfo") FlightInfo flightInfo, Model model){
        model.addAttribute("airplanes", getAirplaneList());
        model.addAttribute("airports", getAirportList());
        return "flightInfo/form";
    }

    @PostMapping
    public String addNewFlightInfo(@ModelAttribute("flightInfo") FlightInfo flightInfo, Model model){
        flightInfo.setAirportOfArrival(airportService.findAirportById(flightInfo.getAirportOfArrivalID()));
        flightInfo.setTypeOfPlane(airplaneService.findAirplaneById(flightInfo.getTypeOfPlaneID()));
        flightInfoService.saveOrUpdate(flightInfo);
        return "redirect:/flightInfo";
    }

    @PutMapping("/{id}")
    public String findFlightPlaneById(@PathVariable long id, Model model){
        FlightInfo returnedFlightInfo = flightInfoService.findFlightInfoById(id);
        model.addAttribute("flightInfo", returnedFlightInfo);
        model.addAttribute("airplanes", getAirplaneList());
        model.addAttribute("airports", getAirportList());
        return "flightInfo/form";
    }

    @DeleteMapping("/{id}")
    public String deleteFlightInfoById(@PathVariable long id, Model model){
        flightInfoService.deleteFlightInfoById(id);
        return "redirect:/flightInfo";
    }


    //other methods
    private List<Airplane> getAirplaneList(){
       return airplaneService.showAllAirplaneList();
    }
    private List<Airport> getAirportList(){
        return airportService.showAllAirportList();
    }
}
