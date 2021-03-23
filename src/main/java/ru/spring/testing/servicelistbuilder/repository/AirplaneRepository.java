package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Airport;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, Long> {

    public void deleteAirplaneById(long id);

    public Airplane findAirplaneById(long id);

}
