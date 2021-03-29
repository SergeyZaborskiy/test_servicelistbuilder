package ru.spring.testing.servicelistbuilder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.entity.FlightInfo;
import ru.spring.testing.servicelistbuilder.service.AirplaneService;
import ru.spring.testing.servicelistbuilder.service.AirportService;
import ru.spring.testing.servicelistbuilder.service.FlightInfoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    FlightInfoService flightInfoService;
    @Autowired
    AirportService airportService;
    @Autowired
    AirplaneService airplaneService;

    @GetMapping("/flightInfos")
    public List<FlightInfo> showAllFlightInfoList() {
        List<FlightInfo> returnedList = flightInfoService.showAllFlightInfoList();
        return returnedList;
    }

    @GetMapping("/airplanes")
    public List<Airplane> showAllAirplaneList() {
        List<Airplane> returnedList = airplaneService.showAllAirplaneList();
        return returnedList;
    }

    @GetMapping("/airports")
    public List<Airport> showAllAirportList() {
        List<Airport> returnedList = airportService.showAllAirportList();
        return returnedList;
    }
}
