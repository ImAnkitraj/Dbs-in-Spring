package com.tekion.udemyjpahibernate.datasource.model;

import com.tekion.udemyjpahibernate.datasource.enums.ReviewRating;
import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(value = EnumType.STRING)
    private ReviewRating rating;
    private String description;

    @ManyToOne
    private Course course;


    public Review(){}
    public Review(ReviewRating rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public ReviewRating getRating() {
        return rating;
    }

    public void setRating(ReviewRating rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "\n[ " + id + " " + description + " ]";
    }
}
