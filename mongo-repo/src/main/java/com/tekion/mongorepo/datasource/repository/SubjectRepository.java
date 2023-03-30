package com.tekion.mongorepo.datasource.repository;

import com.tekion.mongorepo.datasource.model.Subject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubjectRepository extends MongoRepository<Subject, String> {

}
