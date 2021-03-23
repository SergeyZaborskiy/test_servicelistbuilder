package ru.spring.testing.servicelistbuilder.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FlightInfo {
    //Primary key
    @Id
    @GeneratedValue
    private long id;

    //Variables
    private String routeID;
    private int timeOfParking;
    private int numberOfPassengers;
    @ManyToOne
    private Airport airportOfArrival;
    private long airportOfArrivalID;
    @ManyToOne
    private Airport airportOfDeparture;
    private long airportOfDepartureID;
    @ManyToOne
    private Airplane typeOfPlane;
    private long typeOfPlaneID;


    //Constructors
    public FlightInfo() {
    }

    public FlightInfo(String routeID, int timeOfParking, int numberOfPassengers, Airport airportOfArrival, Airport airportOfDeparture, Airplane typeOfPlane) {
        this.routeID = routeID;
        this.timeOfParking = timeOfParking;
        this.numberOfPassengers = numberOfPassengers;
        this.airportOfArrival = airportOfArrival;
        this.airportOfDeparture = airportOfDeparture;
        this.typeOfPlane = typeOfPlane;
    }

    //Getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public int getTimeOfParking() {
        return timeOfParking;
    }

    public void setTimeOfParking(int timeOfParking) {
        this.timeOfParking = timeOfParking;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public Airport getAirportOfArrival() {
        return airportOfArrival;
    }

    @Autowired
    public void setAirportOfArrival(Airport airportOfArrival) {
        this.airportOfArrival = airportOfArrival;
    }

    public Airport getAirportOfDeparture() {
        return airportOfDeparture;
    }

    @Autowired
    public void setAirportOfDeparture(Airport airportOfDeparture) {
        this.airportOfDeparture = airportOfDeparture;
    }

    public Airplane getTypeOfPlane() {
        return typeOfPlane;
    }

    @Autowired
    public void setTypeOfPlane(Airplane typeOfPlane) {
        this.typeOfPlane = typeOfPlane;
    }

    public long getAirportOfArrivalID() {
        return airportOfArrivalID;
    }

    public void setAirportOfArrivalID(long airportOfArrivalID) {
        this.airportOfArrivalID = airportOfArrivalID;
    }

    public long getAirportOfDepartureID() {
        return airportOfDepartureID;
    }

    public void setAirportOfDepartureID(long airportOfDepartureID) {
        this.airportOfDepartureID = airportOfDepartureID;
    }

    public long getTypeOfPlaneID() {
        return typeOfPlaneID;
    }

    public void setTypeOfPlaneID(long typeOfPlaneID) {
        this.typeOfPlaneID = typeOfPlaneID;
    }
}
