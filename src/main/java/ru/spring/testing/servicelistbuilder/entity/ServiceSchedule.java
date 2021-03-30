package ru.spring.testing.servicelistbuilder.entity;

import ru.spring.testing.servicelistbuilder.entity.operation.Operation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "service_schedules")
public class ServiceSchedule {
    //Primary Key
    @Id
    @GeneratedValue
    private long id;


    //Variables
    @Column(name = "shedule_id")
    String scheduleID;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @ManyToOne
    @JoinColumn(name = "airport_id")
    private Airport airport;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id")
    private List<Operation> operations;


    //Constructors
    public ServiceSchedule() {
    }

    public ServiceSchedule(String scheduleID) {
        this.scheduleID = scheduleID;
    }


    //Getters and setters
    public long getId() {
        return id;
    }

    public String getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(String scheduleID) {
        this.scheduleID = scheduleID;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Airport getAirport() {
        return airport;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    //Data initialization
    public void addAirport(Airport airport) {
        this.airport = airport;
    }

    public void addAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public void addOperationsToServiceSchedule(Operation operation) {
        if (operations == null) {
            operations = new ArrayList<>();
        }
        operations.add(operation);
    }


}
