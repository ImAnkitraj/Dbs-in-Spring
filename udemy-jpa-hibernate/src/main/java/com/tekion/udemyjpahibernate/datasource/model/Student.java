package com.tekion.udemyjpahibernate.datasource.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(indexes = {
        @Index(columnList = "name"),
        @Index(name = "fn_index", columnList = "name"),
        @Index(name = "mulitIndex1", columnList = "name, id"),
        @Index(name = "mulitIndex2", columnList = "id, name"),
        @Index(name = "mulitSortIndex", columnList = "name, id DESC"),
        @Index(name = "uniqueIndex", columnList = "name", unique = true),
        @Index(name = "uniqueMulitIndex", columnList = "name, id", unique = true)
})
public class Student {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @Embedded
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany
    @JoinTable(name = "STUDENT_COURSE",
               joinColumns = @JoinColumn(name = "STUDENT_ID"),
               inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "\n[ " + id + " " + name + " ]";
    }
}
