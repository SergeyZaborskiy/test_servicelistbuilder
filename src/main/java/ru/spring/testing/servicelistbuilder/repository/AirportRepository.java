package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long> {

    public void deleteAirportById(long id);

    public Airport findAirportById(long id);

}
