package ru.spring.testing.servicelistbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.spring.testing.servicelistbuilder.entity.Contractor;
import ru.spring.testing.servicelistbuilder.repository.ContractorRepository;

import java.util.List;

@Service
public class ContractorService {

    @Autowired
    ContractorRepository contractorRepository;

    @Transactional
    public List<Contractor> showAllContractorList() {
        List<Contractor> returnedList = (List<Contractor>) contractorRepository.findAll();
        return returnedList;

    }

    @Transactional
    public void saveOrUpdate(Contractor contractor) {
        contractorRepository.save(contractor);
    }

    @Transactional
    public Contractor findFlightInfoById(long id) {
        return contractorRepository.findContractorById(id);
    }

    @Transactional
    public void deleteContractorById(long id) {
        contractorRepository.deleteById(id);
    }

}
