package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.entity.FlightInfo;

import java.util.List;

@Repository
public interface FlightInfoRepository extends CrudRepository<FlightInfo, Long> {

    FlightInfo findById(long id);

    void deleteById(long id);
}
