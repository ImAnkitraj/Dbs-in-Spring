package com.tekion.udemyjpahibernate.datasource.repository;

import com.tekion.udemyjpahibernate.datasource.model.Course;
import com.tekion.udemyjpahibernate.datasource.model.Review;
import com.tekion.udemyjpahibernate.datasource.model.Student;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.weaver.patterns.IScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(long id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {
        if (course.getId() == 0l) {
            em.persist(course);
            //            em.flush();
            //            em.detach(course);

            //            course.setName("New");
            //            em.refresh(course);
            return course;
        }

        em.merge(course);
        return course;
    }

    public void deleteById(long id) {
        Course course = findById(id);
        em.remove(course);
    }

    public List<Course> findAll() {
        //        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        //        TypedQuery<Course> query = em.createNamedQuery("query_get_all", Course.class);



        Query query = em.createNativeQuery("Select * from Course", Course.class);
        //        Query query = em.createNativeQuery("Select * from Course where id = ?", Course.class);
        //        query.setParameter("id", 100);
        List<Course> resultList = query.getResultList();

        //        Query query1 = em.createNamedQuery("Update Course set last_updated_timestamp = sysdate()");
        //        int rows = query1.executeUpdate()
        return resultList;
    }

    public List<Course> findAllEntityGraph() {
        EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);

        Subgraph<Object> sub = entityGraph.addKeySubgraph("students");
        Query query = em.createNativeQuery("Select * from Course", Course.class).setHint("javax.persistence" +
                                                                                         ".loadgraph", "students");
        List<Course> resultList = query.getResultList();
        return resultList;
    }

    public List<Course> findAllJoinFtech() {
        Query query = em.createQuery("Select c from Course c JOIN FETCH c.students s", Course.class);
        List<Course> resultList = query.getResultList();
        return resultList;
    }
    public void addReviewsForCourse(long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        System.out.println("course reviews ------ > " + course.getReviews());
        for (Review r : reviews) {
            r.setCourse(course);
            course.addReview(r);
            em.persist(r);
        }
    }


//    @Transactional
    public List<Review> getReviewsForCourse(long id) {
        Course course = em.find(Course.class, id);
        System.out.println(course);
        List<Review> reviews = course.getReviews();
        return new ArrayList<>(reviews);
    }

//    @Transactional
    public Course getCourseForReview(long id) {
            Review review = em.find(Review.class, id);
            System.out.println(review);
            Course course=  review.getCourse();
            System.out.println(course);
            return course;
    }
    @Transactional
    public void retrieveCourseAndStudents(long id) {
        Course course = em.find(Course.class, id);
        System.out.println(course);
        List<Student> students = course.getStudents();
        System.out.println(students);
    }

    public void criteriaQuery() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate like = cb.like(courseRoot.get("name"), "%10");
        cq.where(like);

        courseRoot.join("students", JoinType.LEFT);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> courses = query.getResultList();


        System.out.println(courses);
    }


}



