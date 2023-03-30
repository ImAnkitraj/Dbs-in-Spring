package com.tekion.udemyjpahibernate.datasource.repository;

import com.tekion.udemyjpahibernate.datasource.model.Course;
import com.tekion.udemyjpahibernate.datasource.model.Passport;
import com.tekion.udemyjpahibernate.datasource.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(long id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {
        if (student.getId() == 0l) {
            em.persist(student);
            return student;
        }

        em.merge(student);
        return student;
    }


    public Student saveStudentWithPassport() {
        Passport passport = new Passport("12345");
        em.persist(passport);
        Student student = new Student("____");
        student.setPassport(passport);
        em.persist(student);
        return student;
    }

    public Student saveStudentWithCourse(Student student, Course course) {

        em.persist(student);
        em.persist(course);

        student.addCourse(course);
        course.addStudent(student);
        return student;
    }

    public void deleteById(long id) {
        Student student = findById(id);
        em.remove(student);
    }

    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("Select c From Student c", Student.class);
        List<Student> resultList = query.getResultList();
        return resultList;
    }

    public void findStudentWithPassport(long id) {
        Student student = em.find(Student.class,id);
        System.out.println(student);
        Passport passport = student.getPassport();
        System.out.println(passport);

    }

    @Transactional
    public void retrievePassportAssociatedStudent(long id) {
        Passport passport = em.find(Passport.class, id);
        System.out.println(passport);
        System.out.println(passport.getStudent());
    }

    @Transactional
    public void retrieveStudentAndCourses(long id) {
        Student student = em.find(Student.class, id);
        System.out.println(student);
        List<Course> courses = student.getCourses();
        System.out.println(courses);
    }
}



