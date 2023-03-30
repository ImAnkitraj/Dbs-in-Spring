package com.tekion.udemyjpahibernate.datasource.repository;

import com.tekion.udemyjpahibernate.datasource.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByName(String name);
    List<Course> findByNameAndId(String name, long id);
    List<Course> findByNameAndIdOrderByName(String name, long id);
    List<Course> findByNameAndIdOrderByNameDesc(String name, long id);
    int deleteByName(String name);
    int countByName(String name);

    @Query("Select c From Course c")
    List<Course> getAll();
    @Query(value = "Select c From Course c", nativeQuery = true)
    List<Course> getAllNative();


}
