package org.blitz.mongodbsample.repository;

import org.blitz.mongodbsample.document.EmployeeDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeDocument, String> {

    public EmployeeDocument getEmployeeByEmployeeId(String id);
}
