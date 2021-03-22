package ru.spring.testing.servicelistbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.repository.AirportRepository;

import java.util.List;

@Service
public class AirportService {

    @Autowired
    AirportRepository airportRepository;

    //Save or update to database method
    @Transactional
    public void saveOrUpdate(Airport airport) {
        airportRepository.save(airport);
    }

    //Show list of all airports in database
    @Transactional
    public List<Airport> showAllAirportList(){
        List<Airport> airportList = (List<Airport>) airportRepository.findAll();
        return  airportList;
    }

    //Delete airport
    @Transactional
    public void deleteAirport(Airport airport){
        airportRepository.delete(airport);
    }
    @Transactional
    public void deleteAirportById(long id){
        airportRepository.deleteAirportById(id);
    }

    //Find airport by Id
    @Transactional
    public Airport findAirportById(long id){
        return airportRepository.findAirportById(id);
    }



}
