package ru.spring.testing.servicelistbuilder.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    //Primary key
    @Id
    @GeneratedValue()
    private long id;

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

    //Getters and setteers


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

}
