package ru.spring.testing.servicelistbuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Contractor;

@Repository
public interface ContractorRepository extends CrudRepository<Contractor, Long> {

    public void deleteContractorById(long id);

    public Contractor findContractorById(long id);

}
