package com.tekion.udemyjpahibernate.datasource.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{

    private BigDecimal hourlyWage;

    public  PartTimeEmployee(){}


    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
