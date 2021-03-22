package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airplane {
    //Primary key
    @Id
    @GeneratedValue
    private long id;

    //Variables
    private String model;

    private String mass;

    private String maxFuelCapacity;

    private int maxNumberOfPassenger;

    //Constructors
    protected Airplane() {
    }

    public Airplane(String model, String mass, String maxFuelCapacity, int maxNumberOfPassenger) {
        this.model = model;
        this.mass = mass;
        this.maxFuelCapacity = maxFuelCapacity;
        this.maxNumberOfPassenger = maxNumberOfPassenger;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMaxFuelCapacity() {
        return maxFuelCapacity;
    }

    public void setMaxFuelCapacity(String maxFuelCapacity) {
        this.maxFuelCapacity = maxFuelCapacity;
    }

    public int getMaxNumberOfPassenger() {
        return maxNumberOfPassenger;
    }

    public void setMaxNumberOfPassenger(int maxNumberOfPassenger) {
        this.maxNumberOfPassenger = maxNumberOfPassenger;
    }

}
