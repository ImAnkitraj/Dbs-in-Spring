package com.tekion.mongorepo.service;

import com.tekion.mongorepo.datasource.model.Student;
import com.tekion.mongorepo.datasource.model.Subject;
import com.tekion.mongorepo.datasource.repository.DepartmentRepository;
import com.tekion.mongorepo.datasource.repository.StudentRepository;
import com.tekion.mongorepo.datasource.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SubjectRepository subjectRepository;

    public Student create(Student student) {
        departmentRepository.save(student.getDepartment());
        subjectRepository.saveAll(student.getSubjects());
        return studentRepository.save(student);
    }

    public Student get(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, Sort.Direction.DESC, "id", "name");
        return studentRepository.findAll(pageable).getContent();
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public String delete(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted";
    }

    public List<Student> getByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> getByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> getByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getBySubjectName(String name) {
        return studentRepository.findBySubjectsName(name);
    }

    public List<Student> getByDepartmentName(String name) {
        return studentRepository.findByDepartmentName(name);
    }
    public List<Student> getByEmailIsLike(String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> getByNameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> getByDepartmentId(String id) {
        return studentRepository.findByDepartmentId(id);
    }
}
