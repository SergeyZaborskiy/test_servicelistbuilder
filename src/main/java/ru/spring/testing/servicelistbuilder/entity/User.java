package ru.spring.testing.servicelistbuilder.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    //Primary key
    @Id
    @GeneratedValue()
    private int id;

    //Variable

    private String firstName;
    private String secondName;
    private String password;
    private String email;

    private UserRole userRole;

    //Constructors


    protected User() {
    }

    public User(String firstName, String secondName, String password, String email, UserRole userRole) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }
}
