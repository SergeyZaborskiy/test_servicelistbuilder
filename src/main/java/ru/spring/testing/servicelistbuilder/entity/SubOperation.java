package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.*;

@Entity
public class SubOperation {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Variables
    private String name;
    @ManyToOne
    private Operation operation;



}
