package ru.spring.testing.servicelistbuilder.entity.operation;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="operations")
public class Operation {
    //Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //Variables
    @Column(name="name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "operation")
    private List<SubOperation> subOperationList;

    //Constructor

    protected Operation() {
    }

    public Operation(String name, @Autowired List<SubOperation> subOperationList) {
        this.name = name;
        this.subOperationList = subOperationList;
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

    public List<SubOperation> getSubOperationList() {
        return subOperationList;
    }

    public void setSubOperationList(List<SubOperation> subOperationList) {
        this.subOperationList = subOperationList;
    }

    //One-to-many execute
    public void addSubOperationToOperation(SubOperation subOperation){
        if (subOperationList==null){
            subOperationList = new ArrayList<>();
        } else {
            subOperationList.add(subOperation);
            subOperation.setOperation(this);
        }
    }

}
