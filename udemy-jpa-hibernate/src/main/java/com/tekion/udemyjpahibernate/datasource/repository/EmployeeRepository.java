package com.tekion.udemyjpahibernate.datasource.repository;

import com.tekion.udemyjpahibernate.datasource.model.Course;
import com.tekion.udemyjpahibernate.datasource.model.Employee;
import com.tekion.udemyjpahibernate.datasource.model.Review;
import com.tekion.udemyjpahibernate.datasource.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    @Autowired
    EntityManager em;

    public void insert(Employee employee) {
        em.persist(employee);
    }

    public List<Employee> findAll() {
        List<Employee> employees = em.createQuery("select e from Employee e", Employee.class).getResultList();
        return employees;
    }

}



