//package com.tekion.udemyjpahibernate;
//
//import static org.junit.jupiter.api.Assertions.*;
//import com.tekion.udemyjpahibernate.datasource.model.Course;
//import com.tekion.udemyjpahibernate.datasource.repository.CourseRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest(classes = UdemyJpaHibernateApplication.class)
//public class CourseRepositoryTest {
//
//
//    @Autowired
//    CourseRepository courseRepository;
//    @Test
//    void test() {
//        Course course = courseRepository.findById(1001);
//        System.out.println(course);
//        assertEquals(course.getName(), "anki");
//    }
//}
