package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.*;

@Entity
@Table(name="airports")
public class Airport {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Variable
    @Column(name="name")
    private String name;
    @Column(name="icao")
    private String icao;
    @Column(name="country")
    private String country;

    //Constructor
    protected Airport() {
    }

    public Airport(String name, String icao, String county) {
        this.name = name;
        this.icao = icao;
        this.country = county;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setCountry(String county) {
        this.country = county;
    }

}
