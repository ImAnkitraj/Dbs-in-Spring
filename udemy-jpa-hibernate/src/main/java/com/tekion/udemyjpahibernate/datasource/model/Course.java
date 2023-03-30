package com.tekion.udemyjpahibernate.datasource.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


//@Table(name = "Course")

//@NamedQueries(value = { @NamedQuery(name = "query_get_all", query = "Select c from Course c"), })
//@NamedQuery(name = "query_get_all", query = "Select c from Course c")
@Entity
@SQLDelete(sql = "update course set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class Course {

    @Id
    @GeneratedValue
    private long id;

    //    @Column(insertable = true, updatable = true, length = 255, nullable = false, unique = true)
    private String name;

    @CreationTimestamp
    private LocalDateTime createdTimestamp;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedTimestamp;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();


    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();

    private boolean isDeleted;

    @PreRemove
    private void preRemove() {
        this.isDeleted = true;
    }
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Course() {
    }
    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public Course(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public LocalDateTime getLastUpdatedTimestamp() {
        return lastUpdatedTimestamp;
    }

    public void setLastUpdatedTimestamp(LocalDateTime lastUpdatedTimestamp) {
        this.lastUpdatedTimestamp = lastUpdatedTimestamp;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        reviews.add(review);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
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
        return "\n[ " + id + " " + name + " " + createdTimestamp + " " + lastUpdatedTimestamp + " ]";
    }
}
