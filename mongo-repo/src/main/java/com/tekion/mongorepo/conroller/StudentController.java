package com.tekion.mongorepo.conroller;

import com.tekion.mongorepo.datasource.model.Student;
import com.tekion.mongorepo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/")
    public Student create(@RequestBody Student student) {
        return service.create(student);
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable String id) {
            return service.get(id);
    }

    @GetMapping("/")
    public List<Student> getAll(@RequestParam int pageNo, @RequestParam int pageSize) {
        return service.getAll(pageNo, pageSize);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        student.setId(id);
        return service.update(student);
    }
    @DeleteMapping("/{id}")
    public String update(@PathVariable String id) {
        return service.delete(id);
    }

    @GetMapping("/student-name/{name}")
    public List<Student> getByName(@PathVariable String name) {
        return service.getByName(name);
    }
    @GetMapping("/student-name-and-email")
    public List<Student> getByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return service.getByNameAndEmail(name, email);
    }

    @GetMapping("/student-name-or-email")
    public List<Student> getByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return service.getByNameOrEmail(name, email);
    }

    @GetMapping("/student-department-name/{name}")
    public List<Student> getByDepartmentNamel(@PathVariable String name) {
        return service.getByDepartmentName(name);
    }
    @GetMapping("/student-subject-name/{name}")
    public List<Student> getBySubjectName(@PathVariable String name) {
        return service.getBySubjectName(name);
    }

    @GetMapping("/student-email-like/{email}")
    public List<Student> getByEmailIsLike(@PathVariable String email) {
        return service.getByEmailIsLike(email);
    }

    @GetMapping("/student-name-starts-with/{name}")
    public List<Student> getByNameStartsWith(@PathVariable String name) {
        return service.getByNameStartsWith(name);
    }

    @GetMapping("/student-department-id/{id}")
    public List<Student> getByDepartmentId(@PathVariable String id) {
        return service.getByDepartmentId(id);
    }
}
