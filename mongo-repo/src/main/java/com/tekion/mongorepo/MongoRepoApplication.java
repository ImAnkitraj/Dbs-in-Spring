package com.tekion.mongorepo;

import com.tekion.mongorepo.datasource.model.Department;
import com.tekion.mongorepo.datasource.model.Student;
import com.tekion.mongorepo.datasource.model.Subject;
import com.tekion.mongorepo.datasource.repository.StudentRepository;
import com.tekion.mongorepo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MongoRepoApplication  {

    private static Logger logger = LoggerFactory.getLogger(MongoRepoApplication.class);
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Autowired
//    StudentService studentService;
    public static void main(String[] args) {
        SpringApplication.run(MongoRepoApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Student student = new Student("Ankit", "rankit@tekion.com", new Department(), List.of(new Subject[]{}));
//
//        logger.info("{}", studentService.create(student));
//    }
}
