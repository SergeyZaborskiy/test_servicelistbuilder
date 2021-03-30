package ru.spring.testing.servicelistbuilder.entity;

import ru.spring.testing.servicelistbuilder.entity.operation.Operation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contractors")
public class Contractor {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //Variables
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "airport_contractor",
            joinColumns = @JoinColumn(name = "contractor_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id"))
    private List<Airport> airports;


    //Constructors
    public Contractor() {
    }

    public Contractor(String name) {
        this.name = name;
    }


    //Getters and Setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airport> getAirports() {
        return airports;
    }


    //Many to many add method
    public void addAirportToContractor(Airport airport) {
        if (airports == null) {
            airports = new ArrayList<>();
        }
        airports.add(airport);
    }

}
