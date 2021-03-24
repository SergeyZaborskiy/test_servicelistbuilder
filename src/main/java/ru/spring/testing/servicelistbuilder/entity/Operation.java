package ru.spring.testing.servicelistbuilder.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Operation {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Variables
    private String name;
    @OneToMany
    private List<SubOperation> subOperationList;

}
