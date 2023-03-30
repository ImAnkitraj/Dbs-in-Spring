package com.tekion.udemyjpahibernate.datasource.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name = "EmployeeType")
public abstract class Employee {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n Employee : [ " + id + " " + name + " ]";
    }
}
