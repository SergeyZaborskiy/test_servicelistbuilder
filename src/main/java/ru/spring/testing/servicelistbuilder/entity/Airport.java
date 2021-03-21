package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Airport {
    //Key
    @Id
    @GeneratedValue
    private int id;

    //Variable
    private String name;
    private String icao;
    private String county;

    //Constructor
    protected Airport() {
    }

    public Airport(int id, String name, String icao, String county) {
        this.name = name;
        this.icao = icao;
        this.county = county;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
