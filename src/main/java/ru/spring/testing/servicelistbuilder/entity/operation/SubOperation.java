package ru.spring.testing.servicelistbuilder.entity.operation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name="suboperations")
public class SubOperation {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Variables
    @Column(name="name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="operation_id")
    private Operation operation;


    //Constructors

    public SubOperation() {
    }

    public SubOperation(String name, Operation operation) {
        this.name = name;
        this.operation = operation;
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
