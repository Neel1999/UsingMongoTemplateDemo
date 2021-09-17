package com.neeladri.demoProjectForMongoDB.service;

import java.util.Date;
import java.util.List;

import com.neeladri.demoProjectForMongoDB.model.Student;
import com.neeladri.demoProjectForMongoDB.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {
    
    @Autowired
    StudentRepository studentRepository;

    
    public Student save(Student student) {
        student.setJoiningDate(new Date());
        return studentRepository.save(student);
    }


    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }


    public Student changeStudent(Student student) {
        return studentRepository.save(student);
    }


    public long deleteStudent(String id) {
        return studentRepository.deleteStudent(id);
    }


    public List<Student> getStudentBySalary(long salary) {
        return studentRepository.getStudentBySalary(salary);
    }
}
