package com.tekion.mongorepo.datasource.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "student")
public class Student {
    @Id
    private String id;

    private String name;
    private String email;

    @DBRef
    private Department department;
    @DBRef
    private List<Subject> subjects;

    @Transient
    private Double percentage;

    public Student() {
    }

//    @PersistenceConstructor
    public Student(String name, String email, Department department, List<Subject> subjects) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Double getPercentage() {
        if(subjects != null && subjects.size() >0) {
            int total = 0 ;

            for(Subject subject: subjects) {
                total += subject.getMarks();
            }
            return (double )total/subjects.size();
        }
        return 0.0;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + email + "\n";
    }
}
