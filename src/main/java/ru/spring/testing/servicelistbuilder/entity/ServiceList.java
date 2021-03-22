package ru.spring.testing.servicelistbuilder.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ServiceList {
    //Primary key
    @Id
    @GeneratedValue
    private long id;

    //Variables
    private String serviceName;

    //Constructor
    public ServiceList() {
    }

    public ServiceList(String serviceName) {
        this.serviceName = serviceName;
    }

    //Getters and Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
