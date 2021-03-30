package ru.spring.testing.servicelistbuilder.entity.operation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "suboperations")
public class SubOperation {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    //Variables
    @Column(name = "name")
    private String name;
    @Column(name = "normative_duration")
    private int normativeDuration;
    @Column(name = "actual_duration")
    private int actualDuration;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id")
    private Operation operation;


    //Constructors
    public SubOperation() {
    }

    public SubOperation(String name) {
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

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getNormativeDuration() {
        return normativeDuration;
    }

    public void setNormativeDuration(int normativeDuration) {
        this.normativeDuration = normativeDuration;
    }

    public int getActualDuration() {
        return actualDuration;
    }

    public void setActualDuration(int actualDuration) {
        this.actualDuration = actualDuration;
    }

}
