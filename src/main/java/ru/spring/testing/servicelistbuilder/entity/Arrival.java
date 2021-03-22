package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Arrival {
    //Primary key
    @Id
    @GeneratedValue
    private long id;

    //Variables
    private String name;

    //Constructors
    public Arrival() {
    }

    public Arrival(String name) {
        this.name = name;
    }

    //Getters and setters
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
}
