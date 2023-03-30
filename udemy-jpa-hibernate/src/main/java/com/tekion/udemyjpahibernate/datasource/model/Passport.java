package com.tekion.udemyjpahibernate.datasource.model;

import jakarta.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private long id;
    private String number;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;
    public Passport(){}
    public Passport(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getNumber() {
        return number;
    }

    public long getId() {
        return id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "\n[ " + id + " " + number + " ]";
    }
}
