package ru.spring.testing.servicelistbuilder.data.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.testing.servicelistbuilder.entity.Airplane;
import ru.spring.testing.servicelistbuilder.entity.Airport;
import ru.spring.testing.servicelistbuilder.entity.Contractor;
import ru.spring.testing.servicelistbuilder.entity.ServiceSchedule;
import ru.spring.testing.servicelistbuilder.entity.operation.Operation;
import ru.spring.testing.servicelistbuilder.entity.operation.SubOperation;
import ru.spring.testing.servicelistbuilder.service.*;

import javax.annotation.PostConstruct;

@Component
public class AddDemoSource {

    @Autowired
    AirplaneService airplaneService;
    @Autowired
    AirportService airportService;
    @Autowired
    OperationService operationService;
    @Autowired
    ContractorService contractorService;
    @Autowired
    ServiceScheduleService serviceScheduleService;

    @PostConstruct
    public void update() {
        //Add airplane
        Airplane airplane1 = new Airplane("SU-29", "7500", 7500, 120, 200);
        Airplane airplane2 = new Airplane("Sj-1100", "5800", 5500, 90, 120);
        Airplane airplane3 = new Airplane("737-400", "8900", 9000, 170, 320);
        Airplane airplane4 = new Airplane("737-401", "9100", 9500, 184, 540);
        airplaneService.saveOrUpdate(airplane1);
        airplaneService.saveOrUpdate(airplane2);
        airplaneService.saveOrUpdate(airplane3);
        airplaneService.saveOrUpdate(airplane4);


        //Add airport
        Airport airport1 = new Airport("PULKOVO", "ULLU", "RUSSIA", "SPB");
        Airport airport2 = new Airport("MIN.VODI", "MVRL", "RUSSIA", "MRV");
        Airport airport3 = new Airport("LARNAKA", "KTGL", "CYPRYS", "LRN");
        airportService.saveOrUpdate(airport1);
        airportService.saveOrUpdate(airport2);
        airportService.saveOrUpdate(airport3);

        //Add contractor
        Contractor contractor1 = new Contractor("ООО Компания 1");
        Contractor contractor2 = new Contractor("ООО Компания 2");
        Contractor contractor3 = new Contractor("ООО Компания 3");
        contractor1.addAirportToContractor(airport1);
        contractor1.addAirportToContractor(airport2);
        contractor2.addAirportToContractor(airport2);
        contractor2.addAirportToContractor(airport3);
        contractor3.addAirportToContractor(airport3);
        contractor3.addAirportToContractor(airport1);
        contractorService.saveOrUpdate(contractor1);
        contractorService.saveOrUpdate(contractor2);
        contractorService.saveOrUpdate(contractor3);


        //Add operation
        Operation operation1 = new Operation("Прием ВС / Выпуск ВС");
        SubOperation subOperation1 = new SubOperation("Конусы безопасности");
        SubOperation subOperation2 = new SubOperation("Без конусов безопасности");
        SubOperation subOperation3 = new SubOperation("Установка колодок");
        SubOperation subOperation4 = new SubOperation("Подготовка места стоянки");
        SubOperation subOperation5 = new SubOperation("Открытие / Закрытие багажных люков и грузовых отсеков");
        SubOperation subOperation6 = new SubOperation("Открытие багажных люков и грузовых отсеков");
        SubOperation subOperation7 = new SubOperation("Закрытие багажных люков и грузовых отсеков");
        SubOperation subOperation8 = new SubOperation("Предоставление персонала для осмотра ВС");
        operation1.addSubOperationToOperation(subOperation1);
        operation1.addSubOperationToOperation(subOperation2);
        operation1.addSubOperationToOperation(subOperation3);
        operation1.addSubOperationToOperation(subOperation4);
        operation1.addSubOperationToOperation(subOperation5);
        operation1.addSubOperationToOperation(subOperation6);
        operation1.addSubOperationToOperation(subOperation7);
        operation1.addSubOperationToOperation(subOperation8);
        operationService.saveOrUpdate(operation1);

        //Add operation
        Operation operation2 = new Operation("Буксировка");
        SubOperation subOperation11 = new SubOperation("Буксировка + водило");
        SubOperation subOperation12 = new SubOperation("Буксировка без водило");
        operation2.addSubOperationToOperation(subOperation11);
        operation2.addSubOperationToOperation(subOperation12);
        operationService.saveOrUpdate(operation2);

        //Add operation
        Operation operation3 = new Operation("ВСУ");
        SubOperation subOperation21 = new SubOperation("ВСУ");
        operation3.addSubOperationToOperation(subOperation21);
        operationService.saveOrUpdate(operation3);

        //Add operation
        Operation operation4 = new Operation("НИП");
        SubOperation subOperation31 = new SubOperation("НИП стационарный");
        SubOperation subOperation32 = new SubOperation("НИП передвижной");
        operation4.addSubOperationToOperation(subOperation31);
        operation4.addSubOperationToOperation(subOperation32);
        operationService.saveOrUpdate(operation4);

        //Add service schedule
        ServiceSchedule serviceSchedule1 = new ServiceSchedule("v4001");
        serviceSchedule1.addAirplane(airplane1);
        serviceSchedule1.addAirport(airport1);
        ServiceSchedule serviceSchedule2 = new ServiceSchedule("v4001");
        serviceSchedule2.addAirplane(airplane2);
        serviceSchedule2.addAirport(airport2);
        serviceScheduleService.saveOrUpdate(serviceSchedule1);
        serviceScheduleService.saveOrUpdate(serviceSchedule2);


    }
}
