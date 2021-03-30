package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    //Variable
    @Column(name = "name")
    private String name;
    @Column(name = "icao")
    private String icao;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "airport_contractor",
            joinColumns = @JoinColumn(name = "airport_id"),
            inverseJoinColumns = @JoinColumn(name = "contractor_id"))
    private List<Contractor> contractors;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_schedule_id")
    private List<ServiceSchedule> serviceSchedules;


    //Constructor
    protected Airport() {
    }

    public Airport(String name, String icao, String county, String city) {
        this.name = name;
        this.icao = icao;
        this.country = county;
        this.city = city;
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

    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Contractor> getContractors() {
        return contractors;
    }

    public List<ServiceSchedule> getServiceSchedules() {
        return serviceSchedules;
    }


    //Many to many add method
    public void addContractorToAirport(Contractor contractor) {
        if (contractors == null) {
            contractors = new ArrayList<>();
        }
        contractors.add(contractor);
    }

}
