package com.neeladri.demoProjectForMongoDB.repository;

import java.util.List;

import com.mongodb.client.result.DeleteResult;
import com.neeladri.demoProjectForMongoDB.model.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;

    public Student save(Student student) {
        return mongoTemplate.save(student,"Students");
    }

    public List<Student> getAllStudents() {
        return mongoTemplate.findAll(Student.class);
    }

    public long deleteStudent(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        DeleteResult dr = mongoTemplate.remove(query, Student.class);
        return dr.getDeletedCount();
    }

    public List<Student> getStudentBySalary(long salary) {
        Query query = new Query(Criteria.where("salary").gte(salary));
        return mongoTemplate.find(query,Student.class);
    }
}
