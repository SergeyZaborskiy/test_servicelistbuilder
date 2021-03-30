package ru.spring.testing.servicelistbuilder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.testing.servicelistbuilder.entity.ServiceSchedule;
import ru.spring.testing.servicelistbuilder.repository.ServiceScheduleRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceScheduleService {

    @Autowired
    ServiceScheduleRepository serviceScheduleRepository;

    @Transactional
    public List<ServiceSchedule> showAllServiceScheduleList() {
        return (List<ServiceSchedule>) serviceScheduleRepository.findAll();
    }

    @Transactional
    public void saveOrUpdate(ServiceSchedule serviceSchedule) {
        serviceScheduleRepository.save(serviceSchedule);
    }

    @Transactional
    public ServiceSchedule findOperationById(long id) {
        return serviceScheduleRepository.findById(id);
    }

    @Transactional
    public void deleteOperationById(long id) {
        serviceScheduleRepository.deleteById(id);
    }

}
