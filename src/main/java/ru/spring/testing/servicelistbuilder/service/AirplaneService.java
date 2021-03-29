package ru.spring.testing.servicelistbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.repository.AirplaneRepository;
import ru.spring.testing.servicelistbuilder.repository.AirportRepository;

import java.util.List;

@Service
public class AirplaneService {

    @Autowired
    AirplaneRepository airplaneRepository;

    //Save or update to database method
    @Transactional
    public void saveOrUpdate(Airplane airplane) {
        airplaneRepository.save(airplane);
    }

    //Show list of all airplanes in database
    @Transactional
    public List<Airplane> showAllAirplaneList() {
        List<Airplane> airportList = (List<Airplane>) airplaneRepository.findAll();
        return airportList;
    }

    //Delete airplane
    @Transactional
    public void deleteAirplane(Airplane airplane) {
        airplaneRepository.delete(airplane);
    }

    @Transactional
    public void deleteAirplaneById(long id) {
        airplaneRepository.deleteAirplaneById(id);
    }

    //Find airplane by Id
    @Transactional
    public Airplane findAirplaneById(long id) {
        return airplaneRepository.findAirplaneById(id);
    }
}
