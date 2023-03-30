package com.tekion.mongorepo.datasource.repository;

import com.tekion.mongorepo.datasource.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    //    ONly work when embedded
    List<Student> findByDepartmentName(String name);

    List<Student> findBySubjectsName(String name);

    List<Student> findByDepartmentId(String id);

    List<Student> findByEmailIsLike(String email);

    List<Student> findByNameStartsWith(String name);

}

