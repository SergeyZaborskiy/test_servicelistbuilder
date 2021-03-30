package ru.spring.testing.servicelistbuilder.entity.operation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "operations")
public class Operation {
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
    private List<SubOperation> subOperationList;


    //Constructor
    public Operation() {
    }

    public Operation(String name) {
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

    public List<SubOperation> getSubOperationList() {
        return subOperationList;
    }

    public void setSubOperationList(List<SubOperation> subOperationList) {
        this.subOperationList = subOperationList;
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


    //One-to-many initialization
    public void addSubOperationToOperation(SubOperation subOperation) {
        if (subOperationList == null) {
            subOperationList = new ArrayList<>();
            subOperationList.add(subOperation);
            subOperation.setOperation(this);
        } else {
            subOperationList.add(subOperation);
            subOperation.setOperation(this);
        }
    }

}
