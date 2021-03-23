package ru.spring.testing.servicelistbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.testing.servicelistbuilder.entity.FlightInfo;
import ru.spring.testing.servicelistbuilder.repository.FlightInfoRepository;

import java.util.List;

@Service
public class FlightInfoService {

    @Autowired
    FlightInfoRepository flightInfoRepository;

    @Transactional
    public  List<FlightInfo> showAllFlightInfoList() {
        List<FlightInfo> returnedList = (List<FlightInfo>) flightInfoRepository.findAll();
        return returnedList;

    }

    @Transactional
    public void saveOrUpdate(FlightInfo flightInfo) {
        flightInfoRepository.save(flightInfo);
    }

    @Transactional
    public FlightInfo findFlightInfoById(long id){
        return flightInfoRepository.findById(id);
    }

    @Transactional
    public void deleteFlightInfoById(long id){
        flightInfoRepository.deleteById(id);
    }
}
