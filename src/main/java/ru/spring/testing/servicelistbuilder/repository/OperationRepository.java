package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.operation.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

    Operation findById(long id);

    void deleteById(long id);

}
