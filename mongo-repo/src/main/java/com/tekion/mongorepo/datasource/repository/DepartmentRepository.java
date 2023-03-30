package com.tekion.mongorepo.datasource.repository;

import com.tekion.mongorepo.datasource.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {

}
