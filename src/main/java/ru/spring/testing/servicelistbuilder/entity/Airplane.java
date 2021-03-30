package ru.spring.testing.servicelistbuilder.entity;

import ru.spring.testing.servicelistbuilder.entity.operation.Operation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airplanes")
public class Airplane {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //Variables
    @Column(name = "model")
    private String model;
    @Column(name = "mass")
    private String mass;
    @Column(name = "max_fuel_capacity")
    private int maxFuelCapacity;
    @Column(name = "max_number_of_passengers")
    private int maxNumberOfPassengers;
    @Column(name = "max_number_of_baggages")
    private int maxNumberOfBaggage;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_schedule_id")
    private List<ServiceSchedule> serviceSchedules;


    //Constructors
    protected Airplane() {
    }

    public Airplane(String model, String mass, int maxFuelCapacity, int maxNumberOfPassengers, int maxNumberOfBaggage) {
        this.model = model;
        this.mass = mass;
        this.maxFuelCapacity = maxFuelCapacity;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
        this.maxNumberOfBaggage = maxNumberOfBaggage;
    }


    //Getters and Setters
    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public int getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public void setMaxFuelCapacity(int maxFuelCapacity) {
        this.maxFuelCapacity = maxFuelCapacity;
    }

    public int getMaxNumberOfPassengers() {
        return maxNumberOfPassengers;
    }

    public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
        this.maxNumberOfPassengers = maxNumberOfPassengers;
    }

    public int getMaxNumberOfBaggage() {
        return maxNumberOfBaggage;
    }

    public void setMaxNumberOfBaggage(int maxNumberOfBaggage) {
        this.maxNumberOfBaggage = maxNumberOfBaggage;
    }

    public List<ServiceSchedule> getServiceSchedules() {
        return serviceSchedules;
    }

    //Data initialization
    public void addServiceScheduleToAirplane(ServiceSchedule serviceSchedule) {
        if (serviceSchedules == null) {
            serviceSchedules = new ArrayList<>();
        }
        serviceSchedules.add(serviceSchedule);
    }

}
