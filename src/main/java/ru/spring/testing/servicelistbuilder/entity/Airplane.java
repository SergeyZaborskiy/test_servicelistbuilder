package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.*;

@Entity
@Table(name="airplanes")
public class Airplane {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Variables
    @Column(name="model")
    private String model;
    @Column(name="mass")
    private String mass;
    @Column(name="max_fuel_capacity")
    private int maxFuelCapacity;
    @Column(name="max_number_of_passengers")
    private int maxNumberOfPassengers;

    //Constructors
    protected Airplane() {
    }

    public Airplane(String model, String mass, int maxFuelCapacity, int maxNumberOfPassengers) {
        this.model = model;
        this.mass = mass;
        this.maxFuelCapacity = maxFuelCapacity;
        this.maxNumberOfPassengers = maxNumberOfPassengers;
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
}
