package ru.spring.testing.servicelistbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.testing.servicelistbuilder.entity.operation.Operation;
import ru.spring.testing.servicelistbuilder.repository.OperationRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OperationService {

    @Autowired
    OperationRepository operationRepository;

    @Transactional
    public List<Operation> showAllOperationList() {
        return (List<Operation>) operationRepository.findAll();
    }

    @Transactional
    public void saveOrUpdate(Operation operation) {
        operationRepository.save(operation);
    }

    @Transactional
    public Operation findOperationById(long id) {
        return operationRepository.findById(id);
    }

    @Transactional
    public void deleteOperationById(long id) {
        operationRepository.deleteById(id);
    }

}
