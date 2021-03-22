package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.Arrival;

@Repository
public interface ArrivalRepository extends CrudRepository<Arrival, Long> {

}
