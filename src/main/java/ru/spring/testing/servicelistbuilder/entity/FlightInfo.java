package ru.spring.testing.servicelistbuilder.entity;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "flight_infos")
public class FlightInfo {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Variables
    @Column(name = "route_id")
    private String routeID;

    @Column(name = "time_of_parking")
    private int timeOfParking;

    @Column(name = "number_of_passengers")
    private int numberOfPassengers;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_of_arrival_id")
    private Airport airportOfArrival;

/*    @Column(name = "airport_of_arrival_id")
    private long airportOfArrivalID;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airport_of_departure_id")
    private Airport airportOfDeparture;

/*    @Column(name = "airport_of_departure_id")
    private long airportOfDepartureID;*/

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_of_plane_id")
    private Airplane typeOfPlane;

/*    @Column(name = "type_of_plane_id")
    private long typeOfPlaneID;*/


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

}
