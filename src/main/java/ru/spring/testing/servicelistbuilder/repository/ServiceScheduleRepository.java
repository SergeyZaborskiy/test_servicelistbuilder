package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.ServiceSchedule;

@Repository
public interface ServiceScheduleRepository extends CrudRepository<ServiceSchedule, Long> {

    ServiceSchedule findById(long id);

    void deleteById(long id);

}
